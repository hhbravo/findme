package pe.tinker.solutions.db.repository;

import org.springframework.data.repository.CrudRepository;
import pe.tinker.solutions.db.model.User;

/**
 * Created on 26/12/2017.
 *
 * @author Entelgy
 */
public interface IUsuarioRepository extends CrudRepository<User, Integer> {
    User findUserById(Integer userId);

    User findUserByUsername(String email);
}
