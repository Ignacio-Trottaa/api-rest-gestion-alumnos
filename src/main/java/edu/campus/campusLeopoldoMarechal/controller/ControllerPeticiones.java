package edu.campus.campusLeopoldoMarechal.controller;

import edu.campus.campusLeopoldoMarechal.model.Peticiones;
import edu.campus.campusLeopoldoMarechal.service.IPeticionService;
import java.util.List;

import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@CrossOrigin(origins = "http://localhost:5173")
@RestController
@RequestMapping("/v1")
@AllArgsConstructor
public class ControllerPeticiones {

    @Autowired
    private IPeticionService peticionesService;

    @GetMapping("/peticiones")
    public ResponseEntity<List<Peticiones>> getAllPeticiones() {
        return new ResponseEntity<>(peticionesService.findAll(), HttpStatus.OK);
    }

    @PostMapping("/peticion")
    public ResponseEntity<Peticiones> savePeticion(@RequestBody Peticiones peticion) {
        return new ResponseEntity<>(peticionesService.save(peticion), HttpStatus.CREATED);
    }

    @DeleteMapping("/peticion/{id}")
    public ResponseEntity<String> deletePeticion(@PathVariable Long id) {
        peticionesService.delete(id);
        return new ResponseEntity<>("Peticion cumplida", HttpStatus.OK);
    }
    
}
