/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package test;

import datos.ClienteDAO;
import domain.Cliente;
import java.util.List;


public class TestManejoCliente {
    public static void main(String[] args) {
        ClienteDAO clienteDao = new ClienteDAO();
        List<Cliente> clientes = clienteDao.seleccionar();
        clientes.forEach(cliente -> {//"cliente" alamacena almacena cada cliente que se tenga la lista "clientes" 
            System.out.println("cliente = " + cliente);
        });
    }
}
