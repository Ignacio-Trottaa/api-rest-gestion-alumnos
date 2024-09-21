package edu.campus.campusLeopoldoMarechal.service;

import edu.campus.campusLeopoldoMarechal.model.Materias;
import edu.campus.campusLeopoldoMarechal.repository.IMateriasRepository;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class MateriasService implements IMateriasService {

    @Autowired
    private IMateriasRepository materiasRepository;

    @Override
    public List<Materias> getMaterias() {
        return materiasRepository.findAll();
    }

    @Override
    public void saveMaterias(Materias materias) {
        materiasRepository.save(materias);

    }

    @Override
    public void findMateria(Long id) {
        materiasRepository.findById(id).orElse(null);
    }

    @Override
    public void deleteMateria(Long id, Materias materias) {
        materiasRepository.delete(materias);

    }

    @Override
    public void updateMaterias(Long id, Materias materias) {

    }

}
