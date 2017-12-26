package pe.tinker.solutions.rest.service;

import pe.tinker.solutions.db.model.User;

/**
 * Created on 26/12/2017.
 *
 * @author Entelgy
 */
public interface IUsuarioService {
    User loadUserByUser(Integer idUser);

    User loadUserByEmail(String email);
}
