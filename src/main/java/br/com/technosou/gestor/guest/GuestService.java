package br.com.technosou.gestor.guest;

import br.com.technosou.gestor.entityCrud.CrudMethods;
import br.com.technosou.gestor.exception.RequiredObjectIsNullException;
import br.com.technosou.gestor.exception.ResourceNotFoundException;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.logging.Logger;

import static br.com.technosou.gestor.mapper.ObjectMapper.parseListObjects;
import static br.com.technosou.gestor.mapper.ObjectMapper.parseObject;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.linkTo;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.methodOn;
import static br.com.technosou.gestor.guest.Guest.guestUpdate;

@Service
public class GuestService implements CrudMethods<GuestDTO, Long> {

    @Autowired
    private GuestRepository repository;

    private Logger logger = Logger.getLogger(GuestService.class.getName());

    @Transactional
    public List<GuestDTO> findAll() {

        logger.info("Find all Guests");

        var entities = parseListObjects(repository.findAll(), GuestDTO.class);
        entities.forEach(this::addHateoasLinks);
        return entities;
    }

    @Transactional
    public GuestDTO findById(Long id) {

        logger.info("Find Guest by id: " + id);
        var entity = repository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Id " + id + " No records found!"));

        var dto = parseObject(entity, GuestDTO.class);
        addHateoasLinks(dto);
        return dto;
    }

    public GuestDTO create(GuestDTO dto) {

        if (dto == null) throw new RequiredObjectIsNullException();
        logger.info("Create Guest: " + dto);

        var entity = parseObject(dto, Guest.class);
        var saved = parseObject(repository.save(entity), GuestDTO.class);

        addHateoasLinks(saved);
        return saved;
    }

    @Transactional
    public GuestDTO update(GuestDTO dto) {

        if (dto == null) throw new RequiredObjectIsNullException();
        logger.info("Update Guest: " + dto);

        var entity = repository.findById(dto.getId()).orElseThrow(() -> new ResourceNotFoundException("No records found for this ID!"));
        var entityUpdated = guestUpdate(dto, entity);
        var saved = parseObject(repository.save(entityUpdated), GuestDTO.class);

        addHateoasLinks(saved);
        return saved;
    }

    @Transactional
    public void delete(Long id) {
        logger.info("Delete Guest: " + id);
        var entity = repository.findById(id).orElseThrow(() -> new ResourceNotFoundException("No records found for this ID!"));
        repository.delete(entity);
    }

    private void addHateoasLinks(GuestDTO dto) {
        dto.add(linkTo(methodOn(GuestController.class).findById(dto.getId())).withSelfRel().withType("GET"));
        dto.add(linkTo(methodOn(GuestController.class).findAll()).withRel("findlAll").withType("GET"));
        dto.add(linkTo(methodOn(GuestController.class).create(dto)).withRel("create").withType("POST"));
        dto.add(linkTo(methodOn(GuestController.class).update(dto)).withRel("update").withType("PUT"));
        dto.add(linkTo(methodOn(GuestController.class).delete(dto.getId())).withRel("delete").withType("DELETE"));
    }
}
