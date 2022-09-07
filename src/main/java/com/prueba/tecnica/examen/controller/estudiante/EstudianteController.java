package com.prueba.tecnica.examen.controller.estudiante;

import com.prueba.tecnica.examen.dominio.Estudiante;
import com.prueba.tecnica.examen.dominio.Examen;
import com.prueba.tecnica.examen.dominio.RespuestaRegistroEstudiante;
import com.prueba.tecnica.examen.manejador.ManejadorEstudiante;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping(value = "/estudiante")
public class EstudianteController {

    private final ManejadorEstudiante manejadorEstudiante;

    @Autowired
    public EstudianteController(ManejadorEstudiante manejadorEstudiante) {
        this.manejadorEstudiante = manejadorEstudiante;
    }

    @PostMapping("/registrar")
    public ResponseEntity<RespuestaRegistroEstudiante> registrarEstudiante(@RequestBody Estudiante estudiante){
        return new ResponseEntity<RespuestaRegistroEstudiante>(manejadorEstudiante.ejecutar(estudiante), HttpStatus.OK);
    }

}
