package com.example.javaapi.models;

import javax.persistence.*;

@Entity
@Table(name = "tagproducto")
public class ProductoTagModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(unique = true, nullable = false)
    private Long tagId;

    @Column(nullable = false)
    private Long productoId;

    @Column(nullable = false)
    private String tag;

    public Long getTagId() {
        return this.tagId;
    }

    public void setTagId(Long tagId) {
        this.tagId = tagId;
    }

    public Long getProductoId() {
        return this.productoId;
    }

    public void setProductoId(Long productoId) {
        this.productoId = productoId;
    }

    public String getTag() {
        return this.tag;
    }

    public void setTag(String tag) {
        this.tag = tag;
    }

}
