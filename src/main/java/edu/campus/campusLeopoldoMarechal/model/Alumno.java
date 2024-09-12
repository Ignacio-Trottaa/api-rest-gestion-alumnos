package edu.campus.campusLeopoldoMarechal.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Getter;
import lombok.Setter;
import jakarta.persistence.Table;
import java.util.Date;
import java.sql.*;

@Getter
@Setter
@Entity
@Table(name="estudiantes")
public class Alumno {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long id;

    private String nombre;
    private String apellido;
    private int dni; // Puede ser String si incluye caracteres especiales o ceros a la izquierda
    private int edad;
    private String fecha_nac;
    private String lugar_nac;
    private String estado_civil;
    private int cant_hijos;
    private String familiares_acargo;
    private String direccion;
    private String numero; // String en caso de que incluya letras o caracteres especiales
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
    private boolean trabaja; // boolean para valores true/false
    private String actividad;
    private String horario_inicio;
    private String horario_fin;
    private boolean obra_social; // boolean para valores true/false
    private String nombre_obra;
    private boolean estado_estudiante;

    public Alumno() {
    }

    public Alumno(Long id, String nombre, String apellido, int dni, int edad, String fecha_nac, String lugar_nac, 
                  String estado_civil, int cant_hijos, String familiares_acargo, String direccion, String numero, 
                  String piso, String depto, String localidad, String partido, String codigo_postal, 
                  String tel_personal, String correo_electronico, String titulo, int anio_egreso, String institucion, 
                  String distrito, String otros_estudios, boolean trabaja, String actividad, String horario_inicio, 
                  String horario_fin, boolean obra_social, String nombre_obra, boolean estado_estudiante) {
        this.id = id;
        this.nombre = nombre;
        this.apellido = apellido;
        this.dni = dni;
        this.edad = edad;
        this.fecha_nac = fecha_nac;
        this.lugar_nac = lugar_nac;
        this.estado_civil = estado_civil;
        this.cant_hijos = cant_hijos;
        this.familiares_acargo = familiares_acargo;
        this.direccion = direccion;
        this.numero = numero;
        this.piso = piso;
        this.depto = depto;
        this.localidad = localidad;
        this.partido = partido;
        this.codigo_postal = codigo_postal;
        this.tel_personal = tel_personal;
        this.correo_electronico = correo_electronico;
        this.titulo = titulo;
        this.anio_egreso = anio_egreso;
        this.institucion = institucion;
        this.distrito = distrito;
        this.otros_estudios = otros_estudios;
        this.trabaja = trabaja;
        this.actividad = actividad;
        this.horario_inicio = horario_inicio;
        this.horario_fin = horario_fin;
        this.obra_social = obra_social;
        this.nombre_obra = nombre_obra;
        this.estado_estudiante = estado_estudiante;
    }
}

