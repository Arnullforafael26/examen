package com.prueba.tecnica.examen.dominio;


import lombok.Data;

@Data
public class Estudiante {

    private Long idUsuario;
    private String nombre;
    private String edad;
    private String ciudad;
    private String zonaHoraria;


}
