package pe.tinker.solutions.db.repository;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.junit4.SpringRunner;
import pe.tinker.solutions.db.model.Empresa;

import java.util.List;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;
import static org.hamcrest.Matchers.not;
import static org.hamcrest.Matchers.nullValue;

/**
 * Created on 27/12/2017.
 *
 * @author Entelgy
 */
@RunWith(SpringRunner.class)
@DataJpaTest
public class EmpresaRepositoryTest {

    @Autowired
    private IEmpresaRepository repository;

    @Test
    public void findAllBusiness() {
        List<Empresa> results = (List<Empresa>) repository.findAll();
        assertThat(results, is(not(nullValue())));
        assertThat(results.size(), is(2));
    }

    @Test
    public void findAllBusinessActive() {
        List<Empresa> results = repository.findAllByEstado(true);
        assertThat(results, is(not(nullValue())));
        assertThat(results.size(), is(2));
    }

    @Test
    public void saveBusiness() {
        Empresa empresa = new Empresa();
        empresa.setEstado(true);
        empresa.setNombre("pepe");
        empresa.setRuc("123123");
        empresa.setTelefono(123123);
        Empresa result = repository.save(empresa);
        assertThat(result, is(not(nullValue())));
        assertThat(result.getId(), is(not(nullValue())));
    }
}
