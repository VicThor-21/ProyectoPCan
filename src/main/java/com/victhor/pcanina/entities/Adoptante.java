package com.victhor.pcanina.entities;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Entity
@Table(name="ADOPTANTE")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Adoptante {

    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    @Column(name="adoptante_id")
    private int id;
    @Column(name="nombre")
    private String nombre;
    @Column(name="apellidos")
    private String apellidos;
    @Column(name="dni")
    private String dni;
    @Column(name="telefono")
    private String telefono;
    @Column(name="email")
    private String email;
    @Column(name="fecharegistro")
    private LocalDate fechaRegistro;

}
