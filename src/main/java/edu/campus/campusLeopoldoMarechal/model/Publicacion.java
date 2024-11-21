package edu.campus.campusLeopoldoMarechal.model;

import jakarta.persistence.*;
import java.util.List;

import org.springframework.web.multipart.MultipartFile;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;

import lombok.NoArgsConstructor;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Entity
@Table(name = "publicacion")
public class Publicacion {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
    private String contenido;
    private String fecha;
    
    private String creadorNom;
    private String creadorApe;
    private String creadorRol;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "archivo_id")
    @JsonManagedReference("publicacion-archivo")
    private Archivo archivo;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "materia_id")
    @JsonBackReference("materia-publicacion")   
    private Materia materias;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "alumno_id", nullable = true)
    @JsonBackReference("alumno-publicacion")
    private Alumno alumno;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "profesor_id", nullable = true)
    @JsonBackReference("profesor-publicacion")
    private Profesor profesor;

    @OneToMany(mappedBy = "publicacion", cascade = CascadeType.ALL)
    @JsonManagedReference("publicacion-comentarios")
    private List<Comentarios> comentarios;

}
