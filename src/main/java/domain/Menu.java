package domain;


import datos.MenuDAO;
import datos.IngredienteDAO;
import datos.PlatilloDAO;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Menu {
    private String nombre;
    private int idRestaurante;
    private int idMenu;
    private ArrayList<Platillo> platillos = new ArrayList<Platillo>(); // Lista de platillos de cada menu
    
    public Menu(){
        
    }
    
    public Menu(Restaurante restaurante){
        this.nombre = restaurante.getNombre();
        this.idRestaurante = restaurante.getId();
    }
    
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setIdRestaurante(int idRestaurante) {
        this.idRestaurante = idRestaurante;
    }
    public void setPlatillos(ArrayList<Platillo> platillos) {
        this.platillos = platillos;
    }

    public String getNombre() {
        return nombre;
    }
    public int consultarIdMenu(){
        MenuDAO menu_management = new MenuDAO();
        Menu menu_temp = new Menu();
        try {
            menu_temp = menu_management.select_byId(this.idRestaurante);
        } catch (SQLException ex) {
            ex.printStackTrace(System.out);
            return -1;
        }
        
        this.idMenu = menu_temp.idMenu;
        return 0;
    }
    public int getIdMenu() {
        return idMenu;
    }
    public void setIdMenu(int id) {
        this.idMenu = id;
    }
    public int getIdRestaurante() {
        return idRestaurante;
    }
    public int leerPlatillos(){ // Lee los platillos del restaurante de la base de datos
        PlatilloDAO plat_management = new PlatilloDAO();
        try {
            this.platillos = plat_management.seleccionar_por(idMenu);
        } catch (SQLException ex) {
            Logger.getLogger(Menu.class.getName()).log(Level.SEVERE, null, ex);
        }
        for(Platillo plat: platillos){
            IngredienteDAO ing_management = new IngredienteDAO();
            plat.setIngredientes(ing_management.seleccionar_por_id(plat.getIdPlatillo()));
        }
        return 0;
    }
    public int agregarPlatillo(Platillo plat){ // Agrega un platillo a la lista en el menu
        
        return 0;
    }
    public int removerPlatillo(Platillo plat){ // Remueve un platillo de la lista en el menú
        
        return 0;
    }
    public ArrayList<Platillo> getPlatillos() {
        return platillos;
    }
    
    
}
