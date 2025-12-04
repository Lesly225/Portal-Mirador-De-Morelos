package com.miradordemorelos.MIRADORDEMORELOS.NOTICIA.Controller;

import com.miradordemorelos.MIRADORDEMORELOS.NEGOCIO.Relaciones.Entity.PublicacionDTO;
import com.miradordemorelos.MIRADORDEMORELOS.NOTICIA.Entity.NoticiaDTO;
import com.miradordemorelos.MIRADORDEMORELOS.NOTICIA.Entity.NoticiaEntity;
import com.miradordemorelos.MIRADORDEMORELOS.NOTICIA.Service.NoticiaService;
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
@RequestMapping("/api/noticia")
public class NoticiaController {
    @Autowired
    NoticiaService noticiaService;

    @PostMapping(value = "/new", consumes = MediaType.MULTIPART_FORM_DATA_VALUE)
    public ResponseEntity<?> crearnueva(
            @RequestPart("noticia") NoticiaDTO noticia,
            @RequestPart("imagen") MultipartFile imagen) throws IOException {
        return ResponseEntity.ok(noticiaService.crearNoticia(noticia, imagen));
    }
    @GetMapping("/image/{nombreFoto}")
    public ResponseEntity<Resource> verFotoNoticia(@PathVariable String nombreFoto) {
        return ImageManager.getImage(nombreFoto);
    }
    @GetMapping("/now")
    public ResponseEntity<List<NoticiaEntity>> nuevas(){
        return ResponseEntity.ok( noticiaService.obtenerNoticiasNuevas());
    }
    @GetMapping("/categoria/{categoria}")
    public ResponseEntity<List<NoticiaEntity>> filterCategoria(@PathVariable String categoria){
        return ResponseEntity.ok(noticiaService.filterByCategoria(categoria));
    }
    @GetMapping("/municipio/{municipio}")
    public ResponseEntity<List<NoticiaEntity>> filterMunicipio(@PathVariable String municipio){
        return ResponseEntity.ok(noticiaService.filterByMunicipio(municipio));
    }
    @GetMapping("/id/{id}")
    public ResponseEntity<NoticiaEntity> getById(@PathVariable Long id){
        return ResponseEntity.ok(noticiaService.getById(id));
    }
    @GetMapping("/usuario/{id}")
    public ResponseEntity<List<NoticiaEntity>> filterUsuario(@PathVariable Long id){
        return ResponseEntity.ok(noticiaService.filterByUsuario(id));
    }
    @DeleteMapping("/delete/{id}")
    public ResponseEntity<?> delete(@PathVariable Long id){
        noticiaService.deleteById(id);
        return ResponseEntity.ok(Map.of("response", "noticia eliminada"));
    }
    @GetMapping("/filterByTitulo/{titulo}")
    public ResponseEntity<?> filterByTitulo(@PathVariable String titulo){
        return ResponseEntity.ok(noticiaService.buscarTitulo(titulo));
    }
}
