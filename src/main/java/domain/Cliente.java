/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package domain;

/**
 *
 * Esta clase se utilizara para la modificar , agregar y elimnar algun registro de la TABLA CLIENTE
 */
public class Cliente {
    
    private int idCliente;
    private String nombreCliente;

    public Cliente() {
    }
    /*Este contructor lo utilizaremos para eliminar un dato de la tabla cliente
    debido a que basta con eliminar el id para eliminar un registro*/
    public Cliente(int idCliente) {
        this.idCliente = idCliente;
    }
    
    /*Este constructor se utlizara para agregar un registro
    no se necesita el id ya que este es autoincrementable*/
    public Cliente(String nombreCliente) {
        this.nombreCliente = nombreCliente;
    }
    
    /*Este contructor se utilizara para la modificacion de datos*/

    public Cliente(int idCliente, String nombreCliente) {
        this.idCliente = idCliente;
        this.nombreCliente = nombreCliente;
    }

    public int getIdCliente() {
        return idCliente;
    }

    public void setIdCliente(int idCliente) {
        this.idCliente = idCliente;
    }

    public String getNombreCliente() {
        return nombreCliente;
    }

    public void setNombreCliente(String nombreCliente) {
        this.nombreCliente = nombreCliente;
    }
    /*toString para saber el estado del objeto en cualquier momento*/
    @Override
    public String toString() {
        return "Cliente{" + "idCliente=" + idCliente + ", nombreCliente=" + nombreCliente + '}';
    }
    
    
    
    
    
    
    
    
}
