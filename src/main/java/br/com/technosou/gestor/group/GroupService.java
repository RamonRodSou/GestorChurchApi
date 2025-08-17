package br.com.technosou.gestor.group;

import br.com.technosou.gestor.entityCrud.CrudMethods;
import br.com.technosou.gestor.exception.RequiredObjectIsNullException;
import br.com.technosou.gestor.exception.ResourceNotFoundException;
import br.com.technosou.gestor.member.adult.AdultRepository;
import br.com.technosou.gestor.member.child.ChildRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.logging.Logger;

import static br.com.technosou.gestor.mapper.ObjectMapper.parseListObjects;
import static br.com.technosou.gestor.mapper.ObjectMapper.parseObject;
import static br.com.technosou.gestor.group.Group.groupUpdate;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.linkTo;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.methodOn;


@Service
public class GroupService implements CrudMethods<GroupDTO, Long> {

    @Autowired
    private GroupRepository repository;

    @Autowired
    private AdultRepository adultRepository;

    @Autowired
    private ChildRepository childRepository;

    private Logger logger = Logger.getLogger(GroupService.class.getName());

    @Transactional
    public List<GroupDTO> findAll() {

        logger.info("Find all Groups");

        var entities = parseListObjects(repository.findAll(), GroupDTO.class);
        entities.forEach(this::addHateoasLinks);
        return entities;
    }

    @Transactional
    public GroupDTO findById(Long id) {

        logger.info("Find Group by id: " + id);
        var entity = repository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Id " + id + " No records found!"));

        var dto = parseObject(entity, GroupDTO.class);
        addHateoasLinks(dto);
        return dto;
    }

    public GroupDTO create(GroupDTO dto) {

        if (dto == null) throw new RequiredObjectIsNullException();
        logger.info("Create Group: " + dto);

        var entity = parseObject(dto, Group.class);
        var saved = parseObject(repository.save(entity), GroupDTO.class);

        addHateoasLinks(saved);
        return saved;
    }

    @Transactional
    public GroupDTO update(GroupDTO dto) {

        if (dto == null) throw new RequiredObjectIsNullException();
        logger.info("Update Group: " + dto);

        var entity = repository.findById(dto.getId()).orElseThrow(() -> new ResourceNotFoundException("No records found for this ID!"));
        var entityUpdated = groupUpdate(dto, entity);
        var saved = parseObject(repository.save(entityUpdated), GroupDTO.class);

        addHateoasLinks(saved);
        return saved;
    }

    @Transactional
    public void delete(Long id) {
        logger.info("Delete group: " + id);
        var entity = repository.findById(id).orElseThrow(() -> new ResourceNotFoundException("No records found for this ID!"));
        removeMember(entity);
        repository.delete(entity);
    }

    public void addHateoasLinks(GroupDTO dto) {
        dto.add(linkTo(methodOn(GroupController.class).findById(dto.getId())).withSelfRel().withType("GET"));
        dto.add(linkTo(methodOn(GroupController.class).findAll()).withRel("findlAll").withType("GET"));
        dto.add(linkTo(methodOn(GroupController.class).create(dto)).withRel("create").withType("POST"));
        dto.add(linkTo(methodOn(GroupController.class).update(dto)).withRel("update").withType("PUT"));
        dto.add(linkTo(methodOn(GroupController.class).delete(dto.getId())).withRel("delete").withType("DELETE"));
    }

    void removeMember(Group group) {
        if (group.getLeaders() != null) {
            group.getLeaders().forEach(it -> it.setGroup(null));
                adultRepository.saveAll(group.getLeaders());
        }

        if (group.getMembers() != null) {
            group.getMembers().forEach(it -> it.setGroup(null));
                adultRepository.saveAll(group.getMembers());
        }

        if (group.getChildren() != null) {
            group.getChildren().forEach(it -> it.setGroup(null));
                childRepository.saveAll(group.getChildren());
        };
    }
}
