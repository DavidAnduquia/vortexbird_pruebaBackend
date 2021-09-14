package com.vortexbird.vortexbird_prueba_backend.Domain;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "factura" , schema =  "public")
public class Factura {
    

    private Integer factura_id;
    private MetodoPago metodoPago;
    private Usuario usuario;
    private double total;
    private String enable;
 
    
    private List<CartPelicula> cartPeliculas = new ArrayList<CartPelicula>(0);

    @Id
    @Column(name = "factura_id", unique = true, nullable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY) 
    public Integer getFactura_id() {
        return factura_id;
    }

    public void setFactura_id(Integer factura_id) {
        this.factura_id = factura_id;
    }



    @Column(name = "total", nullable = false)
    public double getTotal() {
        return total;
    }

    public void setTotal(double total) {
        this.total = total;
    }

    @Column(name = "enable", nullable = false)
    public String getEnable() {
        return enable;
    }

    public void setEnable(String enable) {
        this.enable = enable;
    }

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "factura")
    public List<CartPelicula> getCartPeliculas() {
        return cartPeliculas;
    }

    public void setCartPeliculas(List<CartPelicula> cartPeliculas) {
        this.cartPeliculas = cartPeliculas;
    }
    
    @ManyToOne(fetch =  FetchType.LAZY)
    @JoinColumn(name ="payment_id")
    public MetodoPago getMetodoPago() {
		return metodoPago;
	}

	public void setMetodoPago(MetodoPago metodoPago) {
		this.metodoPago = metodoPago;
	}

 
   
    @ManyToOne(fetch =  FetchType.LAZY)
    @JoinColumn(name ="email")
    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }
   
}
