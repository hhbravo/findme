package pe.tinker.solutions.rest.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pe.tinker.solutions.db.model.Empresa;
import pe.tinker.solutions.db.repository.IEmpresaRepository;
import pe.tinker.solutions.rest.service.IEmpresaService;

import java.util.List;

@Service
public class EmpresaServiceImpl implements IEmpresaService {

    @Autowired
    private IEmpresaRepository empresaRepository;

    @Override
    public Empresa createEmpresa(Empresa empresa) {
        return empresaRepository.save(empresa);
    }

    @Override
    public List<Empresa> findAllEmpresa() {
        List<Empresa> empresas = empresaRepository.findAllByEstado(true);
        if (empresas == null || empresas.isEmpty()) {
            return null;
        }
        return empresas;
    }
}
