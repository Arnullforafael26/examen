package com.prueba.tecnica.examen.repositorio;

import com.prueba.tecnica.examen.dominio.Estudiante;

public interface RepositorioOperacionesEstudiante {
    Long registrarEstudiante(Estudiante estudiante);
    String consultarEstudiante(Long idEstudiante);
}
