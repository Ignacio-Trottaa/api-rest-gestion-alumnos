package edu.campus.campusLeopoldoMarechal.repository;

import edu.campus.campusLeopoldoMarechal.model.Alumno;
import edu.campus.campusLeopoldoMarechal.model.Profesor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
// Mapeo como repositorio
/*La interface extiende de Jpa Repository(que maneja Repositorios JPA)
 * en los parametros "<>", debe ir: <Clase a persistir, tipo de dato su ID>
 * */
public interface IAlumnoRepository extends JpaRepository<Alumno, Long> {

}

