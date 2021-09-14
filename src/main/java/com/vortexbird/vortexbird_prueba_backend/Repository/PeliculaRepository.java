package com.vortexbird.vortexbird_prueba_backend.Repository;

import com.vortexbird.vortexbird_prueba_backend.Domain.Pelicula;

import org.springframework.data.jpa.repository.JpaRepository;

public interface PeliculaRepository extends JpaRepository<Pelicula,Integer> {
    
}
