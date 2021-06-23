package datos;

import static datos.Conexion.*;
import domain.Platillo;
import java.sql.*;
import java.util.*;

public class PlatilloDAO {

    private Connection conexionTransaccional; // Para transacciones
    private static final String SQL_SELECT = "SELECT * FROM platillo";
    private static final String SQL_SELECT_MAX_PLATILLO = "SELECT MAX(idPlatillo) AS ultimoIDPlatillo FROM platillo";
    private static final String SQL_SELECT_BY_IDMENU = "SELECT * FROM platillo where idMenu = ? and tipo != 1";
    private static final String SQL_INSERT_IN_CONTIENE = "INSERT INTO contiene (idPlatillo, idOrden)  VALUES(?, ?)";
    private static final String SQL_SELECT_BY_DATA = "select * from platillo where (nombrePlatillo = ? and costoPlatillo = ? and composicion = ?)";
    private static final String SQL_INSERT = "INSERT INTO platillo (idMenu,nombrePlatillo,costoPlatillo,composicion, tipo)  VALUES(?, ?, ?, ?, ?) ";
    /*En VALUES se pone ? en represantacion a cada valor que se quiere editar, se pondran mas  ? seguido 
    de comas si existen mas columnas en la tabla(?,?,?)*/
    private static final String SQL_UPDATE = "UPDATE  platillo SET idMenu = ?, nombrePlatillo = ?, costoPlatillo = ?, composicion = ?  WHERE idPlatillo = ? ";
    private static final String SQL_DELETE = "DELETE FROM platillo  WHERE idPlatillo = ? ";
    private static final String SQL_SELECT_BY_IDORDEN = "SELECT * FROM platillo where idPlatillo in (select idPlatillo from contiene where idOrden = ?)";
    public PlatilloDAO() {

    }

    // Para transacciones
    public PlatilloDAO(Connection conexionTransaccional) {
        this.conexionTransaccional = conexionTransaccional;
    }

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
                platillo = new Platillo(idPlatillo, idMenu, nombrePlatillo, costoPlatillo, composicion);//Convertimos informacion de base de datos a objetos java

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
    
