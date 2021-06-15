/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package test;

import java.sql.*;
import java.util.logging.Level;
import java.util.logging.Logger;



/**
 *
 * @author chris
 */
public class TestMySqlJDBC {
    public static void main(String[] args) {
        //URL para acceder a nuestro servidor localhost 
        var url = "jdbc:mysql://localhost:3306/mydb?useSSL=false&useTimezone=true&serverTimezone=UTC&allowPublicKeyRetrieval=true";
        try {
            //Se comenta ya que no es tan necesario si se usa servidor local
            //Class.forName("com.mysql.cj.jdbc.Driver");
            Connection conexion = DriverManager.getConnection(url,"root","root123"); //Proporcionamos datos necesarios para la conexion 
            Statement instruccion =conexion.createStatement();
            var sql = "SELECT idCliente, nombreCliente FROM cliente";
            ResultSet resultado = instruccion.executeQuery(sql);
            while(resultado.next()){
                   System.out.println("Id Cliente: " + resultado.getInt("idCliente"));
                   System.out.println("Nombre Cliente: " + resultado.getString("nombreCliente"));
            }
        } catch (SQLException ex) {
           ex.printStackTrace(System.out);
        }
    }
}
