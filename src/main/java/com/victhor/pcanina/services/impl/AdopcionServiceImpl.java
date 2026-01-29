package com.victhor.pcanina.services.impl;

import java.time.LocalDate;
import java.util.Date;
import java.util.List;

import com.victhor.pcanina.entities.Adopcion;
import com.victhor.pcanina.entities.Adoptante;
import com.victhor.pcanina.entities.Perro;
import com.victhor.pcanina.repositories.AdopcionRepository;
import com.victhor.pcanina.services.AdopcionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AdopcionServiceImpl implements AdopcionService {

    @Autowired
    private AdopcionRepository adopcionRepository;

    @Override
    public Adopcion insertarAdopcion(LocalDate fecha, int estado, boolean donacion, Perro perro, Adoptante adoptante) {

        Adopcion a=new Adopcion();
        a.setFechaAdopcion(fecha);
        a.setEstado(estado);
        a.setDonacion(donacion);
        a.setPerro(perro);
        a.setAdoptante(adoptante);

        return adopcionRepository.save(a);
    }

    @Override
    public List<Adopcion> listadoAdopciones() {

        return adopcionRepository.findAll();
    }

    @Override
    public Adopcion obtenerAdopcion(int id) {

        return adopcionRepository.findById(id).orElse(null);
    }

}
