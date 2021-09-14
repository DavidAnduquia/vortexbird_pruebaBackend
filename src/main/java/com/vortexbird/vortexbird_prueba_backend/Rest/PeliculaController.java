package com.vortexbird.vortexbird_prueba_backend.Rest;

import java.util.List;
import java.util.Optional;

import com.vortexbird.vortexbird_prueba_backend.Domain.Pelicula;
 
import com.vortexbird.vortexbird_prueba_backend.Dto.PeliculaDTO;
import com.vortexbird.vortexbird_prueba_backend.Mapper.PeliculaMapper;
import com.vortexbird.vortexbird_prueba_backend.Service.PeliculaService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/pelicula") 
@CrossOrigin
public class PeliculaController {
    
    @Autowired
    PeliculaService peliculaService;

    @Autowired
    PeliculaMapper peliculaMapper;
    

    @RequestMapping("/save")
    public ResponseEntity<?> save(@RequestBody PeliculaDTO peliculaDTO) throws Exception {

        Pelicula pelicula = peliculaMapper.toPelicula(peliculaDTO);
        pelicula = peliculaService.save(pelicula);
        peliculaDTO = peliculaMapper.toPeliculaDTO(pelicula);
 
        return ResponseEntity.ok().body(peliculaDTO);
    }
    
    @GetMapping("/findAll")
    public ResponseEntity<?> findAll() throws Exception{
    	List<Pelicula> peliculas = peliculaService.findAll();
    	List<PeliculaDTO> peliculaDTOs = peliculaMapper.listToPeliculaDTO(peliculas);
    	
    	return ResponseEntity.ok().body(peliculaDTOs);
    }
 
    @GetMapping("/findById/{id}")
	public ResponseEntity<?> findById(@PathVariable("id") Integer id) throws Exception {

			Optional<Pelicula> pOptional = peliculaService.findById(id);
			if(pOptional.isPresent()==false) {
				return ResponseEntity.ok().body("Pelicula no existe");
			}

			Pelicula pelicula  = pOptional.get();

			PeliculaDTO peliculaDTO = peliculaMapper.toPeliculaDTO(pelicula);
           
			return ResponseEntity.ok().body(peliculaDTO);

	}

    @PutMapping("/update")
    public ResponseEntity<?> update(@RequestBody PeliculaDTO peliculaDTO) throws Exception {
  
        Pelicula pelicula=peliculaMapper.toPelicula(peliculaDTO);
        pelicula=peliculaService.update(pelicula);
        peliculaDTO = peliculaMapper.toPeliculaDTO(pelicula);
    
        return ResponseEntity.ok().body(peliculaDTO);

    }
    

 

}
