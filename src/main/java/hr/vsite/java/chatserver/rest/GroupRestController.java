package hr.vsite.java.chatserver.rest;

import hr.vsite.java.chatserver.domain.Group;
import hr.vsite.java.chatserver.domain.GroupServices;
import org.springframework.web.bind.annotation.*;

import java.util.LinkedList;

import java.util.List;

@RestController
public class GroupRestController {

    private final GroupServices groupService;



    public GroupRestController(GroupServices groupService){
        this.groupService=groupService;
    }
    @DeleteMapping("/groups/{groupName}")
    public void deleteGroup(@PathVariable String groupName){
        groupService.deleteGroup(groupName);
    }

    public List<GroupDTO> getGRoups(String groupName){
        List<Group> groups = groupService.searchGroups(groupName);
        List<GroupDTO>groupDTOS=new LinkedList<>();
        for(Group group:groups){
            groupDTOS.add(toDto(group));
        }
        return groupDTOS;
    }



    private GroupDTO toDto(Group group){
        GroupDTO dto = new GroupDTO();
        dto.setGroupName(group.getGroupName());
        return dto;
    }

    @PutMapping("/groups/{groupName}")
    public void createGroup(@RequestBody GroupDTO groupDTO, @PathVariable String groupName){

        Group group=new Group();
        group.setGroupName(groupDTO.getGroupName());
        groupService.createGroup(group);

    }

    @GetMapping("/groups/{groupName}")
    public GroupDTO getGroup(@PathVariable String groupName){
        Group group = groupService.getGroup(groupName);
        if(group==null){
            return null;
        }
        return new  GroupDTO(group.getGroupName());

    }
}
