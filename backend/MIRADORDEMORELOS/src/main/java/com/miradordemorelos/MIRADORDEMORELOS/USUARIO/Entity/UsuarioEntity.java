package com.miradordemorelos.MIRADORDEMORELOS.USUARIO.Entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.miradordemorelos.MIRADORDEMORELOS.NOTICIA.Entity.NoticiaEntity;
import com.miradordemorelos.MIRADORDEMORELOS.NEGOCIO.Entity.NegocioEntity;
import jakarta.persistence.*;

import java.util.List;

@Entity
@Table(name = "usuario")
public class UsuarioEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, unique = true)
    private String email;

    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    @Column(nullable = false)
    private String password;

    @Column(nullable = false)
    private String rol;

    private String nombre;

    @Column(name = "apellido_p")
    private String apellidoP;

    @Column(name = "apellido_m")
    private String apellidoM;

    @Column(name = "imagen_perfil")
    private String imagenPerfil;

    @OneToMany(mappedBy = "usuario", fetch = FetchType.LAZY)
    @JsonIgnore
    private List<NegocioEntity> negocios;

    //Constructor

    public UsuarioEntity(Long id, String email, String password, String rol, String nombre, String apellidoP, String apellidoM, String imagenPerfil, List<NegocioEntity> negocios, List<NoticiaEntity> noticiasAdministradas) {
        this.id = id;
        this.email = email;
        this.password = password;
        this.rol = rol;
        this.nombre = nombre;
        this.apellidoP = apellidoP;
        this.apellidoM = apellidoM;
        this.imagenPerfil = imagenPerfil;
        this.negocios = negocios;
    }

    public UsuarioEntity() {
    }

    //getters and setters
    public Long getId() {
        return id;
    }


    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
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

}

