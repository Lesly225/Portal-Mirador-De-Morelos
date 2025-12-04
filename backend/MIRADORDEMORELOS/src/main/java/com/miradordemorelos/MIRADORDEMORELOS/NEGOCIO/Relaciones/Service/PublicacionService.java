package com.miradordemorelos.MIRADORDEMORELOS.NEGOCIO.Relaciones.Service;

import com.miradordemorelos.MIRADORDEMORELOS.NEGOCIO.Entity.DTO.NegocioDTO;
import com.miradordemorelos.MIRADORDEMORELOS.NEGOCIO.Entity.NegocioEntity;
import com.miradordemorelos.MIRADORDEMORELOS.NEGOCIO.Relaciones.Entity.PublicacionDTO;
import com.miradordemorelos.MIRADORDEMORELOS.NEGOCIO.Relaciones.Entity.PublicacionEntity;
import com.miradordemorelos.MIRADORDEMORELOS.NEGOCIO.Relaciones.Repository.PublicacionRepository;
import com.miradordemorelos.MIRADORDEMORELOS.NEGOCIO.Repository.NegocioRepository;
import com.miradordemorelos.MIRADORDEMORELOS.Scripts.ImageManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Service
public class PublicacionService {
    @Autowired
    private NegocioRepository negocioRepository;
    @Autowired
    private PublicacionRepository publicacionRepository;

    //create
    public PublicacionEntity guardarPublicacion(PublicacionDTO publicacion, MultipartFile image) throws IOException {
        NegocioEntity negocio = negocioRepository.findById(publicacion.getId_negocio()).orElse(null);
        PublicacionEntity publicacionEntity = new PublicacionEntity();

        publicacionEntity.setFechaCreacion(LocalDateTime.now());
        publicacionEntity.setContenido(publicacion.getContenido());
        publicacionEntity.setTitulo(publicacion.getTitulo());
        publicacionEntity.setImagen(ImageManager.saveImage(image));
        publicacionEntity.setNegocio(negocio);
        return publicacionRepository.save(publicacionEntity);
    }
    public PublicacionEntity obtenerPublicacion(Long id){
        return publicacionRepository.findById(id).orElse(null);
    }
    public List<PublicacionEntity> filterByNegocio(Long id){
        return publicacionRepository.findByNegocioId(id);
    }
    public List<PublicacionEntity> obtenerPublicacionesNuevas(){
        return publicacionRepository.findTop10ByOrderByFechaCreacionDesc();
    }
    public void deleteById(Long id){
        publicacionRepository.deleteById(id);
    }
    public List<PublicacionDTO> buscarTitulo(String titulo){
        List<PublicacionDTO> dto = new ArrayList<>();
        List<PublicacionEntity> publicaciones = publicacionRepository.findByTituloContainingIgnoreCase(titulo);

        for(PublicacionEntity publicacion : publicaciones){
            PublicacionDTO publicacionDTO = new PublicacionDTO();

            publicacionDTO.setId(publicacion.getId());
            publicacionDTO.setTitulo(publicacion.getTitulo());
            publicacionDTO.setContenido(publicacion.getContenido());
            publicacionDTO.setImagen(publicacion.getImagen());
            publicacionDTO.setId_negocio(publicacion.getNegocio().getId());
            publicacionDTO.setNombreNegocio(publicacion.getNegocio().getNombre());
            publicacionDTO.setFechaCreacion(publicacion.getFechaCreacion());

            dto.add(publicacionDTO);
        }
        return dto;
    }
}
