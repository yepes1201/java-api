package com.example.javaapi.controllers;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.example.javaapi.models.ProductoModel;
import com.example.javaapi.models.ProductoTagModel;
import com.example.javaapi.services.ProductoService;
import com.example.javaapi.services.ProductoTagService;

@RestController
@RequestMapping("/producto")
public class ProductoController {

    @Autowired
    ProductoService productoService;

    @Autowired
    ProductoTagService productoTagService;

    // Ruta -> /producto
    @GetMapping
    public ArrayList<ProductoModel> obtenerProductos() {
        return productoService.obtenerProductos();
    }

    // Ruta -> /producto
    @PostMapping
    public ProductoModel guardarProducto(@RequestBody ProductoModel producto) {
        ProductoModel newProducto = productoService.guardarProducto(producto);

        /*
         * Recorremos la lista de tags dentro del producto y lo guardamos en
         * ProductoTagModel localmente.
         * Después usando el service del productoTag lo guardamos en la base de datos.
         */
        for (String tag : producto.getTags()) {
            ProductoTagModel productoTag = new ProductoTagModel();
            productoTag.setProductoId(newProducto.getProductoId());
            productoTag.setTag(tag);
            productoTagService.guardarTag(productoTag);
        }

        return newProducto;
    }

    // Ruta -> /producto/1
    @GetMapping(path = "/{id}")
    public ArrayList<ProductoModel> obtenerProducto(@PathVariable("id") Long productoId) {
        return productoService.obtenerProducto(productoId);
    }

    // Ruta -> /producto/buscar?q=lapiz
    @GetMapping(path = "/buscar")
    public ArrayList<ProductoModel> obtenerProductosPorNombre(@RequestParam("q") String query) {
        return productoService.obtenerProductosPorTitulo(query);
    }

}
