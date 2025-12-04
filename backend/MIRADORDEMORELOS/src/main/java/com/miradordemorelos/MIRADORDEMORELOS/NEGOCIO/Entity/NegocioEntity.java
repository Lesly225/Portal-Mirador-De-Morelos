package com.miradordemorelos.MIRADORDEMORELOS.NEGOCIO.Entity;

import com.miradordemorelos.MIRADORDEMORELOS.MUNICIPIO.Entity.MunicipioEntity;
import com.miradordemorelos.MIRADORDEMORELOS.NEGOCIO.Relaciones.Entity.CategoriaNegocioEntity;
import com.miradordemorelos.MIRADORDEMORELOS.NEGOCIO.Relaciones.Entity.HorarioEntity;
import com.miradordemorelos.MIRADORDEMORELOS.NEGOCIO.Relaciones.Entity.PublicacionEntity;
import com.miradordemorelos.MIRADORDEMORELOS.NEGOCIO.Relaciones.Entity.UrlEntity;
import com.miradordemorelos.MIRADORDEMORELOS.USUARIO.Entity.UsuarioEntity;
import jakarta.persistence.*;
import jakarta.persistence.GeneratedValue;

import java.time.LocalDateTime;
import java.util.List;


    @Entity
    @Table(name = "negocio")
    public class NegocioEntity {

        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        private Long id;

        private String nombre;

        private String telefono;

        @ManyToOne
        @JoinColumn(name = "id_usuario", nullable = false)
        private UsuarioEntity usuario;

        private String descripcion;

        private String imagen;

        @Column(name = "ubicacion_url_gmaps")
        private String ubicacionUrlGmaps;

        private Integer interacciones;

        @Column(name = "fecha_creacion")
        private LocalDateTime fechaCreacion;

        @ManyToOne
        @JoinColumn(name = "id_municipio", nullable = false)
        private MunicipioEntity municipio;

        @OneToMany(mappedBy = "negocio", fetch = FetchType.LAZY, cascade = CascadeType.ALL, orphanRemoval = true)
        private List<HorarioEntity> horarios;

        @OneToMany(mappedBy = "negocio", fetch = FetchType.LAZY, cascade = CascadeType.ALL, orphanRemoval = true)
        private List<UrlEntity> urls;

        @OneToMany(mappedBy = "negocio", cascade = CascadeType.ALL, orphanRemoval = true)
        private List<PublicacionEntity> publicaciones;


        @ManyToMany(fetch = FetchType.LAZY)
        @JoinTable(
                name = "negocio_categoria",
                joinColumns = @JoinColumn(name = "id_negocio"),
                inverseJoinColumns = @JoinColumn(name = "id_categoria")
        )
        private List<CategoriaNegocioEntity> categorias;

        //Constructor

        public NegocioEntity(Long id, String nombre, String telefono, UsuarioEntity usuario, String descripcion,
                             String imagen, String ubicacionUrlGmaps, Integer interacciones, MunicipioEntity municipio,
                             List<HorarioEntity> horarios, List<UrlEntity> urls, List<PublicacionEntity> publicaciones,
                             List<CategoriaNegocioEntity> categorias) {
            this.id = id;
            this.nombre = nombre;
            this.telefono = telefono;
            this.usuario = usuario;
            this.descripcion = descripcion;
            this.imagen = imagen;
            this.ubicacionUrlGmaps = ubicacionUrlGmaps;
            this.interacciones = interacciones;
            this.municipio = municipio;
            this.horarios = horarios;
            this.urls = urls;
            this.publicaciones = publicaciones;
            this.categorias = categorias;
        }

        public NegocioEntity(){}

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

        public String getTelefono() {
            return telefono;
        }

        public void setTelefono(String telefono) {
            this.telefono = telefono;
        }

        public UsuarioEntity getUsuario() {
            return usuario;
        }

        public void setUsuario(UsuarioEntity usuario) {
            this.usuario = usuario;
        }

        public String getDescripcion() {
            return descripcion;
        }

        public void setDescripcion(String descripcion) {
            this.descripcion = descripcion;
        }

        public String getImagen() {
            return imagen;
        }

        public void setImagen(String imagen) {
            this.imagen = imagen;
        }

        public String getUbicacionUrlGmaps() {
            return ubicacionUrlGmaps;
        }

        public void setUbicacionUrlGmaps(String ubicacionUrlGmaps) {
            this.ubicacionUrlGmaps = ubicacionUrlGmaps;
        }

        public Integer getInteracciones() {
            return interacciones;
        }

        public void setInteracciones(Integer interacciones) {
            this.interacciones = interacciones;
        }

        public MunicipioEntity getMunicipio() {
            return municipio;
        }

        public void setMunicipio(MunicipioEntity municipio) {
            this.municipio = municipio;
        }

        public List<HorarioEntity> getHorarios() {
            return horarios;
        }

        public void setHorarios(List<HorarioEntity> horarios) {
            this.horarios = horarios;
        }

        public List<UrlEntity> getUrls() {
            return urls;
        }

        public void setUrls(List<UrlEntity> urls) {
            this.urls = urls;
        }

        public List<PublicacionEntity> getPublicaciones() {
            return publicaciones;
        }

        public void setPublicaciones(List<PublicacionEntity> publicaciones) {
            this.publicaciones = publicaciones;
        }

        public List<CategoriaNegocioEntity> getCategorias() {
            return categorias;
        }

        public void setCategorias(List<CategoriaNegocioEntity> categorias) {
            this.categorias = categorias;
        }
    }