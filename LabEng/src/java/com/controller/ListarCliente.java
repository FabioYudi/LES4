/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.controller;

import com.entity.Cliente;
import com.query.ClienteDAO;
import java.io.Serializable;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import java.util.List;
import javax.annotation.PostConstruct;

/**
 *
 * @author luizl
 */
@ManagedBean(name = "dtClientes")
@ViewScoped
public class ListarCliente implements Serializable{

    private List<Cliente> clientes;
    
    @PostConstruct
    public void init(){
        ClienteDAO clienteDAO = new  ClienteDAO();
        clientes = clienteDAO.selecionar_tudo();
    }
    
    public List<Cliente> getClientes(){
        return clientes;
    }
}