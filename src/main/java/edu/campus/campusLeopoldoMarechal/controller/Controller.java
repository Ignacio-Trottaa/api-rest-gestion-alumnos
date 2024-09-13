package edu.campus.campusLeopoldoMarechal.controller;

import edu.campus.campusLeopoldoMarechal.model.Alumno;
import edu.campus.campusLeopoldoMarechal.repository.IAlumnoRepository;
import edu.campus.campusLeopoldoMarechal.service.IAlumnoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


import java.util.List;

@CrossOrigin(origins="http://localhost:5173")
@RestController
@RequestMapping("/api")
public class Controller {

    @Autowired
    private IAlumnoService injectAlumno;
    //private IAlumnoRepository alumnoRepository;

    @GetMapping("/alumnos")
    public List<Alumno> getAlumno() {
        return injectAlumno.getAlumno();
    }

    @PostMapping("/alumno/crear")
    public String createAlumno(@RequestBody Alumno alumno) {
        injectAlumno.saveAlumno(alumno);
        return "Alumno creado correctamente";
    }

    @GetMapping("/alumno/{id}")
    public Alumno findAlumno(@PathVariable Long id) {
        return injectAlumno.findAlumno(id);
    }

    @PutMapping("/alumno/update/{id}")
    public Alumno updateAlumno(@PathVariable Long id, @RequestBody Alumno alumno){
        return injectAlumno.updateAlumno(id, alumno);
    }

    @PutMapping("/alumno/baja/{id}")
    public Alumno bajaAlumno(@PathVariable Long id, @RequestBody Alumno alumno){
        return injectAlumno.bajaAlumno(id, alumno);
    }
}
