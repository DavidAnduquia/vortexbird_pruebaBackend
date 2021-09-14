package com.vortexbird.vortexbird_prueba_backend.Dto;

public class FacturaDTO {

	private Integer factura_id;
	private Integer payment_id;
	private String email;
	private double total;
	private String enable;
	
	
	public FacturaDTO() {
		super();
	}
	
	
	
 
	
	public FacturaDTO(Integer factura_id, Integer payment_id, String email, double total, String enable) {
		super();
		this.factura_id = factura_id;
		this.payment_id = payment_id;
		this.email = email;
		this.total = total;
		this.enable = enable;
	}





	public Integer getPayment_id() {
		return payment_id;
	}





	public void setPayment_id(Integer payment_id) {
		this.payment_id = payment_id;
	}





	public Integer getFactura_id() {
		return factura_id;
	}
	public void setFactura_id(Integer factura_id) {
		this.factura_id = factura_id;
	}
 
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public double getTotal() {
		return total;
	}
	public void setTotal(double total) {
		this.total = total;
	}
	public String getEnable() {
		return enable;
	}
	public void setEnable(String enable) {
		this.enable = enable;
	}
	
	
	
	    
	    
}
