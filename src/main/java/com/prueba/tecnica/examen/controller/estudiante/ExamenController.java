package com.prueba.tecnica.examen.controller.estudiante;

import com.prueba.tecnica.examen.dominio.Examen;
import com.prueba.tecnica.examen.dominio.RespuestaRegistroExamen;
import com.prueba.tecnica.examen.manejador.ManejadorExamen;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = "/examen")
public class ExamenController {

    private final ManejadorExamen manejadorExamen;

    @Autowired
    public ExamenController(ManejadorExamen manejadorExamen) {
        this.manejadorExamen = manejadorExamen;
    }

    @PostMapping("/registrar")
    public ResponseEntity<RespuestaRegistroExamen> registrarExamen(@RequestBody Examen examen){
        return new ResponseEntity<RespuestaRegistroExamen>(manejadorExamen.ejecutar(examen), HttpStatus.OK);
    }

}
