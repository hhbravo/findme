package pe.tinker.solutions.rest.controller.mapper.impl;

import ma.glasnost.orika.MapperFactory;
import ma.glasnost.orika.impl.ConfigurableMapper;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import pe.tinker.solutions.db.model.Empresa;
import pe.tinker.solutions.rest.controller.mapper.ICreateEmpresaMapper;
import pe.tinker.solutions.rest.dto.EmpresaDTO;
import pe.tinker.solutions.rest.util.Mapper;

@Mapper
public class CreateEmpresaMapper extends ConfigurableMapper implements ICreateEmpresaMapper {

    private static final Log LOG = LogFactory.getLog(CreateEmpresaMapper.class);

    @Override
    protected void configure(MapperFactory factory) {
        super.configure(factory);

        factory.classMap(Empresa.class, EmpresaDTO.class)
                .field("nombre", "nombre")
                .field("ruc", "ruc")
                .field("telefono", "telefono")
                .register();
    }

    @Override
    public Empresa mapIn(EmpresaDTO empresaDTO) {
        Empresa empresa = map(empresaDTO, Empresa.class);
        empresa.setEstado(true);
        return empresa;
    }
}
