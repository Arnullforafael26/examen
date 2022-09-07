package com.prueba.tecnica.examen.servicio;

import com.prueba.tecnica.examen.dominio.Estudiante;
import com.prueba.tecnica.examen.repositorio.RepositorioOperacionesEstudiante;

public class ServicioOperacionesEstudiante {

    private final RepositorioOperacionesEstudiante repositorioOperacionesEstudiante;

    public ServicioOperacionesEstudiante(RepositorioOperacionesEstudiante repositorioOperacionesEstudiante) {
        this.repositorioOperacionesEstudiante = repositorioOperacionesEstudiante;
    }

    public Long ejecutar(Estudiante estudiante) {
        return this.repositorioOperacionesEstudiante.registrarEstudiante(estudiante);
    }

    public String ejecutar(Long idEstudiante) {
        return this.repositorioOperacionesEstudiante.consultarEstudiante(idEstudiante);
    }
}
