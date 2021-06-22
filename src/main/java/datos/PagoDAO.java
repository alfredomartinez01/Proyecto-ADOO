package datos;

import static datos.Conexion.*;
import domain.Pago;
import java.sql.*;
import java.util.*;
import java.util.Date;

public class PagoDAO {
    
    private Connection conexionTransaccional;
    private static final String SQL_INSERT = "INSERT INTO pago (idCliente,montoTotal,noCuenta, cvv, fechaCad, tipo)  VALUES(?,?,?,?,?,?) ";

    public PagoDAO() {
    }
    public PagoDAO(Connection conexionTransaccional){
        this.conexionTransaccional = conexionTransaccional;
    }
    
    public int insertar(Pago pago) throws SQLException{
        Connection conn = null;
        PreparedStatement stmt = null;
        int registros = 0;
        try {
            conn = this.conexionTransaccional != null ? this.conexionTransaccional : Conexion.getConnection(); // asigna la conn, si no es una transacción, entonces la crea, de otro modo usa la de la transacción
            stmt = conn.prepareStatement(SQL_INSERT);
            stmt.setInt(1,pago.getIdCliente());
            stmt.setDouble(2,pago.getMontoTotal());
            stmt.setString(3, pago.getNoCuenta());
            stmt.setInt(4,pago.getCvv());
            stmt.setString(5,pago.getFechaCad());
            stmt.setString(6, pago.getTipo());
            
            System.out.println("-----------------------------------------------------------------");
            System.out.println("ejecutando query:" + stmt);
            registros = stmt.executeUpdate();//actualiza base de datos, puede ejecutar sentencias , update, delete ,insert 
        }finally{
            Conexion.close(stmt);
                if (this.conexionTransaccional == null) {
                    Conexion.close(conn); // Si no es una transaccion entonces la cerramos
                }
        }
        return registros;
    }
    
}
