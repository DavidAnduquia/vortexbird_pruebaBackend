package com.vortexbird.vortexbird_prueba_backend.Domain;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name= "metodo_pago" , schema = "public")
public class MetodoPago {
		
	private Integer payId;
	private String nombre;
	private String enable;
	
	private List<Factura> facturas = new ArrayList<Factura>(0);

	
 
	@Id
    @Column(name = "payment_id", unique = true, nullable = false)
	@GeneratedValue(strategy = GenerationType.IDENTITY) 
	public Integer getPayId() {
		return payId;
	}

	public void setPayId(Integer payId) {
		this.payId = payId;
	}

	@Column(name = "nombre",nullable = false)
	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

    @Column(name = "enable", nullable = false)
	public String getEnable() {
		return enable;
	}

	public void setEnable(String enable) {
		this.enable = enable;
	}

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "metodoPago")
	public List<Factura> getFacturas() {
		return facturas;
	}

	public void setFacturas(List<Factura> facturas) {
		this.facturas = facturas;
	}

	
	
	
	
	

}	

 