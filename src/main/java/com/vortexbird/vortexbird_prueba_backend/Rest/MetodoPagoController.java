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

import com.vortexbird.vortexbird_prueba_backend.Domain.MetodoPago;
import com.vortexbird.vortexbird_prueba_backend.Dto.MetodoPagoDTO; 
import com.vortexbird.vortexbird_prueba_backend.Mapper.MetodoPagoMapper;
import com.vortexbird.vortexbird_prueba_backend.Service.MetodoPagoService;

@RestController // Servicio
@RequestMapping("/api/metodopago") // Ruta api
@CrossOrigin  // Acceso al origen de destino
public class MetodoPagoController {
		
	
	@Autowired
	MetodoPagoService metodoPagoService;
	
	@Autowired
	MetodoPagoMapper metodoPagoMapper;
	
   @RequestMapping("/save")
    public ResponseEntity<?> save(@RequestBody MetodoPagoDTO metodoPagoDTO) throws Exception {

        MetodoPago metodoPago = metodoPagoMapper.toMetodoPago(metodoPagoDTO);
        metodoPago = metodoPagoService.save(metodoPago);
        metodoPagoDTO = metodoPagoMapper.toMetodoPagoDTO(metodoPago);
 
        return ResponseEntity.ok().body(metodoPagoDTO);
    }
    
    @GetMapping("/findAll")
    public ResponseEntity<?> findAll() throws Exception{
    	List<MetodoPago> metodoPagos = metodoPagoService.findAll();
    	List<MetodoPagoDTO> metodoPagoDTOs = metodoPagoMapper.listToMetodoPagoDTO(metodoPagos);
    	
    	return ResponseEntity.ok().body(metodoPagoDTOs);
    }
 
    @GetMapping("/findById/{id}")
	public ResponseEntity<?> findById(@PathVariable("id") Integer id) throws Exception {

			Optional<MetodoPago> pOptional = metodoPagoService.findById(id);
			if(pOptional.isPresent()==false) {
				return ResponseEntity.ok().body("El metodo de pago no existe");
			}

			MetodoPago metodoPago  = pOptional.get();

			MetodoPagoDTO metodoPagoDTO = metodoPagoMapper.toMetodoPagoDTO(metodoPago);
           
			return ResponseEntity.ok().body(metodoPagoDTO);

	}

    @PutMapping("/update")
    public ResponseEntity<?> update(@RequestBody MetodoPagoDTO metodoPagoDTO) throws Exception {
  
        MetodoPago metodoPago=metodoPagoMapper.toMetodoPago(metodoPagoDTO);
        metodoPago=metodoPagoService.update(metodoPago);
        metodoPagoDTO = metodoPagoMapper.toMetodoPagoDTO(metodoPago);
    
        return ResponseEntity.ok().body(metodoPagoDTO);

    }
    
    
    
}
