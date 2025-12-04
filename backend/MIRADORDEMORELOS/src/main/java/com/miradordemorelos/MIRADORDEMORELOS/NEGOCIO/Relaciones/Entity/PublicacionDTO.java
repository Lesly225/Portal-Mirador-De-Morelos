package com.miradordemorelos.MIRADORDEMORELOS.NEGOCIO.Relaciones.Entity;

import java.time.LocalDateTime;

public class PublicacionDTO {
    private Long id;
    private String titulo;
    private String contenido;
    private LocalDateTime fechaCreacion;
    private String imagen;
    private Long id_negocio;
    private String nombreNegocio;

    public String getTitulo() {
        return titulo;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public LocalDateTime getFechaCreacion() {
        return fechaCreacion;
    }

    public void setFechaCreacion(LocalDateTime fechaCreacion) {
        this.fechaCreacion = fechaCreacion;
    }

    public String getNombreNegocio() {
        return nombreNegocio;
    }

    public void setNombreNegocio(String nombreNegocio) {
        this.nombreNegocio = nombreNegocio;
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

    public String getImagen() {
        return imagen;
    }

    public void setImagen(String imagen) {
        this.imagen = imagen;
    }

    public Long getId_negocio() {
        return id_negocio;
    }

    public void setId_negocio(Long id_negocio) {
        this.id_negocio = id_negocio;
    }
}
