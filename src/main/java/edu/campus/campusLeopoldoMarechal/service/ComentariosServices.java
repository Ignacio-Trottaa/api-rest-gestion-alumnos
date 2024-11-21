package edu.campus.campusLeopoldoMarechal.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import edu.campus.campusLeopoldoMarechal.model.Alumno;
import edu.campus.campusLeopoldoMarechal.model.Comentarios;
import edu.campus.campusLeopoldoMarechal.model.Profesor;
import edu.campus.campusLeopoldoMarechal.model.Publicacion;
import edu.campus.campusLeopoldoMarechal.repository.IAlumnoRepository;
import edu.campus.campusLeopoldoMarechal.repository.IComentariosRepository;
import edu.campus.campusLeopoldoMarechal.repository.IProfesorRepository;
import edu.campus.campusLeopoldoMarechal.repository.IPublicacionRepository;

import java.util.List;

@Service
public class ComentariosServices implements IComentariosService{
    
    @Autowired
    private IComentariosRepository comentariosRepository;

    @Autowired
    private IPublicacionRepository publicacionRepository;

    @Autowired
    private IAlumnoRepository alumnoRepository;

    @Autowired
    private IProfesorRepository profesorRepository;

    @Override
    public Comentarios save(Comentarios comentario, Long publicacionId, Long alumnoId, Long profesorId) {
         Publicacion publicacion = publicacionRepository.findById(publicacionId).orElse(null);
         comentario.setPublicacion(publicacion);
         if(alumnoId != null){
            Alumno alumno = alumnoRepository.findById(alumnoId).orElse(null);
            comentario.setAlumno(alumno);
            comentario.setCreadorNom(alumno.getNombre());
            comentario.setCreadorApe(alumno.getApellido());
            comentario.setCreadorRol("estudiante");
         }else if(profesorId != null){
            Profesor profesor = profesorRepository.findById(profesorId).orElse(null);
            comentario.setProfesor(profesor);
            comentario.setCreadorNom(profesor.getNombre());
            comentario.setCreadorApe(profesor.getApellido());
            comentario.setCreadorRol("profesor");
         }
            return comentariosRepository.save(comentario);    
    }
    @Override
    public List<Comentarios> findAllByPublicacionId(Long publicacionId){
        return comentariosRepository.findByPublicacionId(publicacionId);
    }
}
