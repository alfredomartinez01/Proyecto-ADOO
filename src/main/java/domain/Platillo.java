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
    private int idMenu;
    private String nombrePlatillo;
    private double costoPlatillo;
    private String composicion;
    private int tipo;
    private ArrayList<Ingrediente> ingredientes = new ArrayList<Ingrediente>();

    public Platillo() {
    }

    public Platillo(int idPlatillo, int idClienteP, String nombrePlatillo, double costoPlatillo, String composicion) {
        this.idPlatillo = idPlatillo;
        this.nombrePlatillo = nombrePlatillo;
        this.costoPlatillo = costoPlatillo;
        this.composicion = composicion;
    }

    public Platillo(int idClienteP, String nombrePlatillo, double costoPlatillo, String composicion) {
        this.nombrePlatillo = nombrePlatillo;
        this.costoPlatillo = costoPlatillo;
        this.composicion = composicion;
    }
    
    public Platillo(int idPlatillo) {
        this.idPlatillo = idPlatillo;
    }
    public void copiar(Platillo plat){
        this.composicion = plat.composicion;
        this.costoPlatillo = plat.costoPlatillo;
        this.idMenu = plat.idMenu;
        this.idPlatillo = plat.idPlatillo;
        this.ingredientes = plat.ingredientes;
        this.nombrePlatillo = plat.nombrePlatillo;
        this.tipo = plat.tipo;
    }
    public int getIdPlatillo() {
        return idPlatillo;
    }

    public void setIdPlatillo(int idPlatillo) {
        this.idPlatillo = idPlatillo;
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

    public int getTipo() {
        return tipo;
    }

    public void setIdMenu(int idMenu) {
        this.idMenu = idMenu;
    }

    public ArrayList<Ingrediente> getIngredientes() {
        return ingredientes;
    }

    public void setIngredientes(ArrayList<Ingrediente> ingredientes) {
        this.ingredientes = new ArrayList<Ingrediente>();
        for(Ingrediente ing: ingredientes){
            this.ingredientes.add(ing.get());
        }
    }

    public void agregarIngrediente(Ingrediente ingrediente) {
        ingredientes.add(ingrediente);
    }

    public void eliminarIngrediente(Ingrediente ingrediente) {
        if (this.ingredientes.size() > 0) {
            for (Ingrediente ing : this.ingredientes) {
                // Si no coincide con el ingrediente
                if (ingrediente.getNombreIngrediente().equals(ing.getNombreIngrediente()) && ingrediente.getCostoIngrediente() == ing.getCostoIngrediente()) {
                    this.ingredientes.remove(ing);
                }
            }
        }

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
            for (Ingrediente ing : this.ingredientes) {
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

    public int actualizarPlatillo() {
        Connection conexion = null; // Creamos la conexión

        try {
            conexion = Conexion.getConnection(); // Establecemos la conexión
            if (conexion.getAutoCommit()) {
                conexion.setAutoCommit(false); // Quitamos el autocommit para la transacción
            }
            PlatilloDAO plat_management = new PlatilloDAO(conexion);
            plat_management.actualizar(this);

            // Comprobando los platillos que no estan en el menu ahora
            IngredienteDAO ing_management = new IngredienteDAO(conexion);
            ArrayList<Ingrediente> ing_en_db = ing_management.seleccionar_agrega(this.idPlatillo);

            for (Ingrediente ing : this.ingredientes) {

                for (Ingrediente ing_db : ing_en_db) {
                    if (ing_db.getIdIngrediente() == ing.getIdIngrediente()) {
                        ing_en_db.remove(ing_db);
                        break;
                    }

                }

            }
            // Eliminando esos ingredientes eliminados
            for (Ingrediente ing : ing_en_db) {
                ing_management.eliminar(ing);
            }

            // Actualizando o insertando ingredientes
            for (Ingrediente ing : this.ingredientes) {
                if (ing.getIdIngrediente() != 0) {
                    ing_management.actualizar(ing);
                } else {
                    ing_management.insertar(ing);
                    // Obteniendo el id del ingrediente y platillo
                    ing_management.seleccionar_por_data(ing);
                    ing_management.insertar_en_agrega(this.idPlatillo, ing.getIdIngrediente());
                }

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

    public int eliminarPlatillo() {
        Connection conexion = null; // Creamos la conexión

        try {
            conexion = Conexion.getConnection(); // Establecemos la conexión
            if (conexion.getAutoCommit()) {
                conexion.setAutoCommit(false); // Quitamos el autocommit para la transacción
            }
            PlatilloDAO plat_management = new PlatilloDAO(conexion);
            plat_management.eliminar(this);

            IngredienteDAO ing_management = new IngredienteDAO(conexion);
            for (Ingrediente ing : this.getIngredientes()) {
                ing_management.eliminar(ing);
                //System.out.println(ing);
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
