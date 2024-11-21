package edu.campus.campusLeopoldoMarechal.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.http.*;

import edu.campus.campusLeopoldoMarechal.model.Publicacion;
import edu.campus.campusLeopoldoMarechal.service.IPublicacionService;

import lombok.AllArgsConstructor;

import java.io.IOException;

import java.util.List;

@CrossOrigin(origins = "http://localhost:5173")
@RestController
@RequestMapping("/v1")
@AllArgsConstructor
public class ControllerPublicacion {

    @Autowired
    private IPublicacionService publicacionService;


    @GetMapping("/publicaciones/{materiaId}")
    public List<Publicacion> getPublicacionesByMaterias(@PathVariable Long materiaId) {
        return publicacionService.findAllByMateriasId(materiaId);
    }

    @PostMapping(value= "/publicacion/{materiaId}" , consumes = MediaType.MULTIPART_FORM_DATA_VALUE)
    public Publicacion createPublicacion(
        @PathVariable Long materiaId,
        @RequestParam(required = false, name = "alumnoId") Long alumnoId,
        @RequestParam(required = false, name = "profesorId") Long profesorId,
        @RequestParam("contenido") String contenido,
        @RequestParam("fecha") String fecha,
        @RequestParam(value="archivo", required = false) MultipartFile archivoFile) throws IOException {
            Publicacion publicacion = new Publicacion();
            publicacion.setContenido(contenido);
            publicacion.setFecha(fecha);
        return publicacionService.save(publicacion, materiaId, alumnoId, profesorId, archivoFile);
    }
}
