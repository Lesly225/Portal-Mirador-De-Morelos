package com.miradordemorelos.MIRADORDEMORELOS.NOTICIA.Entity;

import com.miradordemorelos.MIRADORDEMORELOS.MUNICIPIO.Entity.MunicipioEntity;
import com.miradordemorelos.MIRADORDEMORELOS.USUARIO.Entity.UsuarioEntity;
import jakarta.persistence.*;

import java.time.LocalDateTime;
import java.util.List;

@Entity
@Table(name = "noticia")
public class NoticiaEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String titulo;

    private String contenido;

    @Column(name = "fecha_creacion")
    private LocalDateTime fechaCreacion;

    @Column(name = "imagen_destacada")
    private String imagenDestacada;

    @Column(name = "credito_autor")
    private String creditoAutor;

    @ManyToOne
    @JoinColumn(name = "id_usuario")
    private UsuarioEntity usuario;

    @ManyToOne
    @JoinColumn(name = "id_municipio", nullable = false)
    private MunicipioEntity municipio;

    @ManyToMany(fetch = FetchType.LAZY)
    @JoinTable(
            name = "noticia_categoria",
            joinColumns = @JoinColumn(name = "id_noticia"),
            inverseJoinColumns = @JoinColumn(name = "id_categoria")
    )
    private List<CategoriaNoticiaEntity> categorias;

    //Constructor

    public NoticiaEntity(Long id, String titulo, String contenido, LocalDateTime fechaCreacion, String imagenDestacada,
                         UsuarioEntity administrador, UsuarioEntity usuario, MunicipioEntity municipio,
                         List<CategoriaNoticiaEntity> categorias) {
        this.id = id;
        this.titulo = titulo;
        this.contenido = contenido;
        this.fechaCreacion = fechaCreacion;
        this.imagenDestacada = imagenDestacada;
        //this.administrador = administrador;
        this.usuario = usuario;
        this.municipio = municipio;
        this.categorias = categorias;
    }
    public NoticiaEntity(){
    }

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

    public String getImagenDestacada() {
        return imagenDestacada;
    }

    public void setImagenDestacada(String imagenDestacada) {
        this.imagenDestacada = imagenDestacada;
    }

    //public UsuarioEntity getAdministrador() {
    //    return administrador;
    //}

    //public void setAdministrador(UsuarioEntity administrador) {
    //    this.administrador = administrador;
    //}

    public UsuarioEntity getUsuario() {
        return usuario;
    }

    public String getCreditoAutor() {
        return creditoAutor;
    }

    public void setCreditoAutor(String creditoAutor) {
        this.creditoAutor = creditoAutor;
    }

    public void setUsuario(UsuarioEntity usuario) {
        this.usuario = usuario;
    }

    public MunicipioEntity getMunicipio() {
        return municipio;
    }

    public void setMunicipio(MunicipioEntity municipio) {
        this.municipio = municipio;
    }

    public List<CategoriaNoticiaEntity> getCategorias() {
        return categorias;
    }

    public void setCategorias(List<CategoriaNoticiaEntity> categorias) {
        this.categorias = categorias;
    }
}
