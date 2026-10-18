package com.casosofia.asistente.controller;

import com.casosofia.asistente.service.CambioRutinaService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class CambioRutinaController {

    private final CambioRutinaService cambioRutinaService;

    public CambioRutinaController(CambioRutinaService cambioRutinaService) {
        this.cambioRutinaService = cambioRutinaService;
    }

    @PostMapping("/cambio-rutina")
    public String anunciarCambio(@RequestParam Long actividadId,
                                 @RequestParam(required = false, defaultValue = "5") Integer minutos) {
        cambioRutinaService.registrarCambio(actividadId, minutos);
        return "redirect:/aviso-cambio";
    }

    @PostMapping("/transicion")
    public String registrarTransicion(@RequestParam Long actividadId) {
        cambioRutinaService.marcarCompletada(actividadId);
        return "redirect:/horario/" + java.time.LocalDate.now();
    }
}
