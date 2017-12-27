package pe.tinker.solutions.rest.service.impl;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pe.tinker.solutions.db.model.User;
import pe.tinker.solutions.db.repository.IUsuarioRepository;
import pe.tinker.solutions.rest.service.IUsuarioService;

/**
 * Created on 26/12/2017.
 *
 * @author Entelgy
 */

@Service
public class UsuarioServiceImpl implements IUsuarioService {

    private final Logger LOG = LoggerFactory.getLogger(UsuarioServiceImpl.class);

    @Autowired
    private IUsuarioRepository repository;

    @Override
    public User loadUserByUser(final Integer idUser) {
        return repository.findUserById(idUser);
    }

    @Override
    public User loadUserByEmail(final String email) {
        return repository.findUserByUsername(email);
    }

}
