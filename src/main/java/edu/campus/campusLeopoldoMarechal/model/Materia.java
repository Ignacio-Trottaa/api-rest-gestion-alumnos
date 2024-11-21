package edu.campus.campusLeopoldoMarechal.model;

import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;

import jakarta.persistence.CascadeType;
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
@Table(name = "materias")
public class Materia {

    @ManyToMany(mappedBy = "materias")
    @JsonBackReference
    private List<Alumno> alumnos;

    @OneToMany(mappedBy = "materias", cascade = CascadeType.ALL)
    @JsonManagedReference("materia-publicacion")
    private List<Publicacion> publicaciones;

    @ManyToOne
    @JoinColumn(name = "profesor_id")
    @JsonBackReference("profesor-materia")
    private Profesor profesor;
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nombre;
    private String descripcion;
    private String curso;
    private String codigo;
}
