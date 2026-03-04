package com.victhor.pcanina.services;

import java.util.List;

import com.victhor.pcanina.entities.HistorialClinico;

public interface HCService {

    public List<HistorialClinico> listadoHC();
    public HistorialClinico obtenerHC(int id);
}
