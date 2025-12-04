package com.miradordemorelos.MIRADORDEMORELOS.USUARIO.Service;

import com.miradordemorelos.MIRADORDEMORELOS.USUARIO.Entity.UsuarioDTO;
import com.miradordemorelos.MIRADORDEMORELOS.USUARIO.Entity.UsuarioEntity;

public class Scripts {
    public static UsuarioDTO convertToDto(UsuarioEntity usuarioEntity){
        if(usuarioEntity != null) {
            return new UsuarioDTO(usuarioEntity.getId(), usuarioEntity.getEmail(), usuarioEntity.getRol(),
                    usuarioEntity.getNombre(), usuarioEntity.getApellidoP(), usuarioEntity.getApellidoM(),
                    usuarioEntity.getImagenPerfil(), usuarioEntity.getNegocios());
        }else{
            return null;
        }
    }
}
