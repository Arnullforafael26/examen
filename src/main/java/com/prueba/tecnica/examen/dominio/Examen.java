package com.prueba.tecnica.examen.dominio;

import lombok.Data;

import java.util.List;

@Data
public class Examen {

    private Long idExamen;
    private String fechaExamen;
    private List<Pregunta> preguntas;
    private String zonaHoraria;

}
