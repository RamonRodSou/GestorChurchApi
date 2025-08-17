package br.com.technosou.gestor.group;

import br.com.technosou.gestor.entityCrud.EntityCrud;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api/groups/v1")
public class GroupController extends EntityCrud<GroupDTO, Long, GroupService> {

    @Autowired
    private GroupService service;

    public GroupController(GroupService service) {
        super(service);
    }
}
