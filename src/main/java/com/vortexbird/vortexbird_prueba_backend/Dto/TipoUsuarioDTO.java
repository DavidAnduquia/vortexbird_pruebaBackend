package com.vortexbird.vortexbird_prueba_backend.Dto;

public class  TipoUsuarioDTO {

   private String tipo_rol;
   private String nombre_rol;
   
   
   
   public TipoUsuarioDTO() {
	super();
}

public TipoUsuarioDTO(String tipo_rol, String nombre_rol) {
		super();
		this.tipo_rol = tipo_rol;
		this.nombre_rol = nombre_rol;
	}
   
	public String getTipo_rol() {
		return tipo_rol;
	}
	public void setTipo_rol(String tipo_rol) {
		this.tipo_rol = tipo_rol;
	}
	public String getNombre_rol() {
		return nombre_rol;
	}
	public void setNombre_rol(String nombre_rol) {
		this.nombre_rol = nombre_rol;
	}


   

}
