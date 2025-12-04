package com.miradordemorelos.MIRADORDEMORELOS.NEGOCIO.Relaciones.Repository;

import com.miradordemorelos.MIRADORDEMORELOS.NEGOCIO.Relaciones.Entity.HorarioEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface HorarioRepository extends JpaRepository<HorarioEntity, Long> {
}
