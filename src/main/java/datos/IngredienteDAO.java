package datos;

import static datos.Conexion.*;
import domain.Ingrediente;
import java.sql.*;
import java.util.*;

public class IngredienteDAO {

    private Connection conexionTransaccional;
    private static final String SQL_SELECT = "SELECT idIngrediente, nombreIngrediente, costoIngrediente FROM ingrediente";
    private static final String SQL_SELECT_BY_IDPLAT = "select * from ingrediente where idIngrediente in (SELECT idIngrediente FROM agrega where idPlatillo = ?)";
    private static final String SQL_SELECT_BY_DATA = "select * from ingrediente where (nombreIngrediente = ? and costoIngrediente = ?)";
    private static final String SQL_INSERT = "INSERT INTO ingrediente (nombreIngrediente, costoIngrediente)  VALUES(?, ?)";
    private static final String SQL_INSERT_IN_AGREGA = "INSERT INTO agrega (idPlatillo, idIngrediente)  VALUES(?, ?)";
    private static final String SQL_SELECT_FROM_AGREGA = "select * from agrega where idPlatillo = ?";

    /*En VALUES se pone ? en represantacion a cada valor que se quiere editar, se pondran mas  ? seguido 
    de comas si existen mas columnas en la tabla(?,?,?)*/
    private static final String SQL_UPDATE = "UPDATE  ingrediente SET nombreIngrediente = ?, costoIngrediente = ? WHERE idIngrediente = ? ";
    private static final String SQL_DELETE = "DELETE FROM ingrediente  WHERE idIngrediente = ? ";

    public IngredienteDAO() {

    }

    public IngredienteDAO(Connection conexionTransaccional) {
        this.conexionTransaccional = conexionTransaccional;
    }

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

                ingrediente = new Ingrediente(idIngrediente, nombreIngrediente, costoIngrediente);//Convertimos informacion de base de datos a objetos java

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

    public ArrayList<Ingrediente> seleccionar_por_idPlatillo(int id) throws SQLException {
        Connection conn = null;
        PreparedStatement stmt = null; //Variable para trabajar con Querys
        ResultSet rs = null;
        Ingrediente ingrediente = null;// Cada renglon se convertira en un objeto tipo Ingrediente
        ArrayList<Ingrediente> ingredientes = new ArrayList<>();

        try {
            conn = getConnection();//Conexion activa hacia la base de datos
            stmt = conn.prepareStatement(SQL_SELECT_BY_IDPLAT);//Mandamos la instruccion SELECT
            stmt.setString(1, String.valueOf(id));

            System.out.println("-----------------------------------------------------------------");
            System.out.println("ejecutando query:" + stmt);
            rs = stmt.executeQuery();//Se ejecuta la instruccion dada
            while (rs.next()) {
                int idIngrediente = rs.getInt("idIngrediente");
                String nombreIngrediente = rs.getString("nombreIngrediente");
                float costoIngrediente = rs.getFloat("costoIngrediente");

                ingrediente = new Ingrediente(idIngrediente, nombreIngrediente, costoIngrediente);//Convertimos informacion de base de datos a objetos java

                ingredientes.add(ingrediente);//Agregamos a la lista
            }
        }finally {
            Conexion.close(stmt);
            if (this.conexionTransaccional == null) {
                Conexion.close(conn); // Si no es una transaccion entonces la cerramos
            }
        }

        return ingredientes;
    }

    public void seleccionar_por_data(Ingrediente ingrediente) throws SQLException {
        Connection conn = null;
        PreparedStatement stmt = null; //Variable para trabajar con Querys
        ResultSet rs = null;

        try {
            conn = this.conexionTransaccional != null ? this.conexionTransaccional : Conexion.getConnection(); // asigna la conn, si no es una transacción, entonces la crea, de otro modo usa la de la transacción
            stmt = conn.prepareStatement(SQL_SELECT_BY_DATA);//Mandamos la instruccion SELECT
            stmt.setString(1, ingrediente.getNombreIngrediente());
            stmt.setString(2, String.valueOf(ingrediente.getCostoIngrediente()));

            System.out.println("-----------------------------------------------------------------");
            System.out.println("ejecutando query:" + stmt);
            rs = stmt.executeQuery();//Se ejecuta la instruccion dada

            while (rs.next()) {
                ingrediente.setIdIngrediente(rs.getInt("idIngrediente"));
            }
        } finally {
            Conexion.close(stmt);
            if (this.conexionTransaccional == null) {
                Conexion.close(conn); // Si no es una transaccion entonces la cerramos
            }
        }

    }

