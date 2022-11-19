package com.example.javaapi.services;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.javaapi.models.ProductoTagModel;
import com.example.javaapi.repositories.ProductoTagRepository;

@Service
public class ProductoTagService {
    @Autowired
    ProductoTagRepository productoTagRepository;

    public ArrayList<ProductoTagModel> obtenerTagsProducto(Long productoId) {
        return productoTagRepository.findByProductoId(productoId);
    }

    public ProductoTagModel guardarTag(ProductoTagModel productoTag) {
        return productoTagRepository.save(productoTag);
    }
}
