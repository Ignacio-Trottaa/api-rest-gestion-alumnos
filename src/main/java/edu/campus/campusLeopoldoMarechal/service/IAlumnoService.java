package edu.campus.campusLeopoldoMarechal.service;

import edu.campus.campusLeopoldoMarechal.model.Alumno;

import java.util.List;

public interface IAlumnoService {

    /*Interfaz para aplicar metodos crud a la clase alumno*/

    //Metodo para traer todos los alumnos
    public List<Alumno> getAlumno();

    //metodo para dar de alta un alumno
    public void saveAlumno(Alumno alumno);

    //Metodo para encontrar un alumno
    public Alumno findAlumno(Long id);

    //Metodo para actualizar un alumno
    public Alumno updateAlumno(Long id, Alumno alumno);

    //Metodo para dar de baja alumno
    public Alumno bajaAlumno(Long id, Alumno alumno);
}
