package be.jimve.springbootusermanager.ws;

import be.jimve.springbootusermanager.beans.User;
import be.jimve.springbootusermanager.repositories.UserRepository;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@CrossOrigin(origins = "http://localhost:4200") // Allows request coming from the Angular Web Application
public class UserRESTController {
    private final UserRepository userRepository;

    public UserRESTController(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @GetMapping("/users")
    public List<User> getUsers() {
        return (List<User>) userRepository.findAll();
    }

    @PostMapping("/user")
    void addUser(@RequestBody User user) {
        userRepository.save(user);
    }

    @PutMapping("/user")
    void updateUser(@RequestBody User userParameter) {
        Optional<User> userById = userRepository.findById(userParameter.getId());
        if(userById.isPresent()) {
            User user = userById.get();
            user.setName(userParameter.getName());
            user.setFirstName(userParameter.getFirstName());
            user.setUsername(userParameter.getUsername());
            user.setPassword(userParameter.getPassword());
        } else {
            throw new IllegalArgumentException("User not found");
        }
    }

    @DeleteMapping("/{id}")
    void deleteUser(@PathVariable Long id) {
        userRepository.deleteById(id);
    }

    @GetMapping("/search")
    List<String> getUsernamesLike(@RequestParam String username) {
        return userRepository.getUsernamesLike(username);
    }
}
