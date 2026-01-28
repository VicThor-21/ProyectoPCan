package com.victhor.pcanina.entities;

import java.util.Date;

import com.victhor.pcanina.common.EstadoPerro;
import com.victhor.pcanina.common.SexoPerro;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name="PERRO") // Nombre de la tabla en H2
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Perro {

    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    @Column(name="perro_id")
    private int id;
    @Column(name="nombre")  // El nombre de los campos los crea por defecto en mayuscula
    private String nombre;
    @Column(name="edad")
    private int edad;
    @Column(name="raza")
    private String raza;
    @Enumerated(EnumType.ORDINAL)
    @Column(name="sexo")
    private SexoPerro sexo;
    @Column(name="peso")
    private float peso;
    @Enumerated(EnumType.STRING)
    @Column(name="estado")
    private EstadoPerro estado;
    @Column(name="fecha_ingreso")
    private Date fechaIngreso;

}
