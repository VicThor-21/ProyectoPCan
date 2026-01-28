package com.victhor.pcanina.services;

import com.victhor.pcanina.entities.Adopcion;
import com.victhor.pcanina.entities.Adoptante;
import com.victhor.pcanina.entities.Perro;

import java.util.Date;
import java.util.List;

public interface AdopcionService {

    public Adopcion insertarAdopcion(Date fecha, int estado, boolean donacion, Perro perro, Adoptante adoptante);
    public List<Adopcion> listadoAdopciones();
    public Adopcion obtenerAdopcion(int id);

}
