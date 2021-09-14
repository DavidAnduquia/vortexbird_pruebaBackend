package com.vortexbird.vortexbird_prueba_backend.Service.Implementation;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.vortexbird.vortexbird_prueba_backend.Domain.MetodoPago;
import com.vortexbird.vortexbird_prueba_backend.Repository.MetodoPagoRepository;
import com.vortexbird.vortexbird_prueba_backend.Service.MetodoPagoService;

@Service
@Scope("singleton")
public class MetodoPagoImpl implements MetodoPagoService {
	
	@Autowired
	MetodoPagoRepository metodoPagoRepository;
 
	
	@Override
    @Transactional(readOnly = true)
	public List<MetodoPago> findAll() {
		return metodoPagoRepository.findAll();
	}

	@Override
    @Transactional(readOnly = true)
	public Optional<MetodoPago> findById(Integer id) throws Exception {
		if( id == null ) {
			throw new Exception("Error en el id");
		}
		
		return metodoPagoRepository.findById(id);
	}

	@Override
    @Transactional(readOnly = false, propagation = Propagation.REQUIRED, rollbackFor =Exception.class)
	public MetodoPago save(MetodoPago entity) throws Exception {
		if(entity == null) {
			throw new Exception("Datos nulos");
		}
		return metodoPagoRepository.save(entity);
	}

	@Override
    @Transactional(readOnly = false, propagation = Propagation.REQUIRED, rollbackFor =Exception.class)
	public MetodoPago update(MetodoPago entity) throws Exception {
		  if(entity == null ) {
	        	throw new Exception("La entidad es nula");
	        }
	        
	        if(metodoPagoRepository.existsById(entity.getPayId())== false ) {
	            throw new Exception("El metodo de pago  "+entity.getNombre() +" No existe");
	        }
	        
	        return metodoPagoRepository.save(entity);
	}

}
