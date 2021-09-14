package com.vortexbird.vortexbird_prueba_backend.testRest;

 
import static org.junit.jupiter.api.Assertions.assertNotNull;

import java.util.Optional;

import javax.transaction.Transactional;

import com.vortexbird.vortexbird_prueba_backend.Domain.Factura;
import com.vortexbird.vortexbird_prueba_backend.Domain.MetodoPago;
import com.vortexbird.vortexbird_prueba_backend.Domain.Usuario;
import com.vortexbird.vortexbird_prueba_backend.Service.FacturaService;
import com.vortexbird.vortexbird_prueba_backend.Service.MetodoPagoService;
import com.vortexbird.vortexbird_prueba_backend.Service.UsuarioService;

import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.junit.jupiter.api.MethodOrderer.OrderAnnotation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Rollback;

@SpringBootTest
@Rollback(false)
@TestMethodOrder(OrderAnnotation.class)
public class FacturaServiceTest {
    

    @Autowired
    public FacturaService facturaService;

    @Autowired
    public UsuarioService usuarioService;

    @Autowired
    public MetodoPagoService metodoPagoService;
    
    private Integer idfactu = 1;

    @Order(1)
    @Transactional
    @Test
    public void save() throws Exception{
        Factura factura = new Factura();
        Optional<Usuario> usuario = usuarioService.findById("daledro-1998@hotmail.com");
        Optional<MetodoPago> metodo = metodoPagoService.findById(3);

        factura.setEnable("Y");
        factura.setTotal(120);
 
        factura.setMetodoPago( metodo.get() );
        factura.setUsuario( usuario.get() );
        factura = facturaService.save(factura);
      
        idfactu=factura.getFactura_id();
        //log.info("El id es ", idpeli);
        assertNotNull(idfactu,"El id de la factura es nulo");
    }
}
