package be.jimve.springbootusermanager.services;

import be.jimve.springbootusermanager.beans.User;
import be.jimve.springbootusermanager.repositories.UserRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserServiceImpl implements UserService {
    private final UserRepository userRepository;

    public UserServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public List<User> getUsers() {
        return userRepository.findAll();
    }

    @Override
    public void addUser(User user) {
        userRepository.save(user);
    }

    @Override
    public void updateUser(User userParameter) {
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

    @Override
    public void deleteUser(Long id) {
        userRepository.deleteById(id);
    }

    @Override
    public List<String> getUsernamesLike(String username) {
        return userRepository.getUsernamesLike(username);
    }
}
