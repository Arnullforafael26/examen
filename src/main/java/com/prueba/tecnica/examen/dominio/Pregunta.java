package com.prueba.tecnica.examen.dominio;

import lombok.Data;
@Data
public class Pregunta {

    private String numeroPregunta;
    private String descripcionPregunta;
    private String opcion1;
    private String opcion2;
    private String opcion3;
    private String opcion4;
    private String respuestaCorrecta;
    private Long puntajePregunta;

}
