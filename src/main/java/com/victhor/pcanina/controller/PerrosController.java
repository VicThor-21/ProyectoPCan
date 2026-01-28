package com.victhor.pcanina.controller;

import java.util.List;

import com.victhor.pcanina.common.EstadoPerro;
import com.victhor.pcanina.entities.Perro;
import com.victhor.pcanina.services.PerroService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import lombok.extern.slf4j.Slf4j;

@Controller
@Slf4j
@RequestMapping("/perros")
public class PerrosController {

    @Autowired
    private PerroService perroService;

    @GetMapping
    public String listadoPerros(@RequestParam(required=false) String nombre,
                                @RequestParam(required=false) EstadoPerro estado, Model model){

        log.info("[listadoPerros]");

        List<Perro> perros=perroService.obtenerPerro(nombre, estado);

        model.addAttribute("Perros", perros);
        model.addAttribute("estados", EstadoPerro.values());

        return "/perros";
    }

}
