package edu.campus.campusLeopoldoMarechal.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import edu.campus.campusLeopoldoMarechal.model.Profesor;
import edu.campus.campusLeopoldoMarechal.service.IProfesorService;
import lombok.AllArgsConstructor;

@CrossOrigin(origins = "http://localhost:5173")
@RestController
@RequestMapping("/v1")
@AllArgsConstructor
public class ControllerProfesores {

    @Autowired
    private IProfesorService injectProfesores;

    @GetMapping("/profesores")
    public List<Profesor> getProfesores() {
        return injectProfesores.getProfesores();
    }

    @PostMapping("/profesor/crear")
    public String saveProfesor(@RequestBody Profesor profesor) {
        injectProfesores.saveProfesor(profesor);
        return "Profesor creado correctamente";
    }

    @GetMapping("/profesor/{id}")
    public Profesor findProfesor(@PathVariable Long id) {
        return injectProfesores.findProfesor(id);
    }

    @PutMapping("/profesor/update/{id}")
    public Profesor updaeProfesor(@PathVariable Long id, @RequestBody Profesor profesor) {
        return injectProfesores.updateProfesor(id, profesor);

    }

    @DeleteMapping("profesor/baja/{id}")
    public String bajaProfesor(@PathVariable Long id) {
        injectProfesores.bajaProfesor(id);
        return "Profesor dado de baja";
    }
}
