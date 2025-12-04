package com.miradordemorelos.MIRADORDEMORELOS.NEGOCIO.Relaciones.Entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.miradordemorelos.MIRADORDEMORELOS.NEGOCIO.Entity.NegocioEntity;
import jakarta.persistence.*;

@Entity
@Table(name = "url")
public class UrlEntity {

    @Id
    @JsonIgnore
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @JsonIgnore
    @ManyToOne
    @JoinColumn(name = "id_negocio", nullable = false)
    private NegocioEntity negocio;

    private String url;

    private String tipo;
    //Constructor

    public UrlEntity(Long id, NegocioEntity negocio, String url, String tipo) {
        this.id = id;
        this.negocio = negocio;
        this.url = url;
        this.tipo = tipo;
    }

    public UrlEntity(){}

    //getters y setters

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public NegocioEntity getNegocio() {
        return negocio;
    }

    public void setNegocio(NegocioEntity negocio) {
        this.negocio = negocio;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }
}

