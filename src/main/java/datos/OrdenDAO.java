
package datos;
import static datos.Conexion.*;
import domain.Orden;
import java.sql.*;
import java.util.*;
import java.util.Date;


public class OrdenDAO {
   
    private Connection conexionTransaccional;
    private static final String SQL_SELECT = "SELECT * FROM orden";
    private static final String SQL_SELECT_MAX_ORDEN = "SELECT MAX(idOrden) AS ultimoIDOrden FROM orden";
    //private static final String SQL_SELECT_BY_DATA = "select * from orden where (nombrePlatillo = ? and costoPlatillo = ? and composicion = ?) and tipo = 1";
    private static final String SQL_INSERT = "INSERT INTO orden (idCliente, fecha, hora, estado)  VALUES(?,?,?,?) ";
    private static final String SQL_UPDATE = "UPDATE  orden SET estado=? WHERE idOrden = ? ";
    private static final String SQL_DELETE = "DELETE FROM orden  WHERE idOrden = ? ";
    private static final String SQL_SELECT_CONTIENE = "SELECT idOrden, idPlatillo FROM contiene";
    
        public OrdenDAO(Connection conexionTransaccional) {
        this.conexionTransaccional = conexionTransaccional;
    }
        public OrdenDAO() {
    }
    
    public List<Orden> seleccionar() {
        Connection conn = null;
        PreparedStatement stmt = null; //Variable para trabajar con Querys
        ResultSet rs = null;
        Orden orden = null;// Cada renglon se convertira en un objeto tipo Orden
        List<Orden> ordenes = new ArrayList<>();

        try {
            conn = getConnection();//Conexion activa hacia la base de datos
            stmt = conn.prepareStatement(SQL_SELECT);//Mandamos la instruccion SELECT
            
            
            System.out.println("-----------------------------------------------------------------");
            System.out.println("ejecutando query:" + stmt);
            
            rs = stmt.executeQuery();//Se ejecuta la instruccion dada
            while (rs.next()) {
                int idOrden = rs.getInt("idOrden");
                int idCliente = rs.getInt("idCliente");
                String fecha = rs.getString("fecha");
                String hora = rs.getString("hora");
                String estado = rs.getString("estado");
                
                orden = new Orden(idOrden, idCliente,fecha,hora,estado);//Convertimos informacion de base de datos a objetos java

                ordenes.add(orden);//Agregamos a la lista
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

        return ordenes;
    }
    
    public int insertar(Orden orden){
        Connection conn = null;
        PreparedStatement stmt = null;
        int registros = 0;
        try {
            conn = getConnection();
            stmt = conn.prepareStatement(SQL_INSERT);
            stmt.setInt(1,orden.getIdCliente());
            stmt.setString(2,orden.getFecha());
            stmt.setString(3, orden.getHora());
            stmt.setString(4, orden.getEstado());
            
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
    /*Obtener ultimo id de orden*/
    public int lastIDOrden() throws SQLException {
        Connection conn = null;
        PreparedStatement stmt = null; //Variable para trabajar con Querys
        ResultSet rs = null;
        int idOrden = 0;// Cada renglon se convertira en un objeto tipo cliente

        try {
            conn = this.conexionTransaccional != null ? this.conexionTransaccional : Conexion.getConnection(); // asigna la conn, si no es una transacción, entonces la crea, de otro modo usa la de la transacción
            stmt = conn.prepareStatement(SQL_SELECT_MAX_ORDEN);//Mandamos la instruccion SELECT
            
            System.out.println("-----------------------------------------------------------------");
            System.out.println("ejecutando query:" + stmt);
            rs = stmt.executeQuery();//Se ejecuta la instruccion dada
            rs.next();
            idOrden = rs.getInt("ultimoIDOrden");
        } finally {
            Conexion.close(stmt);
                if (this.conexionTransaccional == null) {
                    Conexion.close(conn); // Si no es una transaccion entonces la cerramos
                }
        }

        return idOrden;
    }
    public int actualizar(Orden orden){
        Connection conn = null;
        PreparedStatement stmt = null;
        int registros = 0;
        try {
            conn = getConnection();
            stmt = conn.prepareStatement(SQL_UPDATE);
            stmt.setString(1,orden.getEstado());
            stmt.setInt(2,orden.getIdOrden());
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
    
    public int eliminar(Orden orden){
        Connection conn = null;
        PreparedStatement stmt = null;
        int registros = 0;
        try {
            conn = getConnection();
            stmt = conn.prepareStatement(SQL_DELETE);           
            stmt.setInt(1,orden.getIdOrden());
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
    
    
    
    
    public List<Orden> seleccionar_contiene() {
        Connection conn = null;
        PreparedStatement stmt = null; //Variable para trabajar con Querys
        ResultSet rs = null;
        Orden orden = null;// Cada renglon se convertira en un objeto tipo Orden
        List<Orden> ordenes = new ArrayList<>();

        try {
            conn = getConnection();//Conexion activa hacia la base de datos
            stmt = conn.prepareStatement(SQL_SELECT_CONTIENE);//Mandamos la instruccion SELECT
            rs = stmt.executeQuery();//Se ejecuta la instruccion dada
            while (rs.next()) {
                int idOrden = rs.getInt("idOrden");
                int idPlatillo = rs.getInt("idPlatillo");                               
                orden = new Orden(idOrden, idPlatillo);//Convertimos informacion de base de datos a objetos java

                ordenes.add(orden);//Agregamos a la lista
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

        return ordenes;
    }
}
