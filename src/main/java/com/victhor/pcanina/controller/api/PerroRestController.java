package com.victhor.pcanina.controller.api;

import java.util.List;

import com.victhor.pcanina.common.EstadoPerro;
import com.victhor.pcanina.entities.Perro;
import com.victhor.pcanina.services.PerroService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import lombok.extern.slf4j.Slf4j;

@RestController
@Slf4j
@RequestMapping("/api/perro")
public class PerroRestController {
    @Autowired
    private PerroService perroService;

    @PostMapping(value="/add/{perro}") // ruta en el navegador para insertar un nuevo perro
    public void insertarPerro(@PathVariable Perro perro) {
        log.info("Inicio: insertarPerros");

        perroService.crearPerro(perro);

    }

    @GetMapping(value= {"","/"})  // ruta en el navegador para volver a ver el listado de perros
    public List<Perro> listadoPerros(){
        log.info("Inicio: listadoPerros");
        return perroService.listadoPerros();
    }

    @GetMapping(value="/id/{id}") // búsqueda en el navegador por id de perro
    public Perro obtenerPerro(@PathVariable Integer id) {
        log.info("Inicio: obtenerPerro por id");

        return perroService.obtenerPerro(id);
    }

    @GetMapping(value="/estado/{estado}") // búsqueda en el navegador por id de perro
    public List<Perro> obtenerPerro(@PathVariable EstadoPerro estado) {
        log.info("[Inicio: obtenerPerro]");

        return perroService.filtroPorEstado(estado);
    }

}
