package be.stocka.springbootusermanager.repositories;

import java.util.List;

public interface UserRepositoryCustom {
    List<String> getUsernamesLike(String username);
}
