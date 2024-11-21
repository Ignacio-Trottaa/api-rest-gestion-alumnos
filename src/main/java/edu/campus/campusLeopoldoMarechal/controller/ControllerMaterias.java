package edu.campus.campusLeopoldoMarechal.controller;

import edu.campus.campusLeopoldoMarechal.model.Materia;
import edu.campus.campusLeopoldoMarechal.service.IMateriaService;
import java.util.List;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@CrossOrigin(origins = "http://localhost:5173")
@RestController
@RequestMapping("/v1")
@AllArgsConstructor
public class ControllerMaterias {

    @Autowired
    private IMateriaService injectMateria;

    @GetMapping("/materias")
    public List<Materia> getMaterias() {
        return injectMateria.findAll();
    }

    @PostMapping("/materia")
    public String createMateria(@RequestBody Materia materias,@RequestParam("profesorId") Long profesorId) {
        injectMateria.save(materias,profesorId);
        return "Materia creada correctamente";
    }

    @GetMapping("/materia/{id}")
    public Materia findMaterias(@PathVariable Long id) {
        return injectMateria.findById(id);
    }
    @GetMapping("/materias/profesor/{profesorId}")
    public List<Materia> getMateriasByProfesor(@PathVariable Long profesorId) {
        return injectMateria.findMateriasByProfesorId(profesorId);
    }

    @PutMapping("/materia/{id}")
    public Materia updatMaterias(@PathVariable Long id, @RequestBody Materia materias) {
        return injectMateria.update(id, materias);
    }

    @DeleteMapping("/materia/{id}")
    public String bajaMaterias(@PathVariable Long id, @RequestBody Materia materias) {
        injectMateria.delete(id, materias);
        return "Materia dada de baja";
    }

}
