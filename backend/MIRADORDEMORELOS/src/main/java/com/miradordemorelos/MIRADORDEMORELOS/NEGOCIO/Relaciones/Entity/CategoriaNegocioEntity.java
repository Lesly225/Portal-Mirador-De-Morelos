package com.miradordemorelos.MIRADORDEMORELOS.NEGOCIO.Relaciones.Entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.miradordemorelos.MIRADORDEMORELOS.NEGOCIO.Entity.NegocioEntity;
import jakarta.persistence.*;

import java.util.List;

@Entity
@Table(name = "categoria_negocio")
public class CategoriaNegocioEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nombre;

    @JsonIgnore
    @ManyToMany(mappedBy = "categorias")
    private List<NegocioEntity> negocios;
    //Constructor

    public CategoriaNegocioEntity(Long id, String nombre, List<NegocioEntity> negocios) {
        this.id = id;
        this.nombre = nombre;
        this.negocios = negocios;
    }
    public CategoriaNegocioEntity(){}
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
}
