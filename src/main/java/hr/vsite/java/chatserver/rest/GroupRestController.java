package hr.vsite.java.chatserver.rest;

import hr.vsite.java.chatserver.domain.Group;
import hr.vsite.java.chatserver.domain.GroupServices;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class GroupRestController {

    private final GroupServices groupService;



    public GroupRestController(GroupServices groupService){
        this.groupService=groupService;
    }

    @PostMapping("/groups")
    public void createGroup(@RequestBody GroupDTO groupDTO){

        Group group=new Group();
        group.setGroupName(groupDTO.getGroupName());
        groupService.createGroup(group);

    }

    @GetMapping("/groups/{groupName}")
    public GroupDTO getGroup(String groupName){
        Group group = groupService.getGroup(groupName);
        if(group==null){
            return null;
        }
        return new  GroupDTO(group.getGroupName());

    }
}
