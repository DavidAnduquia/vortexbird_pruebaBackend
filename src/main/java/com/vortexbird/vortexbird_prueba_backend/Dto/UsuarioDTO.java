package com.vortexbird.vortexbird_prueba_backend.Dto;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

public class UsuarioDTO {
    
    private String email;
    @NotEmpty
    private String password;
    @NotNull
    private String nombre;
    @NotNull
    private String apellido;
    @NotNull
    private String tipo_rol;
    private String enable;


    public UsuarioDTO() {
    }


	public UsuarioDTO(String email, @NotEmpty String password, @NotNull String nombre, @NotNull String apellido,
			@NotNull String tipo_rol, String enable) {
		super();
		this.email = email;
		this.password = password;
		this.nombre = nombre;
		this.apellido = apellido;
		this.tipo_rol = tipo_rol;
		this.enable = enable;
	}


	public String getEmail() {
		return email;
	}


	public void setEmail(String email) {
		this.email = email;
	}


	public String getPassword() {
		return password;
	}


	public void setPassword(String password) {
		this.password = password;
	}


	public String getNombre() {
		return nombre;
	}


	public void setNombre(String nombre) {
		this.nombre = nombre;
	}


	public String getApellido() {
		return apellido;
	}


	public void setApellido(String apellido) {
		this.apellido = apellido;
	}


	public String getTipo_rol() {
		return tipo_rol;
	}


	public void setTipo_rol(String tipo_rol) {
		this.tipo_rol = tipo_rol;
	}


	public String getEnable() {
		return enable;
	}


	public void setEnable(String enable) {
		this.enable = enable;
	}


    
	
 
 
 




} 
