package pe.tinker.solutions.rest.controller.mapper;

import pe.tinker.solutions.db.model.Empresa;
import pe.tinker.solutions.rest.dto.EmpresaDTO;

public interface ICreateEmpresaMapper {

    Empresa mapIn(EmpresaDTO empresaDTO);
}
