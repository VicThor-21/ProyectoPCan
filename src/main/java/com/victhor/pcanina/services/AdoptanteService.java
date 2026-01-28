package com.victhor.pcanina.services;

import com.victhor.pcanina.entities.Adoptante;

import java.util.List;

public interface AdoptanteService {
    public Adoptante insertarAdoptante(String nombre, String apellidos, String dni, String telefono, String email);
    public List<Adoptante> listadoAdoptantes();
    public Adoptante obtenerAdoptante(int id);
    public Adoptante obtenerAdoptante(String nombre);
}
