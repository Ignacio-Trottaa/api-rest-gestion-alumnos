package edu.campus.campusLeopoldoMarechal.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
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
    private IProfesorService profesorService;

    @GetMapping("/profesores")
    public ResponseEntity<List<Profesor>> findAllProfesor() {
        List<Profesor> profesor = profesorService.findAll();
        return ResponseEntity.ok(profesor);
    }

    @PostMapping("/profesor/alta")
    public ResponseEntity<String> saveProfesor(@RequestBody Profesor profesor) {
        profesorService.save(profesor);
        return ResponseEntity.status(HttpStatus.CREATED).body("Profesor creado correctamente");
    }

    @GetMapping("/profesor/{id}")
    public ResponseEntity<Profesor> findProfesorById(@PathVariable Long id) {
        Profesor profesor = profesorService.findById(id);
        return ResponseEntity.ok(profesor);
    }

    @PutMapping("/profesor/actualizar/{id}")
    public ResponseEntity<Profesor> updateProfesor(@PathVariable Long id, @RequestBody Profesor profesor) {
        Profesor updateProfesor = profesorService.update(id, profesor);
        return ResponseEntity.ok(updateProfesor);
    }

    @PutMapping("/profesor/eliminar/{id}")
    public ResponseEntity<Profesor> deleteProfesor(@PathVariable Long id) {
        Profesor deactivateProfesor = profesorService.deactivate(id);
        return ResponseEntity.ok(deactivateProfesor);
    }
    @PutMapping("/profesor/reintegrar/{id}")
    public ResponseEntity<Profesor> reintegrarProfesor(@PathVariable Long id) {
        Profesor reintegrarProfesor = profesorService.reintegrar(id);
        return ResponseEntity.ok(reintegrarProfesor);
    }
}
