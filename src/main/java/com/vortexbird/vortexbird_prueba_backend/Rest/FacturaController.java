package com.vortexbird.vortexbird_prueba_backend.Rest;

import java.util.List;
import java.util.Optional;

import com.vortexbird.vortexbird_prueba_backend.Domain.Factura;
import com.vortexbird.vortexbird_prueba_backend.Dto.FacturaDTO;
import com.vortexbird.vortexbird_prueba_backend.Mapper.FacturaMapper;
import com.vortexbird.vortexbird_prueba_backend.Service.FacturaService;


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
@RequestMapping("/api/factura") 
@CrossOrigin
public class FacturaController {
    
    @Autowired
    FacturaMapper facturaMapper;

    @Autowired
    FacturaService facturaService;

    @RequestMapping("/save")
    public ResponseEntity<?> save(@RequestBody FacturaDTO facturaDTO) throws Exception {

        Factura factura = facturaMapper.toFactura(facturaDTO);
        factura = facturaService.save(factura);
        facturaDTO = facturaMapper.toFacturaDTO(factura);
 
        return ResponseEntity.ok().body(facturaDTO);
    }
    
    @GetMapping("/findAll")
    public ResponseEntity<?> findAll() throws Exception{
    	List<Factura> facturas = facturaService.findAll();
    	List<FacturaDTO> facturaDTOs = facturaMapper.listToFacturaDTO(facturas);
    	
    	return ResponseEntity.ok().body(facturaDTOs);
    }
 
    @GetMapping("/findById/{id}")
	public ResponseEntity<?> findById(@PathVariable("id") Integer id) throws Exception {

			Optional<Factura> fOptional= facturaService.findById(id);
			if(fOptional.isPresent()==false) {
				return ResponseEntity.ok().body("La factura no existe");
			}

			Factura factura  = fOptional.get();

			FacturaDTO facturaDTO = facturaMapper.toFacturaDTO(factura);
           
			return ResponseEntity.ok().body(facturaDTO);

	}

    @PutMapping("/update")
    public ResponseEntity<?> update(@RequestBody FacturaDTO facturaDTO) throws Exception {
  
        Factura factura=facturaMapper.toFactura(facturaDTO);
        factura=facturaService.update(factura);
        facturaDTO = facturaMapper.toFacturaDTO(factura);
    
        return ResponseEntity.ok().body(facturaDTO);

    }


}
 