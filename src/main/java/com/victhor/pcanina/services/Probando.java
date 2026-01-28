package com.victhor.pcanina.services;

import com.victhor.pcanina.entities.Perro;
import org.apache.catalina.Service;

public interface Probando extends Service {
    public void insertarPerro(Perro perro);
    public Perro obtenerPerro(int id);
    public Perro obtenerPerro(String nombre);
}