    public int insertar(Ingrediente ingrediente) throws SQLException {
        Connection conn = null;
        PreparedStatement stmt = null;
        int registros = 0;
        try {
            conn = this.conexionTransaccional != null ? this.conexionTransaccional : Conexion.getConnection(); // asigna la conn, si no es una transacción, entonces la crea, de otro modo usa la de la transacción
            stmt = conn.prepareStatement(SQL_INSERT);
            stmt.setString(1, ingrediente.getNombreIngrediente());
            stmt.setDouble(2, ingrediente.getCostoIngrediente());

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

    public int insertar_en_agrega(int idPlat, int idIngrediente) throws SQLException {
        Connection conn = null;
        PreparedStatement stmt = null;
        int registros = 0;
        try {
            conn = this.conexionTransaccional != null ? this.conexionTransaccional : Conexion.getConnection(); // asigna la conn, si no es una transacción, entonces la crea, de otro modo usa la de la transacción
            stmt = conn.prepareStatement(SQL_INSERT_IN_AGREGA);
            stmt.setInt(1, idPlat);
            stmt.setInt(2, idIngrediente);

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

    public ArrayList<Ingrediente> seleccionar_agrega(int idPlatillo) throws SQLException {
        Connection conn = null;
        PreparedStatement stmt = null; //Variable para trabajar con Querys
        ResultSet rs = null;
        Ingrediente ingrediente = null;// Cada renglon se convertira en un objeto tipo Ingrediente
        ArrayList<Ingrediente> ingredientes = new ArrayList<>();

        try {
            conn = this.conexionTransaccional != null ? this.conexionTransaccional : Conexion.getConnection(); // asigna la conn, si no es una transacción, entonces la crea, de otro modo usa la de la transacción
            stmt = conn.prepareStatement(SQL_SELECT_FROM_AGREGA);//Mandamos la instruccion SELECT
            stmt.setInt(1, idPlatillo);

            System.out.println("-----------------------------------------------------------------");
            System.out.println("ejecutando query:" + stmt);
            rs = stmt.executeQuery();//Se ejecuta la instruccion dada
            while (rs.next()) {
                int idIngrediente = rs.getInt("idIngrediente");

                ingrediente = new Ingrediente(idIngrediente);//Convertimos informacion de base de datos a objetos java

                ingredientes.add(ingrediente);//Agregamos a la lista
            }
        } finally {
            Conexion.close(stmt);
            if (this.conexionTransaccional == null) {
                Conexion.close(conn); // Si no es una transaccion entonces la cerramos
            }
        }

        return ingredientes;
    }

    public int actualizar(Ingrediente ingrediente) throws SQLException {
        Connection conn = null;
        PreparedStatement stmt = null;
        int registros = 0;
        try {
            conn = getConnection();
            stmt = conn.prepareStatement(SQL_UPDATE);
            stmt.setString(1, ingrediente.getNombreIngrediente());
            stmt.setDouble(2, ingrediente.getCostoIngrediente());
            stmt.setInt(3, ingrediente.getIdIngrediente());

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

    public int eliminar(Ingrediente ingrediente) throws SQLException {
        Connection conn = null;
        PreparedStatement stmt = null;
        int registros = 0;
        try {
            conn = this.conexionTransaccional != null ? this.conexionTransaccional : Conexion.getConnection(); // asigna la conn, si no es una transacción, entonces la crea, de otro modo usa la de la transacción
            stmt = conn.prepareStatement(SQL_DELETE);
            stmt.setInt(1, ingrediente.getIdIngrediente());

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
}
