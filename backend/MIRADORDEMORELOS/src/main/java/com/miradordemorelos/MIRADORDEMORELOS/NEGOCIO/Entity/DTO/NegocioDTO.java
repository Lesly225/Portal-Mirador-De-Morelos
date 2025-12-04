package com.miradordemorelos.MIRADORDEMORELOS.NEGOCIO.Entity.DTO;

import java.util.List;
public class NegocioDTO {
    public String nombre;
    public String telefono;
    public Long idUsuario;
    public String descripcion;
    public String imagen;
    public String ubicacionUrlGmaps;
    public Long idMunicipio;

    public List<HorarioDTO> horarios;
    public List<UrlDTO> urls;
    public List<String> categorias;
}
