package com.victhor.pcanina.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.victhor.pcanina.entities.Adoptante;
import com.victhor.pcanina.services.AdoptanteService;

import lombok.extern.slf4j.Slf4j;

@Controller
@Slf4j
@RequestMapping({"/formadoptante", "/formadoptante/{id}"})
public class FormAdoptanteController {

    @Autowired
    AdoptanteService servicio;

    @GetMapping
    public String mostrarFormularioAdoptante(@PathVariable(required = false) Integer id, Model model) {
        log.info("[mostrarFormularioAdoptante]");
        log.debug("[id: {}]", id);

        if (id != null){
            Adoptante adoptanteExistente=servicio.obtenerAdoptante(id);
            log.debug("[adoptante: {}]",adoptanteExistente);
            model.addAttribute("adoptante", adoptanteExistente);
        }else {
            model.addAttribute("adoptante", new Adoptante());
        }
        return "/formadoptante";
    }

    @PostMapping
    public String crear(Adoptante adoptante) {
        log.info("[crear]");
        log.debug("[adoptante: {}]",adoptante);

        servicio.crearAdoptante(adoptante);

        return "redirect:/adoptante" ;
    }


}
