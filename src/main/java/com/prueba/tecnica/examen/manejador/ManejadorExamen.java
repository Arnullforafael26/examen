package com.prueba.tecnica.examen.manejador;

import com.prueba.tecnica.examen.dominio.Examen;
import com.prueba.tecnica.examen.dominio.Pregunta;
import com.prueba.tecnica.examen.dominio.RespuestaRegistroExamen;
import com.prueba.tecnica.examen.servicio.ServicioOperacionesExamen;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class ManejadorExamen {
    private final ServicioOperacionesExamen servicioOperacionesExamen;

    @Autowired
    public ManejadorExamen(ServicioOperacionesExamen servicioOperacionesExamen) {
        this.servicioOperacionesExamen = servicioOperacionesExamen;
    }

    public RespuestaRegistroExamen ejecutar(Examen examen) {
        RespuestaRegistroExamen respuestaRegistroExamen = null;
        if (validarPuntaje(examen.getPreguntas())) {
            Long resultadoRegistrarExamen = servicioOperacionesExamen.ejecutar(examen);
            if (resultadoRegistrarExamen > 0) {
                for (Pregunta pregunta : examen.getPreguntas()) {
                    servicioOperacionesExamen.ejecutar(pregunta, resultadoRegistrarExamen);
                }
                respuestaRegistroExamen = new RespuestaRegistroExamen("Guardado", false);
            } else {
                respuestaRegistroExamen = new RespuestaRegistroExamen("Error", true);
            }
        }else{
            respuestaRegistroExamen = new RespuestaRegistroExamen("Puntaje del examen debe ser igual a 100", true);
        }
        return respuestaRegistroExamen;
    }

    private boolean validarPuntaje(List<Pregunta> preguntas) {
        boolean esCorrecto = false;
        int sumaPuntaje = 0;
        for (Pregunta pregunta : preguntas) {
            sumaPuntaje += pregunta.getPuntajePregunta();
        }
        if(sumaPuntaje > 100 || sumaPuntaje < 100){
            return false;
        }
        return true;
    }
}

