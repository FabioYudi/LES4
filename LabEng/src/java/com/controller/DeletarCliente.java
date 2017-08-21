/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.controller;

import com.entity.Cliente;
import com.persistence.ClienteDAO;
import java.util.Map;
import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.context.FacesContext;

/**
 *
 * @author luizl
 */
@ManagedBean
@RequestScoped
public class DeletarCliente {
    private Cliente cliente;
    private String Id;
    
    @PostConstruct
    public void init(){
        Map<String,String> map =  FacesContext.getCurrentInstance().getExternalContext().getRequestParameterMap();
        this.Id = map.get("id");
        ClienteDAO clienteDAO = new ClienteDAO();
        clienteDAO.getClienteById(this.Id);
    }
    
    public Cliente getCliente(){
        return cliente;
    }
}
