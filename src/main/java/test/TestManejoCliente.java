/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package test;

import datos.ClienteDAO;
import datos.IngredienteDAO;
import datos.OrdenDAO;
import domain.Cliente;
import domain.Ingrediente;
import domain.Orden;
import java.text.*;
import java.util.Date;
import java.util.List;


public class TestManejoCliente {
    public static void main(String[] args) {
        IngredienteDAO ingredienteDao = new IngredienteDAO();
        OrdenDAO ordenDao = new OrdenDAO();
        
        //Insertando un nuevo objeto de tipo Cliente
        
        //Cliente clienteN = new Cliente("Geovanni");//AGREGAMOS 
        //clienteDao.insertar(clienteN);//MANDAMOS AL METODO INSERTAR 
        
        //Modificar un objeto de persona existente
        //Cliente clienteModificar = new Cliente(452,"Juan");
        //clienteDao.actualizar(clienteModificar);
        
        //Eliminar
        /*Cliente clienteEliminar = new Cliente(452);
        clienteDao.eliminar(clienteEliminar);*/
        List<Ingrediente> ingredientes = ingredienteDao.seleccionar();
        ingredientes.forEach(ingrediente -> {//"cliente" alamacena almacena cada cliente que se tenga la lista "clientes" 
            System.out.println("cliente = " + ingrediente);
        });
        
        List<Orden> ordenes = ordenDao.seleccionar();
        ordenes.forEach(orden -> {//"cliente" alamacena almacena cada cliente que se tenga la lista "clientes" 
            System.out.println("cliente = " + orden);
        });
    }
}



/*Date fecha = new Date();
        System.out.println(fecha);
        DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd");
        System.out.println("Fecha: "+dateFormat.format(fecha));
        
        DateFormat hourFormat = new SimpleDateFormat("HH:mm:ss");
        System.out.println("Hora: "+hourFormat.format(fecha));*/