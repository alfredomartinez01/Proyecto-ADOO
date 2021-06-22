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
    
    private Connection conexionTransaccional; // Para transacciones
    private static final String SQL_SELECT = "SELECT idCliente, nombreCliente FROM cliente";
    private static final String SQL_SELECT_MAX_CLIENTE = "SELECT MAX(idCliente) AS ultimoIDCliente FROM cliente";
    private static final String SQL_INSERT = "INSERT INTO cliente (nombreCliente)  VALUES(?) ";
    /*En VALUES se pone ? en represantacion a cada valor que se quiere editar, se pondran mas  ? seguido 
        de comas si existen mas columnas en la tabla(?,?,?)*/
    private static final String SQL_UPDATE = "UPDATE  cliente SET nombreCliente = ? WHERE idCliente = ? ";
    private static final String SQL_DELETE = "DELETE FROM cliente  WHERE idCliente = ? ";

    
    public ClienteDAO(Connection conexionTransaccional){
        this.conexionTransaccional = conexionTransaccional;
    }
    //Regresa lista de objetos tipo cliente 
    //Crearemos objetos de tipo cliente
    public List<Cliente> seleccionar() {
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

    /*Obtener ultimo id de cliente*/
    public int lastIDCliente() throws SQLException {
        Connection conn = null;
        PreparedStatement stmt = null; //Variable para trabajar con Querys
        ResultSet rs = null;
        int idCliente = 0;// Cada renglon se convertira en un objeto tipo cliente

        try {
            conn = this.conexionTransaccional != null ? this.conexionTransaccional : Conexion.getConnection(); // asigna la conn, si no es una transacción, entonces la crea, de otro modo usa la de la transacción
            stmt = conn.prepareStatement(SQL_SELECT_MAX_CLIENTE);//Mandamos la instruccion SELECT            
            
            System.out.println("-----------------------------------------------------------------");
            System.out.println("ejecutando query:" + stmt);
            rs = stmt.executeQuery();//Se ejecuta la instruccion dada
            rs.next();
            idCliente = rs.getInt("ultimoIDCliente");
        } finally {
            Conexion.close(stmt);
            Conexion.close(rs);
            if (this.conexionTransaccional == null) {
                Conexion.close(conn); // Si no es una transaccion entonces la cerramos
            }            
        }
        
        return idCliente;
    }
    
    public int insertar(Cliente cliente) throws SQLException {
        Connection conn = null;
        PreparedStatement stmt = null;
        int registros = 0;
        
        try {
            conn = this.conexionTransaccional != null ? this.conexionTransaccional : Conexion.getConnection(); // asigna la conn, si no es una transacción, entonces la crea, de otro modo usa la de la transacción
            stmt = conn.prepareStatement(SQL_INSERT);
            stmt.setString(1, cliente.getNombreCliente());
            /*El primer parametro 1 corresponde al primer 
                parametro de la sentencia INSERT -> VALUES(?), el segundo parametro 
                hace refencia */
            
            System.out.println("-----------------------------------------------------------------");
            System.out.println("ejecutando query:" + stmt);
            registros = stmt.executeUpdate();//actualiza base de datos, puede ejecutar sentencias , update, delete ,insert 
        } finally {
            Conexion.close(stmt);
            if (this.conexionTransaccional == null) {
                Conexion.close(conn); // Si no es una transaccion entonces la cerramos
            }
        }
        return registros;
    }
    
    public int actualizar(Cliente cliente) {
        Connection conn = null;
        PreparedStatement stmt = null;
        int registros = 0;
        try {
            conn = getConnection();
            stmt = conn.prepareStatement(SQL_UPDATE);
            stmt.setString(1, cliente.getNombreCliente());
            /*El primer parametro 1 corresponde al primer 
                parametro de la sentencia INSERT -> VALUES(?), el segundo parametro 
                hace refencia */
            stmt.setInt(2, cliente.getIdCliente());
            registros = stmt.executeUpdate();//actualiza base de datos, puede ejecutar sentencias , update, delete ,insert 
        } catch (SQLException ex) {
            ex.printStackTrace(System.out);
        } finally {
            try {
                close(stmt);
                close(conn);
            } catch (SQLException ex) {
                ex.printStackTrace(System.out);
            }
        }
        return registros;
    }
    
    public int eliminar(Cliente cliente) {
        Connection conn = null;
        PreparedStatement stmt = null;
        int registros = 0;
        try {
            conn = getConnection();
            stmt = conn.prepareStatement(SQL_DELETE);
            stmt.setInt(1, cliente.getIdCliente());
            registros = stmt.executeUpdate();//actualiza base de datos, puede ejecutar sentencias , update, delete ,insert 
        } catch (SQLException ex) {
            ex.printStackTrace(System.out);
        } finally {
            try {
                close(stmt);
                close(conn);
            } catch (SQLException ex) {
                ex.printStackTrace(System.out);
            }
        }
        return registros;
    }
}
