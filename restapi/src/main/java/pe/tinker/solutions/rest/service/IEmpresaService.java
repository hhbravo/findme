package pe.tinker.solutions.rest.service;

import pe.tinker.solutions.db.model.Empresa;

import java.util.List;

public interface IEmpresaService {

    Empresa createEmpresa(Empresa empresa);

    List<Empresa> findAllEmpresa();
}
