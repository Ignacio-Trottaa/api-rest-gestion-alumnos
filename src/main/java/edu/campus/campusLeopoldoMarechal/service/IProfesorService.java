package edu.campus.campusLeopoldoMarechal.service;

import edu.campus.campusLeopoldoMarechal.model.Profesor;

import java.util.List;

public interface IProfesorService {

    public List<Profesor> getProfesores();

    public void saveProfesor(Profesor profesor);

    public Profesor findProfesor(Long id);

    public Profesor updateProfesor(Long id, Profesor profesor);

    public void bajaProfesor(Long id);
}
