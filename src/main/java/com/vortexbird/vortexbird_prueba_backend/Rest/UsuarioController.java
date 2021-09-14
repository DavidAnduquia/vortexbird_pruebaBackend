package com.vortexbird.vortexbird_prueba_backend.Rest;
 
import java.util.List;
import java.util.Optional;

import com.vortexbird.vortexbird_prueba_backend.Domain.Usuario;
import com.vortexbird.vortexbird_prueba_backend.Dto.UsuarioDTO;
import com.vortexbird.vortexbird_prueba_backend.Mapper.UsuarioMapper;
import com.vortexbird.vortexbird_prueba_backend.Service.UsuarioService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController // Servicio
@RequestMapping("/api/usuario") // Ruta api
@CrossOrigin  // Acceso al origen de destino
public class UsuarioController  {

    @Autowired
    UsuarioMapper usuarioMapper;

    @Autowired
    UsuarioService usuarioService;
 


    @RequestMapping("/save")
    public ResponseEntity<?> save(@RequestBody UsuarioDTO usuariosDto) throws Exception {

        Usuario usuario = usuarioMapper.toUsuarios(usuariosDto);
        usuario = usuarioService.save(usuario);
        usuariosDto = usuarioMapper.toUsuarioDTO(usuario);
 
        return ResponseEntity.ok().body(usuariosDto);
    }
    
    @GetMapping("/findAll")
    public ResponseEntity<?> findAll() throws Exception{
    	List<Usuario> usuario = usuarioService.findAll();
    	List<UsuarioDTO> usuariosDTO = usuarioMapper.listToUsuariosDTO(usuario);
    	
    	return ResponseEntity.ok().body(usuariosDTO);
    }


    @GetMapping("/findById/{email}")
	public ResponseEntity<?> findById(@PathVariable("email") String email) throws Exception {

			Optional<Usuario> customerOptional = usuarioService.findById(email);
			if(customerOptional.isPresent()==false) {
				return ResponseEntity.ok().body("Customer Not Found");
			}

			Usuario usuario  = customerOptional.get();

			UsuarioDTO usuariosDto = usuarioMapper.toUsuarioDTO(usuario);
           
			return ResponseEntity.ok().body(usuariosDto);

	}

    @PutMapping("/update")
    public ResponseEntity<?> update(@RequestBody UsuarioDTO usuariosDto) throws Exception {
  
        Usuario usuario=usuarioMapper.toUsuarios(usuariosDto);
        usuario=usuarioService.save(usuario);
        usuariosDto = usuarioMapper.toUsuarioDTO(usuario);
    
        return ResponseEntity.ok().body(usuariosDto);

    }

 

}
