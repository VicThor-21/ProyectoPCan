package com.victhor.pcanina.services.impl;

import java.time.LocalDateTime;
import java.util.List;

import com.victhor.pcanina.common.CausaHC;
import com.victhor.pcanina.entities.HistorialClinico;
import com.victhor.pcanina.entities.Perro;
import com.victhor.pcanina.repositories.HCRepository;
import com.victhor.pcanina.services.HCService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class HCServiceImpl implements HCService {

    @Autowired
    private HCRepository hcRepo;

    @Override
    public HistorialClinico insertarHC(CausaHC causa, String descripcion, LocalDateTime fecha, String veterinario, Perro perro) {

        HistorialClinico hc=new HistorialClinico();
        hc.setCausa(causa);
        hc.setDescripcion(descripcion);
        hc.setFecha(fecha);
        hc.setVeterinario(veterinario);
        hc.setPerro(perro);

        return hcRepo.save(hc);
    }

    @Override
    public List<HistorialClinico> listadoHC() {

        return hcRepo.findAll();
    }

    @Override
    public HistorialClinico obtenerHC(int id) {

        return hcRepo.findById(id).orElse(null);
    }

}
