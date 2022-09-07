package com.prueba.tecnica.examen.configuracion;

import com.prueba.tecnica.examen.servicio.ServicioOperacionesAsignarExamen;
import com.prueba.tecnica.examen.servicio.ServicioOperacionesExamen;
import com.prueba.tecnica.examen.repositorio.RepositorioOperacionesAsignarExamen;
import com.prueba.tecnica.examen.repositorio.RepositorioOperacionesEstudiante;
import com.prueba.tecnica.examen.repositorio.RepositorioOperacionesExamen;
import com.prueba.tecnica.examen.servicio.ServicioOperacionesEstudiante;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class BeanServicio {

    @Bean
    public ServicioOperacionesEstudiante servicioOperacionesEstudiante(RepositorioOperacionesEstudiante repositorioOperacionesEstudiante){
        return new ServicioOperacionesEstudiante(repositorioOperacionesEstudiante);
    }

    @Bean
    public ServicioOperacionesExamen servicioOperacionesExamen(RepositorioOperacionesExamen repositorioOperacionesExamen){
        return new ServicioOperacionesExamen(repositorioOperacionesExamen);
    }

    @Bean
    public ServicioOperacionesAsignarExamen servicioOperacionesAsignarExamen(RepositorioOperacionesAsignarExamen repositorioOperacionesAsignarExamen){
        return new ServicioOperacionesAsignarExamen (repositorioOperacionesAsignarExamen);
    }

}
