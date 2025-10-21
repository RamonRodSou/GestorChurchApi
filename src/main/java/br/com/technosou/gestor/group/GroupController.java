package br.com.technosou.gestor.group;

import br.com.technosou.gestor.docs.GenericControllerDocs;
import br.com.technosou.gestor.entityCrud.EntityCrud;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/groups/v1")
@Tag(name = "Groups", description = "Endpoints for Managing Groups")
public class GroupController extends EntityCrud<GroupDTO, Long, GroupService> implements GenericControllerDocs<GroupDTO> {

    @Autowired
    private GroupService service;

    public GroupController(GroupService service) {
        super(service);
    }

    @GetMapping(produces = {MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE, MediaType.APPLICATION_YAML_VALUE})
    @Override
    public List<GroupDTO> findAll() {
        return service.findAll();
    }

    @GetMapping(
            value = "/{id}",
            produces = {MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE, MediaType.APPLICATION_YAML_VALUE}
    )
    @Override
    public GroupDTO findById(@PathVariable("id") Long id) {
        var dto = service.findById(id);
        return dto;
    }

    @PostMapping(
            consumes = {MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE, MediaType.APPLICATION_YAML_VALUE},
            produces = {MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE, MediaType.APPLICATION_YAML_VALUE}
    )
    @Override
    public GroupDTO create(@RequestBody GroupDTO dto) {
        return service.create(dto);
    }

    @PutMapping(
            consumes = {MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE, MediaType.APPLICATION_YAML_VALUE},
            produces = {MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE, MediaType.APPLICATION_YAML_VALUE}
    )
    @Override
    public GroupDTO update(@RequestBody GroupDTO dto) {
        return service.update(dto);
    }

    @DeleteMapping(
            value = "/{id}"
    )
    @Override
    public ResponseEntity<Void> delete(@PathVariable("id") Long id) {
        service.delete(id);
        return ResponseEntity.noContent().build();
    }
}
