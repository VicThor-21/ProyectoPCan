package com.victhor.pcanina.controller;

import com.victhor.pcanina.entities.Adoptante;
import com.victhor.pcanina.services.AdoptanteService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
@Slf4j
@RequestMapping("/adoptante")
public class AdoptanteController {

    @Autowired
    private AdoptanteService servicio;

    @GetMapping
    public String gestionAdoptante(@RequestParam(required=false) String dni,
                                   @RequestParam(required=false) String nombre, Model model) {
        log.info("[gestionAdoptante]");
        log.debug("[dni:{}, nombre:{}]", dni, nombre);

        List<Adoptante> adoptantes;
        if ((dni == null || dni.trim().isEmpty()) && (nombre == null || nombre.trim().isEmpty())) {
            adoptantes = servicio.listadoAdoptantes();
        } else if (dni == null || dni.trim().isEmpty()) {
            adoptantes = servicio.buscarPorNombre(nombre);
        } else if (nombre == null || nombre.trim().isEmpty()){
            adoptantes = servicio.buscarPorDni(dni);
        }else{
            adoptantes = servicio.filtrarDniYNombre(dni, nombre);
        }

        model.addAttribute("listaAdoptantes", adoptantes);

        return "adminadoptante";
    }
}
