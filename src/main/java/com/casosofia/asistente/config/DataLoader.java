package com.casosofia.asistente.config;

import com.casosofia.asistente.model.Actividad;
import com.casosofia.asistente.model.Jornada;
import com.casosofia.asistente.model.Pictograma;
import com.casosofia.asistente.repository.ActividadRepository;
import com.casosofia.asistente.repository.JornadaRepository;
import com.casosofia.asistente.repository.PictogramaRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import java.time.LocalDate;

@Configuration
public class DataLoader {

    @Bean
    CommandLineRunner initDatos(JornadaRepository jornadaRepository,
                                ActividadRepository actividadRepository,
                                PictogramaRepository pictogramaRepository) {
        return args -> {
            // Solo cargar si no hay datos (prototipo)
            if (pictogramaRepository.count() == 0) {
                // Pictogramas temáticos marino y transporte (placeholders)
                Pictograma p1 = new Pictograma();
                p1.setClave("comida");
                p1.setUrlImagen("/img/pictogramas/comida.png");
                p1.setTema("marino");
                p1.setDescripcion("Hora de comer");
                pictogramaRepository.save(p1);

                Pictograma p2 = new Pictograma();
                p2.setClave("banio");
                p2.setUrlImagen("/img/pictogramas/banio.png");
                p2.setTema("marino");
                p2.setDescripcion("Hora del baño");
                pictogramaRepository.save(p2);

                Pictograma p3 = new Pictograma();
                p3.setClave("recreo");
                p3.setUrlImagen("/img/pictogramas/recreo.png");
                p3.setTema("marino");
                p3.setDescripcion("Hora de jugar");
                pictogramaRepository.save(p3);

                Pictograma p4 = new Pictograma();
                p4.setClave("clase");
                p4.setUrlImagen("/img/pictogramas/clase.png");
                p4.setTema("transporte");
                p4.setDescripcion("Hora de clase");
                pictogramaRepository.save(p4);

                Pictograma p5 = new Pictograma();
                p5.setClave("traslado");
                p5.setUrlImagen("/img/pictogramas/traslado.png");
                p5.setTema("transporte");
                p5.setDescripcion("Hora de salir");
                pictogramaRepository.save(p5);

                Pictograma p6 = new Pictograma();
                p6.setClave("siesta");
                p6.setUrlImagen("/img/pictogramas/siesta.png");
                p6.setTema("marino");
                p6.setDescripcion("Hora de descansar");
                pictogramaRepository.save(p6);
            }

            if (jornadaRepository.count() == 0) {
                Jornada hoy = new Jornada(LocalDate.now());
                jornadaRepository.save(hoy);

                // Actividades de ejemplo para hoy
                Actividad a1 = new Actividad();
                a1.setJornada(hoy);
                a1.setNombre("Llegada al cole");
                a1.setPictogramaClave("traslado");
                a1.setOrden(1);
                a1.setDuracionEstimadaMin(15);
                a1.setAvisoCambioMin(5);
                a1.setActivo(true);
                actividadRepository.save(a1);

                Actividad a2 = new Actividad();
                a2.setJornada(hoy);
                a2.setNombre("Clase");
                a2.setPictogramaClave("clase");
                a2.setOrden(2);
                a2.setDuracionEstimadaMin(45);
                a2.setAvisoCambioMin(5);
                a2.setActivo(true);
                actividadRepository.save(a2);

                Actividad a3 = new Actividad();
                a3.setJornada(hoy);
                a3.setNombre("Recreo");
                a3.setPictogramaClave("recreo");
                a3.setOrden(3);
                a3.setDuracionEstimadaMin(30);
                a3.setAvisoCambioMin(5);
                a3.setActivo(true);
                actividadRepository.save(a3);

                Actividad a4 = new Actividad();
                a4.setJornada(hoy);
                a4.setNombre("Comida");
                a4.setPictogramaClave("comida");
                a4.setOrden(4);
                a4.setDuracionEstimadaMin(40);
                a4.setAvisoCambioMin(5);
                a4.setActivo(true);
                actividadRepository.save(a4);

                Actividad a5 = new Actividad();
                a5.setJornada(hoy);
                a5.setNombre("Siesta");
                a5.setPictogramaClave("siesta");
                a5.setOrden(5);
                a5.setDuracionEstimadaMin(60);
                a5.setAvisoCambioMin(10);
                a5.setActivo(true);
                actividadRepository.save(a5);

                Actividad a6 = new Actividad();
                a6.setJornada(hoy);
                a6.setNombre("Salida");
                a6.setPictogramaClave("traslado");
                a6.setOrden(6);
                a6.setDuracionEstimadaMin(15);
                a6.setAvisoCambioMin(5);
                a6.setActivo(true);
                actividadRepository.save(a6);
            }
        };
    }
}
