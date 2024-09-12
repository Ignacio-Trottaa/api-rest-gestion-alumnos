package edu.campus.campusLeopoldoMarechal.controller;

import edu.campus.campusLeopoldoMarechal.model.Alumno;
import edu.campus.campusLeopoldoMarechal.repository.IAlumnoRepository;
import edu.campus.campusLeopoldoMarechal.service.IAlumnoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RequestMapping("/api")
@RestController
public class Controller {

    @Autowired
    private IAlumnoService injectAlumno;
   // private IAlumnoRepository alumnoRepository;

    @GetMapping("/alumnos")
    public List<Alumno> getAlumno() {
        return injectAlumno.getAlumno();
    }

    @PostMapping("/alumnos/crear")
    public String createAlumno(@RequestBody Alumno alumno) {
        injectAlumno.saveAlumno(alumno);
        return "Alumno creado correctamente";
    }
    @GetMapping("/alumnos/{id}")
    public Alumno findAlumno(@PathVariable Long id) {
        return injectAlumno.findAlumno(id);
    }
/* 
    @DeleteMapping("/darBajaAlumno/{id}")
    public ResponseEntity<Alumno> DarBajaEstudiante(@PathVariable Long id){
        Alumno estudianteActual = alumnoRepository.findById(id).orElse(null);
        estudianteActual.setEstado_estudiante(false);  
        return ResponseEntity.ok(estudianteActual);
    }
*/
}
