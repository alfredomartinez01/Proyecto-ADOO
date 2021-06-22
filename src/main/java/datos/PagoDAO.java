package datos;

import static datos.Conexion.*;
import domain.Pago;
import java.sql.*;
import java.util.*;



/**
 *
 * @author chris
 */
public class PagoDAO {

        private static final String SQL_SELECT = "SELECT idPago,idCliente,montoTotal, tipo FROM pago";
        
        //Regresa lista de objetos tipo pago 
        //Crearemos objetos de tipo pago
        public List<Pago> seleccionar() {
            Connection conn = null;
            PreparedStatement stmt = null; //Variable para trabajar con Querys
            ResultSet rs = null;
            Pago pago = null;// Cada renglon se convertira en un objeto tipo pago
            List<Pago> pagos = new ArrayList<>();

            try {
                conn = getConnection();//Conexion activa hacia la base de datos
                stmt = conn.prepareStatement(SQL_SELECT);//Mandamos la instruccion SELECT
                rs = stmt.executeQuery();//Se ejecuta la instruccion dada
                while (rs.next()) {
                    int idPago = rs.getInt("idPago");
                    int idCliente = rs.getInt("idCliente");
                    double montoTotal = rs.getDouble("montoTotal");
                    String tipo = rs.getString("tipo");

                    pago = new Pago(idPago,idCliente,montoTotal,tipo);//Convertimos informacion de base de datos a objetos java

                    pagos.add(pago);//Agregamos a la lista
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

            return pagos;
        }
}
