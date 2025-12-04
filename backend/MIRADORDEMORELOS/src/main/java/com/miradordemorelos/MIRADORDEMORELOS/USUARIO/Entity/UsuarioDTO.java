package com.miradordemorelos.MIRADORDEMORELOS.USUARIO.Entity;

import com.miradordemorelos.MIRADORDEMORELOS.NEGOCIO.Entity.NegocioEntity;
import com.miradordemorelos.MIRADORDEMORELOS.NOTICIA.Entity.NoticiaEntity;
import jakarta.persistence.*;

import java.util.List;

public class UsuarioDTO {

    private Long id;

    private String email;

    private String rol;

    private String nombre;

    private String apellidoP;

    private String apellidoM;

    private String imagenPerfil;

    private List<NegocioEntity> negocios;

    private List<NoticiaEntity> noticiasAdministradas;

    //constructor

    public UsuarioDTO(Long id, String email, String rol, String nombre, String apellidoP, String apellidoM,
                      String imagenPerfil, List<NegocioEntity> negocios) {
        this.id = id;
        this.email = email;
        this.rol = rol;
        this.nombre = nombre;
        this.apellidoP = apellidoP;
        this.apellidoM = apellidoM;
        this.imagenPerfil = imagenPerfil;
        this.negocios = negocios;
    }


    //getters y setters

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getRol() {
        return rol;
    }

    public void setRol(String rol) {
        this.rol = rol;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellidoP() {
        return apellidoP;
    }

    public void setApellidoP(String apellidoP) {
        this.apellidoP = apellidoP;
    }

    public String getApellidoM() {
        return apellidoM;
    }

    public void setApellidoM(String apellidoM) {
        this.apellidoM = apellidoM;
    }

    public String getImagenPerfil() {
        return imagenPerfil;
    }

    public void setImagenPerfil(String imagenPerfil) {
        this.imagenPerfil = imagenPerfil;
    }

    public List<NegocioEntity> getNegocios() {
        return negocios;
    }

    public void setNegocios(List<NegocioEntity> negocios) {
        this.negocios = negocios;
    }

    public List<NoticiaEntity> getNoticiasAdministradas() {
        return noticiasAdministradas;
    }

    public void setNoticiasAdministradas(List<NoticiaEntity> noticiasAdministradas) {
        this.noticiasAdministradas = noticiasAdministradas;
    }
}
