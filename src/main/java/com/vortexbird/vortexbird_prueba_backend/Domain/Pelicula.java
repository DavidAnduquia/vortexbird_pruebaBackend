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
@Table(name ="pelicula" , schema = "public")
public class Pelicula {

    private Integer id_pelicula;
    private String nombre_pelicula;
    private String descripcion;
    private String estreno;
    private Integer duracion;
    private double precio;
    private String enable;
    private String img_url;

    private List<CartPelicula> cartPeliculas = new ArrayList<CartPelicula>(0);

    public Pelicula() {
    }


    public Pelicula(Integer id_pelicula, String nombre_pelicula, String descripcion, String estreno, Integer duracion,
			double precio, String enable, String img_url, List<CartPelicula> cartPeliculas) {
		super();
		this.id_pelicula = id_pelicula;
		this.nombre_pelicula = nombre_pelicula;
		this.descripcion = descripcion;
		this.estreno = estreno;
		this.duracion = duracion;
		this.precio = precio;
		this.enable = enable;
		this.img_url = img_url;
		this.cartPeliculas = cartPeliculas;
	}


	@Id
	@Column(name = "id_pelicula", unique = true, nullable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY) 
    public Integer getId_pelicula() {
        return id_pelicula;
    }
    public void setId_pelicula(Integer id_pelicula) {
        this.id_pelicula = id_pelicula;
    }

    @Column(name = "nombre_pelicula")
    public String getNombre_pelicula() {
        return nombre_pelicula;
    }
    public void setNombre_pelicula(String nombre_pelicula) {
        this.nombre_pelicula = nombre_pelicula;
    }

    @Column(name = "descripcion")
    public String getDescripcion() {
        return descripcion;
    }
    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    @Column(name = "estreno")
    public String getEstreno() {
        return estreno;
    }

    public void setEstreno(String estreno) {
        this.estreno = estreno;
    }

    @Column(name = "duracion")
    public Integer getDuracion() {
        return duracion;
    }
    public void setDuracion(Integer duracion) {
        this.duracion = duracion;
    }

    @Column(name = "precio", nullable = false)
    public double getPrecio() {
        return precio;
    }
    public void setPrecio(double precio) {
        this.precio = precio;
    }

    @Column(name = "enable", nullable = false)
    public String getEnable() {
        return enable;
    }
    public void setEnable(String enable) {
        this.enable = enable;
    }


    @Column(name = "img_url", nullable = false)
    public String getImg_url() {
		return img_url;
	}


	public void setImg_url(String img_url) {
		this.img_url = img_url;
	}


	@OneToMany(cascade = CascadeType.ALL, mappedBy = "pelicula")
    public List<CartPelicula> getCartPeliculas() {
        return cartPeliculas;
    }

    public void setCartPeliculas(List<CartPelicula> cartPeliculas) {
        this.cartPeliculas = cartPeliculas;
    }

    
}
