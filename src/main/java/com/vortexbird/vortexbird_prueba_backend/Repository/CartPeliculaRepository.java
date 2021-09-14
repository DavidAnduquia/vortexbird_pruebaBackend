package com.vortexbird.vortexbird_prueba_backend.Repository;

import com.vortexbird.vortexbird_prueba_backend.Domain.CartPelicula;

import org.springframework.data.jpa.repository.JpaRepository;

public interface CartPeliculaRepository extends JpaRepository<CartPelicula,Integer> {
    
}
