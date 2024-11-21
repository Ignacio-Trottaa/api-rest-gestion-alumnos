package edu.campus.campusLeopoldoMarechal.service;

import edu.campus.campusLeopoldoMarechal.model.Materia;

import java.util.List;

public interface IMateriaService {

    public List<Materia> findAll();

    public void save(Materia materias, Long profesorId);

    public Materia findById(Long id);

    public Materia update(Long id, Materia materias);

    public void delete(Long id, Materia materias);

    public List<Materia> findMateriasByProfesorId(Long profesorId);
}
