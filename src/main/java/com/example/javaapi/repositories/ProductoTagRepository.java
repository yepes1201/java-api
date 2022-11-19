package com.example.javaapi.repositories;

import java.util.ArrayList;

import org.springframework.data.jpa.repository.*;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.example.javaapi.models.ProductoTagModel;

@Repository
public interface ProductoTagRepository extends CrudRepository<ProductoTagModel, Long> {

    @Query(value = "select * from tagproducto t where t.producto_id = :productoid", nativeQuery = true)
    ArrayList<ProductoTagModel> findByProductoId(@Param("productoid") Long productoId);
}
