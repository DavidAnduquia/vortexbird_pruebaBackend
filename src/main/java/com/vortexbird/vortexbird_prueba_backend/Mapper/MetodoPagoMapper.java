package com.vortexbird.vortexbird_prueba_backend.Mapper;

import java.util.List;

import org.mapstruct.Mapper;

import com.vortexbird.vortexbird_prueba_backend.Domain.MetodoPago;
 import com.vortexbird.vortexbird_prueba_backend.Dto.MetodoPagoDTO;
 
@Mapper
public interface MetodoPagoMapper {
			
	
	public MetodoPagoDTO toMetodoPagoDTO(MetodoPago metodoPago);
	
	public MetodoPago toMetodoPago(MetodoPagoDTO metodoPagoDTO);
	
	public List<MetodoPago> listToMetodoPago(List<MetodoPagoDTO> metodoPagoDTO);
 
	public List<MetodoPagoDTO> listToMetodoPagoDTO(List<MetodoPago> metodoPago);
}



 