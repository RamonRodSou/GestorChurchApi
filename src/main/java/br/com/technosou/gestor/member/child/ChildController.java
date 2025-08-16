package br.com.technosou.gestor.member.child;

import br.com.technosou.gestor.entityCrud.EntityCrud;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("api/children/v1")
public class ChildController extends EntityCrud<ChildDTO, Long, ChildService> {

    @Autowired
    private ChildService service;
    public ChildController(ChildService service) {
        super(service);
    }

}
