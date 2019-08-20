package be.jimve.springbootusermanager.ws;

import be.jimve.springbootusermanager.beans.User;
import be.jimve.springbootusermanager.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin(origins = "http://localhost:4200") // Allows request coming from the Angular Web Application
@RequestMapping("/user-controller")
public class UserRestController {
    @Autowired
    private UserService userService;

    @GetMapping("/users")
    public List<User> getUsers() {
        return userService.getUsers();
    }

    @PostMapping("/user")
    void addUser(@RequestBody User user) {
        userService.addUser(user);
    }

    @PutMapping("/user")
    void updateUser(@RequestBody User userParameter) {
        userService.updateUser(userParameter);
    }

    @DeleteMapping("/{id}")
    void deleteUser(@PathVariable Long id) {
        userService.deleteUser(id);
    }

    @GetMapping("/search")
    List<String> getUsernamesLike(@RequestParam String username) {
        return userService.getUsernamesLike(username);
    }
}
