package br.com.technosou.gestor.member.child;

import br.com.technosou.gestor.entityCrud.CrudMethods;
import br.com.technosou.gestor.exception.RequiredObjectIsNullException;
import br.com.technosou.gestor.exception.ResourceNotFoundException;
import br.com.technosou.gestor.member.adult.AdultService;
import jakarta.transaction.Transactional;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

import static br.com.technosou.gestor.mapper.ObjectMapper.parseListObjects;
import static br.com.technosou.gestor.mapper.ObjectMapper.parseObject;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.linkTo;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.methodOn;
import static br.com.technosou.gestor.member.child.Child.childUpdate;

@Service
public class ChildService implements CrudMethods<ChildDTO, Long> {

    @Autowired
    private ChildRepository repository;

    private Logger logger = LoggerFactory.getLogger(AdultService.class.getName());

    public List<ChildDTO> findAll() {

        logger.info("Find all Children!");

        var entities = parseListObjects(repository.findAll(), ChildDTO.class);
        entities.forEach(this::addHateoasLinks);
        return entities;
    }

    @Transactional
    public ChildDTO findById(Long id) {

        logger.info("Find Child by id: " + id);
        var entity = repository.findById(id).orElseThrow(() -> new RuntimeException("Id " + id + " No records found!"));

        var dto = parseObject(entity, ChildDTO.class);
        addHateoasLinks(dto);
        return dto;
    }

    public ChildDTO create(ChildDTO child) {

        if (child == null) throw new RequiredObjectIsNullException();
        logger.info("Create Adult: " + child);

        var entity = parseObject(child, Child.class);
        var dto = parseObject(repository.save(entity), ChildDTO.class);

        addHateoasLinks(dto);
        return child;
    }

    public ChildDTO update(ChildDTO child) {

        if (child == null) throw new RequiredObjectIsNullException();
        logger.info("Update Adult: " + child);

        var entity = repository.findById(child.getId()).orElseThrow(() -> new ResourceNotFoundException("No records found for this ID!"));
        var entityUpdated = childUpdate(child, entity);
        var dto = parseObject(repository.save(entityUpdated), ChildDTO.class);

        addHateoasLinks(dto);
        return child;
    }

    public void delete(Long id) {
        logger.info("Delete Adult: " + id);
        var entity = repository.findById(id).orElseThrow(() -> new ResourceNotFoundException("No records found for this ID!"));
        repository.delete(entity);
    }

    public void addHateoasLinks(ChildDTO dto) {
        dto.add(linkTo(methodOn(ChildController.class).findById(dto.getId())).withSelfRel().withType("GET"));
        dto.add(linkTo(methodOn(ChildController.class).findAll()).withRel("findlAll").withType("GET"));
        dto.add(linkTo(methodOn(ChildController.class).create(dto)).withRel("create").withType("POST"));
        dto.add(linkTo(methodOn(ChildController.class).update(dto)).withRel("update").withType("PUT"));
        dto.add(linkTo(methodOn(ChildController.class).delete(dto.getId())).withRel("delete").withType("DELETE"));
    }
}
