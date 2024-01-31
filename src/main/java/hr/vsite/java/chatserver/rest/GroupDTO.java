package hr.vsite.java.chatserver.rest;

public class GroupDTO {
    public String groupName;

    public GroupDTO(){

    }

    public GroupDTO(String groupName){
        this.groupName=groupName;
    }


    public String getGroupName() {
        return groupName;
    }

    public void setGroupName(String groupName) {
        this.groupName = groupName;
    }
}
