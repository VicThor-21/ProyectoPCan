package com.victhor.pcanina.services.impl;

import java.util.List;
import com.victhor.pcanina.entities.HistorialClinico;
import com.victhor.pcanina.repositories.HCRepository;
import com.victhor.pcanina.services.HCService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class HCServiceImpl implements HCService {

    @Autowired
    private HCRepository hcRepo;

    @Override
    public List<HistorialClinico> listadoHC() {

        return hcRepo.findAll();
    }

    @Override
    public HistorialClinico obtenerHC(int id) {

        return hcRepo.findById(id).orElse(null);
    }

}
