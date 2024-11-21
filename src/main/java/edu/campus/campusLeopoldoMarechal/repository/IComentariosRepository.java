package edu.campus.campusLeopoldoMarechal.repository;

import edu.campus.campusLeopoldoMarechal.model.Comentarios;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IComentariosRepository extends JpaRepository<Comentarios, Long> {

    List<Comentarios> findByPublicacionId(Long publicacionId);

}
