package com.miradordemorelos.MIRADORDEMORELOS.NEGOCIO.Service;

import com.miradordemorelos.MIRADORDEMORELOS.MUNICIPIO.Repository.MunicipioRepository;
import com.miradordemorelos.MIRADORDEMORELOS.NEGOCIO.Entity.DTO.HorarioDTO;
import com.miradordemorelos.MIRADORDEMORELOS.NEGOCIO.Entity.DTO.NegocioDTO;
import com.miradordemorelos.MIRADORDEMORELOS.NEGOCIO.Entity.DTO.OnlyNegocioDTO;
import com.miradordemorelos.MIRADORDEMORELOS.NEGOCIO.Entity.DTO.UrlDTO;
import com.miradordemorelos.MIRADORDEMORELOS.NEGOCIO.Entity.NegocioEntity;
import com.miradordemorelos.MIRADORDEMORELOS.NEGOCIO.Relaciones.Entity.CategoriaNegocioEntity;
import com.miradordemorelos.MIRADORDEMORELOS.NEGOCIO.Relaciones.Entity.HorarioEntity;
import com.miradordemorelos.MIRADORDEMORELOS.NEGOCIO.Relaciones.Entity.UrlEntity;
import com.miradordemorelos.MIRADORDEMORELOS.NEGOCIO.Relaciones.Repository.CategoriaNegocioRepository;
import com.miradordemorelos.MIRADORDEMORELOS.NEGOCIO.Repository.NegocioRepository;
import com.miradordemorelos.MIRADORDEMORELOS.Scripts.ImageManager;
import com.miradordemorelos.MIRADORDEMORELOS.USUARIO.Repository.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;

@Service
public class NegocioService {
    //instancia de repositorio con dependencias
    @Autowired
    private NegocioRepository negocioRepository;

    @Autowired
    private UsuarioRepository usuarioRepository;

    @Autowired
    private MunicipioRepository municipioRepository;

    @Autowired
    private CategoriaNegocioRepository categoriaRepository;


    public NegocioEntity crearNegocio(NegocioDTO dto, MultipartFile image) throws IOException {

        NegocioEntity negocio = new NegocioEntity();
        negocio.setNombre(dto.nombre);
        negocio.setTelefono(dto.telefono);
        negocio.setDescripcion(dto.descripcion);
        negocio.setImagen(ImageManager.saveImage(image));
        negocio.setUbicacionUrlGmaps(dto.ubicacionUrlGmaps);

        negocio.setUsuario(usuarioRepository.findById(dto.idUsuario)
                .orElseThrow(() -> new RuntimeException("Usuario no encontrado")));

        negocio.setMunicipio(municipioRepository.findById(dto.idMunicipio)
                .orElseThrow(() -> new RuntimeException("Municipio no encontrado")));

        // horario
        List<HorarioEntity> horarios = new ArrayList<>();
        for (HorarioDTO h : dto.horarios) {
            HorarioEntity horario = new HorarioEntity();
            horario.setDia(h.dia);
            horario.setHoraApertura(LocalTime.parse(h.horaApertura));
            horario.setHoraCierre(LocalTime.parse(h.horaCierre));
            horario.setNegocio(negocio);
            horarios.add(horario);
        }
        negocio.setHorarios(horarios);

        // url's
        List<UrlEntity> urls = new ArrayList<>();
        for (UrlDTO u : dto.urls) {
            UrlEntity url = new UrlEntity();
            url.setUrl(u.url);
            url.setTipo(u.tipo);
            url.setNegocio(negocio);
            urls.add(url);
        }
        negocio.setUrls(urls);

        //categorias
        List<CategoriaNegocioEntity> categorias = new ArrayList<>();

        for (String nombreCat : dto.categorias) {

            CategoriaNegocioEntity categoria = categoriaRepository
                    .findByNombreIgnoreCase(nombreCat)
                    .orElseThrow(() -> new RuntimeException("Categoría no encontrada: " + nombreCat));

            categorias.add(categoria);
        }

        negocio.setCategorias(categorias);

        return negocioRepository.save(negocio);
    }

    public NegocioEntity obtenerNegocioPorId(Long id){
        return negocioRepository.findById(id).orElse(null);
    }

    public List<NegocioEntity> obtenerPorCategoria(String categoria){
        return negocioRepository.findByCategoriasNombre(categoria);

    }
    public List<NegocioEntity> obtenerPorMunicipio(String municipio){
        return negocioRepository.findByMunicipioNombre(municipio);

    }

    public List<NegocioEntity> buscarPorMunicipioYCategoria(Long municipioId, Long categoriaId) {
        return negocioRepository.findByMunicipioIdAndCategoriasId(municipioId, categoriaId);
    }
    public List<OnlyNegocioDTO> buscarPorUsuario(Long id){
        List<OnlyNegocioDTO> dto = new ArrayList<>();
        List<NegocioEntity> negocios = negocioRepository.findByUsuarioId(id);
        for(NegocioEntity negocio: negocios){
            OnlyNegocioDTO negocioDTO = new OnlyNegocioDTO();

            negocioDTO.id = negocio.getId();
            negocioDTO.nombre = negocio.getNombre();
            negocioDTO.telefono = negocio.getTelefono();
            negocioDTO.descripcion = negocio.getDescripcion();
            negocioDTO.imagen = negocio.getImagen();
            negocioDTO.ubicacionUrlGmaps = negocio.getUbicacionUrlGmaps();
            negocioDTO.Municipio = negocio.getMunicipio();
            negocioDTO.horarios = negocio.getHorarios();
            negocioDTO.urls = negocio.getUrls();
            negocioDTO.categorias = negocio.getCategorias();

            dto.add(negocioDTO);
        }
        return dto;
    }
    public void deleteById(Long id){
        negocioRepository.deleteById(id);
    }
    public List<OnlyNegocioDTO> buscarNombre(String nombre){
        List<OnlyNegocioDTO> dto = new ArrayList<>();
        List<NegocioEntity> negocios = negocioRepository.findByNombreContainingIgnoreCase(nombre);
        for(NegocioEntity negocio: negocios){
            OnlyNegocioDTO negocioDTO = new OnlyNegocioDTO();

            negocioDTO.id = negocio.getId();
            negocioDTO.nombre = negocio.getNombre();
            negocioDTO.telefono = negocio.getTelefono();
            negocioDTO.descripcion = negocio.getDescripcion();
            negocioDTO.imagen = negocio.getImagen();
            negocioDTO.ubicacionUrlGmaps = negocio.getUbicacionUrlGmaps();
            negocioDTO.Municipio = negocio.getMunicipio();
            negocioDTO.horarios = negocio.getHorarios();
            negocioDTO.urls = negocio.getUrls();
            negocioDTO.categorias = negocio.getCategorias();

            dto.add(negocioDTO);
        }
        return dto;
    }
}