package edu.campus.campusLeopoldoMarechal.model;

import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.Table;
import jakarta.validation.constraints.Email;

import java.time.LocalDate;
import java.util.List;

import jakarta.persistence.Entity;
import lombok.NoArgsConstructor;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Entity
@Table(name = "estudiantes")
public class Alumno {

    @ManyToMany
    @JoinTable(name = "materia_alumno", joinColumns = @JoinColumn(name = "alumno_id"), inverseJoinColumns = @JoinColumn(name = "materia_id"))
    private List<Materia> materias;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nombre;
    private String apellido;
    private int dni;
    private int edad;
    private LocalDate fechaNacimiento;
    private String lugarNacimiento;
    private String estadoCivil;
    private int cantidadHijos;
    private String familiaresACargo;
    private String direccion;
    private String numero;
    private String piso;
    private String departamento;
    private String localidad;
    private String codigoPostal;
    private String telefonoPersonal;
    @Email
    private String correoElectronico;
    private String titulo;
    private int anioEgreso;
    private String institucion;
    private String localidadInstitucion;
    private String otrosEstudios;
    private boolean trabaja;
    private String actividad;
    private String horarioInicio;
    private String horarioFin;
    private boolean obraSocial;
    private String nombreObraSocial;
    private boolean estadoEstudiante;

}
