package be.jimve.ws;

import be.jimve.beans.UserEntity;
import be.jimve.repositories.UserRepository;
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
    public List<UserEntity> getUsers() {
        return (List<UserEntity>) userRepository.findAll();
    }

    @PostMapping("/user")
    void addUser(@RequestBody UserEntity user) {
        userRepository.save(user);
    }

    @PutMapping("/user")
    void updateUser(@RequestBody UserEntity userParameter) {
        Optional<UserEntity> userById = userRepository.findById(userParameter.getId());
        if(userById.isPresent()) {
            UserEntity user = userById.get();
            user.setName(userParameter.getName());
            user.setEmail(userParameter.getEmail());
        } else {
            throw new IllegalArgumentException("User not found");
        }
    }

    @DeleteMapping("/{id}")
    void deleteUser(@PathVariable Long id) {
        userRepository.deleteById(id);
    }
}
