package com.vortexbird.vortexbird_prueba_backend.Dto;

public class MetodoPagoDTO {

	private Integer payId;
	private String nombre;
	private String enable;




	
	public MetodoPagoDTO() {
	}


	public MetodoPagoDTO(Integer payId, String nombre, String enable) {
		this.payId = payId;
		this.nombre = nombre;
		this.enable = enable;
	}

	
	public Integer getPayId() {
		return payId;
	}
	public void setPayId(Integer payId) {
		this.payId = payId;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public String getEnable() {
		return enable;
	}
	public void setEnable(String enable) {
		this.enable = enable;
	}
	
	
	 
	
}
