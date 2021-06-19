package datos;

import static datos.Conexion.*;
import domain.Platillo;
import java.sql.*;
import java.util.*;

public class PlatilloDAO {
    private static final String SQL_SELECT = "SELECT idPlatillo, idMenu, nombrePlatillo, costoPlatillo, composicion FROM platillo";
    private static final String SQL_INSERT = "INSERT INTO platillo (idMenu,nombrePlatillo,costoPlatillo,composicion)  VALUES(?,?) ";
    /*En VALUES se pone ? en represantacion a cada valor que se quiere editar, se pondran mas  ? seguido 
    de comas si existen mas columnas en la tabla(?,?,?)*/
    private static final String SQL_UPDATE = "UPDATE  platillo SET idMenu = ?, nombrePlatillo = ?, costoPlatillo = ?, composicion = ?  WHERE idPlatillo = ? ";
    private static final String SQL_DELETE = "DELETE FROM platillo  WHERE idPlatillo = ? ";

    //Regresa lista de objetos tipo Platillo 
    //Crearemos objetos de tipo Platillo
    public List<Platillo> seleccionar() {
        Connection conn = null;
        PreparedStatement stmt = null; //Variable para trabajar con Querys
        ResultSet rs = null;
        Platillo platillo = null;// Cada renglon se convertira en un objeto tipo Platillo
        List<Platillo> platillos = new ArrayList<>();

        try {
            conn = getConnection();//Conexion activa hacia la base de datos
            stmt = conn.prepareStatement(SQL_SELECT);//Mandamos la instruccion SELECT
            rs = stmt.executeQuery();//Se ejecuta la instruccion dada
            while (rs.next()) {
                int idPlatillo = rs.getInt("idPlatillo");
                int idMenu = rs.getInt("idMenu");
                String nombrePlatillo = rs.getString("nombrePlatillo");
                float costoPlatillo = rs.getFloat("costoPlatillo");
                String composicion = rs.getString("composicion");
                platillo = new Platillo(idPlatillo,idMenu, nombrePlatillo,costoPlatillo,composicion);//Convertimos informacion de base de datos a objetos java

                platillos.add(platillo);//Agregamos a la lista
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

        return platillos;
    }
    
    public int insertar(Platillo platillo){
        Connection conn = null;
        PreparedStatement stmt = null;
        int registros = 0;
        try {
            conn = getConnection();
            stmt = conn.prepareStatement(SQL_INSERT);
            stmt.setInt(1,platillo.getIdClienteP());
            stmt.setString(2,platillo.getNombrePlatillo());
            stmt.setFloat(3,platillo.getCostoPlatillo());
            stmt.setString(4,platillo.getComposicion());
            
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
    
    public int actualizar(Platillo platillo){
        Connection conn = null;
        PreparedStatement stmt = null;
        int registros = 0;
        try {
            conn = getConnection();
            stmt = conn.prepareStatement(SQL_UPDATE);
            stmt.setInt(1,platillo.getIdClienteP());
            stmt.setString(2,platillo.getNombrePlatillo());
            stmt.setFloat(3,platillo.getCostoPlatillo());
            stmt.setString(4,platillo.getComposicion());
            
            stmt.setInt(5,platillo.getIdPlatillo());
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
    
    public int eliminar(Platillo platillo){
        Connection conn = null;
        PreparedStatement stmt = null;
        int registros = 0;
        try {
            conn = getConnection();
            stmt = conn.prepareStatement(SQL_DELETE);           
            stmt.setInt(1,platillo.getIdPlatillo());
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

