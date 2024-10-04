package edu.campus.campusLeopoldoMarechal.service;

import edu.campus.campusLeopoldoMarechal.model.Alumno;

import java.util.List;

public interface IAlumnoService {

    // Metodo para traer todos los alumnos
    public List<Alumno> findAll();

    // metodo para guardar un alumno
    public void save(Alumno alumno);

    // Metodo para encontrar un alumno por su ID
    public Alumno findById(Long id);

    // Metodo para actualizar un alumno
    public Alumno update(Long id, Alumno alumno);

    // Metodo para dar de baja alumno (o cambiar su estado)
    public Alumno deactivate(Long id);
}
