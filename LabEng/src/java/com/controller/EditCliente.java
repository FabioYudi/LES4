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
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.context.FacesContext;
import org.primefaces.context.RequestContext;

/**
 *
 * @author luizl
 */
@ManagedBean(name = "editarView")
@RequestScoped
public class EditCliente {

    private String Id;
    private Cliente cliente;
    private ClienteDAO clienteDAO;

    @PostConstruct
    public void init() {
        Map<String, String> map = FacesContext.getCurrentInstance().getExternalContext().getRequestParameterMap();
        this.Id = map.get("id");
        this.clienteDAO = new ClienteDAO();
        this.cliente = clienteDAO.getClienteById(this.Id);
    }

    public Cliente getCliente() {
        return this.cliente;
    }

    public void editar() {
        if (this.clienteDAO.updateCliente(this.cliente)) {
            RequestContext.getCurrentInstance().showMessageInDialog(
                    new FacesMessage(FacesMessage.SEVERITY_INFO, "Editar", "Cliente editado com sucesso")
            );
        }else{
            RequestContext.getCurrentInstance().showMessageInDialog(
                    new FacesMessage(FacesMessage.SEVERITY_ERROR, "Editar", "Não foi possivel editar o cliente")
            );
        }
    }
}
