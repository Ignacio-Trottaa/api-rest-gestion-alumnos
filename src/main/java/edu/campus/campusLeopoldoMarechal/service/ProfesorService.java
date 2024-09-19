package edu.campus.campusLeopoldoMarechal.service;

import edu.campus.campusLeopoldoMarechal.model.Profesor;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public class ProfesorService implements IProfesorService {

    @Autowired
    private IProfesorService profesorService;

    @Override
    public List<Profesor> getProfesores() {
        return List.of();
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
