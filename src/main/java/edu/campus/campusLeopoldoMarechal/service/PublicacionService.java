package edu.campus.campusLeopoldoMarechal.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import edu.campus.campusLeopoldoMarechal.model.Alumno;
import edu.campus.campusLeopoldoMarechal.model.Archivo;
import edu.campus.campusLeopoldoMarechal.model.Materia;
import edu.campus.campusLeopoldoMarechal.model.Profesor;
import edu.campus.campusLeopoldoMarechal.model.Publicacion;
import edu.campus.campusLeopoldoMarechal.repository.IAlumnoRepository;
import edu.campus.campusLeopoldoMarechal.repository.IMateriaRepository;
import edu.campus.campusLeopoldoMarechal.repository.IProfesorRepository;
import edu.campus.campusLeopoldoMarechal.repository.IPublicacionRepository;

import java.io.IOException;
import java.util.List;

@Service
public class PublicacionService implements IPublicacionService{

    @Autowired
    private IArchivoService archivoService;
    
    @Autowired
    private IPublicacionRepository publicacionRepository;

    @Autowired
    private IMateriaRepository materiaRepository;
    
    @Autowired
    private IAlumnoRepository alumnoRepository;

    @Autowired
    private IProfesorRepository profesorRepository;

    @Override
    public List<Publicacion> findAllByMateriasId(Long materiaId){
        return publicacionRepository.findByMateriasId(materiaId);
    }

    @Override
    public Publicacion save(Publicacion publicacion, Long materiaId, Long alumnoId, Long profesorId, MultipartFile archivoFile) throws IOException{
        Materia materia = materiaRepository.findById(materiaId).orElse(null);
        publicacion.setMaterias(materia);

        if(alumnoId!=null){
            Alumno alumno = alumnoRepository.findById(alumnoId).orElse(null);
            publicacion.setAlumno(alumno);
            publicacion.setCreadorNom(alumno.getNombre());
            publicacion.setCreadorApe(alumno.getApellido());
            publicacion.setCreadorRol("estudiante");
        }else if(profesorId!=null){
            Profesor profesor = profesorRepository.findById(profesorId).orElse(null);
            publicacion.setProfesor(profesor);
            publicacion.setCreadorNom(profesor.getNombre());
            publicacion.setCreadorApe(profesor.getApellido());
            publicacion.setCreadorRol("profesor");
        }else{
            return null;
        }
        if(archivoFile != null){
            String fileName = archivoFile.getOriginalFilename();
            Archivo archivo = archivoService.guardarArchivo(fileName, archivoFile.getContentType(), archivoFile.getBytes());
            publicacion.setArchivo(archivo);   
        }
        return publicacionRepository.save(publicacion);
    }
}
