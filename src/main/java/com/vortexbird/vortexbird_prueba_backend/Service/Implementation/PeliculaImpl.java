package com.vortexbird.vortexbird_prueba_backend.Service.Implementation;

import java.util.List;
import java.util.Optional;

 

import com.vortexbird.vortexbird_prueba_backend.Domain.Pelicula;
import com.vortexbird.vortexbird_prueba_backend.Repository.PeliculaRepository;
import com.vortexbird.vortexbird_prueba_backend.Service.PeliculaService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

@Service
@Scope("singleton")
public class PeliculaImpl implements PeliculaService {

    @Autowired
    PeliculaRepository peliculaRepository;


    @Override
    @Transactional(readOnly = true)
    public List<Pelicula> findAll() {
        return peliculaRepository.findAll();
    }

    @Override
    @Transactional(readOnly = true)
    public Optional<Pelicula> findById(Integer id) throws Exception {
        if (id == null) {
            throw new Exception("Error con el identificador");
        }

        return peliculaRepository.findById(id);
    }

    @Override
    @Transactional(readOnly = false, propagation = Propagation.REQUIRED, rollbackFor =Exception.class)
    public Pelicula save(Pelicula entity) throws Exception {
        if(entity == null){
            throw new Exception("Error con los datos");
        }

        return peliculaRepository.save(entity);
    }

    @Override
    @Transactional(readOnly = false, propagation = Propagation.REQUIRED, rollbackFor =Exception.class)
    public Pelicula update(Pelicula entity) throws Exception {
        if(entity == null ) {
        	throw new Exception("La entidad es nula");
        }
        
        if(peliculaRepository.existsById(entity.getId_pelicula())==false ) {
            throw new Exception("La pelicula  "+entity.getNombre_pelicula() +" No existe");
        }
        
        return peliculaRepository.save(entity);
    }
    
}
