/*
 * Los archivos terminados en service son aquellos que se encargan de manejar los servicios de la entidad relacionada.
 * Estos usan los repositorios para comunicarse con la base de datos y hacer los respectivos procedimientos.
 */

package com.example.javaapi.services;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.javaapi.models.ProductoModel;
import com.example.javaapi.models.ProductoTagModel;
import com.example.javaapi.repositories.ProductoRepository;
import com.example.javaapi.repositories.ProductoTagRepository;

@Service
public class ProductoService {

    @Autowired
    ProductoRepository productoRepository;

    @Autowired
    ProductoTagRepository productoTagRepository;

    /*
     * Por cada producto buscamos sus TAGS por el id del mismo, y los metemos en un
     * ArrayList de Strings.
     * Después le setteamos el ArrayList de Strings de los tags al producto para ser
     * devueltos en la petición.
     * --------------------------
     */
    private void obtenerProductosTags(ArrayList<ProductoModel> productos) {
        for (ProductoModel producto : productos) {
            ArrayList<ProductoTagModel> tags = productoTagRepository.findByProductoId(producto.getProductoId());
            ArrayList<String> tagsString = new ArrayList<>();

            for (ProductoTagModel tag : tags) {
                tagsString.add(tag.getTag());
            }

            producto.setTags(tagsString);
        }
    }

    /*
     * Obtener todos los productos.
     */
    public ArrayList<ProductoModel> obtenerProductos() {
        ArrayList<ProductoModel> productos = (ArrayList<ProductoModel>) productoRepository.findAll();
        obtenerProductosTags(productos);
        return productos;
    }

    /*
     * Obtener un producto por su ID.
     */
    public ArrayList<ProductoModel> obtenerProducto(Long productoId) {
        ArrayList<Long> id = new ArrayList<>(1);
        id.add(productoId);
        ArrayList<ProductoModel> productoConTags = (ArrayList<ProductoModel>) productoRepository.findAllById(id);
        obtenerProductosTags(productoConTags);
        return productoConTags;
    }

    /*
     * Obtener productos por su nombre.
     */
    public ArrayList<ProductoModel> obtenerProductosPorTitulo(String query) {
        ArrayList<ProductoModel> productos = (ArrayList<ProductoModel>) productoRepository
                .findAllByTitleContaining(query);
        obtenerProductosTags(productos);
        return productos;
    }

    /*
     * Se guarda el producto a la base de datos.
     */
    public ProductoModel guardarProducto(ProductoModel producto) {
        return productoRepository.save(producto);
    }
}
