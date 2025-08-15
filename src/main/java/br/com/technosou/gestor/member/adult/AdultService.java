package br.com.technosou.gestor.member.adult;


import br.com.technosou.gestor.exception.RequiredObjectIsNullException;
import br.com.technosou.gestor.exception.ResourceNotFoundException;

import br.com.technosou.gestor.member.child.ChildSummaryDTO;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import java.util.List;

import static br.com.technosou.gestor.mapper.ObjectMapper.parseListObjects;
import static br.com.technosou.gestor.mapper.ObjectMapper.parseObject;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.linkTo;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.methodOn;
import static br.com.technosou.gestor.member.adult.Adult.AdultUpdate;

@Service
public class AdultService {

    @Autowired
    private AdultRepository repository;

    private Logger logger = LoggerFactory.getLogger(AdultService.class.getName());

    public List<AdultDTO> findAll() {

        logger.info("Find all Adults");

        var entities = parseListObjects(repository.findAll(), AdultDTO.class);
        entities.forEach(this::addHateoasLinks);

        return entities;
    }

    @Transactional
    public AdultDTO findById(Long id) {

        logger.info("Find Adult by id: " + id);

        var entity = repository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Id " + id + " No records found!"));

        var dto = parseObject(entity, AdultDTO.class);
//        List<ChildSummaryDTO> children = repository.findChildrenByAdultId(id);
//        dto.setChildren(children);

        addHateoasLinks(dto);
        return dto;
    }

    public AdultDTO create(AdultDTO Adult) {
        
        if (Adult == null) throw new RequiredObjectIsNullException();
        logger.info("Create Adult: " + Adult);

        var entity = parseObject(Adult, Adult.class);
        var dto = parseObject(repository.save(entity), AdultDTO.class);

        addHateoasLinks(dto);
        return Adult;
    }

    public AdultDTO update(AdultDTO Adult) {

        if (Adult == null) throw new RequiredObjectIsNullException();
        logger.info("Update Adult: " + Adult);

        var entity = repository.findById(Adult.getId()).orElseThrow(() -> new ResourceNotFoundException("No records found for this ID!"));
        var entityUpdated = AdultUpdate(Adult, entity);
        var dto = parseObject(repository.save(entityUpdated), AdultDTO.class);

        addHateoasLinks(dto);
        return Adult;
    }

    public void delete(Long id) {

        logger.info("Delete Adult: " + id);
        var entity = repository.findById(id).orElseThrow(() -> new ResourceNotFoundException("No records found for this ID!"));

        repository.delete(entity);
    }

    public void addHateoasLinks(AdultDTO dto) {

        dto.add(linkTo(methodOn(AdultController.class).findbyId(dto.getId())).withSelfRel().withType("GET"));
        dto.add(linkTo(methodOn(AdultController.class).findAll()).withRel("findlAll").withType("GET"));
        dto.add(linkTo(methodOn(AdultController.class).create(dto)).withRel("create").withType("POST"));
        dto.add(linkTo(methodOn(AdultController.class).update(dto)).withRel("update").withType("PUT"));
        dto.add(linkTo(methodOn(AdultController.class).delete(dto.getId())).withRel("delete").withType("DELETE"));
    }
}
