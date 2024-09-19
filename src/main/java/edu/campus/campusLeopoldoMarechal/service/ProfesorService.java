package edu.campus.campusLeopoldoMarechal.service;

import edu.campus.campusLeopoldoMarechal.model.Profesor;
import edu.campus.campusLeopoldoMarechal.repository.IProfesorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class ProfesorService implements IProfesorService {

    @Autowired
    private IProfesorRepository profesorRepository;

    @Override
    public List<Profesor> getProfesores() {
        return profesorRepository.findAll();
    }

    @Override
    public void saveProfesor(Profesor profesor) {

    }

    @Override
    public Profesor findProfesor(Long id) {
        return null;
    }

    @Override
    public Profesor updateProfesor(Long id, Profesor profesor) {
        return null;
    }

    @Override
    public void bajaProfesor(Long id, Profesor profesor) {

    }
}
