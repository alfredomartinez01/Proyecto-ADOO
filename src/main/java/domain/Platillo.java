package domain;

import datos.Conexion;
import datos.IngredienteDAO;
import datos.MenuDAO;
import datos.PlatilloDAO;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

//import java.util.ArrayList;
public class Platillo {

    private int idPlatillo;
    private int idClienteP;
    private int idMenu;
    private String nombrePlatillo;
    private double costoPlatillo;
    private String composicion;
    private ArrayList<Ingrediente> ingredientes = new ArrayList<Ingrediente>();

    public Platillo() {
    }

    public Platillo(int idPlatillo, int idClienteP, String nombrePlatillo, double costoPlatillo, String composicion) {
        this.idPlatillo = idPlatillo;
        this.idClienteP = idClienteP;
        this.nombrePlatillo = nombrePlatillo;
        this.costoPlatillo = costoPlatillo;
        this.composicion = composicion;
    }

    public Platillo(int idClienteP, String nombrePlatillo, double costoPlatillo, String composicion) {
        this.idClienteP = idClienteP;
        this.nombrePlatillo = nombrePlatillo;
        this.costoPlatillo = costoPlatillo;
        this.composicion = composicion;
    }

    public Platillo(int idPlatillo) {
        this.idPlatillo = idPlatillo;
    }

    public int getIdPlatillo() {
        return idPlatillo;
    }

    public void setIdPlatillo(int idPlatillo) {
        this.idPlatillo = idPlatillo;
    }

    public int getIdClienteP() {
        return idClienteP;
    }

    public void setIdClienteP(int idClienteP) {
        this.idClienteP = idClienteP;
    }

    public String getNombrePlatillo() {
        return nombrePlatillo;
    }

    public void setNombrePlatillo(String nombrePlatillo) {
        this.nombrePlatillo = nombrePlatillo;
    }

    public double getCostoPlatillo() {
        return costoPlatillo;
    }

    public void setCostoPlatillo(double costoPlatillo) {
        this.costoPlatillo = costoPlatillo;
    }

    public String getComposicion() {
        return composicion;
    }

    public void setComposicion(String composicion) {
        this.composicion = composicion;
    }

    public int getIdMenu() {
        return idMenu;
    }

    public void setIdMenu(int idMenu) {
        this.idMenu = idMenu;
    }

    public ArrayList<Ingrediente> getIngredientes() {
        return ingredientes;
    }

    public void setIngredientes(ArrayList<Ingrediente> ingredientes) {
        this.ingredientes = ingredientes;
    }

    public void agregarIngrediente(Ingrediente ingrediente) {
        ingredientes.add(ingrediente);
    }

    public void eliminarIngrediente(int id) {

    }

    public int escribirPlatillo() {
        Connection conexion = null; // Creamos la conexión

        try {
            conexion = Conexion.getConnection(); // Establecemos la conexión
            if (conexion.getAutoCommit()) {
                conexion.setAutoCommit(false); // Quitamos el autocommit para la transacción
            }
            PlatilloDAO plat_management = new PlatilloDAO(conexion);
            plat_management.insertar(this);
            
            IngredienteDAO ing_management = new IngredienteDAO(conexion);
            for(Ingrediente ing: this.ingredientes){
                ing_management.insertar(ing);
                // Obteniendo el id del ingrediente y platillo
                plat_management.seleccionar_data(this);
                ing_management.seleccionar_por_data(ing);
                ing_management.insertar_en_agrega(this.idPlatillo, ing.getIdIngrediente());
            }            
            
            conexion.commit(); // Intentamos hacer el commit de todos los queries 
            System.out.println("Se ha hecho commit de la transaccion");

            return 0;

        } catch (SQLException ex) {

            ex.printStackTrace(System.out);
            System.out.println("Entramos al rollback");
            try {
                conexion.rollback(); // Si hubo algún error
            } catch (SQLException ex1) {
                ex1.printStackTrace(System.out);
            }

            return -1;
        }
    }
}
