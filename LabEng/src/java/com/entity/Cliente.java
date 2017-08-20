/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.entity;

import com.query.ClienteDAO;
import java.util.ArrayList;
import java.util.List;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import org.primefaces.context.RequestContext;

/**
 *
 * @author Lucas
 */
@ManagedBean(name = "cliente")
@SessionScoped
public class Cliente {

    private String id;
    private String nome;
    private int idade;
    private String cpf;
    private String rg;
    private String rua;
    private int num_rua;
    private String cidade;
    private String estado;

    public Cliente() {
    }

    public Cliente(String id, String nome, int idade, String cpf, String rg, String rua,
            int num_rua, String cidade, String estado) {
        this.id = id;
        this.nome = nome;
        this.idade = idade;
        this.cpf = cpf;
        this.rg = rg;
        this.rua = rua;
        this.num_rua = num_rua;
        this.cidade = cidade;
        this.estado = estado;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public int getIdade() {
        return idade;
    }

    public void setIdade(int idade) {
        this.idade = idade;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public String getRg() {
        return rg;
    }

    public void setRg(String rg) {
        this.rg = rg;
    }

    public String getRua() {
        return rua;
    }

    public void setRua(String rua) {
        this.rua = rua;
    }

    public int getNum_rua() {
        return num_rua;
    }

    public void setNum_rua(int num_rua) {
        this.num_rua = num_rua;
    }

    public String getCidade() {
        return cidade;
    }

    public void setCidade(String cidade) {
        this.cidade = cidade;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public void adicionar() {
        ClienteDAO cli = new ClienteDAO();
        cli.inserir(this);
        RequestContext.getCurrentInstance().showMessageInDialog(
                new FacesMessage(FacesMessage.SEVERITY_INFO, "Cadastro", "Cliente cadastrado com sucesso")
        );
    }

    public void buscar() {
        ClienteDAO cli = new ClienteDAO();
        cli.buscar(this);
    }

    public void deletar() {

        ClienteDAO cli = new ClienteDAO();
        cli.deletar(this);
    }

    public List<String> complete(String query) {
        List<String> results = new ArrayList<String>();
        results.add("São Paulo");
        results.add("Rio de Janeiro");
        results.add("Amazonas");
        results.add("Bahia");
        results.add("Minas Gerais");

        return results;
    }

}
