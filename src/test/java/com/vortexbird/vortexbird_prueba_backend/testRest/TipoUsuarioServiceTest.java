package com.vortexbird.vortexbird_prueba_backend.testRest;

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

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.Optional;

import com.vortexbird.vortexbird_prueba_backend.Domain.TipoUsuario;
import com.vortexbird.vortexbird_prueba_backend.Service.TipoUsuarioService;


@SpringBootTest
@Rollback(false)
@TestMethodOrder(OrderAnnotation.class)
public class TipoUsuarioServiceTest {

    private static final Logger log = LoggerFactory.getLogger(TipoUsuarioServiceTest.class);

    @Autowired
    public TipoUsuarioService tipoUsuarioService;
    
    private String tipo = "tp03";

    @Order(1)
    @Transactional
    @Test
    public void save() throws Exception{
        TipoUsuario tipoUsuario = new TipoUsuario();

        tipoUsuario.setTipo_rol(tipo);
        tipoUsuario.setNombre_rol("administrador");

        tipoUsuario = tipoUsuarioService.save(tipoUsuario);
        tipo=tipoUsuario.getTipo_rol();
        log.info("El id es ", tipo);
		assertNotNull(tipo,"El id rol es nulo");
    }

    @Order(2)
    @Transactional
    @Test
    public void findById() throws Exception{
        Optional<TipoUsuario> tipoUsuarioOpt = tipoUsuarioService.findById(tipo);
        assertTrue(tipoUsuarioOpt.isPresent(), "El tipo usuario no existe");
    }

    @Order(3)
    @Transactional
    @Test
    public void update()throws Exception{
        Optional<TipoUsuario> tiOptional = tipoUsuarioService.findById(tipo);
        assertTrue(tiOptional.isPresent(),"El tipo de usuario existe");

        TipoUsuario tipoUsuario = tiOptional.get();
        tipoUsuario.setNombre_rol("Rol_actualizado");
        tipoUsuarioService.update(tipoUsuario);

    }


}
