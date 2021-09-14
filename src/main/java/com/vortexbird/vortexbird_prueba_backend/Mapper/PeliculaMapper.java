package com.vortexbird.vortexbird_prueba_backend.Mapper;

import java.util.List;

import com.vortexbird.vortexbird_prueba_backend.Domain.Pelicula;
import com.vortexbird.vortexbird_prueba_backend.Dto.PeliculaDTO;

import org.mapstruct.Mapper;
 

@Mapper
public interface PeliculaMapper {
    

    public PeliculaDTO toPeliculaDTO(Pelicula pelicula);
    
    public Pelicula toPelicula(PeliculaDTO peliculaDTO);

    public List <PeliculaDTO> listToPeliculaDTO(List<Pelicula> pelicula);

    public List<Pelicula> listToPelicula(List<PeliculaDTO> peliculaDTOs);


}
