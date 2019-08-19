package be.jimve.springbootusermanager.repositories;

import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

@Repository
public class UserRepositoryImpl implements UserRepositoryCustom {
    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public List<String> getUsernamesLike(String username) {
        username = '%' + username.toLowerCase() + '%';
        String query = "SELECT u.username FROM users u WHERE LOWER(u.username) LIKE ?";
        return entityManager.createNativeQuery(query)
                .setParameter(1, username)
                .getResultList();
    }
}
