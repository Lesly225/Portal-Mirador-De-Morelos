package com.miradordemorelos.MIRADORDEMORELOS.NEGOCIO.Entity.DTO;

import com.miradordemorelos.MIRADORDEMORELOS.MUNICIPIO.Entity.MunicipioEntity;
import com.miradordemorelos.MIRADORDEMORELOS.NEGOCIO.Relaciones.Entity.CategoriaNegocioEntity;
import com.miradordemorelos.MIRADORDEMORELOS.NEGOCIO.Relaciones.Entity.HorarioEntity;
import com.miradordemorelos.MIRADORDEMORELOS.NEGOCIO.Relaciones.Entity.UrlEntity;

import java.util.List;

public class OnlyNegocioDTO {
    public Long id;
    public String nombre;
    public String telefono;
    public String descripcion;
    public String imagen;
    public String ubicacionUrlGmaps;
    public MunicipioEntity Municipio;

    public List<HorarioEntity> horarios;
    public List<UrlEntity> urls;
    public List<CategoriaNegocioEntity> categorias;
}
