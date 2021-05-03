package clases;

import java.sql.*;

public class Conexion {

    // Invocamos la clase "conectar" para evitar escribir la linea de codigo cada vez que necesitemos la base de datos.
    // Servido Ubuntu ServidorSK
    public static Connection conectar() {
        try {
            Connection cn = DriverManager.getConnection("jdbc:mysql://192.168.0.30:3306/bd_sk", "usuario_remoto", "Sankarasel20");
            return cn;
        } catch (SQLException e) {
            System.out.println("Error en conexion a base de datos: " + e);
        }
        return (null);
    }
}
