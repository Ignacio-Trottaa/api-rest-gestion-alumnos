package edu.campus.campusLeopoldoMarechal.service;

import edu.campus.campusLeopoldoMarechal.model.Materias;

import java.util.List;

public interface IMateriasService {

    public List<Materias> getMaterias();

    public void saveMaterias(Materias materias);

    public Materias findMateria(Long id);

    public Materias updateMaterias(Long id, Materias materias);

    public void deleteMateria(Long id, Materias materias);
}
