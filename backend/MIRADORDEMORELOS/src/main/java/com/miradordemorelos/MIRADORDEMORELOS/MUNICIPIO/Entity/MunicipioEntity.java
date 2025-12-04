package com.miradordemorelos.MIRADORDEMORELOS.MUNICIPIO.Entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.miradordemorelos.MIRADORDEMORELOS.NEGOCIO.Entity.NegocioEntity;
import com.miradordemorelos.MIRADORDEMORELOS.NOTICIA.Entity.NoticiaEntity;
import jakarta.persistence.*;

import java.util.List;

@Entity
@Table(name = "municipio")
public class MunicipioEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nombre;

    @OneToMany(mappedBy = "municipio", fetch = FetchType.LAZY)
    @JsonIgnore
    private List<NegocioEntity> negocios;

    @OneToMany(mappedBy = "municipio", fetch = FetchType.LAZY)
    @JsonIgnore
    private List<NoticiaEntity> noticias;
    //Constructor

    public MunicipioEntity(Long id, String nombre, List<NegocioEntity> negocios, List<NoticiaEntity> noticias) {
        this.id = id;
        this.nombre = nombre;
        this.negocios = negocios;
        this.noticias = noticias;
    }
    public MunicipioEntity(){}

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

    public List<NegocioEntity> getNegocios() {
        return negocios;
    }

    public void setNegocios(List<NegocioEntity> negocios) {
        this.negocios = negocios;
    }

    public List<NoticiaEntity> getNoticias() {
        return noticias;
    }

    public void setNoticias(List<NoticiaEntity> noticias) {
        this.noticias = noticias;
    }
}

