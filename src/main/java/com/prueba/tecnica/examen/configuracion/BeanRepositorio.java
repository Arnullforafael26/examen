package com.prueba.tecnica.examen.configuracion;
import com.prueba.tecnica.examen.repositorio.RepositorioOperacionesAsignarExamenImpl;
import com.prueba.tecnica.examen.repositorio.RepositorioOperacionesAsignarExamen;
import com.prueba.tecnica.examen.repositorio.RepositorioOperacionesExamen;
import com.prueba.tecnica.examen.repositorio.RepositorioOperacionesExamenImpl;
import com.prueba.tecnica.examen.repositorio.RepositorioOperacionesEstudiante;
import com.prueba.tecnica.examen.repositorio.RepositorioOperacionesEstudianteImpl;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class BeanRepositorio {

    @Bean
    public RepositorioOperacionesEstudiante repositorioOperacionesEstudiante(ConexionBD conexionBD){
        return new RepositorioOperacionesEstudianteImpl(conexionBD);
    }

    @Bean
    public RepositorioOperacionesExamen repositorioOperacionesExamen(ConexionBD conexionBD){
        return new RepositorioOperacionesExamenImpl(conexionBD);
    }

    @Bean
    public RepositorioOperacionesAsignarExamen repositorioOperacionesAsignarExamen(ConexionBD conexionBD){
        return new RepositorioOperacionesAsignarExamenImpl(conexionBD);
    }
}
