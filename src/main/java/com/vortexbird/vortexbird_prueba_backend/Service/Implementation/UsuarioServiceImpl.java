package com.vortexbird.vortexbird_prueba_backend.Service.Implementation;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.vortexbird.vortexbird_prueba_backend.Domain.Usuario;
import com.vortexbird.vortexbird_prueba_backend.Repository.UsuariosRepository;
import com.vortexbird.vortexbird_prueba_backend.Service.UsuarioService;

@Service
@Scope("singleton")
public class UsuarioServiceImpl implements UsuarioService {

    @Autowired
    UsuariosRepository usuariosRepository;

  

    @Override
    //@Transactional(readOnly = true)
    public List<Usuario> findAll() {
        return usuariosRepository.findAll();
    }

    @Override
    //@Transactional(readOnly = true)
    public Optional<Usuario> findById(String id) throws Exception {
        if (id == null) {
            throw new Exception("Error con el identificador");
        }

        return usuariosRepository.findById(id);
    }


    @Override
   // @Transactional(readOnly = false, propagation = Propagation.REQUIRED, rollbackFor =Exception.class)
    public Usuario save(Usuario entity) throws Exception {
        if(entity != null){

            if (usuariosRepository.existsById(entity.getEmail() )) {
                throw new Exception("Correo ya registrado");
            }
     
            return usuariosRepository.save(entity); 
        }

        throw new Exception("Error con los datos");

    }


    @Override
    //@Transactional(readOnly = false, propagation = Propagation.REQUIRED, rollbackFor =Exception.class)
    public Usuario update(Usuario entity) throws Exception {

        if(usuariosRepository.existsById(entity.getEmail())==false ) {
				throw new Exception("El cliente ya con id "+entity.getEmail() +" No existe");
		}
        
		return usuariosRepository.save(entity);
    }

}
