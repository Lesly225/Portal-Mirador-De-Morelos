package com.miradordemorelos.MIRADORDEMORELOS.USUARIO.Controller;

import com.miradordemorelos.MIRADORDEMORELOS.Scripts.ImageManager;
import com.miradordemorelos.MIRADORDEMORELOS.USUARIO.Entity.UsuarioDTO;
import com.miradordemorelos.MIRADORDEMORELOS.USUARIO.Entity.UsuarioEntity;
import com.miradordemorelos.MIRADORDEMORELOS.USUARIO.Entity.UsuarioLogin;
import com.miradordemorelos.MIRADORDEMORELOS.USUARIO.Service.Scripts;
import com.miradordemorelos.MIRADORDEMORELOS.USUARIO.Service.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.Resource;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.Optional;


@RestController
@RequestMapping("/api/usuario")
public class UsuarioController {
    private final UsuarioService service;
    public UsuarioController(UsuarioService service) {
        this.service = service;
    }

    @PostMapping("/auth")
    public ResponseEntity<?> validar(@RequestBody UsuarioLogin login) {

        Optional<UsuarioEntity> usuario = service.validacion(login);

        if (usuario.isEmpty()) {
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED)
                    .body(Map.of("error", "Credenciales incorrectas"));
        }

        return ResponseEntity.ok(Map.of(
                "mensaje", "Login correcto",
                "usuario", usuario
        ));
    }

    @GetMapping("/all")
    public ResponseEntity<List<UsuarioEntity>> getAll() {
        return ResponseEntity.ok(service.obtenerTodos());
    }

    @GetMapping("/search/id/{id}")
    public ResponseEntity<UsuarioDTO> getById(@PathVariable Long id) {
        return ResponseEntity.ok(Scripts.convertToDto(service.buscarPorId(id)));
    }
    //CREATE
    @PostMapping("/create")
    public ResponseEntity<UsuarioDTO> createUser(@RequestBody UsuarioEntity usuarioEntity){
        service.guardarUsuario(usuarioEntity);
        return ResponseEntity.ok(Scripts.convertToDto(usuarioEntity));
    }
    //UPDATE
    @PatchMapping("/update")
    public ResponseEntity<?> updateUser(@RequestBody UsuarioEntity usuarioEntity){
        System.out.println("CONTRASENIA:("+usuarioEntity.getPassword()+")");

        if(usuarioEntity.getId() == null){
            return ResponseEntity.badRequest().body("El ID es obligatorio");
        }

        UsuarioEntity usuario = service.buscarPorId(usuarioEntity.getId());
        if (usuario == null) {
            return ResponseEntity.notFound().build();
        }
        if(usuarioEntity.getEmail() != null){
            usuario.setEmail(usuarioEntity.getEmail());
        }
        if(usuarioEntity.getPassword() != null){
            usuario.setPassword(usuarioEntity.getPassword());
        }
        if(usuarioEntity.getRol() != null){
            usuario.setRol(usuarioEntity.getRol());
        }
        if(usuarioEntity.getNombre() != null){
            usuario.setNombre(usuarioEntity.getNombre());
        }
        if(usuarioEntity.getApellidoP() != null){
            usuario.setApellidoP(usuarioEntity.getApellidoP());
        }
        if(usuarioEntity.getApellidoM() != null){
            usuario.setApellidoM(usuarioEntity.getApellidoM());
        }
        if(usuarioEntity.getImagenPerfil() != null){
            usuario.setImagenPerfil(usuarioEntity.getImagenPerfil());
        }
        if(usuarioEntity.getNegocios() != null){
            usuario.setNegocios(usuarioEntity.getNegocios());
        }

        service.guardarUsuario(usuario);

        return ResponseEntity.ok(Scripts.convertToDto(usuario));
    }

    @PostMapping("/upload/image/{id}")
    public ResponseEntity<?> uploadFotoUsuario(
            @PathVariable Long id,
            @RequestParam("file") MultipartFile file) throws IOException {

        if (!file.getContentType().startsWith("image/")) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST)
                    .body("Solo se permiten imágenes");
        }

        String urlImagen = ImageManager.saveImage(file);
        UsuarioEntity usuario = service.buscarPorId(id);
        usuario.setImagenPerfil(urlImagen);

        service.guardarImagenUsuario(usuario);
        return ResponseEntity.ok(Map.of("url", urlImagen));
    }

    @GetMapping("/image/{nombreFoto}")
    public ResponseEntity<Resource> verFotoUsuario(@PathVariable String nombreFoto) {
       return ImageManager.getImage(nombreFoto);
    }
}