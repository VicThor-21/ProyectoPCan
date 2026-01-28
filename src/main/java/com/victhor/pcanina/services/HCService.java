package com.victhor.pcanina.services;

import com.victhor.pcanina.common.CausaHC;
import com.victhor.pcanina.entities.HistorialClinico;
import com.victhor.pcanina.entities.Perro;

import java.time.LocalDateTime;
import java.util.List;

public interface HCService {

    public HistorialClinico insertarHC(CausaHC causa, String descripcion, LocalDateTime fecha, String veterinario, Perro perro);
    public List<HistorialClinico> listadoHC();
    public HistorialClinico obtenerHC(int id);

}
