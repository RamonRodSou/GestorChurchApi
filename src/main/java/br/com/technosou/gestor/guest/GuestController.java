package br.com.technosou.gestor.guest;

import br.com.technosou.gestor.docs.GenericControllerDocs;
import br.com.technosou.gestor.entityCrud.EntityCrud;
import br.com.technosou.gestor.group.GroupService;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/guests/v1")
@Tag(name = "Guests", description = "Endpoints for Managing Guests")
public class GuestController extends EntityCrud<GuestDTO, Long, GuestService> implements GenericControllerDocs<GuestDTO> {

    @Autowired
    private GuestService service;

    public GuestController(GuestService service) {
        super(service);
    }

    @GetMapping(produces = {MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE, MediaType.APPLICATION_YAML_VALUE})
    @Override
    public List<GuestDTO> findAll() {
        return service.findAll();
    }

    @GetMapping(
            value = "/{id}",
            produces = {MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE, MediaType.APPLICATION_YAML_VALUE}
    )
    @Override
    public GuestDTO findById(@PathVariable("id") Long id) {
        var dto = service.findById(id);
        return dto;
    }

    @PostMapping(
            consumes = {MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE, MediaType.APPLICATION_YAML_VALUE},
            produces = {MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE, MediaType.APPLICATION_YAML_VALUE}
    )
    @Override
    public GuestDTO create(@RequestBody GuestDTO dto) {
        return service.create(dto);
    }

    @PutMapping(
            consumes = {MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE, MediaType.APPLICATION_YAML_VALUE},
            produces = {MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE, MediaType.APPLICATION_YAML_VALUE}
    )
    @Override
    public GuestDTO update(@RequestBody GuestDTO dto) {
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
