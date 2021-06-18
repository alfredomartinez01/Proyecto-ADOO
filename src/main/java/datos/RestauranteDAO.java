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
public class RestauranteDAO {

    private Connection conexionTransaccional;
    private String SQL_INSERT_IN_RESTAURANTE = "insert into restaurante(nombreRest, local, telefono, nombreUsuario, contrasena) values(?, ?, ?, ?, ?)";
    private String SQL_SELECT = "select * from restaurante where ( (local = ? and nombreRest = ?) or (nombreUsuario = ?) or (idRestaurante = ?) )";
    private String SQL_INSERT_IN_HORARIO = "insert into horario_restaurante values(?, ?, ?, ?)"; // dia, hora_apertura, hora_cierre, idRestaurante
    private String SQL_SELECT_IN_HORARIO = "select * from horario_restaurante where idRestaurante = ?";

    public RestauranteDAO() {

    }

    public RestauranteDAO(Connection conexionTransaccional) { // Traemos la conexión para una transacción
        this.conexionTransaccional = conexionTransaccional;
    }

    /* Registramos los datos del nuevo restaurante en restaurante*/
    public int insertar(Restaurante restaurante) throws SQLException {
        Connection conn = null;
        PreparedStatement stmt_rest = null;
        int rows = 0;
        try {
            conn = this.conexionTransaccional != null ? this.conexionTransaccional : Conexion.getConnection(); // asigna la conn, si no es una transacción, entonces la crea, de otro modo usa la de la transacción
            stmt_rest = conn.prepareStatement(SQL_INSERT_IN_RESTAURANTE); // Preparamos el insert en restaurante
            stmt_rest.setString(1, restaurante.getNombre());
            stmt_rest.setString(2, String.valueOf(restaurante.getLocal()));
            stmt_rest.setString(3, String.valueOf(restaurante.getTelefono()));
            stmt_rest.setString(4, restaurante.getCorreo());
            stmt_rest.setString(5, restaurante.getContrasena());

            System.out.println("ejecutando query:" + SQL_INSERT_IN_RESTAURANTE);
            rows = stmt_rest.executeUpdate();
            System.out.println("Registros afectados:" + rows);
        } finally {
            Conexion.close(stmt_rest);
            if (this.conexionTransaccional == null) {
                Conexion.close(conn); // Si no es una transaccion entonces la cerramos
            }
        }
        return rows;
    }

    /* Registramos los datos del nuevo restaurante en horario*/
    public int insertar_horario(String dia, int id, String horaAp, String horaCie) throws SQLException {
        Connection conn = null;
        PreparedStatement stmt_rest = null;
        int rows = 0;
        try {
            conn = this.conexionTransaccional != null ? this.conexionTransaccional : Conexion.getConnection(); // asigna la conn, si no es una transacción, entonces la crea, de otro modo usa la de la transacción
            stmt_rest = conn.prepareStatement(SQL_INSERT_IN_HORARIO); // Preparamos el insert en restaurante
            stmt_rest.setString(1, dia);
            stmt_rest.setString(2, horaAp);
            stmt_rest.setString(3, horaCie);
            stmt_rest.setString(4, String.valueOf(id));

            System.out.println("ejecutando query:" + SQL_INSERT_IN_HORARIO);
            rows = stmt_rest.executeUpdate();
            System.out.println("Registros afectados:" + rows);
        } finally {
            Conexion.close(stmt_rest);
            if (this.conexionTransaccional == null) {
                Conexion.close(conn); // Si no es una transaccion entonces la cerramos
            }
        }
        return rows;
    }

