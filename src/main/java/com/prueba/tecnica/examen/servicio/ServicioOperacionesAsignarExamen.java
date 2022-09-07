package com.prueba.tecnica.examen.servicio;

import com.prueba.tecnica.examen.dominio.AsignarExamen;
import com.prueba.tecnica.examen.repositorio.RepositorioOperacionesAsignarExamen;

public class ServicioOperacionesAsignarExamen {

    private final RepositorioOperacionesAsignarExamen repositorioOperacionesAsignarExamen;

    public ServicioOperacionesAsignarExamen(RepositorioOperacionesAsignarExamen repositorioOperacionesAsignarExamen) {
        this.repositorioOperacionesAsignarExamen = repositorioOperacionesAsignarExamen;
    }

    public Long ejecutar(AsignarExamen asignarExamen) {
        return this.repositorioOperacionesAsignarExamen.registrarAsignarExamen(asignarExamen);
    }
}
