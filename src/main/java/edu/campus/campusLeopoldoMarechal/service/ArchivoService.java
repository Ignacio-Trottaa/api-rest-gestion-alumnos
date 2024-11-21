package edu.campus.campusLeopoldoMarechal.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import edu.campus.campusLeopoldoMarechal.model.Archivo;
import edu.campus.campusLeopoldoMarechal.repository.IArchivoRepository;

@Service
public class ArchivoService implements IArchivoService {

    @Autowired
    private IArchivoRepository archivoRepository;

    @Override
    public Archivo guardarArchivo(String nombre, String tipo, byte[] datos) {
        Archivo archivo = new Archivo();
        archivo.setNombre(nombre);
        archivo.setTipo(tipo);
        archivo.setTamaño((long) datos.length);
        archivo.setDatos(datos);
        return archivoRepository.save(archivo);
    }

    @Override
    public Archivo obtenerArchivo(Long id) {
        return archivoRepository.findById(id).orElse(null);
    }
}

