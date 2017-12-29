package pe.tinker.solutions.rest.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import pe.tinker.solutions.db.model.Empresa;
import pe.tinker.solutions.rest.dto.EmpresaDTO;
import pe.tinker.solutions.rest.service.IEmpresaService;

import java.util.List;

@CrossOrigin
@RestController
@RequestMapping(value = "/public")
public class PublicController {

    @Autowired
    private IEmpresaService empresaService;

    @RequestMapping(path = "/empresa", method = RequestMethod.GET)
    public List<Empresa> findAllEmpresa() {
        return empresaService.findAllEmpresa();
    }

}
