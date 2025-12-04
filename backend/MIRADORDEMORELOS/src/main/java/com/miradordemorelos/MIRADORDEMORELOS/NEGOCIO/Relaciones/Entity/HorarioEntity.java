package com.miradordemorelos.MIRADORDEMORELOS.NEGOCIO.Relaciones.Entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.miradordemorelos.MIRADORDEMORELOS.NEGOCIO.Entity.NegocioEntity;
import jakarta.persistence.*;

import java.time.LocalTime;

@Entity
@Table(name = "horario")
public class HorarioEntity{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @JsonIgnore
    private Long id;

    @Column(name = "hora_apertura")
    private LocalTime horaApertura;

    @Column(name = "hora_cierre")
    private LocalTime horaCierre;

    private String dia;

    @ManyToOne
    @JoinColumn(name = "id_negocio", nullable = false)
    @JsonIgnore
    private NegocioEntity negocio;
    //Constructor

    public HorarioEntity(Long id, LocalTime horaApertura, LocalTime horaCierre, String dia, NegocioEntity negocio) {
        this.id = id;
        this.horaApertura = horaApertura;
        this.horaCierre = horaCierre;
        this.dia = dia;
        this.negocio = negocio;
    }

    public HorarioEntity(){}

    //getters y setters

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public LocalTime getHoraApertura() {
        return horaApertura;
    }

    public void setHoraApertura(LocalTime horaApertura) {
        this.horaApertura = horaApertura;
    }

    public LocalTime getHoraCierre() {
        return horaCierre;
    }

    public void setHoraCierre(LocalTime horaCierre) {
        this.horaCierre = horaCierre;
    }

    public String getDia() {
        return dia;
    }

    public void setDia(String dia) {
        this.dia = dia;
    }

    public NegocioEntity getNegocio() {
        return negocio;
    }

    public void setNegocio(NegocioEntity negocio) {
        this.negocio = negocio;
    }
}

