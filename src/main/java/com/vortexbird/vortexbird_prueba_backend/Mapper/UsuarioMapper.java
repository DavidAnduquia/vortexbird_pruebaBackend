package com.vortexbird.vortexbird_prueba_backend.Mapper;

import java.util.List;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import com.vortexbird.vortexbird_prueba_backend.Domain.Usuario;
import com.vortexbird.vortexbird_prueba_backend.Dto.UsuarioDTO;

@Mapper
public interface UsuarioMapper {
	
    @Mapping(source = "tipoUsuario.tipo_rol", target = "tipo_rol")
    public UsuarioDTO toUsuarioDTO(Usuario usuario);

    @Mapping(source = "tipo_rol", target = "tipoUsuario.tipo_rol")
    public Usuario toUsuarios(UsuarioDTO usuarioDTO);

    public List<UsuarioDTO> listToUsuariosDTO(List<Usuario> usuarios);

    public List<Usuario> listToUsuarios(List<UsuarioDTO> usuariosDTO);


}
