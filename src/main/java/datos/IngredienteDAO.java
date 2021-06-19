
package datos;

import static datos.Conexion.*;
import domain.Ingrediente;
import java.sql.*;
import java.util.*;

public class IngredienteDAO {
    private static final String SQL_SELECT = "SELECT idIngrediente, nombreIngrediente, costoIngrediente FROM ingrediente";
    private static final String SQL_INSERT = "INSERT INTO ingrediente (nombreIngrediente,costoIngrediente)  VALUES(?,?) ";
    /*En VALUES se pone ? en represantacion a cada valor que se quiere editar, se pondran mas  ? seguido 
    de comas si existen mas columnas en la tabla(?,?,?)*/
    private static final String SQL_UPDATE = "UPDATE  ingrediente SET nombreIngrediente = ?, costoIngrediente = ? WHERE idIngrediente = ? ";
    private static final String SQL_DELETE = "DELETE FROM ingrediente  WHERE idIngrediente = ? ";

    //Regresa lista de objetos tipo Ingrediente 
    //Crearemos objetos de tipo Ingrediente
    public List<Ingrediente> seleccionar() {
        Connection conn = null;
        PreparedStatement stmt = null; //Variable para trabajar con Querys
        ResultSet rs = null;
        Ingrediente ingrediente = null;// Cada renglon se convertira en un objeto tipo Ingrediente
        List<Ingrediente> ingredientes = new ArrayList<>();

        try {
            conn = getConnection();//Conexion activa hacia la base de datos
            stmt = conn.prepareStatement(SQL_SELECT);//Mandamos la instruccion SELECT
            rs = stmt.executeQuery();//Se ejecuta la instruccion dada
            while (rs.next()) {
                int idIngrediente = rs.getInt("idIngrediente");
                String nombreIngrediente = rs.getString("nombreIngrediente");
                float costoIngrediente = rs.getFloat("costoIngrediente");

                ingrediente = new Ingrediente(idIngrediente, nombreIngrediente,costoIngrediente);//Convertimos informacion de base de datos a objetos java

                ingredientes.add(ingrediente);//Agregamos a la lista
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

        return ingredientes;
    }
    
    public int insertar(Ingrediente ingrediente){
        Connection conn = null;
        PreparedStatement stmt = null;
        int registros = 0;
        try {
            conn = getConnection();
            stmt = conn.prepareStatement(SQL_INSERT);
            stmt.setString(1,ingrediente.getNombreIngrediente());
            stmt.setFloat(2,ingrediente.getCostoIngrediente());
            
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
    
    public int actualizar(Ingrediente ingrediente){
        Connection conn = null;
        PreparedStatement stmt = null;
        int registros = 0;
        try {
            conn = getConnection();
            stmt = conn.prepareStatement(SQL_UPDATE);
            stmt.setString(1,ingrediente.getNombreIngrediente());
            stmt.setFloat(2,ingrediente.getCostoIngrediente());
            
            stmt.setInt(3,ingrediente.getIdIngrediente());
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
    
    public int eliminar(Ingrediente ingrediente){
        Connection conn = null;
        PreparedStatement stmt = null;
        int registros = 0;
        try {
            conn = getConnection();
            stmt = conn.prepareStatement(SQL_DELETE);           
            stmt.setInt(1,ingrediente.getIdIngrediente());
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
