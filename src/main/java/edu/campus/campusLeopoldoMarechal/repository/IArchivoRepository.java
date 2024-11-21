package edu.campus.campusLeopoldoMarechal.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import edu.campus.campusLeopoldoMarechal.model.Archivo;

@Repository
public interface IArchivoRepository extends JpaRepository<Archivo, Long> {
}
