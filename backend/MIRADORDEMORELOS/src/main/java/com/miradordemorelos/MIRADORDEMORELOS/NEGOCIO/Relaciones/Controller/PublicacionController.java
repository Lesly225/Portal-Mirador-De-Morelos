package com.miradordemorelos.MIRADORDEMORELOS.NEGOCIO.Relaciones.Controller;

import com.miradordemorelos.MIRADORDEMORELOS.NEGOCIO.Relaciones.Entity.PublicacionDTO;
import com.miradordemorelos.MIRADORDEMORELOS.NEGOCIO.Relaciones.Entity.PublicacionEntity;
import com.miradordemorelos.MIRADORDEMORELOS.NEGOCIO.Relaciones.Service.PublicacionService;
import com.miradordemorelos.MIRADORDEMORELOS.Scripts.ImageManager;
import org.apache.coyote.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.Resource;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api/publicacion")
public class PublicacionController {
    @Autowired
    PublicacionService service;

    @PostMapping(value = "/nueva", consumes = MediaType.MULTIPART_FORM_DATA_VALUE)
    public ResponseEntity<?> nueva(
            @RequestPart("publicacion") PublicacionDTO publicacionDTO,
            @RequestPart("imagen") MultipartFile imagen) throws IOException {

        return ResponseEntity.ok(service.guardarPublicacion(publicacionDTO, imagen));
    }

    @GetMapping("/image/{nombreFoto}")
    public ResponseEntity<Resource> verFotoPublicacion(@PathVariable String nombreFoto) {
        return ImageManager.getImage(nombreFoto);
    }

    @GetMapping("/id/{id}")
    public ResponseEntity<?> obtenerPorId(@PathVariable Long id){
        return ResponseEntity.ok(service.obtenerPublicacion(id));
    }

    @GetMapping("/negocio/{id}")
    public ResponseEntity<List<PublicacionEntity>> filterByNegocio(@PathVariable Long id){
        return ResponseEntity.ok(service.filterByNegocio(id));
    }
    @GetMapping("/now")
    public ResponseEntity<List<PublicacionEntity>> nuevas(){
        return ResponseEntity.ok(service.obtenerPublicacionesNuevas());
    }
    @DeleteMapping("/delete/{id}")
    public ResponseEntity<?> delete(@PathVariable Long id){
        service.deleteById(id);
        return ResponseEntity.ok(Map.of("response", "publicacion eliminada"));
    }
    @GetMapping("/filterByTitulo/{titulo}")
    public ResponseEntity<?> filterByNombre(@PathVariable String titulo){
        return ResponseEntity.ok(service.buscarTitulo(titulo));
    }
}