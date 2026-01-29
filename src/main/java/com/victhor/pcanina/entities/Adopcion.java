package com.victhor.pcanina.entities;

import java.time.LocalDate;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name="ADOPCION")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Adopcion {

    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    @Column(name="adopcion_id")
    private int id;
    @Column(name="fecha_adopcion")
    private LocalDate fechaAdopcion;
    @Column(name="estado")
    private int estado;
    @Column(name="donacion")
    private boolean donacion;

    @ManyToOne
    @JoinColumn(name="perro_id")
    private Perro perro;

    @ManyToOne
    @JoinColumn(name="adoptante_id")
    private Adoptante adoptante;

}
