package edu.campus.campusLeopoldoMarechal.model;

import jakarta.persistence.*;
import lombok.NoArgsConstructor;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Entity
@Table(name = "profesores")
public class Profesor {

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
    private String distrito;
    private String horario_inicio;
    private String horario_fin;

}
