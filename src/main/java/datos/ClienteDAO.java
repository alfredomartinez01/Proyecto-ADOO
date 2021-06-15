/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package datos;

import static datos.Conexion.*;
import domain.Cliente;
import java.sql.*;
import java.util.*;


/**
 *
 * @author chris
 */
public class ClienteDAO {

    

    //Regresa lista de objetos tipo cliente 
    //Crearemos objetos de tipo cliente
    public List<Cliente> seleccionar() {
        private static final String SQL_SELECT = "SELECT idCliente, nombreCliente FROM cliente";
        Connection conn = null;
        PreparedStatement stmt = null; //Variable para trabajar con Querys
        ResultSet rs = null;
        Cliente cliente = null;// Cada renglon se convertira en un objeto tipo cliente
        List<Cliente> clientes = new ArrayList<>();

        try {
            conn = getConnection();//Conexion activa hacia la base de datos
            stmt = conn.prepareStatement(SQL_SELECT);//Mandamos la instruccion SELECT
            rs = stmt.executeQuery();//Se ejecuta la instruccion dada
            while (rs.next()) {
                int idCliente = rs.getInt("idCliente");
                String nombreCliente = rs.getString("nombreCliente");

                cliente = new Cliente(idCliente, nombreCliente);//Convertimos informacion de base de datos a objetos java

                clientes.add(cliente);//Agregamos a la lista
            }
        } catch (SQLException ex) {
            ex.printStackTrace(System.out);
        } finally {
            try {
                close(rs);
                close(stmt);
                close(conn);
            } catch (SQLException ex) {
                ex.printStackTrace(System.out);
            }
        }

        return clientes;
    }
}
