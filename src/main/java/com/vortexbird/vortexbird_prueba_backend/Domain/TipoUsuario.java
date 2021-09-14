package com.vortexbird.vortexbird_prueba_backend.Domain;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotEmpty;

@Entity
@Table(name="tipo_usuario", schema = "public")
public class TipoUsuario {

 
    private String tipo_rol;
    @NotEmpty
    private String nombre_rol;
    private List<Usuario> usuarios = new ArrayList<Usuario>(0);
 
    
    public TipoUsuario() {
    }

    public TipoUsuario( String tipo_rol,  String nombre_rol, List<Usuario> usuarios) {
        this.tipo_rol = tipo_rol;
        this.nombre_rol = nombre_rol;
        this.usuarios = usuarios;
    }
    
  
    @Id
    @Column(name = "tipo_rol", unique = true, nullable = false)
    public String getTipo_rol() {
		return tipo_rol;
	}

	public void setTipo_rol(String tipo_rol) {
		this.tipo_rol = tipo_rol;
	}

	@Column(name = "nombre_rol", nullable = false)
    public String getNombre_rol() {
        return nombre_rol;
    }
    public void setNombre_rol(String nombre_rol) {
        this.nombre_rol = nombre_rol;
    }

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "tipoUsuario")
    public List<Usuario> getUsuarios() {
        return this.usuarios;
    }
    public void setUsuarios(List<Usuario> usuarios) {
        this.usuarios = usuarios;
    }


}
