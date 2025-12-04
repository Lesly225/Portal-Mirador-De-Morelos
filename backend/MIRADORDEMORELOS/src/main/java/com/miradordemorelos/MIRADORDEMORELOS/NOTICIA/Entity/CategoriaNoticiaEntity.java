package com.miradordemorelos.MIRADORDEMORELOS.NOTICIA.Entity;
import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;

import java.util.List;

@Entity
@Table(name = "categoria_noticia")
public class CategoriaNoticiaEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nombre;

    @JsonIgnore
    @ManyToMany(mappedBy = "categorias")
    private List<NoticiaEntity> noticias;

    //Constructor

    public CategoriaNoticiaEntity(Long id, String nombre, List<NoticiaEntity> noticias) {
        this.id = id;
        this.nombre = nombre;
        this.noticias = noticias;
    }
    public CategoriaNoticiaEntity(){}
    //getters y setters

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public List<NoticiaEntity> getNoticias() {
        return noticias;
    }

    public void setNoticias(List<NoticiaEntity> noticias) {
        this.noticias = noticias;
    }
}
