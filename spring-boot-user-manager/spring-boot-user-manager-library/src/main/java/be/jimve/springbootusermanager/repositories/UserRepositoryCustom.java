package be.jimve.springbootusermanager.repositories;

import java.util.List;

public interface UserRepositoryCustom {
    List<String> getUsernamesLike(String username);
}
