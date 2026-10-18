package com.casosofia.asistente.controller;

import com.casosofia.asistente.dto.SecuenciaDTO;
import com.casosofia.asistente.model.Actividad;
import com.casosofia.asistente.model.Pictograma;
import com.casosofia.asistente.repository.ActividadRepository;
import com.casosofia.asistente.repository.PictogramaRepository;
import com.casosofia.asistente.service.SecuenciaService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import java.time.LocalDate;
import java.util.Optional;

@Controller
public class HorarioController {

    private final SecuenciaService secuenciaService;
    private final ActividadRepository actividadRepository;
    private final PictogramaRepository pictogramaRepository;

    public HorarioController(SecuenciaService secuenciaService,
                             ActividadRepository actividadRepository,
                             PictogramaRepository pictogramaRepository) {
        this.secuenciaService = secuenciaService;
        this.actividadRepository = actividadRepository;
        this.pictogramaRepository = pictogramaRepository;
    }

    @GetMapping("/")
    public String inicio() {
        return "redirect:/horario/" + LocalDate.now();
    }

    @GetMapping("/horario/{fecha}")
    public String verSecuencia(@PathVariable LocalDate fecha, Model model) {
        SecuenciaDTO secuencia = secuenciaService.obtenerSecuenciaPorFecha(fecha);
        model.addAttribute("secuencia", secuencia);
        model.addAttribute("fecha", fecha);
        return "horario";
    }

    @GetMapping("/actividad/{id}")
    public String verActividad(@PathVariable Long id, Model model) {
        Optional<Actividad> opt = actividadRepository.findById(id);
        if (opt.isPresent()) {
            Actividad actividad = opt.get();
            String urlImagen = pictogramaRepository.findByClave(actividad.getPictogramaClave())
                    .map(Pictograma::getUrlImagen)
                    .orElse("/img/pictogramas/placeholder.png");
            model.addAttribute("actividadId", id);
            model.addAttribute("nombreActividad", actividad.getNombre());
            model.addAttribute("pictogramaClave", actividad.getPictogramaClave());
            model.addAttribute("urlImagen", urlImagen);
            model.addAttribute("duracionEstimadaMin", actividad.getDuracionEstimadaMin());
            model.addAttribute("fecha", actividad.getJornada().getFecha());
        } else {
            model.addAttribute("actividadId", id);
            model.addAttribute("nombreActividad", "Actividad");
            model.addAttribute("pictogramaClave", "");
            model.addAttribute("urlImagen", "/img/pictogramas/placeholder.png");
            model.addAttribute("duracionEstimadaMin", null);
            model.addAttribute("fecha", LocalDate.now());
        }
        return "actividad";
    }

    @GetMapping("/aviso-cambio")
    public String avisoCambio(Model model) {
        model.addAttribute("minutos", 5);
        return "aviso-cambio";
    }
}
