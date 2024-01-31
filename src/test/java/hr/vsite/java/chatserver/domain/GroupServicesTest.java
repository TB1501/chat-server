package hr.vsite.java.chatserver.domain;

import hr.vsite.java.chatserver.GroupValidationException;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;




@SpringBootTest
class GroupServicesTest {

    @Autowired
    private GroupServices groupServices;

    @Test
    void createGroup() {
        Group group=new Group();
        group.setGroupName("test");
        groupServices.createGroup(group);

        Group group2 = groupServices.getGroup("test");
        assertNotNull(group2);
        assertEquals("test", group2.getGroupName());
        org.assertj.core.api.Assertions.assertThat(group2).isNotNull();
        assertEquals("test", group2.getGroupName());
        org.assertj.core.api.Assertions.assertThat(group2).usingRecursiveComparison().isEqualTo(group);
    }

    @Test
    void createGroupNameIsNull() {

        Group group = new Group();
        Assertions.assertThrows(GroupValidationException.class,()->groupServices.createGroup(group));
        org.assertj.core.api.Assertions.assertThatExceptionOfType(GroupValidationException.class).isThrownBy(()->groupServices.createGroup(group));

    }

    @Test
    void creatGroupAndGroupIsNull() {
        org.assertj.core.api.Assertions.assertThatExceptionOfType(RuntimeException.class).isThrownBy(()->groupServices.createGroup(null));
    }
}
