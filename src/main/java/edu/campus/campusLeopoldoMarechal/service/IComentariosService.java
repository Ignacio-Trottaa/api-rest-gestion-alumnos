package edu.campus.campusLeopoldoMarechal.service;

import edu.campus.campusLeopoldoMarechal.model.Comentarios;

import java.util.List;

public interface IComentariosService {

    public Comentarios save(Comentarios comentario, Long publicacionId, Long alumnoId, Long profesorId);

    public List<Comentarios> findAllByPublicacionId(Long publicacionId);
}
