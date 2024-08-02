package edu.campus.campusLeopoldoMarechal.service;

import edu.campus.campusLeopoldoMarechal.repository.IAlumnoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AlumnoService {

    @Autowired
    private IAlumnoRepository alumnoRepository;
}
