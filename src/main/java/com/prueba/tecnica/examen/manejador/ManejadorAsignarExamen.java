package com.prueba.tecnica.examen.manejador;

import com.prueba.tecnica.examen.dominio.AsignarExamen;
import com.prueba.tecnica.examen.dominio.RespuestaRegistroAsignarExamen;
import com.prueba.tecnica.examen.servicio.ServicioOperacionesAsignarExamen;
import com.prueba.tecnica.examen.servicio.ServicioOperacionesEstudiante;
import com.prueba.tecnica.examen.servicio.ServicioOperacionesExamen;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class ManejadorAsignarExamen {

    private final ServicioOperacionesAsignarExamen servicioOperacionesAsignarExamen;
    private final ServicioOperacionesExamen servicioOperacionesExamen;
    private final ServicioOperacionesEstudiante servicioOperacionesEstudiante;

    @Autowired
    public ManejadorAsignarExamen(ServicioOperacionesAsignarExamen servicioOperacionesAsignarExamen,
                                  ServicioOperacionesExamen servicioOperacionesExamen, 
                                  ServicioOperacionesEstudiante servicioOperacionesEstudiante) {
        this.servicioOperacionesAsignarExamen = servicioOperacionesAsignarExamen;
        this.servicioOperacionesExamen = servicioOperacionesExamen;
        this.servicioOperacionesEstudiante = servicioOperacionesEstudiante;
    }
    public RespuestaRegistroAsignarExamen ejecutar(AsignarExamen asignarExamen){
        RespuestaRegistroAsignarExamen respuestaRegistroAsignarExamen = null;
        String zonaHorariaExamen = servicioOperacionesExamen.ejecutar(asignarExamen.getIdExamen());
        String zonaHorariaEstudiante = servicioOperacionesEstudiante.ejecutar(asignarExamen.getIdEstudiante());
        if(zonaHorariaExamen.equals(zonaHorariaEstudiante)){
            Long resultadoRegistrarAsignacionExamen = servicioOperacionesAsignarExamen.ejecutar(asignarExamen);
            if(resultadoRegistrarAsignacionExamen > 0){
                respuestaRegistroAsignarExamen = new RespuestaRegistroAsignarExamen("Guardado", false);
            }else{
                respuestaRegistroAsignarExamen = new RespuestaRegistroAsignarExamen("Error", true);
            }
        }else{
            respuestaRegistroAsignarExamen = new RespuestaRegistroAsignarExamen("La zona horaria del estudiante y del examen no son iguales", true);
        }
        return respuestaRegistroAsignarExamen;
    }

}
