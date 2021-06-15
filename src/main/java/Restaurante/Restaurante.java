package Restaurante;

import Comun.Usuario;


public class Restaurante extends Usuario{
    private int id;
    private String contrasena;
    private String direccion;
    
    public void crearMenu(){
        
    }
    public void eliminar(){
        
    }
    public void editarMenu(){
        
    }

    public String getDireccion() {
        return this.direccion;
    }
    
    private class Empleado{
        private int idEmpleado;        
        private String contrasenaEmpleado;
    }
}
