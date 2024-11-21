package edu.campus.campusLeopoldoMarechal.service;

import edu.campus.campusLeopoldoMarechal.model.Archivo;

public interface IArchivoService {
    
    public Archivo guardarArchivo(String nombre, String tipo, byte[] datos);

    public Archivo obtenerArchivo(Long id);
}
