package be.stocka.springbootusermanager.tests;

import be.stocka.springbootusermanager.beans.User;
import be.stocka.springbootusermanager.services.UserService;
import be.stocka.springbootusermanager.ws.Application;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

import static org.junit.Assert.*;

/**
 * This test is an example of how you can use a Service running within a Spring Boot application. However, performances
 * are not good at all for unit testing and should only be used when needed. We need it to test the data access, and that is why we use a
 * H2 in-memory database configured in the application.properties file located in test/resources.
 */
@RunWith(SpringRunner.class)
@SpringBootTest(classes = Application.class)
public class UTUserService {
    @Autowired
    private UserService userService;

    @Test
    public void saveRetrieveDeleteUser() {
        userService.addUser(new User("Test", "Test", "test", "T35T"));
        List<User> foundUsers = userService.getUsers();
        assertFalse(foundUsers.isEmpty());
        userService.deleteUser(foundUsers.get(0).getId());
        foundUsers = userService.getUsers();
        assertTrue(foundUsers.isEmpty());
    }

    @Test
    public void getUsernamesLike() {
        userService.addUser(new User("Premier", "Test", "test1", "T35T"));
        userService.addUser(new User("Deuxième", "Test", "test2", "T35T"));
        List<String> foundUsernames = userService.getUsernamesLike("Test");
        assertEquals(2, foundUsernames.size());
        List<User> foundUsers = userService.getUsers();
        assertFalse(foundUsers.isEmpty());
        userService.deleteUser(foundUsers.get(0).getId());
        userService.deleteUser(foundUsers.get(1).getId());
        foundUsers = userService.getUsers();
        assertTrue(foundUsers.isEmpty());
    }
}
