package br.com.technosou.gestor.member.adult;

import br.com.technosou.gestor.entityCrud.CrudMethods;
import br.com.technosou.gestor.exception.RequiredObjectIsNullException;
import br.com.technosou.gestor.exception.ResourceNotFoundException;

import br.com.technosou.gestor.member.child.Child;
import br.com.technosou.gestor.member.child.ChildRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.ArrayList;
import java.util.List;

import static br.com.technosou.gestor.mapper.ObjectMapper.parseListObjects;
import static br.com.technosou.gestor.mapper.ObjectMapper.parseObject;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.linkTo;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.methodOn;
import static br.com.technosou.gestor.member.adult.Adult.adultUpdate;

@Service
public class AdultService implements CrudMethods<AdultDTO, Long> {

    @Autowired
    private AdultRepository repository;

    private Logger logger = LoggerFactory.getLogger(AdultService.class.getName());

    @Autowired
    private ChildRepository childRepository;

    @Transactional
    public List<AdultDTO> findAll() {

        logger.info("Find all Adults!");

        var entities = parseListObjects(repository.findAll(), AdultDTO.class);
        entities.forEach(this::addHateoasLinks);
        return entities;
    }

    @Transactional
    public AdultDTO findById(Long id) {

        logger.info("Find Adult by id: " + id);
        var entity = repository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Id " + id + " No records found!"));

        var dto = parseObject(entity, AdultDTO.class);
        addHateoasLinks(dto);
        return dto;
    }

    @Transactional
    public AdultDTO create(AdultDTO dto) {

        if (dto == null) throw new RequiredObjectIsNullException();
        logger.info("Create Adult: " + dto);

        var entity = parseObject(dto, Adult.class);
        var saved = parseObject(repository.save(entity), AdultDTO.class);
        addHateoasLinks(saved);

        associateParentsWithChildren(dto, entity);
        return saved;
    }

    @Transactional
    public AdultDTO update(AdultDTO dto) {

        if (dto == null) throw new RequiredObjectIsNullException();
        logger.info("Update Adult: " + dto);

        var entity = repository.findById(dto.getId()).orElseThrow(() -> new ResourceNotFoundException("No records found for this ID!"));
        var entityUpdated = adultUpdate(dto, entity);
        var saved = parseObject(repository.save(entityUpdated), AdultDTO.class);

        addHateoasLinks(saved);
        return saved;
    }

    @Transactional
    public void delete(Long id) {
        logger.info("Delete Adult: " + id);
        var entity = repository.findById(id).orElseThrow(() -> new ResourceNotFoundException("No records found for this ID!"));

        if (entity.getChildren() != null) {
            entity.getChildren().forEach(it -> it.getParents().remove(entity));
        }

        repository.delete(entity);
    }

    private void addHateoasLinks(AdultDTO dto) {
        dto.add(linkTo(methodOn(AdultController.class).findById(dto.getId())).withSelfRel().withType("GET"));
        dto.add(linkTo(methodOn(AdultController.class).findAll()).withRel("findlAll").withType("GET"));
        dto.add(linkTo(methodOn(AdultController.class).create(dto)).withRel("create").withType("POST"));
        dto.add(linkTo(methodOn(AdultController.class).update(dto)).withRel("update").withType("PUT"));
        dto.add(linkTo(methodOn(AdultController.class).delete(dto.getId())).withRel("delete").withType("DELETE"));
    }

    private void associateParentsWithChildren(AdultDTO dto, Adult entity) {
        if (dto.getChildren() != null && !dto.getChildren().isEmpty()) {
            List<Child> children = dto.getChildren().stream()
                    .map(c -> childRepository.findById(c.getId())
                            .orElseThrow(() -> new ResourceNotFoundException(" Child not found with id: " + c.getId())))
                    .toList();
            children.forEach(child -> {
                if (child.getParents() == null) {
                    child.setParents(new ArrayList<>());
                }
                child.getParents().add(entity);
            });
        }
    }
}
