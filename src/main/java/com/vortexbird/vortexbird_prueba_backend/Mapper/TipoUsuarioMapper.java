package com.vortexbird.vortexbird_prueba_backend.Mapper;

import java.util.List;

import org.mapstruct.Mapper;

import com.vortexbird.vortexbird_prueba_backend.Domain.TipoUsuario;
import com.vortexbird.vortexbird_prueba_backend.Dto.TipoUsuarioDTO;

@Mapper
public interface TipoUsuarioMapper {

    public TipoUsuarioDTO toTipoUsuarioDTO(TipoUsuario tipoUsuario);

    public TipoUsuario toTipoUsuario(TipoUsuarioDTO tipoUsuarioDTO);

    public List<TipoUsuarioDTO> listToTipoUsuarioDTO(List<TipoUsuario> tipoUsuarios);

    public List<TipoUsuario> listToTipoUsuario(List<TipoUsuarioDTO> tipoUsuarioDTOs);

}
