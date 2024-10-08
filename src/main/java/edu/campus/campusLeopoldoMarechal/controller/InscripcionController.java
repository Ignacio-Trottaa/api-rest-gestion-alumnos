package edu.campus.campusLeopoldoMarechal.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import edu.campus.campusLeopoldoMarechal.service.AlumnoService;

@RestController
@RequestMapping("/api")
public class InscripcionController {

    @Autowired
    private AlumnoService alumnoService;

    @PostMapping("/alumno/{alumnoId}/inscripcion/{materiaId}")
    public ResponseEntity<String> inscribirAlumno(@PathVariable Long alumnoId, @PathVariable Long materiaId) {
        alumnoService.inscribirAlumnoEnMateria(alumnoId, materiaId);
        return ResponseEntity.status(HttpStatus.OK).body("Alumno inscrito correctamente en la materia.");
    }

    @DeleteMapping("/alumno/{alumnoId}/desinscripcion/{materiaId}")
    public ResponseEntity<String> desinscribirAlumno(@PathVariable Long alumnoId, @PathVariable Long materiaId) {
        alumnoService.desinscribirAlumnoDeMateria(alumnoId, materiaId);
        return ResponseEntity.status(HttpStatus.OK).body("Alumno desinscripto correctamente de la materia.");
    }
}
