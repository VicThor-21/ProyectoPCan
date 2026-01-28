package com.victhor.pcanina.controller;

import com.victhor.pcanina.common.EstadoPerro;
import com.victhor.pcanina.entities.Perro;
import com.victhor.pcanina.services.PerroService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import lombok.extern.slf4j.Slf4j;

@Controller
@Slf4j
@RequestMapping("/formperro")
public class FormPerroController {

    @Autowired
    PerroService servicio;

    @GetMapping
    public String formularioPerro(Model model) {
        log.info("[formularioPerro]");

        model.addAttribute("estados", EstadoPerro.values());

        return "/formperro";
    }

    @PostMapping
    public String crear(Perro perro) {
        log.info("[crear]");
        log.debug("[perro: {}]",perro);

        servicio.crearPerro(perro);

        return "redirect:/perros";
    }


}
