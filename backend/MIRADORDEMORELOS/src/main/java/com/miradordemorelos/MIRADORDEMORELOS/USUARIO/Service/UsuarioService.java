package com.miradordemorelos.MIRADORDEMORELOS.USUARIO.Service;

import com.miradordemorelos.MIRADORDEMORELOS.USUARIO.Entity.UsuarioEntity;
import com.miradordemorelos.MIRADORDEMORELOS.USUARIO.Entity.UsuarioLogin;
import com.miradordemorelos.MIRADORDEMORELOS.USUARIO.Repository.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UsuarioService {
    @Autowired
    private BCryptPasswordEncoder passwordEncoder;
    @Autowired
    private UsuarioRepository usuarioRepository;

    public List<UsuarioEntity> obtenerTodos(){
        return usuarioRepository.findAll();
    }
    public UsuarioEntity buscarPorId(Long id){
        return usuarioRepository.findById(id).orElse(null);
    }

    public void guardarUsuario(UsuarioEntity usuarioEntity){
        BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
        usuarioEntity.setPassword(encoder.encode(usuarioEntity.getPassword()));

        UsuarioEntity usuario_guardado = usuarioRepository.save(usuarioEntity);
    }
    public Optional<UsuarioEntity> validacion(UsuarioLogin userLog) {
        Optional<UsuarioEntity> usuarioOpt = usuarioRepository.findByEmail(userLog.getEmail());

        if (usuarioOpt.isEmpty()) {
            return Optional.empty();
        }

        UsuarioEntity usuario = usuarioOpt.get();

        if (passwordEncoder.matches(userLog.getPassword(), usuario.getPassword())) {
            return Optional.of(usuario);
        }

        return Optional.empty();
    }
    public void guardarImagenUsuario(UsuarioEntity usuarioEntity){
        UsuarioEntity usuarioGuardado = usuarioRepository.save(usuarioEntity);
    }

}