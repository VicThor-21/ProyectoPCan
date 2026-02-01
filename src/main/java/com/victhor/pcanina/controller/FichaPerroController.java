package com.victhor.pcanina.controller;

import java.util.List;
import java.util.Optional;

import com.victhor.pcanina.common.CausaHC;
import com.victhor.pcanina.entities.HistorialClinico;
import com.victhor.pcanina.entities.Perro;
import com.victhor.pcanina.repositories.HCRepository;
import com.victhor.pcanina.services.HCService;
import com.victhor.pcanina.services.PerroService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import lombok.extern.slf4j.Slf4j;

@Controller
@Slf4j
@RequestMapping("/fichaperro/{id}")
public class FichaPerroController {
    @Autowired
    private PerroService perroService;
    @Autowired
    private HCRepository hcRepository;
    @Autowired
    private HCService hcService;

    @GetMapping({"","/{idHC}"})  // ruta en el navegador para volver a ver el perro pasado por id
    public String fichaPerro(@PathVariable Integer id,@PathVariable (required = false) Integer idHC, Model model) {
        log.info("[fichaPerro]");
        log.debug("[id: {}]",id);

        Perro perro=perroService.obtenerPerro(id);

        List<HistorialClinico> listHC=hcRepository.findByPerro(perro);

        model.addAttribute("FichaPerro", perro);
        model.addAttribute("HC", listHC);
        model.addAttribute("causas", CausaHC.values());
        if (idHC != null) {
            log.debug("[idHC: {}]",idHC);
            model.addAttribute("formHC", hcService.obtenerHC(idHC));
        }else {
            model.addAttribute("formHC", new HistorialClinico());
        }

        return "fichaperro";
    }

    @PostMapping
    public String guardarHC(@PathVariable Integer id, HistorialClinico hc) {
        log.info("[guardarHC]");

        Perro perro=perroService.obtenerPerro(id);
        hc.setPerro(perro);

        hcRepository.save(hc);
        log.debug("[" + hc.toString() + "]" );

        return "redirect:/fichaperro/" + id;
    }

    @PostMapping("/{idHC}")
    public String eliminarHC(@PathVariable Integer idHC) {
        log.info("[eliminarHC]");

        HistorialClinico hc=hcService.obtenerHC(idHC);
        int idPerro=hc.getPerro().getId();
        log.debug("[" + hc.toString() + "]" );
        hcRepository.delete(hc);

        return "redirect:/fichaperro/" + idPerro;
    }

}
