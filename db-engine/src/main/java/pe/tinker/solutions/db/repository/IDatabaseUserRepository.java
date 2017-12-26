package pe.tinker.solutions.db.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import pe.tinker.solutions.db.model.User;

import java.util.Optional;

/**
 * Created on 26/12/2017.
 *
 * @author Entelgy
 */
public interface IDatabaseUserRepository extends JpaRepository<User, Integer> {
    @Query("select u from User u left join fetch u.userRols r where u.email=:username")
    Optional<User> findByUsername(@Param("username") String username);

    @Query("select u from User u left join fetch u.userRols r where u.userId=:userId")
    Optional<User> findByUserId(@Param("userId") Integer userId);
}

