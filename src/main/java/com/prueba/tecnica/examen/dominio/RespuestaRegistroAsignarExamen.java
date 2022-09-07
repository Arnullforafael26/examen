package com.prueba.tecnica.examen.dominio;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class RespuestaRegistroAsignarExamen {

    private String estado;
    private boolean errores;
}
