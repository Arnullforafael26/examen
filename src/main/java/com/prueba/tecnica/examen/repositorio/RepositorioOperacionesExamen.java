package com.prueba.tecnica.examen.repositorio;

import com.prueba.tecnica.examen.dominio.Examen;
import com.prueba.tecnica.examen.dominio.Pregunta;

public interface RepositorioOperacionesExamen {

    Long registrarExamen(Examen examen);
    Long registrarPregunta(Pregunta pregunta, Long idExamen);
    String consultarExamen(Long idExamen);

}
