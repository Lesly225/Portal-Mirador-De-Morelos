package com.miradordemorelos.MIRADORDEMORELOS.NOTICIA.Repository;

import com.miradordemorelos.MIRADORDEMORELOS.NOTICIA.Entity.CategoriaNoticiaEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface CategoriaNoticiaRepository extends JpaRepository<CategoriaNoticiaEntity, Long> {
    Optional<CategoriaNoticiaEntity> findByNombreIgnoreCase(String nombre);
}
