package pe.tinker.solutions.db.repository;

import org.springframework.data.repository.CrudRepository;
import pe.tinker.solutions.db.model.Empresa;

import java.util.List;

/**
 * Created on 27/12/2017.
 *
 * @author Entelgy
 */
public interface IEmpresaRepository extends CrudRepository<Empresa, Integer> {

    List<Empresa> findAllByEstado(Boolean status);

}
