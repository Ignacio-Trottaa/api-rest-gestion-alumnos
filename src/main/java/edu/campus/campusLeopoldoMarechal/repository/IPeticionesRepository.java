package edu.campus.campusLeopoldoMarechal.repository;

import edu.campus.campusLeopoldoMarechal.model.Peticiones;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IPeticionesRepository extends JpaRepository<Peticiones, Long>{

}
