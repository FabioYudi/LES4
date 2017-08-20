/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.controller;

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
public class EditCliente {
    private String Id;
    
    @PostConstruct
    public void init(){
        Map<String,String> map =  FacesContext.getCurrentInstance().getExternalContext().getRequestParameterMap();
        this.Id = map.get("id");
    }
    
    /**
     * Creates a new instance of EditCliente
     */
    public EditCliente() {
    }
    
    public void setId(String id){
        this.Id = id;
    }
    
    public String getId(){
        return Id;
    }
}
