package com.prueba.tecnica.examen.repositorio;

import com.prueba.tecnica.examen.configuracion.ConexionBD;
import com.prueba.tecnica.examen.dominio.Estudiante;
import org.springframework.stereotype.Repository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

@Repository
public class  RepositorioOperacionesEstudianteImpl implements RepositorioOperacionesEstudiante {

    private final ConexionBD configuracionBD;
    private static final String SQL_INSERTAR_ESTUDIANTE = "INSERT INTO estudiante( nombre, edad, ciudad, zonaHoraria ) VALUES (?, ?, ? ,?)";
    private static final String SQL_CONSULTAR_ESTUDIANTE = "SELECT zonaHoraria FROM estudiante WHERE idestudiante = ?";

    public RepositorioOperacionesEstudianteImpl(ConexionBD conexionBD) {
        this.configuracionBD = conexionBD;
    }

    @Override
    public Long registrarEstudiante(Estudiante estudiante){
        Connection conexion = null;
        try {
            conexion = configuracionBD.conectar();
            PreparedStatement preparedStatement = conexion.prepareStatement(SQL_INSERTAR_ESTUDIANTE);
            conexion.setAutoCommit(true);
            preparedStatement.setString(1, estudiante.getNombre());
            preparedStatement.setString(2, estudiante.getEdad());
            preparedStatement.setString(3, estudiante.getCiudad());
            preparedStatement.setString(4, estudiante.getZonaHoraria());
            preparedStatement.execute();
            preparedStatement.close();
            conexion.close();
            return 1L;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public String consultarEstudiante(Long idEstudiante) {
        Connection conexion = null;
        String zonaHorariaEstudianteResul = null;
        try {
            conexion = configuracionBD.conectar();
            PreparedStatement preparedStatement = conexion.prepareStatement(SQL_CONSULTAR_ESTUDIANTE);
            preparedStatement.setLong(1, idEstudiante);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()){
                zonaHorariaEstudianteResul = resultSet.getString("zonaHoraria");
            }
            preparedStatement.close();
            conexion.close();
            return zonaHorariaEstudianteResul;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
