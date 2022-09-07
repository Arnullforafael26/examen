package com.prueba.tecnica.examen.servicio;

import com.prueba.tecnica.examen.dominio.Examen;
import com.prueba.tecnica.examen.dominio.Pregunta;
import com.prueba.tecnica.examen.repositorio.RepositorioOperacionesExamen;

public class ServicioOperacionesExamen {

    private final RepositorioOperacionesExamen repositorioOperacionesExamen;

    public ServicioOperacionesExamen(RepositorioOperacionesExamen repositorioOperacionesExamen) {
        this.repositorioOperacionesExamen = repositorioOperacionesExamen;
    }

    public Long ejecutar(Examen examen) {
        return this.repositorioOperacionesExamen.registrarExamen(examen);
    }

    public Long ejecutar(Pregunta pregunta, Long idExamen) {
        return this.repositorioOperacionesExamen.registrarPregunta(pregunta, idExamen);
    }

    public String ejecutar(Long idExamen) {
        return this.repositorioOperacionesExamen.consultarExamen(idExamen);
    }


}
