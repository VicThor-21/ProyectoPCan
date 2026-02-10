package com.victhor.pcanina.services;

import com.victhor.pcanina.entities.Adoptante;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;
import java.util.Optional;

public interface AdoptanteService {
    public List<Adoptante> filtrarDniYNombre(String dni,String nombre);
    public List<Adoptante> listadoAdoptantes();
    public List<Adoptante> buscarPorDni(String dni);
    public List<Adoptante> buscarPorNombre(String nombre);
    public Adoptante obtenerAdoptante(Integer id);
    public void crearAdoptante(Adoptante adoptante);
}
