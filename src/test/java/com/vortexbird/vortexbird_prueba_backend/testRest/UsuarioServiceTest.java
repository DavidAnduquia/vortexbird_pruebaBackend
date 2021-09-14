package com.vortexbird.vortexbird_prueba_backend.testRest;

import org.junit.jupiter.api.MethodOrderer.OrderAnnotation;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Rollback;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

import com.vortexbird.vortexbird_prueba_backend.Domain.TipoUsuario;
import com.vortexbird.vortexbird_prueba_backend.Domain.Usuario;
import com.vortexbird.vortexbird_prueba_backend.Service.TipoUsuarioService;
import com.vortexbird.vortexbird_prueba_backend.Service.UsuarioService;
import static org.junit.jupiter.api.Assertions.assertTrue;


@SpringBootTest
@Rollback(false)
@TestMethodOrder(OrderAnnotation.class)
public class UsuarioServiceTest {

 	private final static Logger log = LoggerFactory.getLogger(UsuarioServiceTest.class);

    @Autowired
    UsuarioService usuarioService;

    @Autowired
    TipoUsuarioService tipoUsuarioService;

    private String email = "daledro-1998@hotmail.com";

    @Order(1)
    @Test
    @Transactional
    public void save() throws Exception{
        Usuario usuario = new Usuario();
        log.info("msg");
        
        usuario.setEmail(email);
        usuario.setNombre("David");
        usuario.setApellido("anduquia");
        usuario.setPassword("1234");
        usuario.setEnable("Y");
       
        Optional<TipoUsuario> optionalUsuario = tipoUsuarioService.findById("tp02");
        assertTrue(optionalUsuario.isPresent(),"El tipo de usuario no existe");

        TipoUsuario tipoUsuario= optionalUsuario.get();

        
        usuario.setTipoUsuario(tipoUsuario);

        usuarioService.save(usuario);
    }


    @Order(2)
    @Test
    public void findById() throws Exception{
        Optional<Usuario> uOptional = usuarioService.findById(email);
        assertTrue(uOptional.isPresent(), "El  usuario  existe");
    }

    @Order(3)
    @Test
    public void update() throws Exception {
        Optional<Usuario> uOptional = usuarioService.findById(email);
        assertTrue(uOptional.isPresent(),"El  usuario existe");

        Usuario usuario = uOptional.get();
        usuario.setNombre("David Alejandro");
        usuarioService.update(usuario);
    }

}
