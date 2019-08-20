package be.jimve.springbootusermanager.tests;

import be.jimve.springbootusermanager.beans.User;
import be.jimve.springbootusermanager.repositories.UserRepository;
import be.jimve.springbootusermanager.services.UserServiceImpl;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import static org.junit.Assert.*;
import static org.mockito.Mockito.when;

/**
 * This test doesn't really make any sense since our service is just returning what the repository returns itself, and we
 * are controlling what it returns.
 * However, if the service had business logic, this would make sense.
 * Also, when running both this test and {@link UTUserService}, we can see that this one is much faster to run because we don't
 * initialize the whole Spring environment to run it. This doesn't mean that the {@link UTUserService} tests are useless since
 * they are executing real queries on a database, useful for data access testing.
 */
@RunWith(MockitoJUnitRunner.class)
public class UTUserServiceWithMockedRepository {
    @Mock
    private UserRepository userRepositoryMock;

    @InjectMocks
    private UserServiceImpl userService;

    @Test
    public void saveRetrieveDeleteUser() {
        User user = new User("Test", "Test", "test", "T35T");
        userService.addUser(user);
        when(userRepositoryMock.findAll()).thenReturn(Arrays.asList(user));
        List<User> foundUsers = userService.getUsers();
        assertFalse(foundUsers.isEmpty());
        userService.deleteUser(foundUsers.get(0).getId());
        when(userRepositoryMock.findAll()).thenReturn(Collections.emptyList());
        foundUsers = userService.getUsers();
        assertTrue(foundUsers.isEmpty());
    }

    @Test
    public void getUsernamesLike() {
        User user1 = new User("Premier", "Test", "test1", "T35T");
        User user2 = new User("Deuxième", "Test", "test2", "T35T");
        userService.addUser(user1);
        userService.addUser(user2);
        when(userRepositoryMock.getUsernamesLike("Test")).thenReturn(Arrays.asList("test1", "test2"));
        List<String> foundUsernames = userService.getUsernamesLike("Test");
        assertEquals(2, foundUsernames.size());
        when(userRepositoryMock.findAll()).thenReturn(Arrays.asList(user1, user2));
        List<User> foundUsers = userService.getUsers();
        assertFalse(foundUsers.isEmpty());
        userService.deleteUser(foundUsers.get(0).getId());
        userService.deleteUser(foundUsers.get(1).getId());
        when(userRepositoryMock.findAll()).thenReturn(Collections.emptyList());
        foundUsers = userService.getUsers();
        assertTrue(foundUsers.isEmpty());
    }
}
