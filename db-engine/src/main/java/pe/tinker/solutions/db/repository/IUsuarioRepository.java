package pe.tinker.solutions.db.repository;

import pe.tinker.solutions.db.model.User;

/**
 * Created on 26/12/2017.
 *
 * @author Entelgy
 */
public interface IUsuarioRepository {
    User loadUserByKey(Integer userId);

    User loadUserByEmail(String email);
}
