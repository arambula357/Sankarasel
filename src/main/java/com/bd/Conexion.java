package com.bd;

/**
 *
 * @author Diego Arambula
 */
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Conexion
{
  public static Connection getConexion() {
    try {
      return DriverManager.getConnection("jdbc:mysql://192.168.0.30:3306/bd_sk", "usuario_remoto", "Sankarasel20");
    }
    catch (SQLException e) {
      System.out.println("Error en conexion a base de datos: " + e);
      
      return null;
    } 
  }
}
