package hr.vsite.java.chatserver.db;
import hr.vsite.java.chatserver.domain.Group;

import java.util.List;

public interface GroupCustomRepository {

    List<Group>searchGroups(String groupName);
}
