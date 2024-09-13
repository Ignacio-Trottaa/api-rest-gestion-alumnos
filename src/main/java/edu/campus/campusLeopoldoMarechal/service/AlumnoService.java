package edu.campus.campusLeopoldoMarechal.service;

import edu.campus.campusLeopoldoMarechal.model.Alumno;
import edu.campus.campusLeopoldoMarechal.repository.IAlumnoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AlumnoService implements IAlumnoService{

    @Autowired
    private IAlumnoRepository alumnoRepository;

    @Override
    public List<Alumno> getAlumno() {
        return alumnoRepository.findAll();
    }

    @Override
    public void saveAlumno(Alumno alumno) {
        alumnoRepository.save(alumno);
    }

    @Override
    public void deleteAlumno(Long id) {
        alumnoRepository.deleteById(id);
    }

    @Override
    public Alumno findAlumno(Long id) {
        return alumnoRepository.findById(id).orElse(null);
    }
    @Override
    public Alumno updateAlumno(Long id, Alumno alumnoRequest) {
    Alumno alumno = alumnoRepository.findById(id)
            .orElseThrow(() -> new RuntimeException("Alumno no encontrado con id: " + id)); 
            alumno.setNombre(alumnoRequest.getNombre());
            alumno.setApellido(alumnoRequest.getApellido());
            alumno.setDni(alumnoRequest.getDni());
            alumno.setFecha_nac(alumnoRequest.getFecha_nac());
            alumno.setLugar_nac(alumnoRequest.getLugar_nac());
            alumno.setEstado_civil(alumnoRequest.getEstado_civil());
            alumno.setCant_hijos(alumnoRequest.getCant_hijos());
            alumno.setFamiliares_acargo(alumnoRequest.getFamiliares_acargo());
            alumno.setDireccion(alumnoRequest.getDireccion());
            alumno.setNumero(alumnoRequest.getNumero());
            alumno.setPiso(alumnoRequest.getPiso());
            alumno.setDepto(alumnoRequest.getDepto());
            alumno.setLocalidad(alumnoRequest.getLocalidad());
            alumno.setPartido(alumnoRequest.getPartido());
            alumno.setCodigo_postal(alumnoRequest.getCodigo_postal());
            alumno.setTel_personal(alumnoRequest.getTel_personal());
            alumno.setCorreo_electronico(alumnoRequest.getCorreo_electronico());
            alumno.setTitulo(alumnoRequest.getTitulo());
            alumno.setAnio_egreso(alumnoRequest.getAnio_egreso());
            alumno.setInstitucion(alumnoRequest.getInstitucion());
            alumno.setDistrito(alumnoRequest.getDistrito());
            alumno.setOtros_estudios(alumnoRequest.getOtros_estudios());
            alumno.setTrabaja(alumnoRequest.getTrabaja());
            alumno.setActividad(alumnoRequest.getActividad());
            alumno.setHorario_inicio(alumnoRequest.getHorario_inicio());
            alumno.setHorario_fin(alumnoRequest.getHorario_fin());
            alumno.setObra_social(alumnoRequest.getObra_social());
            alumno.setNombre_obra(alumnoRequest.getNombre_obra());
            alumno.setEstado_estudiante(alumnoRequest.getEstado_estudiante());            
    return alumnoRepository.save(alumno);
}

}
