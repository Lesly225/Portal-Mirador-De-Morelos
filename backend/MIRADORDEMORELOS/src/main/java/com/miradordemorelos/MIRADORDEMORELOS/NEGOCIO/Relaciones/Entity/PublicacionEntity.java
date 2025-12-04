package com.miradordemorelos.MIRADORDEMORELOS.NEGOCIO.Relaciones.Entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.miradordemorelos.MIRADORDEMORELOS.NEGOCIO.Entity.NegocioEntity;
import jakarta.persistence.*;

import java.time.LocalDateTime;

@Entity
@Table(name = "publicacion")
public class PublicacionEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String titulo;

    private String contenido;

    @Column(name = "fecha_creacion")
    private LocalDateTime fechaCreacion;

    private String imagen;

    @JsonIgnore
    @ManyToOne
    @JoinColumn(name = "id_negocio", nullable = false)
    private NegocioEntity negocio;
    //Constructor

    public PublicacionEntity(Long id, String titulo, String contenido, LocalDateTime fechaCreacion, String imagen, NegocioEntity negocio) {
        this.id = id;
        this.titulo = titulo;
        this.contenido = contenido;
        this.fechaCreacion = fechaCreacion;
        this.imagen = imagen;
        this.negocio = negocio;
    }
    public PublicacionEntity(){}

    //getters y setters

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getContenido() {
        return contenido;
    }

    public void setContenido(String contenido) {
        this.contenido = contenido;
    }

    public LocalDateTime getFechaCreacion() {
        return fechaCreacion;
    }

    public void setFechaCreacion(LocalDateTime fechaCreacion) {
        this.fechaCreacion = fechaCreacion;
    }

    public String getImagen() {
        return imagen;
    }

    public void setImagen(String imagen) {
        this.imagen = imagen;
    }

    public NegocioEntity getNegocio() {
        return negocio;
    }

    public void setNegocio(NegocioEntity negocio) {
        this.negocio = negocio;
    }
}

