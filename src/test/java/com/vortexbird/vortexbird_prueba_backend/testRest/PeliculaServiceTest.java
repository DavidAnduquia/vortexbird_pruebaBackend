package com.vortexbird.vortexbird_prueba_backend.testRest;

import static org.junit.jupiter.api.Assertions.assertNotNull;

import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.junit.jupiter.api.MethodOrderer.OrderAnnotation;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Rollback;
import org.springframework.transaction.annotation.Transactional;

import com.vortexbird.vortexbird_prueba_backend.Domain.Pelicula;
import com.vortexbird.vortexbird_prueba_backend.Service.PeliculaService;
 

@SpringBootTest
@Rollback(false)
@TestMethodOrder(OrderAnnotation.class)
public class PeliculaServiceTest {
	   private static final Logger log = LoggerFactory.getLogger(TipoUsuarioServiceTest.class);

	    @Autowired
	    public PeliculaService peliculaService;
	    
	    private Integer idpeli = 1;

	    @Order(1)
	    @Transactional
	    @Test
	    public void save() throws Exception{
	        Pelicula pelicula = new Pelicula();

	        pelicula.setId_pelicula(0);
	        pelicula.setNombre_pelicula("Terminator");
	        pelicula.setDescripcion("Pelicula del futuro");
	        pelicula.setDuracion(200);
	        
	        pelicula = peliculaService.save(pelicula);
	      
	        idpeli=pelicula.getId_pelicula();
	        log.info("El id es ", idpeli);
			assertNotNull(idpeli,"El id rol es nulo");
	    }

}
