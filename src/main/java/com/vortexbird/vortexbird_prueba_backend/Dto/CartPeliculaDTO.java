package com.vortexbird.vortexbird_prueba_backend.Dto;

public class CartPeliculaDTO {
    
    private Integer cart_id;
    private String id_pelicula;
    private Integer factura;
    private Integer cantidad;
    
    public CartPeliculaDTO() {
    }


	public CartPeliculaDTO(Integer cart_id, String id_pelicula, Integer factura, Integer cantidad) {
		super();
		this.cart_id = cart_id;
		this.id_pelicula = id_pelicula;
		this.factura = factura;
		this.cantidad = cantidad;
	}
	

	public Integer getCart_id() {
		return cart_id;
	}

	public void setCart_id(Integer cart_id) {
		this.cart_id = cart_id;
	}

	public String getId_pelicula() {
		return id_pelicula;
	}

	public void setId_pelicula(String id_pelicula) {
		this.id_pelicula = id_pelicula;
	}

	public Integer getFactura() {
		return factura;
	}

	public void setFactura(Integer factura) {
		this.factura = factura;
	}

	public Integer getCantidad() {
		return cantidad;
	}

	public void setCantidad(Integer cantidad) {
		this.cantidad = cantidad;
	}

 
  

    

}
