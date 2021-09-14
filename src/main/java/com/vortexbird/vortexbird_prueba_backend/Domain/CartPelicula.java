package com.vortexbird.vortexbird_prueba_backend.Domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name="cart_pelicula", schema = "public" )
public class CartPelicula {


    private Integer cart_id;
    private Pelicula pelicula;
    private Factura factura;
    private Integer cantidad;



    @Id
	@Column(name = "cart_id", unique = true, nullable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY) 
    public Integer getCart_id() {
        return cart_id;
    }


    public void setCart_id(Integer cart_id) {
        this.cart_id = cart_id;
    }

    @ManyToOne(fetch =  FetchType.LAZY)
    @JoinColumn(name = "pelicula_id")
    public Pelicula getPelicula() {
        return pelicula;
    }


    public void setPelicula(Pelicula pelicula) {
        this.pelicula = pelicula;
    }


	
  @ManyToOne(fetch =  FetchType.LAZY)
  @JoinColumn(name = "factura_id")
  public Factura getFactura() {
        return factura;
    }

    public void setFactura(Factura factura) {
        this.factura = factura;
    }

    
	@Column(name = "cantidad", nullable = false)
    public Integer getCantidad() {
        return cantidad;
    }

    public void setCantidad(Integer cantidad) {
        this.cantidad = cantidad;
    }

    




    
}
