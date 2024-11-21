package edu.campus.campusLeopoldoMarechal.repository;

import edu.campus.campusLeopoldoMarechal.model.Materia;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IMateriaRepository extends JpaRepository<Materia, Long> {

    Materia findByCodigo(String codigo);

    List<Materia> findMateriasByProfesorId(Long profesorId);
}
