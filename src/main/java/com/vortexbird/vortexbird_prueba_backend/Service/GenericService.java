
package com.vortexbird.vortexbird_prueba_backend.Service;

import java.util.List;
import java.util.Optional;

public interface GenericService<T,ID> {


    public List<T> findAll();

    public Optional<T> findById(ID id) throws Exception;

    public T save(T entity) throws Exception;

    public T update(T entity) throws Exception;


}
