/*
 * Los archivos terminados en Repository son aquellos que tienen el trabajo de comunicarse con la base de datos.
 */

package com.example.javaapi.repositories;

import java.util.ArrayList;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import com.example.javaapi.models.ProductoModel;

@Repository
public interface ProductoRepository extends CrudRepository<ProductoModel, Long> {

    /*
     * Obtenemos todos los productos filtrados por su nombre.
     */
    @Query(value = "select * from producto p where p.titulo like %:titulo%", nativeQuery = true)
    ArrayList<ProductoModel> findAllByTitleContaining(@Param("titulo") String query);
}
