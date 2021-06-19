/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package datos;

import static datos.Conexion.close;
import static datos.Conexion.getConnection;
import domain.Cliente;
import domain.Restaurante;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author kit_5
 */
public class MenuDAO {

    private Connection conexionTransaccional;
    private String SQL_INSERT_IN_MENU = "insert into menu(idRestaurante) values(?)";
    
    public MenuDAO() {

    }

    public MenuDAO(Connection conexionTransaccional) { // Traemos la conexión para una transacción
        this.conexionTransaccional = conexionTransaccional;
    }
 
    
    /* Para insertar los datos de un nuevo restaurante a menu */
    public int insertar(int id) throws SQLException{
        
        Connection conn = null;
        PreparedStatement stmt_menu = null;
        int rows = 0;
        try {
            conn = this.conexionTransaccional != null ? this.conexionTransaccional : Conexion.getConnection(); // asigna la conn, si no es una transacción, entonces la crea, de otro modo usa la de la transacción
            stmt_menu = conn.prepareStatement(SQL_INSERT_IN_MENU); // Preparamos el insert en restaurante
            stmt_menu.setString(1, String.valueOf(id));

            System.out.println("-----------------------------------------------------------------");
            System.out.println("ejecutando query:" + stmt_menu);
            rows = stmt_menu.executeUpdate();
            System.out.println("Registros afectados:" + rows);
        } 
        finally {
            Conexion.close(stmt_menu);
            if (this.conexionTransaccional == null)               
                Conexion.close(conn); // Si no es una transaccion entonces la cerramos
        }
        return rows;
    }
    
    
}