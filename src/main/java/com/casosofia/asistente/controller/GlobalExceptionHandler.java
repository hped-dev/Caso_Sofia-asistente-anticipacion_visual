package com.casosofia.asistente.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.NoHandlerFoundException;

@ControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(IllegalArgumentException.class)
    public String manejarArgumentoInvalido(IllegalArgumentException ex, Model model) {
        model.addAttribute("titulo", "No encontrado");
        model.addAttribute("mensaje", ex.getMessage());
        model.addAttribute("codigo", 404);
        return "error";
    }

    @ExceptionHandler(NoHandlerFoundException.class)
    public String manejarNoEncontrado(NoHandlerFoundException ex, Model model) {
        model.addAttribute("titulo", "Página no encontrada");
        model.addAttribute("mensaje", "La dirección a la que intentas acceder no existe.");
        model.addAttribute("codigo", 404);
        return "error";
    }

    @ExceptionHandler(Exception.class)
    public String manejarErrorGeneral(Exception ex, Model model) {
        model.addAttribute("titulo", "Error");
        model.addAttribute("mensaje", "Ha ocurrido un error inesperado. Inténtalo de nuevo.");
        model.addAttribute("codigo", 500);
        return "error";
    }

    @RequestMapping("/error")
    public String error(Model model) {
        model.addAttribute("titulo", "Error");
        model.addAttribute("mensaje", "Ha ocurrido un error inesperado.");
        model.addAttribute("codigo", 500);
        return "error";
    }
}
