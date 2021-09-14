package com.vortexbird.vortexbird_prueba_backend.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.vortexbird.vortexbird_prueba_backend.Domain.Usuario;

public interface UsuariosRepository extends JpaRepository<Usuario,String>  {

}
