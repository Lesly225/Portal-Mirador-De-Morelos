package com.miradordemorelos.MIRADORDEMORELOS.NEGOCIO.Repository;

import com.miradordemorelos.MIRADORDEMORELOS.NEGOCIO.Entity.NegocioEntity;
import com.miradordemorelos.MIRADORDEMORELOS.NOTICIA.Entity.NoticiaEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface NegocioRepository extends JpaRepository<NegocioEntity, Long> {

    List<NegocioEntity> findByCategoriasId(Long categoriaId);
    List<NegocioEntity> findByCategoriasNombre(String nombre);
    List<NegocioEntity> findByMunicipioNombre(String nombre);
    List<NegocioEntity> findByMunicipioIdAndCategoriasId(Long municipioId, Long categoriaId);
    List<NegocioEntity> findByMunicipioIdAndCategoriasNombre(Long municipioId, String categoriaNombre);
    List<NegocioEntity> findByUsuarioId(Long id);
    List<NegocioEntity> findByNombreContainingIgnoreCase(String nombre);
}
