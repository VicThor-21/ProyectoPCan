package com.victhor.pcanina.services;

import com.victhor.pcanina.entities.Adoptante;

import java.util.List;

public interface AdoptanteService {
    public List<Adoptante> filtrarDniYNombre(String dni,String nombre);
    public List<Adoptante> listadoAdoptantes();
    public List<Adoptante> buscarPorDni(String dni);
    public List<Adoptante> buscarPorNombre(String nombre);
    public Adoptante obtenerAdoptante(Integer id);
    public void crearAdoptante(Adoptante adoptante);
}
