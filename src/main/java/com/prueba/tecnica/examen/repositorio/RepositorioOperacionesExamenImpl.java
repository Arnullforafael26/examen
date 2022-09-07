package com.prueba.tecnica.examen.repositorio;

import com.prueba.tecnica.examen.configuracion.ConexionBD;
import com.prueba.tecnica.examen.dominio.Examen;
import com.prueba.tecnica.examen.dominio.Pregunta;
import org.springframework.stereotype.Repository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
@Repository
public class RepositorioOperacionesExamenImpl implements RepositorioOperacionesExamen{

    private final ConexionBD configuracionBD;

    private static final String SQL_INSERTAR_EXAMEN = "INSERT INTO examen( fechaExamen, zonaHoraria ) VALUES (?, ?)";
    private static final String SQL_INSERTAR_PREGUNTA = "INSERT INTO preguntas (idExamen, numeroPregunta, descripcionPregunta, opcion1, opcion2, opcion3, opcion4, respuestaCorrecta, puntajePregunta) VALUES (?,?,?,?,?,?,?,?,?)";
    private static final String SQL_CONSULTAR_EXAMEN = "SELECT zonaHoraria FROM examen WHERE idExamen = ? ";


    public RepositorioOperacionesExamenImpl(ConexionBD conexionBD) {
        this.configuracionBD = conexionBD;
    }

    @Override
    public Long registrarExamen(Examen examen){
        Connection conexion = null;
        Long consecutivo = 0L;
        try {
            conexion = configuracionBD.conectar();
            PreparedStatement preparedStatement = conexion.prepareStatement(SQL_INSERTAR_EXAMEN, new String[]{"idExamen"});
            conexion.setAutoCommit(true);
            preparedStatement.setString(1, examen.getFechaExamen());
            preparedStatement.setString(2, examen.getZonaHoraria());
            preparedStatement.execute();
            ResultSet resultSet = preparedStatement.getGeneratedKeys();
            while (resultSet.next()){
                consecutivo = resultSet.getLong(1);
            }
            preparedStatement.close();
            conexion.close();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

        return consecutivo;
    }

    @Override
    public Long registrarPregunta(Pregunta pregunta, Long idExamen) {
        Connection conexion = null;
        try {
            conexion = configuracionBD.conectar();
            PreparedStatement preparedStatement = conexion.prepareStatement(SQL_INSERTAR_PREGUNTA);
            conexion.setAutoCommit(true);
            preparedStatement.setLong(1, idExamen);
            preparedStatement.setString(2, pregunta.getNumeroPregunta());
            preparedStatement.setString(3, pregunta.getDescripcionPregunta());
            preparedStatement.setString(4, pregunta.getOpcion1());
            preparedStatement.setString(5, pregunta.getOpcion2());
            preparedStatement.setString(6, pregunta.getOpcion3());
            preparedStatement.setString(7, pregunta.getOpcion4());
            preparedStatement.setString(8, pregunta.getRespuestaCorrecta());
            preparedStatement.setLong(9, pregunta.getPuntajePregunta());
            preparedStatement.execute();
            preparedStatement.close();
            conexion.close();
            return 1L;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public String consultarExamen(Long idExamen) {
        Connection conexion = null;
        String zonaHorariaExamenResul = null;
        try {
            conexion = configuracionBD.conectar();
            PreparedStatement preparedStatement = conexion.prepareStatement(SQL_CONSULTAR_EXAMEN);
            preparedStatement.setLong(1, idExamen);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()){
                zonaHorariaExamenResul = resultSet.getString("zonaHoraria");
            }
            preparedStatement.close();
            conexion.close();
            return zonaHorariaExamenResul;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

}
