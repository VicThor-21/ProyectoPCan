package com.victhor.pcanina.entities;

import java.time.LocalDateTime;

import com.victhor.pcanina.common.CausaHC;
import org.springframework.format.annotation.DateTimeFormat;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
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
@Table(name="HISTORIAL_CLINICO")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class HistorialClinico {

    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    @Column(name="hc_id")
    private int id;
    @Column(name="causa")
    @Enumerated(EnumType.STRING)
    private CausaHC causa;
    @Column(name="descripcion")
    private String descripcion;

    @Column(name="fecha", nullable=false)
    @DateTimeFormat(pattern = "yyyy-MM-dd' 'HH:mm")
    private LocalDateTime fecha;
    @Column(name="veterinario")
    private String veterinario;

    @ManyToOne
    @JoinColumn(name="perro_id")
    private Perro perro;

}
