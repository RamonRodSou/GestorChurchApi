package br.com.technosou.gestor.member.child;

import br.com.technosou.gestor.docs.GenericControllerDocs;
import br.com.technosou.gestor.entityCrud.EntityCrud;

import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/children/v1")
@Tag(name = "Children", description = "Endpoints for Managing Children")
public class ChildController extends EntityCrud<ChildDTO, Long, ChildService> implements GenericControllerDocs<ChildDTO> {

    @Autowired
    private ChildService service;
    public ChildController(ChildService service) {
        super(service);
    }
    @GetMapping(produces = {MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE, MediaType.APPLICATION_YAML_VALUE})
    @Override
    public List<ChildDTO> findAll() {
        return service.findAll();
    }

    @GetMapping(
            value = "/{id}",
            produces = {MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE, MediaType.APPLICATION_YAML_VALUE}
    )
    @Override
    public ChildDTO findById(@PathVariable("id") Long id) {
        var dto = service.findById(id);
        return dto;
    }

    @PostMapping(
            consumes = {MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE, MediaType.APPLICATION_YAML_VALUE},
            produces = {MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE, MediaType.APPLICATION_YAML_VALUE}
    )
    @Override
    public ChildDTO create(@RequestBody ChildDTO dto) {
        return service.create(dto);
    }

    @PutMapping(
            consumes = {MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE, MediaType.APPLICATION_YAML_VALUE},
            produces = {MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE, MediaType.APPLICATION_YAML_VALUE}
    )
    @Override
    public ChildDTO update(@RequestBody ChildDTO dto) {
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
