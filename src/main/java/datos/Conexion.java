/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package datos;

import java.sql.*;

/**
 *
 * @author chris
 */
public class Conexion {
   //JDBC_URL - Direccion url de conecion con nuestra base de datos
   private static final String JDBC_URL = "jdbc:mysql://localhost:3306/mydb?useSSL=false&useTimezone=true&serverTimezone=UTC&allowPublicKeyRetrieval=true";
  //JDBC_USER - Usuario de nuestro MySQL
   private static final String JDBC_USER = "root";
   //JDBC_PASSWORD - Contraseña de nuestro MySQL
   private static final String JDBC_PASSWORD = "root123";
   
   //Conexion hacia la base de datos
    public static Connection getConnection() throws SQLException{
        return DriverManager.getConnection(JDBC_URL, JDBC_USER, JDBC_PASSWORD);
    }
    
    //Cierre de procesos tipo ResultSet
    public static void close(ResultSet rs) throws SQLException{
        rs.close();
    }
    
     //Cierre de procesos tipo Statement
    public static void close(Statement smtm) throws SQLException{
        smtm.close();
    }
    
     //Cierre de procesos tipo PreparedStatement
    public static void close(PreparedStatement smtm) throws SQLException{
        smtm.close();
    }
    
    //Cierre de conexion
    public static void close(Connection conn) throws SQLException{
        conn.close();
    }
}
