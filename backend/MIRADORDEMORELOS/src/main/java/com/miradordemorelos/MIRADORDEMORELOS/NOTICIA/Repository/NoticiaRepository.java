package com.miradordemorelos.MIRADORDEMORELOS.NOTICIA.Repository;

import com.miradordemorelos.MIRADORDEMORELOS.NEGOCIO.Entity.NegocioEntity;
import com.miradordemorelos.MIRADORDEMORELOS.NEGOCIO.Relaciones.Entity.PublicacionEntity;
import com.miradordemorelos.MIRADORDEMORELOS.NOTICIA.Entity.NoticiaEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface NoticiaRepository extends JpaRepository<NoticiaEntity, Long> {
    List<NoticiaEntity> findTop10ByOrderByFechaCreacionDesc();
    List<NoticiaEntity> findByCategoriasNombre(String nombre);
    List<NoticiaEntity> findByMunicipioNombre(String nombre);
    List<NoticiaEntity> findByUsuarioId(Long id);
    List<NoticiaEntity> findByTituloContainingIgnoreCase(String titulo);
}
