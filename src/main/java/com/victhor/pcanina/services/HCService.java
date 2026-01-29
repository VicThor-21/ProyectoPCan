package com.victhor.pcanina.services;

import com.victhor.pcanina.common.CausaHC;
import com.victhor.pcanina.entities.HistorialClinico;
import com.victhor.pcanina.entities.Perro;

import java.time.LocalDateTime;
import java.util.List;

public interface HCService {

    public List<HistorialClinico> listadoHC();
    public HistorialClinico obtenerHC(int id);
}
