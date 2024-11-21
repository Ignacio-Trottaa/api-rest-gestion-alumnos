package edu.campus.campusLeopoldoMarechal.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.http.*;

import edu.campus.campusLeopoldoMarechal.model.Archivo;
import edu.campus.campusLeopoldoMarechal.service.IArchivoService;
import lombok.AllArgsConstructor;

@CrossOrigin(origins = "http://localhost:5173")
@RestController
@RequestMapping("/v1")
@AllArgsConstructor
public class ControllerArchivos {

    @Autowired
    private IArchivoService archivoService;
    
    @GetMapping("/archivo/{archivoId}")
    public ResponseEntity<byte[]> getArchivo(@PathVariable Long archivoId) {
        Archivo archivo = archivoService.obtenerArchivo(archivoId);
        if (archivo != null) {
            return ResponseEntity.ok()
                .header(HttpHeaders.CONTENT_DISPOSITION, "attachment; filename=\"" + archivo.getNombre() + "\"")
                .contentType(MediaType.parseMediaType(archivo.getTipo()))
                .body(archivo.getDatos());
        }
        return ResponseEntity.notFound().build();
}
}
