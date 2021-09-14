package com.vortexbird.vortexbird_prueba_backend.Dto;

 

public class PeliculaDTO {
    
    private Integer id_pelicula;
    private String nombre_pelicula;
    private String descripcion;
    private String estreno;
    private Integer duracion;
    private double precio;
    private String enable;
    private String img_url;
  

    public PeliculaDTO(Integer id_pelicula, String nombre_pelicula, String descripcion, String estreno,
			Integer duracion, double precio, String enable, String img_url) {
		super();
		this.id_pelicula = id_pelicula;
		this.nombre_pelicula = nombre_pelicula;
		this.descripcion = descripcion;
		this.estreno = estreno;
		this.duracion = duracion;
		this.precio = precio;
		this.enable = enable;
		this.img_url = img_url;
	}

	public PeliculaDTO() {
    }


    public Integer getId_pelicula() {
        return id_pelicula;
    }
    public void setId_pelicula(Integer id_pelicula) {
        this.id_pelicula = id_pelicula;
    }
    public String getNombre_pelicula() {
        return nombre_pelicula;
    }
    public void setNombre_pelicula(String nombre_pelicula) {
        this.nombre_pelicula = nombre_pelicula;
    }
    public String getDescripcion() {
        return descripcion;
    }
    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }
    public String getEstreno() {
        return estreno;
    }
    public void setEstreno(String estreno) {
        this.estreno = estreno;
    }
    public Integer getDuracion() {
        return duracion;
    }
    public void setDuracion(Integer duracion) {
        this.duracion = duracion;
    }
    public double getPrecio() {
        return precio;
    }
    public void setPrecio(double precio) {
        this.precio = precio;
    }
    public String getEnable() {
        return enable;
    }
    public void setEnable(String enable) {
        this.enable = enable;
    }

    
    public String getImg_url() {
		return img_url;
	}

	public void setImg_url(String img_url) {
		this.img_url = img_url;
	}

    
}
