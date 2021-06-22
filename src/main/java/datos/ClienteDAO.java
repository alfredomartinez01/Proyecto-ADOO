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

        private static final String SQL_SELECT = "SELECT idCliente, nombreCliente FROM cliente";
        private static final String SQL_INSERT = "INSERT INTO cliente (nombreCliente)  VALUES(?) ";
        /*En VALUES se pone ? en represantacion a cada valor que se quiere editar, se pondran mas  ? seguido 
        de comas si existen mas columnas en la tabla(?,?,?)*/
        private static final String SQL_UPDATE = "UPDATE  cliente SET nombreCliente = ? WHERE idCliente = ? ";
        private static final String SQL_DELETE = "DELETE FROM cliente  WHERE idCliente = ? ";

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

        public int insertar(Cliente cliente){
            Connection conn = null;
            PreparedStatement stmt = null;
            int registros = 0;
            try {
                conn = getConnection();
                stmt = conn.prepareStatement(SQL_INSERT);
                stmt.setString(1,cliente.getNombreCliente());
                /*El primer parametro 1 corresponde al primer 
                parametro de la sentencia INSERT -> VALUES(?), el segundo parametro 
                hace refencia */
                registros = stmt.executeUpdate();//actualiza base de datos, puede ejecutar sentencias , update, delete ,insert 
            } catch (SQLException ex) {
                ex.printStackTrace(System.out);
            }
            finally{
                try{
                   close(stmt); 
                   close(conn); 
                }catch(SQLException ex){
                    ex.printStackTrace(System.out);
                }
            }
            return registros;
        }

        public int actualizar(Cliente cliente){
            Connection conn = null;
            PreparedStatement stmt = null;
            int registros = 0;
            try {
                conn = getConnection();
                stmt = conn.prepareStatement(SQL_UPDATE);
                stmt.setString(1,cliente.getNombreCliente());
                /*El primer parametro 1 corresponde al primer 
                parametro de la sentencia INSERT -> VALUES(?), el segundo parametro 
                hace refencia */
                stmt.setInt(2,cliente.getIdCliente());
                registros = stmt.executeUpdate();//actualiza base de datos, puede ejecutar sentencias , update, delete ,insert 
            } catch (SQLException ex) {
                ex.printStackTrace(System.out);
            }
            finally{
                try{
                   close(stmt); 
                   close(conn); 
                }catch(SQLException ex){
                    ex.printStackTrace(System.out);
                }
            }
            return registros;
        }

        public int eliminar(Cliente cliente){
            Connection conn = null;
            PreparedStatement stmt = null;
            int registros = 0;
            try {
                conn = getConnection();
                stmt = conn.prepareStatement(SQL_DELETE);           
                stmt.setInt(1,cliente.getIdCliente());
                registros = stmt.executeUpdate();//actualiza base de datos, puede ejecutar sentencias , update, delete ,insert 
            } catch (SQLException ex) {
                ex.printStackTrace(System.out);
            }
            finally{
                try{
                   close(stmt); 
                   close(conn); 
                }catch(SQLException ex){
                    ex.printStackTrace(System.out);
                }
            }
            return registros;
        }
}
