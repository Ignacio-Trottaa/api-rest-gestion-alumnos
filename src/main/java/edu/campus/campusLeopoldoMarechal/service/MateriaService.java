package edu.campus.campusLeopoldoMarechal.service;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import edu.campus.campusLeopoldoMarechal.model.Materia;
import edu.campus.campusLeopoldoMarechal.model.Profesor;
import edu.campus.campusLeopoldoMarechal.repository.IMateriaRepository;

@Service
public class MateriaService implements IMateriaService {

    @Autowired
    private IMateriaRepository materiaRepository;

    @Autowired
    private IProfesorService profesorService;

    @Override
    public List<Materia> findAll() {
        return materiaRepository.findAll();
    }

    @Override
    public void save(Materia materias, Long profesorId) {
        Profesor profesor = profesorService.findById(profesorId);
        materias.setProfesor(profesor);
        materiaRepository.save(materias);
    }

    @Override
    public Materia findById(Long id) {
        return materiaRepository.findById(id).orElse(null);
    }
    public List<Materia> findMateriasByProfesorId(Long profesorId) {
        return materiaRepository.findMateriasByProfesorId(profesorId);
    }

    @Override
    public void delete(Long id, Materia materias) {
        materiaRepository.delete(materias);

    }

    @Override
    public Materia update(Long id, Materia materiaRequest) {
        Materia materia = materiaRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Materia no encontrada con el id: " + id));
        materia.setNombre(materiaRequest.getNombre());
        materia.setDescripcion(materiaRequest.getNombre());
        return materiaRepository.save(materia);
    }
}