    public int insertar_en_contiene(int idPlat, int idOrden) throws SQLException {
        Connection conn = null;
        PreparedStatement stmt = null;
        int registros = 0;
        try {
            conn = this.conexionTransaccional != null ? this.conexionTransaccional : Conexion.getConnection(); // asigna la conn, si no es una transacción, entonces la crea, de otro modo usa la de la transacción
            stmt = conn.prepareStatement(SQL_INSERT_IN_CONTIENE);
            stmt.setInt(1, idPlat);
            stmt.setInt(2, idOrden);

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
    
    /*Obtener ultimo id de platillo*/
    public int lastIDPlatillo() throws SQLException {
        Connection conn = null;
        PreparedStatement stmt = null; //Variable para trabajar con Querys
        ResultSet rs = null;
        int idPlat = 0;// Cada renglon se convertira en un objeto tipo cliente

        try {
            conn = this.conexionTransaccional != null ? this.conexionTransaccional : Conexion.getConnection(); // asigna la conn, si no es una transacción, entonces la crea, de otro modo usa la de la transacción
            stmt = conn.prepareStatement(SQL_SELECT_MAX_PLATILLO);//Mandamos la instruccion SELECT

            System.out.println("-----------------------------------------------------------------");
            System.out.println("ejecutando query:" + stmt);
            rs = stmt.executeQuery();//Se ejecuta la instruccion dada
            rs.next();
            idPlat = rs.getInt("ultimoIDPlatillo");
        } finally {
            Conexion.close(stmt);
            Conexion.close(rs);
            if (this.conexionTransaccional == null) {
                Conexion.close(conn); // Si no es una transaccion entonces la cerramos
            }
        }

        return idPlat;
    }
    
    public ArrayList<Platillo> seleccionar_por(int idmenu) throws SQLException {
        Connection conn = null;
        PreparedStatement stmt = null; //Variable para trabajar con Querys
        ResultSet rs = null;
        Platillo platillo = null;// Cada renglon se convertira en un objeto tipo Platillo
        ArrayList<Platillo> platillos = new ArrayList<>();

        try {
            conn = getConnection();//Conexion activa hacia la base de datos
            stmt = conn.prepareStatement(SQL_SELECT_BY_IDMENU);//Mandamos la instruccion SELECT
            stmt.setInt(1, idmenu);
            
            System.out.println("-----------------------------------------------------------------");
            System.out.println("ejecutando query:" + stmt);
            rs = stmt.executeQuery();//Se ejecuta la instruccion dada
            while (rs.next()) {
                int idPlatillo = rs.getInt("idPlatillo");
                int idMenu = rs.getInt("idMenu");
                String nombrePlatillo = rs.getString("nombrePlatillo");
                float costoPlatillo = rs.getFloat("costoPlatillo");
                String composicion = rs.getString("composicion");
                platillo = new Platillo(idPlatillo, idMenu, nombrePlatillo, costoPlatillo, composicion);//Convertimos informacion de base de datos a objetos java

                platillos.add(platillo);//Agregamos a la lista
            }
        } finally {
                Conexion.close(stmt);
                Conexion.close(rs);                
                if (this.conexionTransaccional == null) {
                    Conexion.close(conn); // Si no es una transaccion entonces la cerramos
                }            
        }
        return platillos;
    }
    
    public ArrayList<Platillo> seleccionar_por_orden(int idorden) throws SQLException {
        Connection conn = null;
        PreparedStatement stmt = null; //Variable para trabajar con Querys
        ResultSet rs = null;
        Platillo platillo = null;// Cada renglon se convertira en un objeto tipo Platillo
        ArrayList<Platillo> platillos = new ArrayList<>();

        try {
            conn = getConnection();//Conexion activa hacia la base de datos
            stmt = conn.prepareStatement(SQL_SELECT_BY_IDORDEN);//Mandamos la instruccion SELECT
            stmt.setInt(1, idorden);
            
            System.out.println("-----------------------------------------------------------------");
            System.out.println("ejecutando query:" + stmt);
            rs = stmt.executeQuery();//Se ejecuta la instruccion dada
            while (rs.next()) {
                int idPlatillo = rs.getInt("idPlatillo");
                int idMenu = rs.getInt("idMenu");
                String nombrePlatillo = rs.getString("nombrePlatillo");
                float costoPlatillo = rs.getFloat("costoPlatillo");
                String composicion = rs.getString("composicion");
                platillo = new Platillo(idPlatillo, idMenu, nombrePlatillo, costoPlatillo, composicion);//Convertimos informacion de base de datos a objetos java

                platillos.add(platillo);//Agregamos a la lista
            }
        } finally {
                Conexion.close(stmt);
                Conexion.close(rs);                
                if (this.conexionTransaccional == null) {
                    Conexion.close(conn); // Si no es una transaccion entonces la cerramos
                }            
        }
        return platillos;
    }
    public void seleccionar_data(Platillo plat) throws SQLException {
        Connection conn = null;
        PreparedStatement stmt = null; //Variable para trabajar con Querys
        ResultSet rs = null;

        try {
            conn = this.conexionTransaccional != null ? this.conexionTransaccional : Conexion.getConnection(); // asigna la conn, si no es una transacción, entonces la crea, de otro modo usa la de la transacción
            stmt = conn.prepareStatement(SQL_SELECT_BY_DATA);//Mandamos la instruccion SELECT
            stmt.setString(1, plat.getNombrePlatillo());
            stmt.setDouble(2, plat.getCostoPlatillo());
            stmt.setString(3, plat.getComposicion());
            
            System.out.println("-----------------------------------------------------------------");
            System.out.println("ejecutando query:" + stmt);
            rs = stmt.executeQuery();//Se ejecuta la instruccion dada
            while (rs.next()) {
                plat.setIdPlatillo(rs.getInt("idPlatillo"));
                plat.setIdMenu(rs.getInt("idMenu"));
                plat.setNombrePlatillo(rs.getString("nombrePlatillo"));
                plat.setCostoPlatillo(rs.getDouble("costoPlatillo"));
                plat.setComposicion(rs.getString("composicion"));
                
            }
        } finally {
                Conexion.close(stmt);
                Conexion.close(rs);                
                if (this.conexionTransaccional == null) {
                    Conexion.close(conn); // Si no es una transaccion entonces la cerramos
                }            
        }
    }
    public int insertar(Platillo platillo) throws SQLException {
        Connection conn = null;
        PreparedStatement stmt = null;
        int registros = 0;
        try {
            conn = this.conexionTransaccional != null ? this.conexionTransaccional : Conexion.getConnection(); // asigna la conn, si no es una transacción, entonces la crea, de otro modo usa la de la transacción
            stmt = conn.prepareStatement(SQL_INSERT);
            stmt.setInt(1, platillo.getIdMenu());
            stmt.setString(2, platillo.getNombrePlatillo());
            stmt.setDouble(3, platillo.getCostoPlatillo());
            stmt.setString(4, platillo.getComposicion());
            stmt.setInt(5, platillo.getTipo());
            
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

    public int actualizar(Platillo platillo) throws SQLException {
        Connection conn = null;
        PreparedStatement stmt = null;
        int registros = 0;
        try {
            conn = this.conexionTransaccional != null ? this.conexionTransaccional : Conexion.getConnection(); // asigna la conn, si no es una transacción, entonces la crea, de otro modo usa la de la transacción
            stmt = conn.prepareStatement(SQL_UPDATE);
            stmt.setInt(1, platillo.getIdMenu());
            stmt.setString(2, platillo.getNombrePlatillo());
            stmt.setDouble(3, platillo.getCostoPlatillo());
            stmt.setString(4, platillo.getComposicion());

            stmt.setInt(5, platillo.getIdPlatillo());
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

    public int eliminar(Platillo platillo) throws SQLException {
        Connection conn = null;
        PreparedStatement stmt = null;
        int registros = 0;
        try {
            conn = this.conexionTransaccional != null ? this.conexionTransaccional : Conexion.getConnection(); // asigna la conn, si no es una transacción, entonces la crea, de otro modo usa la de la transacción
            stmt = conn.prepareStatement(SQL_DELETE);
            stmt.setInt(1, platillo.getIdPlatillo());
            
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
