package edu.campus.campusLeopoldoMarechal.controller;

import edu.campus.campusLeopoldoMarechal.model.Materias;
import edu.campus.campusLeopoldoMarechal.service.IMateriasService;
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
import org.springframework.web.bind.annotation.RestController;

@CrossOrigin(origins = "http://localhost:5173")
@RestController
@RequestMapping("/v1")
@AllArgsConstructor
public class ControllerMaterias {

    @Autowired
    private IMateriasService injectMateria;

    @GetMapping("/materias")
    public List<Materias> getMaterias() {
        return injectMateria.getMaterias();
    }

    @PostMapping("/materias/crear")
    public String createMateria(@RequestBody Materias materias) {
        injectMateria.saveMaterias(materias);
        return "Materia creada correctamente";
    }

    @GetMapping("/materias/{id}")
    public Materias findMaterias(@PathVariable Long id) {
        return injectMateria.findMateria(id);
    }

    @PutMapping("/materias/update/{id}")
    public Materias updatMaterias(@PathVariable Long id, @RequestBody Materias materias) {
        return injectMateria.updateMaterias(id, materias);
    }

    @DeleteMapping("/materias/baja/{id}")
    public String bajaMaterias(@PathVariable Long id, @RequestBody Materias materias) {
        injectMateria.deleteMateria(id, materias);
        return "Materia dada de baja";
    }

}
