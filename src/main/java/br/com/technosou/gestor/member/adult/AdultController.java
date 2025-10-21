package br.com.technosou.gestor.member.adult;

import br.com.technosou.gestor.docs.GenericControllerDocs;
import br.com.technosou.gestor.entityCrud.EntityCrud;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/adults/v1")
@Tag(name = "Adults", description = "Endpoints for Managing Adults")
public class AdultController extends EntityCrud<AdultDTO, Long, AdultService> implements GenericControllerDocs<AdultDTO> {

    @Autowired
    private AdultService service;

    public AdultController(AdultService service) {
        super(service);
    }

    @GetMapping(produces = {MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE, MediaType.APPLICATION_YAML_VALUE})
    @Override
    public List<AdultDTO> findAll() {
        return service.findAll();
    }

    @GetMapping(
            value = "/{id}",
            produces = {MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE, MediaType.APPLICATION_YAML_VALUE}
    )
    @Override
    public AdultDTO findById(@PathVariable("id") Long id) {
        var dto = service.findById(id);
        return dto;
    }

    @PostMapping(
            consumes = {MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE, MediaType.APPLICATION_YAML_VALUE},
            produces = {MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE, MediaType.APPLICATION_YAML_VALUE}
    )
    @Override
    public AdultDTO create(@RequestBody AdultDTO dto) {
        return service.create(dto);
    }

    @PutMapping(
            consumes = {MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE, MediaType.APPLICATION_YAML_VALUE},
            produces = {MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE, MediaType.APPLICATION_YAML_VALUE}
    )
    @Override
    public AdultDTO update(@RequestBody AdultDTO dto) {
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
