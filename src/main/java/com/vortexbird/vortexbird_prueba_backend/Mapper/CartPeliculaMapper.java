package com.vortexbird.vortexbird_prueba_backend.Mapper;

import java.util.List;

import com.vortexbird.vortexbird_prueba_backend.Domain.CartPelicula;
import com.vortexbird.vortexbird_prueba_backend.Dto.CartPeliculaDTO;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper
public interface CartPeliculaMapper {
    

    @Mapping( source = "pelicula.id_pelicula" , target = "id_pelicula")
    @Mapping( source = "factura.factura_id" , target = "factura")
    public CartPeliculaDTO toCartPeliculaDTO(CartPelicula cartPelicula);

    @Mapping( source = "id_pelicula" , target = "pelicula.id_pelicula")
    @Mapping( source = "factura" , target = "factura.factura_id")
    public CartPelicula toCartPelicula(CartPeliculaDTO cartPeliculaDTO);

    public List<CartPeliculaDTO> listToPeliculaDTO(List<CartPelicula> cartPeliculas);

    public List<CartPelicula> listToPelicula(List<CartPeliculaDTO> cartPeliculaDTOs);

}

