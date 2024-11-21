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
    public List<Profesor> findAll() {
        return profesorRepository.findAll();
    }

    @Override
    public void save(Profesor profesor) {
        profesorRepository.save(profesor);

    }

    @Override
    public Profesor findById(Long id) {
        return profesorRepository.findById(id).orElse(null);
    }

    @Override
    public Profesor deactivate(Long id) {
        Profesor profesor = profesorRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Alumno no encontrado con id: " + id));
        profesor.setEstadoProfesor(false);
        return profesorRepository.save(profesor);
    }

    @Override
    public Profesor update(Long id, Profesor profesorRequest) {
        Profesor profesor = profesorRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Profesor no encontrado con id: " + id));
        profesor.setNombre(profesorRequest.getNombre());
        profesor.setApellido(profesorRequest.getApellido());
        profesor.setDni(profesorRequest.getDni());
        profesor.setCorreoElectronico(profesorRequest.getCorreoElectronico());
        profesor.setMateria(profesorRequest.getMateria());
        profesor.setTelefono(profesorRequest.getTelefono());
        return profesorRepository.save(profesor);
    }
    @Override
    public Profesor reintegrar(Long id) {
        Profesor profesor = profesorRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Alumno no encontrado con id: " + id));
        profesor.setEstadoProfesor(true);
        return profesorRepository.save(profesor);
    }
}
