package pe.tinker.solutions.rest.service;

import pe.tinker.solutions.db.model.User;

import java.util.Optional;

/**
 * Created on 26/12/2017.
 *
 * @author Entelgy
 */
public interface IDatabaseUserService {
    Optional<User> getByUsername(String username);

    Optional<User> getByUserId(Integer userId);
}
