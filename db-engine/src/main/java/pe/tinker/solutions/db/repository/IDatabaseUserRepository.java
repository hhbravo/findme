package pe.tinker.solutions.db.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import pe.tinker.solutions.db.model.User;

import java.util.Optional;

/**
 * Created on 26/12/2017.
 *
 * @author Entelgy
 */
public interface IDatabaseUserRepository extends CrudRepository<User, Integer> {
    Optional<User> findUserByUsername(@Param("username") String username);

    Optional<User> findUserById(@Param("userId") Integer userId);
}

