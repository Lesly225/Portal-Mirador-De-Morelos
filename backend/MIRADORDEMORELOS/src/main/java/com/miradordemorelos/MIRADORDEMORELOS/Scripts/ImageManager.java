package com.miradordemorelos.MIRADORDEMORELOS.Scripts;

import org.springframework.core.io.Resource;
import org.springframework.core.io.UrlResource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.util.UUID;

public class ImageManager {
    private static final String carpetaImages = "/home/trixie/fotos/";

    public static String saveImage(MultipartFile file) throws IOException {

        Files.createDirectories(Paths.get(carpetaImages));

        String nombreArchivo = UUID.randomUUID() + "_" + file.getOriginalFilename();
        Path rutaArchivo = Paths.get(carpetaImages).resolve(nombreArchivo).toAbsolutePath();

        Files.copy(file.getInputStream(), rutaArchivo, StandardCopyOption.REPLACE_EXISTING);

        return nombreArchivo;
    }
    public static ResponseEntity<Resource> getImage(String nameImage){
        try {
            Path carpeta = Paths.get(carpetaImages).toAbsolutePath().normalize();
            Path ruta = carpeta.resolve(nameImage).normalize();

            if (!ruta.startsWith(carpeta)) {
                return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
            }

            Resource recurso = new UrlResource(ruta.toUri());
            if (!recurso.exists() || !recurso.isReadable()) {
                return ResponseEntity.notFound().build();
            }

            String contentType = Files.probeContentType(ruta);

            HttpHeaders cabecera = new HttpHeaders();
            cabecera.add(HttpHeaders.CONTENT_TYPE, contentType != null ? contentType : "application/octet-stream");

            return new ResponseEntity<>(recurso, cabecera, HttpStatus.OK);

        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }
}
