package edu.campus.campusLeopoldoMarechal.service;

import edu.campus.campusLeopoldoMarechal.model.Profesor;

import java.util.List;

public interface IProfesorService {

    public List<Profesor> findAll();

    public void save(Profesor profesor);

    public Profesor findById(Long id);

    public Profesor update(Long id, Profesor profesor);

    public void delete(Long id);
}
