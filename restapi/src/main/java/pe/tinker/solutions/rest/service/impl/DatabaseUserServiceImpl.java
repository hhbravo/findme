package pe.tinker.solutions.rest.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pe.tinker.solutions.db.model.User;
import pe.tinker.solutions.db.repository.IDatabaseUserRepository;
import pe.tinker.solutions.rest.service.IDatabaseUserService;

import java.util.Optional;

/**
 * Created on 26/12/2017.
 *
 * @author Entelgy
 */
@Service
public class DatabaseUserServiceImpl implements IDatabaseUserService {

    private IDatabaseUserRepository userRepository;


    @Autowired
    public DatabaseUserServiceImpl(IDatabaseUserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public Optional<User> getByUsername(String username) {
            return this.userRepository.findUserByUsername(username);
    }

    @Override
    public Optional<User> getByUserId(Integer userId) {
        return this.userRepository.findUserById(userId);
    }
}
