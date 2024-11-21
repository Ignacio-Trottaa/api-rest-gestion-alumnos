package edu.campus.campusLeopoldoMarechal.controller;

import edu.campus.campusLeopoldoMarechal.model.Alumno;
import edu.campus.campusLeopoldoMarechal.model.Materia;
import edu.campus.campusLeopoldoMarechal.service.IAlumnoService;
import java.util.List;
import java.util.Optional;

import lombok.AllArgsConstructor;
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

@CrossOrigin(origins = "http://localhost:5173")
@RestController
@RequestMapping("/v1")
@AllArgsConstructor
public class ControllerAlumnos {

    @Autowired
    private final IAlumnoService alumnoService;

    @GetMapping("/alumnos")
    public ResponseEntity<List<Alumno>> getAlumnos() {
        List<Alumno> alumnos = alumnoService.findAll();
        return ResponseEntity.ok(alumnos);

    }

    @PostMapping("/alumno/alta")
    public ResponseEntity<String> createAlumno(@RequestBody Alumno alumno) {
        alumnoService.save(alumno);
        return ResponseEntity.status(HttpStatus.CREATED).body("Alumno creado correctamente");
    }

    @GetMapping("/alumno/{id}")
    public ResponseEntity<Alumno> findAlumno(@PathVariable Long id) {
        Alumno alumno = alumnoService.findById(id);
        return ResponseEntity.ok().body(alumno);
    }

    @PutMapping("/alumno/actualizar/{id}")
    public ResponseEntity<Alumno> updateAlumno(@PathVariable Long id, @RequestBody Alumno alumno) {
        Alumno updateAlumno = alumnoService.update(id, alumno);
        return ResponseEntity.ok(updateAlumno);
    }

    @PutMapping("/alumno/estado/{id}")
    public ResponseEntity<Alumno> deactivateAlumno(@PathVariable Long id) {
        Alumno deactivateAlumno = alumnoService.deactivate(id);
        return ResponseEntity.ok(deactivateAlumno);
    }
    @PutMapping("/alumno/reintegrar/{id}")
    public ResponseEntity<Alumno> reintegrarAlumno(@PathVariable Long id) {
        Alumno reintegrarAlumno = alumnoService.reintegrar(id);
        return ResponseEntity.ok(reintegrarAlumno);
    }

    @GetMapping("/alumno/{id}/materias")
    public ResponseEntity<List<Materia>> allMateriasByAlumno(@PathVariable Long id){
        Optional<Alumno> alumnoOpt = Optional.ofNullable(alumnoService.findById(id));
        
        if (alumnoOpt.isPresent()) {
            Alumno alumno = alumnoOpt.get();
            List<Materia> materias = alumno.getMaterias();
            return ResponseEntity.ok(materias);
        } else {
            return ResponseEntity.notFound().build();
        }
    }
}
