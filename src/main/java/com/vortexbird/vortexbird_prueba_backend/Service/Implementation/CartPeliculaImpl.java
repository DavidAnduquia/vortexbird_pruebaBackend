package com.vortexbird.vortexbird_prueba_backend.Service.Implementation;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.vortexbird.vortexbird_prueba_backend.Domain.CartPelicula;
import com.vortexbird.vortexbird_prueba_backend.Mapper.CartPeliculaMapper;
import com.vortexbird.vortexbird_prueba_backend.Repository.CartPeliculaRepository;
import com.vortexbird.vortexbird_prueba_backend.Service.CartPeliculaService;

@Service
@Scope("singleton")
public class CartPeliculaImpl implements CartPeliculaService{
	
	
	@Autowired
	CartPeliculaRepository cartPeliculaRepository;
	
	@Autowired
	CartPeliculaMapper cartPeliculaMapper;
	
	@Override
    @Transactional(readOnly = true)
	public List<CartPelicula> findAll() {
 		return cartPeliculaRepository.findAll();
	}

	@Override
    @Transactional(readOnly = true)
	public Optional<CartPelicula> findById(Integer id) throws Exception {
 		if( id  == null || id < -1) {
 			throw new Exception("Error con el id");
 		}
 		
 		return cartPeliculaRepository.findById(id);
	}

	@Override
    @Transactional(readOnly = false, propagation = Propagation.REQUIRED, rollbackFor =Exception.class)
	public CartPelicula save(CartPelicula entity) throws Exception {
 		if(entity == null) {
 			throw new Exception("Error con los datos nulos");
 		}
		
		return cartPeliculaRepository.save(entity);
	}

	@Override
    @Transactional(readOnly = false, propagation = Propagation.REQUIRED, rollbackFor =Exception.class)
	public CartPelicula update(CartPelicula entity) throws Exception {
	    if(entity == null ) {
        	throw new Exception("La entidad es nula");
        }
	    
		if(cartPeliculaRepository.existsById(entity.getCart_id()) == false) {
			throw new Exception("La pelicula no existe");
		}
		
		return cartPeliculaRepository.save(entity);
	}

}
