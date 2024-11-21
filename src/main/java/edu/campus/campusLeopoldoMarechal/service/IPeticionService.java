package edu.campus.campusLeopoldoMarechal.service;

import java.util.List;

import edu.campus.campusLeopoldoMarechal.model.Peticiones;

public interface IPeticionService {
    
    public Peticiones save(Peticiones peticion);

    public List<Peticiones> findAll();

    public void delete(Long id);
}
