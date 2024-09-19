package edu.campus.campusLeopoldoMarechal.model;

import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
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

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nombre;
    private String apellido;
    private int dni;
    private int edad;
    private String fecha_nac;
    private String lugar_nac;
    private String estado_civil;
    private int cant_hijos;
    private String familiares_acargo;
    private String direccion;
    private String numero;
    private String piso;
    private String depto;
    private String localidad;
    private String partido;
    private String codigo_postal;
    private String tel_personal;
    private String correo_electronico;
    private String titulo;
    private int anio_egreso;
    private String institucion;
    private String distrito;
    private String otros_estudios;
    private boolean trabaja;
    private String actividad;
    private String horario_inicio;
    private String horario_fin;
    private boolean obra_social;
    private String nombre_obra;
    private boolean estado_estudiante;

}
