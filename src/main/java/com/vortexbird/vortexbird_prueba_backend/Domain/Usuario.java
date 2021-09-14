package com.vortexbird.vortexbird_prueba_backend.Domain;

 
import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
 

@Entity
@Table(name="usuario",schema = "public")
public class Usuario {

 
    private String email;
    private String password;
    private String nombre;
    private String apellido;
    private TipoUsuario tipoUsuario ;
    private String enable;

	private List<Factura> factura = new ArrayList<Factura>(0);

    public Usuario() {
    
    }



	@Id
    @Column(name = "email",  unique = true ,nullable = false)
	public String getEmail() {
		return email;
	}


	public void setEmail(String email) {
		this.email = email;
	}

	@Column(name = "password", nullable = false)
	public String getPassword() {
		return password;
	}


	public void setPassword(String password) {
		this.password = password;
	}

    @Column(name = "nombre", nullable = false)
	public String getNombre() {
		return nombre;
	}


	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

    @Column(name = "apellido", nullable = false)
	public String getApellido() {
		return apellido;
	}


	public void setApellido(String apellido) {
		this.apellido = apellido;
	}


    @ManyToOne(fetch =  FetchType.LAZY)
    @JoinColumn(name ="tipo_rol")
	public TipoUsuario getTipoUsuario() {
		return tipoUsuario;
	}


	public void setTipoUsuario(TipoUsuario tipoUsuario) {
		this.tipoUsuario = tipoUsuario;
	}


	@Column(name = "enable", nullable = false)
	public String getEnable() {
		return enable;
	}


	public void setEnable(String enable) {
		this.enable = enable;
	}

   

    
	@OneToMany(fetch = FetchType.LAZY, mappedBy = "usuario")
    public List<Factura> getFactura() {
		return factura;
	}

	public void setFactura(List<Factura> factura) {
		this.factura = factura;
	}
  

 

 



  


 
    


 
 

	



}
