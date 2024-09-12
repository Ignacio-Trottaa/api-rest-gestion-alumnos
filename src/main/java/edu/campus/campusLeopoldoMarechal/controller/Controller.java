package edu.campus.campusLeopoldoMarechal.controller;

import edu.campus.campusLeopoldoMarechal.model.Alumno;
import edu.campus.campusLeopoldoMarechal.service.IAlumnoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
public class Controller {

    @Autowired
    private IAlumnoService injectAlumno;

    @GetMapping("/alumnos/traer")
    public List<Alumno> getAlumno() {
        return injectAlumno.getAlumno();
    }

    @PostMapping("/alumnos/crear")
    public String createAlumno(@RequestBody Alumno alumno) {

        injectAlumno.saveAlumno(alumno);
        return "Alumno creado correctamente";
    }

    @DeleteMapping("/alumnos/eliminar/{id}")
    public String deleteAlumno(@PathVariable Long id) {
        injectAlumno.deleteAlumno(id);
        return "Alumno eliminado";
    }

}
