package com.prueba.tecnica.examen.controller.estudiante;

import com.prueba.tecnica.examen.dominio.AsignarExamen;
import com.prueba.tecnica.examen.dominio.RespuestaRegistroAsignarExamen;
import com.prueba.tecnica.examen.manejador.ManejadorAsignarExamen;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping(value = "/asignar")
public class AsignarExamenController {

    private final ManejadorAsignarExamen manejadorAsignarExamen;

    @Autowired
    public AsignarExamenController(ManejadorAsignarExamen manejadorAsignarExamen) {
        this.manejadorAsignarExamen = manejadorAsignarExamen;
    }

    @PostMapping("/examen-estudiante")
    public ResponseEntity<RespuestaRegistroAsignarExamen> asignarExamen(@RequestBody AsignarExamen asignarExamen){
        return new ResponseEntity<RespuestaRegistroAsignarExamen>(manejadorAsignarExamen.ejecutar(asignarExamen), HttpStatus.OK);
    }





}






