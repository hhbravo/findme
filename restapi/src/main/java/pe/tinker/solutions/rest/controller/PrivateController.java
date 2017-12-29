package pe.tinker.solutions.rest.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import pe.tinker.solutions.db.model.Empresa;
import pe.tinker.solutions.rest.controller.mapper.ICreateEmpresaMapper;
import pe.tinker.solutions.rest.dto.EmpresaDTO;
import pe.tinker.solutions.rest.service.IEmpresaService;

@CrossOrigin
@RestController
@RequestMapping(value = "/private")
public class PrivateController {

    @Autowired
    private IEmpresaService empresaService;

    @Autowired
    private ICreateEmpresaMapper createEmpresaMapper;

    @RequestMapping(path = "/empresa", method = RequestMethod.POST)
    public Empresa createEmpresa(@RequestBody EmpresaDTO dto) {
        return empresaService.createEmpresa(createEmpresaMapper.mapIn(dto));
    }


}
