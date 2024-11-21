package edu.campus.campusLeopoldoMarechal.model;

import jakarta.persistence.*;

import com.fasterxml.jackson.annotation.JsonBackReference;

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
@Table(name = "comentarios")
public class Comentarios {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String contenido;
    private String fecha;
    private String creadorNom;
    private String creadorApe;
    private String creadorRol;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "publicacion_id")
    @JsonBackReference("publicacion-comentarios")
    private Publicacion publicacion;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "alumno_id", nullable = true)
    @JsonBackReference("alumno-comentarios")
    private Alumno alumno;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "profesor_id", nullable = true)
    @JsonBackReference("profesor-comentarios")
    private Profesor profesor;

}