    /* Para seleccionar el restaurante con base a su local y nombre*/
    public Restaurante select(Restaurante restaurante) throws SQLException {
        Connection conn = null;
        PreparedStatement stmt_menu = null;
        ResultSet rs = null;
        try {
            conn = this.conexionTransaccional != null ? this.conexionTransaccional : Conexion.getConnection(); // asigna la conn, si no es una transacción, entonces la crea, de otro modo usa la de la transacción
            stmt_menu = conn.prepareStatement(SQL_SELECT); // Preparamos el insert en restaurante
            stmt_menu.setString(1, String.valueOf(restaurante.getLocal()));
            stmt_menu.setString(2, restaurante.getNombre());
            stmt_menu.setString(3, restaurante.getCorreo());
            stmt_menu.setString(4, String.valueOf(restaurante.getId()));

            restaurante.setCorreo(""); // Limpieza por comprobación

            System.out.println("ejecutando query:" + SQL_SELECT);
            rs = stmt_menu.executeQuery();
            while (rs.next()) {
                restaurante.setId(rs.getInt("idRestaurante"));
                restaurante.setNombre(rs.getString("nombreRest"));
                restaurante.setLocal(rs.getInt("local"));
                restaurante.setTelefono(rs.getLong("telefono"));
                restaurante.setCorreo(rs.getString("nombreUsuario"));
                restaurante.setContrasena(rs.getString("contrasena"));
                System.out.println("Registros afectados:" + rs);
            }
        } finally {
            Conexion.close(stmt_menu);
            if (this.conexionTransaccional == null) {
                Conexion.close(conn); // Si no es una transaccion entonces la cerramos
            }
        }
        return restaurante;
    }

    /* Rcuperamos el horario del restaurante*/
    public Restaurante select_horario(Restaurante restaurante) throws SQLException {
        Connection conn = null;
        PreparedStatement stmt_rest = null;
        ResultSet rs = null;
        boolean[] diasAbiertos = {false, false, false, false, false, false, false};
        String horarios[][] = {{"", ""}, {"", ""}, {"", ""}, {"", ""}, {"", ""}, {"", ""}, {"", ""}};
        
        try {
            conn = this.conexionTransaccional != null ? this.conexionTransaccional : Conexion.getConnection(); // asigna la conn, si no es una transacción, entonces la crea, de otro modo usa la de la transacción
            stmt_rest = conn.prepareStatement(SQL_SELECT_IN_HORARIO); // Preparamos el insert en restaurante
            stmt_rest.setInt(1, restaurante.getId());

            System.out.println("ejecutando query:" + SQL_SELECT_IN_HORARIO);
            rs = stmt_rest.executeQuery();
            System.out.println("Registros afectados:" + rs);
            
            while(rs.next()){
                switch (rs.getString("dia")) {
                    case "lunes":
                        diasAbiertos[0] = true;
                        horarios[0][0] = rs.getString("horaApertura");
                        horarios[0][1] = rs.getString("horaCierre");
                        break;
                    case "martes":
                        diasAbiertos[1] = true;
                        horarios[1][0] = rs.getString("horaApertura");
                        horarios[1][1] = rs.getString("horaCierre");
                        break;
                    case "miercoles":
                        diasAbiertos[2] = true;
                        horarios[2][0] = rs.getString("horaApertura");
                        horarios[2][1] = rs.getString("horaCierre");
                        break;
                    case "jueves":
                        diasAbiertos[3] = true;
                        horarios[3][0] = rs.getString("horaApertura");
                        horarios[3][1] = rs.getString("horaCierre");
                        break;
                    case "viernes":
                        diasAbiertos[4] = true;
                        horarios[4][0] = rs.getString("horaApertura");
                        horarios[4][1] = rs.getString("horaCierre");
                        break;
                    case "sabado":
                        diasAbiertos[5] = true;
                        horarios[5][0] = rs.getString("horaApertura");
                        horarios[5][1] = rs.getString("horaCierre");
                        break;
                    case "domingo":
                        diasAbiertos[6] = true;
                        horarios[6][0] = rs.getString("horaApertura");
                        horarios[6][1] = rs.getString("horaCierre");
                        break;
                    default:
                        break;
                }
            }
            restaurante.setDias(diasAbiertos);
            restaurante.setHorarios(horarios);
        } finally {
            Conexion.close(stmt_rest);
            if (this.conexionTransaccional == null) {
                Conexion.close(conn); // Si no es una transaccion entonces la cerramos
            }
        }
        return restaurante;
    }
}
