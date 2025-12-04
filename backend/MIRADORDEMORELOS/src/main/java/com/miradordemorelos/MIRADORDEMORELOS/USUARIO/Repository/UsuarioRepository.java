package com.miradordemorelos.MIRADORDEMORELOS.USUARIO.Repository;

import com.miradordemorelos.MIRADORDEMORELOS.USUARIO.Entity.UsuarioEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UsuarioRepository extends JpaRepository<UsuarioEntity, Long> {
    Optional<UsuarioEntity> findByEmail(String email);
}