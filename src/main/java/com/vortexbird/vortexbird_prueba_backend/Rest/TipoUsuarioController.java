package com.vortexbird.vortexbird_prueba_backend.Rest;

import java.util.List;
import java.util.Optional;

import com.vortexbird.vortexbird_prueba_backend.Domain.TipoUsuario;
import com.vortexbird.vortexbird_prueba_backend.Dto.TipoUsuarioDTO;
import com.vortexbird.vortexbird_prueba_backend.Mapper.TipoUsuarioMapper;
import com.vortexbird.vortexbird_prueba_backend.Service.TipoUsuarioService;

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
@RequestMapping("/api/tipoUsuario") // Ruta api
@CrossOrigin  // Acceso al origen de destino
public class TipoUsuarioController {
    
    @Autowired
    TipoUsuarioService tipoUsuarioService;

    @Autowired
    TipoUsuarioMapper tipoUsuarioMapper;

    @RequestMapping("/save")
    public ResponseEntity<?> save(@RequestBody TipoUsuarioDTO tipoUsuarioDTO) throws Exception {
       
        TipoUsuario tipoUsuario = tipoUsuarioMapper.toTipoUsuario(tipoUsuarioDTO);

        tipoUsuario = tipoUsuarioService.save(tipoUsuario);

        tipoUsuarioDTO= tipoUsuarioMapper.toTipoUsuarioDTO(tipoUsuario);
    
        return ResponseEntity.ok().body(tipoUsuarioDTO);
    }


    @GetMapping("/findAll")
    public ResponseEntity<?> findAll(){
    	
    	List<TipoUsuario> tipoUsuarios = tipoUsuarioService.findAll();
    	
    	List<TipoUsuarioDTO> tipoUsuarioDTOs = tipoUsuarioMapper.listToTipoUsuarioDTO(tipoUsuarios);
    	
    	return ResponseEntity.ok().body(tipoUsuarioDTOs);
    }
    
    
    @GetMapping("/findById/{rolId}")
	public ResponseEntity<?> findById(@PathVariable("rolId") String rolId) throws Exception {
       
        Optional<TipoUsuario> tOptional = tipoUsuarioService.findById(rolId);
        if(tOptional.isPresent()==false) {
            return ResponseEntity.ok().body("Tipo de rol no existe");
        }

        TipoUsuario tipoUsuario  = tOptional.get();

        TipoUsuarioDTO tipoUsuarioDTO = tipoUsuarioMapper.toTipoUsuarioDTO(tipoUsuario);
  
        return ResponseEntity.ok().body(tipoUsuarioDTO);

    }


    @PutMapping("/update")
    public ResponseEntity<?> update(@RequestBody TipoUsuarioDTO tipoUsuarioDTO) throws Exception {
    	
    	TipoUsuario tipoUsuario=tipoUsuarioMapper.toTipoUsuario(tipoUsuarioDTO);
    	tipoUsuario=tipoUsuarioService.update(tipoUsuario);
    	tipoUsuarioDTO = tipoUsuarioMapper.toTipoUsuarioDTO(tipoUsuario);
   
        return ResponseEntity.ok().body(tipoUsuarioDTO);
    }

   
}
