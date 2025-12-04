package com.miradordemorelos.MIRADORDEMORELOS.NEGOCIO.Relaciones.Repository;

import com.miradordemorelos.MIRADORDEMORELOS.NEGOCIO.Relaciones.Entity.CategoriaNegocioEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface CategoriaNegocioRepository extends JpaRepository<CategoriaNegocioEntity, Long> {
    Optional<CategoriaNegocioEntity> findByNombreIgnoreCase(String nombre);

}
