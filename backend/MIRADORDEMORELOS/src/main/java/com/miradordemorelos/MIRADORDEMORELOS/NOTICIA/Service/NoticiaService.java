package com.miradordemorelos.MIRADORDEMORELOS.NOTICIA.Service;

import com.miradordemorelos.MIRADORDEMORELOS.MUNICIPIO.Entity.MunicipioEntity;
import com.miradordemorelos.MIRADORDEMORELOS.MUNICIPIO.Repository.MunicipioRepository;
import com.miradordemorelos.MIRADORDEMORELOS.NOTICIA.Entity.CategoriaNoticiaEntity;
import com.miradordemorelos.MIRADORDEMORELOS.NOTICIA.Entity.NoticiaDTO;
import com.miradordemorelos.MIRADORDEMORELOS.NOTICIA.Entity.NoticiaEntity;
import com.miradordemorelos.MIRADORDEMORELOS.NOTICIA.Repository.CategoriaNoticiaRepository;
import com.miradordemorelos.MIRADORDEMORELOS.NOTICIA.Repository.NoticiaRepository;
import com.miradordemorelos.MIRADORDEMORELOS.Scripts.ImageManager;
import com.miradordemorelos.MIRADORDEMORELOS.USUARIO.Entity.UsuarioEntity;
import com.miradordemorelos.MIRADORDEMORELOS.USUARIO.Repository.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Service
public class NoticiaService {

    @Autowired
    MunicipioRepository municipioRepository;
    @Autowired
    CategoriaNoticiaRepository categoriaRepository;

    @Autowired
    UsuarioRepository usuarioRepository;

    private final NoticiaRepository repository;

    public NoticiaService(NoticiaRepository repository){
        this.repository = repository;
    }
    public NoticiaEntity buscarPorId(Long id){
        return repository.findById(id).orElse(null);
    }
    public NoticiaEntity crearNoticia(NoticiaDTO noticiaDTO, MultipartFile image) throws IOException {
        NoticiaEntity noticiaEntity = new NoticiaEntity();

        noticiaEntity.setContenido(noticiaDTO.contenido);
        noticiaEntity.setFechaCreacion(LocalDateTime.now());
        noticiaEntity.setTitulo(noticiaDTO.titulo);
        noticiaEntity.setImagenDestacada(ImageManager.saveImage(image));
        noticiaEntity.setCreditoAutor(noticiaDTO.creditoAutor);

        MunicipioEntity municipio =  municipioRepository.findById(noticiaDTO.id_municipio).orElse(null);
        noticiaEntity.setMunicipio(municipio);

        List<CategoriaNoticiaEntity> categorias = new ArrayList<>();
        for(String nombreCat : noticiaDTO.categorias){
            CategoriaNoticiaEntity categoria = categoriaRepository
                    .findByNombreIgnoreCase(nombreCat)
                    .orElseThrow(() -> new RuntimeException("Categoría no encontrada: " + nombreCat));
            categorias.add(categoria);
        }
        noticiaEntity.setCategorias(categorias);

        UsuarioEntity usuario = usuarioRepository.findById(noticiaDTO.id_usuario).orElse(null);
        noticiaEntity.setUsuario(usuario);

        return repository.save(noticiaEntity);
    }
    public List<NoticiaEntity> obtenerNoticiasNuevas(){
        return repository.findTop10ByOrderByFechaCreacionDesc();
    }
    public List<NoticiaEntity> filterByCategoria(String categoria){
        return repository.findByCategoriasNombre(categoria);
    }
    public List<NoticiaEntity> filterByMunicipio(String municipio){
        return repository.findByMunicipioNombre(municipio);
    }
    public NoticiaEntity getById(Long id){
        return repository.findById(id).orElse(null);
    }
    public List<NoticiaEntity> filterByUsuario(Long id){
        return repository.findByUsuarioId(id);
    }
    public void deleteById(Long id){
        repository.deleteById(id);
    }
    public List<NoticiaEntity> buscarTitulo(String titulo){
        return repository.findByTituloContainingIgnoreCase(titulo);
    }
}
