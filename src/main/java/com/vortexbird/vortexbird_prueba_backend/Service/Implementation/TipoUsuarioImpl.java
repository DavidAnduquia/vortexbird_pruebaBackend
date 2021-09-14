package com.vortexbird.vortexbird_prueba_backend.Service.Implementation;

import java.util.List;
import java.util.Optional;

 
 
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import com.vortexbird.vortexbird_prueba_backend.Domain.TipoUsuario;
import com.vortexbird.vortexbird_prueba_backend.Repository.Tipos_usuariosRepository;
import com.vortexbird.vortexbird_prueba_backend.Service.TipoUsuarioService;


@Service
@Scope("singleton")
public class TipoUsuarioImpl implements TipoUsuarioService {


    @Autowired
    Tipos_usuariosRepository tipos_usuariosRepository;

    @Override
    @Transactional(readOnly = true)
    public List<TipoUsuario> findAll() {
        return tipos_usuariosRepository.findAll();
    }

    @Override
    @Transactional(readOnly = true)
    public Optional<TipoUsuario> findById(String id) throws Exception {
        if( id == null){
            throw new Exception("El id tipo usuario es nulo");
        }
        return tipos_usuariosRepository.findById(id);
    }

    @Override
    @Transactional(readOnly = false, propagation = Propagation.REQUIRED, rollbackFor =Exception.class)
    public TipoUsuario save(TipoUsuario entity) throws Exception {
        if(entity != null){

            if(tipos_usuariosRepository.existsById(entity.getTipo_rol() )){
                throw new Exception("Correo ya registrado");
            }

            return tipos_usuariosRepository.save(entity);
        }
        throw new Exception("Error con los datos");
    }

    @Override
    @Transactional(readOnly = false, propagation = Propagation.REQUIRED, rollbackFor =Exception.class)
    public TipoUsuario update(TipoUsuario entity) throws Exception {


        if(entity == null){
            throw new Exception("Entity null");
        }

        if(tipos_usuariosRepository.existsById(entity.getTipo_rol())==false) {
			throw new Exception("El tipo usuario  con id:"+entity.getNombre_rol()+" no existe");
		}
        
		return tipos_usuariosRepository.save(entity);
    }

}
