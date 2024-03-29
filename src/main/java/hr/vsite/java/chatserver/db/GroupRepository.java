package hr.vsite.java.chatserver.db;

import org.springframework.data.jpa.repository.JpaRepository;
import hr.vsite.java.chatserver.domain.Group;

import java.util.List;

public interface GroupRepository
        extends JpaRepository<Group, String>,
        GroupCustomRepository {

    List<Group> findAllByGroupNameContaining(String groupName);

}
