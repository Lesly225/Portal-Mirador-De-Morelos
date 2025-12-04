package com.miradordemorelos.MIRADORDEMORELOS.NEGOCIO.Controller;

import com.miradordemorelos.MIRADORDEMORELOS.NEGOCIO.Entity.DTO.MunicipioCategoriaDTO;
import com.miradordemorelos.MIRADORDEMORELOS.NEGOCIO.Entity.DTO.NegocioDTO;
import com.miradordemorelos.MIRADORDEMORELOS.NEGOCIO.Entity.DTO.OnlyNegocioDTO;
import com.miradordemorelos.MIRADORDEMORELOS.NEGOCIO.Entity.NegocioEntity;
import com.miradordemorelos.MIRADORDEMORELOS.NEGOCIO.Relaciones.Entity.PublicacionDTO;
import com.miradordemorelos.MIRADORDEMORELOS.NEGOCIO.Service.NegocioService;
import com.miradordemorelos.MIRADORDEMORELOS.Scripts.ImageManager;
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
@RequestMapping("/api/negocio/")
public class NegocioController {

    @Autowired
    private final NegocioService negocioService;


    public NegocioController(NegocioService negocioService){
        this.negocioService = negocioService;
    }


    @PostMapping(value = "/crear", consumes = MediaType.MULTIPART_FORM_DATA_VALUE)
    public ResponseEntity<NegocioEntity> crear(
            @RequestPart("negocio") NegocioDTO negocio,
            @RequestPart("imagen") MultipartFile imagen) throws IOException {
        return ResponseEntity.ok(negocioService.crearNegocio(negocio, imagen));
    }

    @GetMapping("/image/{nombreFoto}")
    public ResponseEntity<Resource> verFotoNegocio(@PathVariable String nombreFoto) {
        return ImageManager.getImage(nombreFoto);
    }

    @GetMapping("/id/{id}")
    public ResponseEntity<?> getById(@PathVariable Long id){
        return ResponseEntity.ok(negocioService.obtenerNegocioPorId(id));
    }
    @GetMapping("/categoria/{categoria}")
    public ResponseEntity<List<NegocioEntity>> filterCategoria(@PathVariable String categoria){
        return ResponseEntity.ok(negocioService.obtenerPorCategoria(categoria));
    }
    @GetMapping("/municipio/{municipio}")
    public ResponseEntity<List<NegocioEntity>> filterMunicipio(@PathVariable String municipio){
        return ResponseEntity.ok(negocioService.obtenerPorMunicipio(municipio));
    }
    @PostMapping("/filterByCatMun")
    public ResponseEntity<List<NegocioEntity>> filter(@RequestBody MunicipioCategoriaDTO filterMunCat){
        return ResponseEntity.ok(negocioService.buscarPorMunicipioYCategoria(filterMunCat.id_municipio, filterMunCat.id_categoria));
    }
    @GetMapping("/usuario/{id}")
    public ResponseEntity<List<OnlyNegocioDTO>> filterNegociosByUsuarioId(@PathVariable Long id){
        return ResponseEntity.ok(negocioService.buscarPorUsuario(id));
    }
    @DeleteMapping("/delete/{id}")
    public ResponseEntity<?> delete(@PathVariable Long id){
        negocioService.deleteById(id);
        return ResponseEntity.ok(Map.of("response", "Negocio eliminado"));
    }
    @GetMapping("/filterByNombre/{nombre}")
    public ResponseEntity<?> filterByNombre(@PathVariable String nombre){
        return ResponseEntity.ok(negocioService.buscarNombre(nombre));
    }
}

