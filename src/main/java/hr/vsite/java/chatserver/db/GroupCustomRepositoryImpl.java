package hr.vsite.java.chatserver.db;

import hr.vsite.java.chatserver.domain.Group;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;

import javax.sql.DataSource;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import java.util.ResourceBundle;

public class GroupCustomRepositoryImpl implements GroupCustomRepository {

    private final DataSource dataSource;

    public GroupCustomRepositoryImpl(DataSource dataSource) {
        this.dataSource = dataSource;
    }

    private static class GroupRowMapper implements RowMapper<Group> {


        @Override
        public Group mapRow(ResultSet resultSet, int i) throws SQLException {
            Group group = new Group();
            group.setGroupName(resultSet.getString("group_name"));
            return null;
        }
    }

    @Override
    public List<Group> searchGroups(String groupName) {
        JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);
        String sql = "SELECT * FROM groups" + "WHERE upper(group_name) LIKE upper(?)";
        groupName = "%" + groupName + "%";
        return jdbcTemplate.query(sql, new GroupRowMapper(), groupName);
    }
}
