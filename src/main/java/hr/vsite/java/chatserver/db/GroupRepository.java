package hr.vsite.java.chatserver.db;

import org.springframework.data.jpa.repository.JpaRepository;
import hr.vsite.java.chatserver.domain.Group;

public interface GroupRepository extends JpaRepository<Group, String> {
}
