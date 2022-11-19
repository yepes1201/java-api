package com.example.javaapi.models;

import java.util.ArrayList;

import javax.persistence.*;

@Entity
@Table(name = "producto")
public class ProductoModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(unique = true, nullable = false)
    private Long productoid;

    @Column(nullable = false)
    private String titulo;

    @Column(nullable = false)
    private String descripcion;

    @Column(nullable = true)
    private String img;

    @Column(nullable = false)
    private float precio;

    @Column(insertable = false, updatable = false)
    private ArrayList<String> tags;

    public Long getProductoId() {
        return this.productoid;
    }

    public void setProductoId(Long productoid) {
        this.productoid = productoid;
    }

    public String getTitulo() {
        return this.titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getDescripcion() {
        return this.descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public String getImg() {
        return this.img;
    }

    public void setImg(String img) {
        this.img = img;
    }

    public float getPrecio() {
        return this.precio;
    }

    public void setPrecio(float precio) {
        this.precio = precio;
    }

    public ArrayList<String> getTags() {
        return this.tags;
    }

    public void setTags(ArrayList<String> tags) {
        this.tags = tags;
    }

}
