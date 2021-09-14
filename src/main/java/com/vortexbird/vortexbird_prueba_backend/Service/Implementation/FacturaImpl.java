package com.vortexbird.vortexbird_prueba_backend.Service.Implementation;

import java.util.List;
import java.util.Optional;

import com.vortexbird.vortexbird_prueba_backend.Domain.Factura;
import com.vortexbird.vortexbird_prueba_backend.Repository.FacturaRepository;
import com.vortexbird.vortexbird_prueba_backend.Service.FacturaService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;


@Service
@Scope("singleton")
public class FacturaImpl implements FacturaService {

    @Autowired
    FacturaRepository facturaRepository;



    @Override
    @Transactional(readOnly = true)
    public List<Factura> findAll() {
         return facturaRepository.findAll();
    }

    @Override
    @Transactional(readOnly = true)
    public Optional<Factura> findById(Integer id) throws Exception {
        if( id == null){
            throw new Exception("El id factura es nulo");
        }  
        
        return facturaRepository.findById(id);
    }

    @Override
    @Transactional(readOnly = false, propagation = Propagation.REQUIRED, rollbackFor =Exception.class)
    public Factura save(Factura entity) throws Exception {
       
        if(entity == null){
            throw new Exception("Error con los datos");
        }

        return facturaRepository.save(entity);
    }

    @Override
    @Transactional(readOnly = false, propagation = Propagation.REQUIRED, rollbackFor =Exception.class)
    public Factura update(Factura entity) throws Exception {
        
        if(entity == null ) {
        	throw new Exception("La entidad es nula");
        }
        
        if(facturaRepository.existsById(entity.getFactura_id())==false ) {
            throw new Exception("La factura "+ entity.getFactura_id() +" del cliente  "+entity.getUsuario().getEmail() +" No existe");
        }

        return facturaRepository.save(entity);
    }
    
}
