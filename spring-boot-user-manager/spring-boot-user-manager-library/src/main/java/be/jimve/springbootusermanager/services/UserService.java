package be.jimve.springbootusermanager.services;

import be.jimve.springbootusermanager.beans.User;

import java.util.List;

public interface UserService {
    List<User> getUsers();
    void addUser(User user);
    void updateUser(User userParameter);
    void deleteUser(Long id);
    List<String> getUsernamesLike(String username);
}
