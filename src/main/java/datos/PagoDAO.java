package datos;

import static datos.Conexion.*;
import domain.Pago;
import java.sql.*;
import java.util.*;
import java.util.Date;

public class PagoDAO {
    private static final String SQL_INSERT = "INSERT INTO pago (idCliente,montoTotal,noCuenta, cvv, fechaCad, tipo)  VALUES(?,?,?,?,?,?) ";

    public PagoDAO() {
    }
    
    public int insertar(Pago pago){
        Connection conn = null;
        PreparedStatement stmt = null;
        int registros = 0;
        try {
            conn = getConnection();
            stmt = conn.prepareStatement(SQL_INSERT);
            stmt.setInt(1,pago.getIdCliente());
            stmt.setDouble(2,pago.getMontoTotal());
            stmt.setInt(3, pago.getNoCuenta());
            stmt.setInt(4,pago.getCvv());
            stmt.setString(5,pago.getFechaCad());
            stmt.setInt(6, pago.getTipo());
            
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
