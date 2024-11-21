package edu.campus.campusLeopoldoMarechal.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import edu.campus.campusLeopoldoMarechal.model.Comentarios;
import edu.campus.campusLeopoldoMarechal.model.Publicacion;
import edu.campus.campusLeopoldoMarechal.service.IComentariosService;
import edu.campus.campusLeopoldoMarechal.service.PublicacionService;

import lombok.AllArgsConstructor;

import java.util.List;

@CrossOrigin(origins = "http://localhost:5173")
@RestController
@RequestMapping("/v1")
@AllArgsConstructor
public class ControllerComentarios {

    @Autowired
    private IComentariosService comentarioService;

    @GetMapping("/comentarios/{publicacionId}")
    public List<Comentarios> getComentariosByPublicacion(@PathVariable Long publicacionId){
         return comentarioService.findAllByPublicacionId(publicacionId);
    }

    @PostMapping("/comentario/{publicacionId}")
    public Comentarios saveComentario(
        @RequestBody Comentarios comentario,
        @PathVariable Long publicacionId,
        @RequestParam(required = false, name = "alumnoId") Long alumnoId, 
        @RequestParam(required = false, name = "profesorId") Long profesorId){
        return comentarioService.save(comentario, publicacionId, alumnoId, profesorId);
    }
}
