package com.vortexbird.vortexbird_prueba_backend.Repository;

import com.vortexbird.vortexbird_prueba_backend.Domain.Factura;

import org.springframework.data.jpa.repository.JpaRepository;

public interface FacturaRepository extends JpaRepository<Factura,Integer> {
    
}
