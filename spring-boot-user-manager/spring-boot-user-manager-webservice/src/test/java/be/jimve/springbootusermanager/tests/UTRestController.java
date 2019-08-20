package be.jimve.springbootusermanager.tests;

import be.jimve.springbootusermanager.beans.User;
import be.jimve.springbootusermanager.services.UserService;
import be.jimve.springbootusermanager.ws.Application;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

import static org.junit.Assert.*;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = Application.class)
public class UTRestController {
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
