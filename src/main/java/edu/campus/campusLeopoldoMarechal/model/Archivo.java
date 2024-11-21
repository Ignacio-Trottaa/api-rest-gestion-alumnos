package edu.campus.campusLeopoldoMarechal.model;

import jakarta.persistence.*;
import com.fasterxml.jackson.annotation.JsonBackReference;

import lombok.NoArgsConstructor;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Entity
@Table(name = "archivo")
public class Archivo {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nombre;
    private String tipo;
    private Long tamaño;

    @Lob
    private byte[] datos;

    @OneToOne(mappedBy = "archivo", cascade = CascadeType.ALL)
    @JsonBackReference("publicacion-archivo")
    private Publicacion publicacion;

}
