package com.prueba.tecnica.examen.manejador;

import com.prueba.tecnica.examen.dominio.Estudiante;
import com.prueba.tecnica.examen.dominio.Examen;
import com.prueba.tecnica.examen.dominio.RespuestaRegistroEstudiante;
import com.prueba.tecnica.examen.servicio.ServicioOperacionesEstudiante;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class ManejadorEstudiante {
    private final ServicioOperacionesEstudiante servicioOperacionesEstudiante;

    @Autowired
    public ManejadorEstudiante(ServicioOperacionesEstudiante servicioOperacionesEstudiante) {
        this.servicioOperacionesEstudiante = servicioOperacionesEstudiante;
    }
    public RespuestaRegistroEstudiante ejecutar(Estudiante estudiante){
        RespuestaRegistroEstudiante respuestaRegistroEstudiante;
        Long resultadoRegistrarEstudiante = servicioOperacionesEstudiante.ejecutar(estudiante);
        if(resultadoRegistrarEstudiante > 0){
            respuestaRegistroEstudiante = new RespuestaRegistroEstudiante("Guardado", false);
        }else{
            respuestaRegistroEstudiante = new RespuestaRegistroEstudiante("Error", true);
        }
        return respuestaRegistroEstudiante;
    }



}
