package com.victhor.pcanina.services.impl;

import java.util.List;

import com.victhor.pcanina.entities.Adoptante;
import com.victhor.pcanina.repositories.AdoptanteRepository;
import com.victhor.pcanina.services.AdoptanteService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class AdoptanteServiceImpl implements AdoptanteService {

    @Autowired
    private AdoptanteRepository repository;

    @Override
    public List<Adoptante> filtrarDniYNombre(String dni, String nombre) {
        log.info("[filtrarDniYNombre]");
        log.debug("[dni:{}, nombre:{}]", dni, nombre);

        return repository.findByDniAndNombre(dni, nombre);
    }

    @Override
    public List<Adoptante> listadoAdoptantes() {
        log.info("[listadoAdoptantes]");
        return repository.findAll();
    }

    @Override
    public List<Adoptante> buscarPorDni(String dni) {
        log.info("[buscarPorDni]");
        log.debug("[dni:{}]", dni);
        return repository.findByDni(dni);
    }

    @Override
    public List<Adoptante> buscarPorNombre(String nombre) {
        log.info("[buscarPorNombre]");
        log.debug("[nombre:{}]", nombre);
        return repository.findByNombre(nombre);
    }

    @Override
    public Adoptante obtenerAdoptante(Integer id) {
        log.info("[obtenerAdoptante: {}]", id);

        return repository.findById(id).orElse(null);
    }

    @Override
    public void crearAdoptante(Adoptante adoptante) {
        log.info("[crearAdoptante: {}]", adoptante);
        repository.save(adoptante);
    }

}
