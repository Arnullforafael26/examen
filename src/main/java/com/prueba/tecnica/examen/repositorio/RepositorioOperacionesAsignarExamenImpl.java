package com.prueba.tecnica.examen.repositorio;

import com.prueba.tecnica.examen.configuracion.ConexionBD;
import com.prueba.tecnica.examen.dominio.AsignarExamen;
import org.springframework.stereotype.Repository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

@Repository
public class RepositorioOperacionesAsignarExamenImpl implements RepositorioOperacionesAsignarExamen{


    private final ConexionBD configuracionBD;

    private static final String SQL_INSERTAR_ASIGNAR_EXAMEN = "INSERT INTO examen_estudiante( idExamen, idEstudiante ) VALUES (?, ?)";

    public RepositorioOperacionesAsignarExamenImpl (ConexionBD conexionBD) {this.configuracionBD = conexionBD;
    }

    @Override
    public Long registrarAsignarExamen(AsignarExamen asignarExamen){
        Connection conexion = null;
        try {
            conexion = configuracionBD.conectar();
            PreparedStatement preparedStatement = conexion.prepareStatement(SQL_INSERTAR_ASIGNAR_EXAMEN);
            conexion.setAutoCommit(true);
            preparedStatement.setLong(1, asignarExamen.getIdExamen());
            preparedStatement.setLong(2, asignarExamen.getIdEstudiante());
            preparedStatement.execute();
            preparedStatement.close();
            conexion.close();
            return 1L;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

}
