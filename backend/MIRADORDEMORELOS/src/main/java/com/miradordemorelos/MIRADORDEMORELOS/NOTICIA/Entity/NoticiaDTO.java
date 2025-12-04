package com.miradordemorelos.MIRADORDEMORELOS.NOTICIA.Entity;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

public class NoticiaDTO {
    public Long id;
    public String titulo;
    public String contenido;
    public String imagenDestacada;
    public String creditoAutor;
    public Long id_municipio;
    public Long id_usuario;
    public LocalDateTime fecha_creacion;
    public List<String> categorias;

}
