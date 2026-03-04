package com.victhor.pcanina.services;

import java.util.List;

import com.victhor.pcanina.common.EstadoPerro;
import com.victhor.pcanina.entities.Perro;

public interface PerroService {
    public List<Perro> listadoPerros();
    public Perro obtenerPerro(int id);
    public List<Perro> filtroPorEstado(EstadoPerro estado);
    public List<Perro>  obtenerPerro(String nombre, EstadoPerro estado);
    public void crearPerro(Perro perro);
    public void eliminarPerro(int id);
}
