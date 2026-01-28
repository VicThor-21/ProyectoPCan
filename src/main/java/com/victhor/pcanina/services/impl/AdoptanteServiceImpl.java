package com.victhor.pcanina.services.impl;

import java.util.List;

import com.victhor.pcanina.entities.Adoptante;
import com.victhor.pcanina.repositories.AdoptanteRepository;
import com.victhor.pcanina.services.AdoptanteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AdoptanteServiceImpl implements AdoptanteService {

    @Autowired
    private AdoptanteRepository adoptanteRepository;

    @Override
    public Adoptante insertarAdoptante(String nombre, String apellidos, String dni, String telefono, String email) {

        Adoptante a=new Adoptante();
        a.setNombre(nombre);
        a.setApellidos(apellidos);
        a.setDni(dni);
        a.setTelefono(telefono);
        a.setEmail(email);

        return adoptanteRepository.save(a);
    }

    @Override
    public List<Adoptante> listadoAdoptantes() {

        return adoptanteRepository.findAll();
    }

    @Override
    public Adoptante obtenerAdoptante(int id) {

        return adoptanteRepository.findById(id).orElse(null);
    }

    @Override
    public Adoptante obtenerAdoptante(String nombre) {

        return adoptanteRepository.findByNombre(nombre).orElse(null);
    }

}
