package pe.tinker.solutions.db.repository;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.junit4.SpringRunner;
import pe.tinker.solutions.db.model.User;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;
import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.notNullValue;


@RunWith(SpringRunner.class)
@DataJpaTest
public class UsuarioRepositoryTest {

    @Autowired
    private IUsuarioRepository usuarioRepository;

    @Test
    public void findUserByUserIdTest() {
        User user = usuarioRepository.findUserById(1);
        assertThat(user, is(not(nullValue())));
        assertThat(user.getPassword(), equalTo("d8a820104dfaa7ebfabdf005672b20920975a39ac92ee4db41b4c47b2872c25d"));
        assertThat(user.getLastName(), equalTo("Herrera"));

    }


}