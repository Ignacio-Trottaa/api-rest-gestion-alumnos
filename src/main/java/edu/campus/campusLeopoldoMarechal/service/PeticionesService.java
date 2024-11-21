package edu.campus.campusLeopoldoMarechal.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import edu.campus.campusLeopoldoMarechal.model.Peticiones;
import edu.campus.campusLeopoldoMarechal.repository.IPeticionesRepository;

@Service
public class PeticionesService implements IPeticionService {

    @Autowired
    private IPeticionesRepository peticionesRepository;
    
    @Override
    public Peticiones save(Peticiones peticiones) {
        return peticionesRepository.save(peticiones);
    }

    @Override
    public List<Peticiones> findAll() {
        return peticionesRepository.findAll();
    }

    @Override
    public void delete(Long id){
        peticionesRepository.deleteById(id);
    }

}
