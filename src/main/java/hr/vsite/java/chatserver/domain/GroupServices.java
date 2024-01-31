package hr.vsite.java.chatserver.domain;

import hr.vsite.java.chatserver.GroupValidationException;
import hr.vsite.java.chatserver.db.GroupRepository;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;
import java.util.List;

@Service
public class GroupServices {

    private final GroupRepository groupRepository;


    public GroupServices(GroupRepository groupRepository) {
        this.groupRepository = groupRepository;
    }

    public void createGroup(Group group){
        if (!StringUtils.hasText(group.getGroupName())){
            throw new GroupValidationException("Group name must be provided");
        }

        groupRepository.save(group);
    }


    public Group getGroup(String groupName){
        return groupRepository.findById(groupName).orElse(null);
    }


    public void deleteGroup(String groupName){
        groupRepository.deleteById(groupName);
    }

    public List<Group> searchGroups(String groupName){
        if (StringUtils.hasText(groupName)){
           // return groupRepository.findByGroupNameContaining(groupName);

            return groupRepository.findAll();
        }
        else{
            return groupRepository.findAll();
        }
    }


}
