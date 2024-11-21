package edu.campus.campusLeopoldoMarechal.repository;

import edu.campus.campusLeopoldoMarechal.model.Publicacion;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IPublicacionRepository extends JpaRepository <Publicacion, Long>{

    List<Publicacion> findByMateriasId(Long materiaId);
    
}
