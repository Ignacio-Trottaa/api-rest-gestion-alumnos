package edu.campus.campusLeopoldoMarechal.service;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import edu.campus.campusLeopoldoMarechal.model.Materia;
import edu.campus.campusLeopoldoMarechal.repository.IMateriaRepository;

@Service
public class MateriaService implements IMateriaService {

    @Autowired
    private IMateriaRepository materiaRepository;

    @Override
    public List<Materia> findAll() {
        return materiaRepository.findAll();
    }

    @Override
    public void save(Materia materias) {
        materiaRepository.save(materias);

    }

    @Override
    public Materia findById(Long id) {
        return materiaRepository.findById(id).orElse(null);
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
