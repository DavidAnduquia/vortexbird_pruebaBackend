
package com.vortexbird.vortexbird_prueba_backend.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.vortexbird.vortexbird_prueba_backend.Domain.TipoUsuario;

public interface Tipos_usuariosRepository extends JpaRepository<TipoUsuario,String>  {

}
