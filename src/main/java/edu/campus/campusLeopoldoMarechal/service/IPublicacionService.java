package edu.campus.campusLeopoldoMarechal.service;

import edu.campus.campusLeopoldoMarechal.model.Publicacion;

import java.io.IOException;
import java.util.List;

import org.springframework.web.multipart.MultipartFile;

public interface IPublicacionService {
    
    public List<Publicacion> findAllByMateriasId(Long materiaId);

    public Publicacion save(Publicacion publicacion, Long materiaId, Long alumnoId, Long profesorId, MultipartFile archivo) throws IOException;
}
