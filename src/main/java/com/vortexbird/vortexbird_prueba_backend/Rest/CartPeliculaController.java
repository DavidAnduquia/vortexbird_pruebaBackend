package com.vortexbird.vortexbird_prueba_backend.Rest;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.vortexbird.vortexbird_prueba_backend.Domain.CartPelicula;
import com.vortexbird.vortexbird_prueba_backend.Dto.CartPeliculaDTO;
import com.vortexbird.vortexbird_prueba_backend.Mapper.CartPeliculaMapper;
import com.vortexbird.vortexbird_prueba_backend.Service.CartPeliculaService;

@RestController
@RequestMapping("/api/cartpelicula") 
@CrossOrigin
public class CartPeliculaController {
	
	@Autowired
	CartPeliculaService cartPeliculaService;
	
	@Autowired
	CartPeliculaMapper cartPeliculaMapper;
	
	
	@RequestMapping("/save")
    public ResponseEntity<?> save(@RequestBody CartPeliculaDTO cartPeliculaDTO) throws Exception {

        CartPelicula cartPelicula = cartPeliculaMapper.toCartPelicula(cartPeliculaDTO);
        cartPelicula = cartPeliculaService.save(cartPelicula);
        cartPeliculaDTO = cartPeliculaMapper.toCartPeliculaDTO(cartPelicula);
 
        return ResponseEntity.ok().body(cartPeliculaDTO);
    }
    
    @GetMapping("/findAll")
    public ResponseEntity<?> findAll() throws Exception{
    	List<CartPelicula> cartPelicula = cartPeliculaService.findAll();
    	List<CartPeliculaDTO> cartPeliculaDTOs = cartPeliculaMapper.listToPeliculaDTO(cartPelicula);
    	
    	return ResponseEntity.ok().body(cartPeliculaDTOs);
    }
 
    @GetMapping("/findById/{id}")
	public ResponseEntity<?> findById(@PathVariable("id") Integer id) throws Exception {

			Optional<CartPelicula> carOptional = cartPeliculaService.findById(id);
			if(carOptional.isPresent()==false) {
				return ResponseEntity.ok().body("El carrito de peliculas no existe");
			}

			CartPelicula cartPelicula  = carOptional.get();
			CartPeliculaDTO cartPeliculaDTOs = cartPeliculaMapper.toCartPeliculaDTO(cartPelicula);
           
			return ResponseEntity.ok().body(cartPeliculaDTOs);

	}

    @PutMapping("/update")
    public ResponseEntity<?> update(@RequestBody CartPeliculaDTO cartPeliculaDTO) throws Exception {
  
    	CartPelicula cartPelicula=cartPeliculaMapper.toCartPelicula(cartPeliculaDTO);
    	cartPelicula=cartPeliculaService.update(cartPelicula);
        cartPeliculaDTO = cartPeliculaMapper.toCartPeliculaDTO(cartPelicula);
    
        return ResponseEntity.ok().body(cartPeliculaDTO);

    }
    
}
