package br.com.technosou.gestor.member.adult;

import br.com.technosou.gestor.entityCrud.EntityCrud;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("api/adults/v1")
public class AdultController extends EntityCrud<AdultDTO, Long, AdultService> {

    @Autowired
    private AdultService service;

    public AdultController(AdultService service) {
        super(service);
    }
}
