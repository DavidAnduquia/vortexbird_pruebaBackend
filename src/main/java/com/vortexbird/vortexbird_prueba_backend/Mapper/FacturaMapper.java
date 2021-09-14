package com.vortexbird.vortexbird_prueba_backend.Mapper;

import java.util.List;

import com.vortexbird.vortexbird_prueba_backend.Domain.Factura;
import com.vortexbird.vortexbird_prueba_backend.Dto.FacturaDTO;

import org.mapstruct.Mapper;

@Mapper
public interface FacturaMapper {
    

    public FacturaDTO toFacturaDTO(Factura factura);
    
    public Factura toFactura(FacturaDTO facturaDTO);

    public List <FacturaDTO> listToFacturaDTO(List<Factura> facturas);

    public List<Factura> listToFactura(List<FacturaDTO> facturaDTOs);


}
