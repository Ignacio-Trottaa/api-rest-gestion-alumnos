package edu.campus.campusLeopoldoMarechal.service;

import edu.campus.campusLeopoldoMarechal.model.Alumno;
import edu.campus.campusLeopoldoMarechal.model.Materia;
import edu.campus.campusLeopoldoMarechal.repository.IAlumnoRepository;
import edu.campus.campusLeopoldoMarechal.repository.IMateriaRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class AlumnoService implements IAlumnoService {

    @Autowired
    private IAlumnoRepository alumnoRepository;

    @Autowired
    private IMateriaRepository materiaRepository;

    @Override
    public List<Alumno> findAll() {
        return alumnoRepository.findAll();
    }

    @Override
    public void save(Alumno alumno) {
        alumnoRepository.save(alumno);
    }

    @Override
    public Alumno findById(Long id) {
        return alumnoRepository.findById(id).orElse(null);
    }

    @Override
    public Alumno update(Long id, Alumno alumnoRequest) {
        Alumno alumno = alumnoRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Alumno no encontrado con id: " + id));
        alumno.setNombre(alumnoRequest.getNombre());
        alumno.setApellido(alumnoRequest.getApellido());
        alumno.setDni(alumnoRequest.getDni());
        alumno.setFechaNacimiento(alumnoRequest.getFechaNacimiento());
        alumno.setLugarNacimiento(alumnoRequest.getLugarNacimiento());
        alumno.setEstadoCivil(alumnoRequest.getEstadoCivil());
        alumno.setCantidadHijos(alumnoRequest.getCantidadHijos());
        alumno.setFamiliaresACargo(alumnoRequest.getFamiliaresACargo());
        alumno.setDireccion(alumnoRequest.getDireccion());
        alumno.setNumero(alumnoRequest.getNumero());
        alumno.setPiso(alumnoRequest.getPiso());
        alumno.setDepartamento(alumnoRequest.getDepartamento());
        alumno.setLocalidad(alumnoRequest.getLocalidad());
        alumno.setCodigoPostal(alumnoRequest.getCodigoPostal());
        alumno.setTelefonoPersonal(alumnoRequest.getTelefonoPersonal());
        alumno.setCorreoElectronico(alumnoRequest.getCorreoElectronico());
        alumno.setTitulo(alumnoRequest.getTitulo());
        alumno.setAnioEgreso(alumnoRequest.getAnioEgreso());
        alumno.setInstitucion(alumnoRequest.getInstitucion());
        alumno.setLocalidadInstitucion(alumnoRequest.getLocalidadInstitucion());
        alumno.setOtrosEstudios(alumnoRequest.getOtrosEstudios());
        alumno.setTrabaja(alumnoRequest.isTrabaja());
        alumno.setActividad(alumnoRequest.getActividad());
        alumno.setHorarioInicio(alumnoRequest.getHorarioInicio());
        alumno.setHorarioFin(alumnoRequest.getHorarioFin());
        alumno.setObraSocial(alumnoRequest.isObraSocial());
        alumno.setNombreObraSocial(alumnoRequest.getNombreObraSocial());
        alumno.setEstadoEstudiante(alumnoRequest.isEstadoEstudiante());
        return alumnoRepository.save(alumno);
    }

    @Override
    public Alumno deactivate(Long id) {
        Alumno alumno = alumnoRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Alumno no encontrado con id: " + id));
        alumno.setEstadoEstudiante(false);
        return alumnoRepository.save(alumno);
    }

    public void inscribirAlumnoEnMateria(Long alumnoId, String codigo) {
        Alumno alumno = alumnoRepository.findById(alumnoId)
                .orElseThrow(() -> new RuntimeException("Alumno no encontrado con id: " + alumnoId));
        Materia materia = materiaRepository.findByCodigo(codigo);
        if(materia == null) {
            throw new RuntimeException("Materia no encontrada con el codigo: " + codigo);
        }
        materia.getAlumnos().add(alumno);
        alumno.getMaterias().add(materia);

        materiaRepository.save(materia);
        alumnoRepository.save(alumno);
    }

    public void desinscribirAlumnoDeMateria(Long alumnoId, Long materiaId) {
        Alumno alumno = alumnoRepository.findById(alumnoId)
                .orElseThrow(() -> new RuntimeException("Alumno no encontrado con id: " + alumnoId));
        Materia materia = materiaRepository.findById(materiaId)
                .orElseThrow(() -> new RuntimeException("Materia no encontrada con id: " + materiaId));

        materia.getAlumnos().remove(alumno);
        alumno.getMaterias().remove(materia);

        materiaRepository.save(materia);
        alumnoRepository.save(alumno);
    }
    @Override
    public Alumno reintegrar(Long id){
        Alumno alumno = alumnoRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Alumno no encontrado con id: " + id));
        alumno.setEstadoEstudiante(true);
        return alumnoRepository.save(alumno);
    }
}
