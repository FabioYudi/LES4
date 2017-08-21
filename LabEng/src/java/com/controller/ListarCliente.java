/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.controller;

import com.entity.Cliente;
import com.persistence.ClienteDAO;
import java.io.IOException;
import java.io.Serializable;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.context.ExternalContext;
import javax.faces.context.FacesContext;
import javax.servlet.http.HttpServletRequest;

/**
 *
 * @author luizl
 */
@ManagedBean(name = "dtClientes")
@ViewScoped
public class ListarCliente implements Serializable {

    private List<Cliente> clientes;
    private ClienteDAO clienteDAO;

    @PostConstruct
    public void init() {
        clienteDAO = new ClienteDAO();
        clientes = clienteDAO.selecionar_tudo();
    }

    public List<Cliente> getClientes() {
        return clientes;
    }

    public void deleteCliente(String id) throws IOException {
        boolean resultado;
        if (clienteDAO != null) {
            resultado = clienteDAO.deleteById(id);
            if (resultado) {
                ExternalContext ec = FacesContext.getCurrentInstance().getExternalContext();
                ec.redirect(((HttpServletRequest) ec.getRequest()).getRequestURI());
            } else {
                addMessage("Erro", "Não foi possivel deletar !!!");
            }
        }
    }

    public void addMessage(String summary, String detail) {
        FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_INFO, summary, detail);
        FacesContext.getCurrentInstance().addMessage(null, message);
    }
}
