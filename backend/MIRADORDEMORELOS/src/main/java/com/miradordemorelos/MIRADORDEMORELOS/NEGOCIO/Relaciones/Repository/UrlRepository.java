package com.miradordemorelos.MIRADORDEMORELOS.NEGOCIO.Relaciones.Repository;

import com.miradordemorelos.MIRADORDEMORELOS.NEGOCIO.Relaciones.Entity.UrlEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UrlRepository extends JpaRepository<UrlEntity, Long> {
}
