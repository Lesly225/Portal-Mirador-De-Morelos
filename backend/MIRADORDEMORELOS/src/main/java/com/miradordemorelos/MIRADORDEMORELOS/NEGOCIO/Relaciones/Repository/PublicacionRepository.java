package com.miradordemorelos.MIRADORDEMORELOS.NEGOCIO.Relaciones.Repository;

import com.miradordemorelos.MIRADORDEMORELOS.NEGOCIO.Entity.NegocioEntity;
import com.miradordemorelos.MIRADORDEMORELOS.NEGOCIO.Relaciones.Entity.PublicacionEntity;
import com.miradordemorelos.MIRADORDEMORELOS.NOTICIA.Entity.NoticiaEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PublicacionRepository extends JpaRepository<PublicacionEntity, Long> {
    List<PublicacionEntity> findByNegocioId(Long id);
    List<PublicacionEntity> findTop10ByOrderByFechaCreacionDesc();
    List<PublicacionEntity> findByTituloContainingIgnoreCase(String titulo);
}
