package com.casosofia.asistente.controller;

import com.casosofia.asistente.model.Actividad;
import com.casosofia.asistente.model.Pictograma;
import com.casosofia.asistente.repository.ActividadRepository;
import com.casosofia.asistente.repository.JornadaRepository;
import com.casosofia.asistente.repository.PictogramaRepository;
import jakarta.validation.Valid;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import java.time.LocalDate;
import java.util.List;

@Controller
@RequestMapping("/docente")
public class ActividadController {

    private final JornadaRepository jornadaRepository;
    private final ActividadRepository actividadRepository;
    private final PictogramaRepository pictogramaRepository;

    public ActividadController(JornadaRepository jornadaRepository,
            ActividadRepository actividadRepository,
            PictogramaRepository pictogramaRepository) {
        this.jornadaRepository = jornadaRepository;
        this.actividadRepository = actividadRepository;
        this.pictogramaRepository = pictogramaRepository;
    }

    @GetMapping("/horario")
    public String listarHorario(Model model) {
        LocalDate hoy = LocalDate.now();
        var jornada = jornadaRepository.findByFecha(hoy);
        modeloConJornada(model, jornada);
        model.addAttribute("fecha", hoy);
        model.addAttribute("pictogramas", pictogramaRepository.findAll());
        return "docente/horario";
    }

    @GetMapping("/horario/{fecha}")
    public String listarHorarioFecha(@PathVariable LocalDate fecha, Model model) {
        var jornada = jornadaRepository.findByFecha(fecha);
        modeloConJornada(model, jornada);
        model.addAttribute("fecha", fecha);
        model.addAttribute("pictogramas", pictogramaRepository.findAll());
        return "docente/horario";
    }

    @GetMapping("/actividad-form")
    public String formularioActividad(@RequestParam(required = false) Long jornadaId,
            @RequestParam(required = false) Long actividadId,
            Model model) {
        model.addAttribute("pictogramas", pictogramaRepository.findAll());
        Actividad actividad;

        if (actividadId != null) {
            actividad = actividadRepository.findById(actividadId).orElseGet(Actividad::new);
            if (actividad.getJornada() != null) {
                model.addAttribute("jornadaId", actividad.getJornada().getId());
                model.addAttribute("jornada", actividad.getJornada());
            }
        } else if (jornadaId != null) {
            actividad = new Actividad();
            jornadaRepository.findById(jornadaId).ifPresent(j -> {
                model.addAttribute("jornada", j);
                model.addAttribute("jornadaId", j.getId());
                actividad.setJornada(j);
            });
        } else {
            actividad = new Actividad();
        }

        model.addAttribute("actividad", actividad);
        return "docente/actividad-form";
    }

    @PostMapping("/actividad")
    public String guardarActividad(@Valid @ModelAttribute Actividad actividad,
            BindingResult result,
            Model model) {
        if (result.hasErrors()) {
            model.addAttribute("pictogramas", pictogramaRepository.findAll());
            return "docente/actividad-form";
        }

        // Asegurar que exista la jornada
        if (actividad.getJornada() == null || actividad.getJornada().getId() == null) {
            model.addAttribute("error", "Debe seleccionar una jornada");
            model.addAttribute("pictogramas", pictogramaRepository.findAll());
            return "docente/actividad-form";
        }

        var jornadaOpt = jornadaRepository.findById(actividad.getJornada().getId());
        if (jornadaOpt.isEmpty()) {
            model.addAttribute("error", "Jornada no encontrada");
            model.addAttribute("pictogramas", pictogramaRepository.findAll());
            return "docente/actividad-form";
        }

        actividad.setJornada(jornadaOpt.get());
        if (actividad.getOrden() == null) {
            List<Actividad> existentes = actividadRepository
                    .findByJornadaIdOrderByOrdenAsc(actividad.getJornada().getId());
            actividad.setOrden(existentes.size() + 1);
        }
        if (actividad.getActivo() == null) {
            actividad.setActivo(true);
        }

        actividadRepository.save(actividad);
        return "redirect:/docente/horario/" + actividad.getJornada().getFecha();
    }

    @GetMapping("/previa/{fecha}")
    public String previaSofia(@PathVariable LocalDate fecha, Model model) {
        var jornada = jornadaRepository.findByFecha(fecha);
        if (jornada.isPresent()) {
            List<Actividad> actividades = actividadRepository
                    .findByJornadaIdAndActivoTrueOrderByOrdenAsc(jornada.get().getId());
            model.addAttribute("actividades", actividades);
            model.addAttribute("fecha", fecha);
        }
        return "docente/previa-sofia";
    }

    private void modeloConJornada(Model model, java.util.Optional<com.casosofia.asistente.model.Jornada> jornadaOpt) {
        if (jornadaOpt.isPresent()) {
            model.addAttribute("jornada", jornadaOpt.get());
            model.addAttribute("actividades",
                    actividadRepository.findByJornadaIdAndActivoTrueOrderByOrdenAsc(jornadaOpt.get().getId()));
        } else {
            model.addAttribute("jornada", null);
            model.addAttribute("actividades", List.of());
        }
    }
}
