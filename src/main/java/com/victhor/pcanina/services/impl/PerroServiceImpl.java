package com.victhor.pcanina.services.impl;

import java.util.List;

import com.victhor.pcanina.common.EstadoPerro;
import com.victhor.pcanina.entities.Perro;
import com.victhor.pcanina.repositories.PerroRepository;
import com.victhor.pcanina.services.PerroService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class PerroServiceImpl implements PerroService {

    @Autowired
    private PerroRepository perroRepository;

    @Override
    public List<Perro> listadoPerros() {

        return perroRepository.findAll();
    }

    @Override
    public Perro obtenerPerro(int id) {
        log.info("[obtenerPerroPorId]");
        return perroRepository.findById(id).orElse(null);
    }

    @Override
    public List<Perro>  obtenerPerro(String nombre, EstadoPerro estado) {
        log.info("[obtenerPerroPorNombre]");
        log.debug("[nombre:{}, Estado:{}]",nombre, estado);

        if ((nombre == null || nombre.trim().isEmpty()) &&
                (estado == null || estado.toString().isEmpty()))
            return perroRepository.findAll();
        if ((nombre == null || nombre.trim().isEmpty()))
            return perroRepository.findByEstado(estado);
        if ((estado == null || estado.toString().isEmpty()))
            return perroRepository.findByNombre(nombre);
        return perroRepository.findByNombreYEstado(nombre, estado);
    }

    //Metodo Hecho para el Controller formperro
    @Override
    public void crearPerro(Perro perro) {
        log.info("[crearPerro]");
        log.debug("[perro:{}]",perro);

        perroRepository.save(perro);

    }

    @Override
    public List<Perro> filtroPorEstado(EstadoPerro estado) {
        log.info("[filtroPorEstado]");
        log.debug("[Estado:{}]", estado);
        if(estado == null || estado.toString().isEmpty()) {
            return perroRepository.findAll();
        }
        return perroRepository.findByEstado(estado);
    }

    @Override
    public void eliminarPerro(int id) {
        log.info("[eliminarPerro]");
        log.debug("[id:{}]", id);

        perroRepository.deleteById(id);

    }

}
