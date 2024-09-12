package edu.campus.campusLeopoldoMarechal.service;

import edu.campus.campusLeopoldoMarechal.model.Alumno;
import edu.campus.campusLeopoldoMarechal.repository.IAlumnoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AlumnoService implements IAlumnoService{

    @Autowired
    private IAlumnoRepository alumnoRepository;

    @Override
    public List<Alumno> getAlumno() {
        return alumnoRepository.findAll();
    }

    @Override
    public void saveAlumno(Alumno alumno) {
        alumnoRepository.save(alumno);
    }

    @Override
    public void deleteAlumno(Long id) {
        alumnoRepository.deleteById(id);
    }

    @Override
    public Alumno findAlumno(Long id) {
        return alumnoRepository.findById(id).orElse(null);
    }
}
