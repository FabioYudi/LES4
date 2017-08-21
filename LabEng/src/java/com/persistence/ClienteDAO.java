/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.persistence;

import com.entity.Cliente;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.List;
import java.util.ArrayList;

/**
 *
 * @author Lucas
 */
public class ClienteDAO {

    public void inserir(Cliente cliente) {
        try {
            Connection conexao = Conexao.getConexao();
            PreparedStatement ps = conexao.prepareStatement("INSERT INTO public.CLIENTE (NOME, IDADE, CPF, RG, RUA, NUM_RUA, CIDADE, ESTADO) VALUES (?,?,?,?,?,?,?,?)");

            //O prepared statement substitui os "?" da query acima com os valores abaixo
            ps.setString(1, cliente.getNome());
            ps.setInt(2, cliente.getIdade());
            ps.setString(3, cliente.getCpf());
            ps.setString(4, cliente.getRg());
            ps.setString(5, cliente.getRua());
            ps.setInt(6, cliente.getNum_rua());
            ps.setString(7, cliente.getCidade());
            ps.setString(8, cliente.getEstado());

            ps.execute();
            Conexao.fecharConexao();
        } catch (SQLException ex) { //erro de sql
            Logger.getLogger(ClienteDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void buscar(Cliente cliente) {
        try {
            Connection conexao = Conexao.getConexao();
            PreparedStatement ps = conexao.prepareStatement("SELECT * FROM CLIENTE WHERE NOME = '" + cliente.getNome() + "'");
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                cliente.setIdade(rs.getInt("IDADE"));
                cliente.setCpf(rs.getString("CPF"));
                cliente.setRg(rs.getString("RG"));
                cliente.setRua(rs.getString("RUA"));
                cliente.setNum_rua(rs.getInt("NUM_RUA"));
                cliente.setCidade(rs.getString("CIDADE"));
                cliente.setEstado(rs.getString("ESTADO"));
            }
            Conexao.fecharConexao();
        } catch (SQLException ex) {
            Logger.getLogger(ClienteDAO.class.getName()).log(Level.SEVERE, null, ex);
            Conexao.fecharConexao();
        }
    }
    
    public Cliente getClienteById(String id){
        Cliente cliente = new Cliente();
        try{
            Connection conexao = Conexao.getConexao();
            PreparedStatement ps = conexao.prepareStatement("SELECT id, nome, idade, cpf, rg, rua, num_rua, cidade, estado FROM cliente where id = " + id);
            ResultSet rs = ps.executeQuery();
            if(rs.next()){
                cliente.setId(rs.getInt("id") + "");
                cliente.setNome(rs.getString("nome"));
                cliente.setIdade(rs.getInt("idade"));
                cliente.setCpf(rs.getString("cpf"));
                cliente.setRg(rs.getString("rg"));
                cliente.setRua(rs.getString("rua"));
                cliente.setNum_rua(rs.getInt("num_rua"));
                cliente.setCidade(rs.getString("cidade"));
                cliente.setEstado(rs.getString("estado"));
            }
            Conexao.fecharConexao();
            return cliente;
        }catch(SQLException ex){
            Conexao.fecharConexao();
            return cliente;
        }
    }

    public void deletar(Cliente cliente) {
        try {
            Connection conexao = Conexao.getConexao();
            PreparedStatement ps = conexao.prepareStatement("DELETE FROM CLIENTE WHERE NOME = '" + cliente.getNome() + "'");
            ps.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(ClienteDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        Conexao.fecharConexao();

    }
    
    public boolean deleteById(String id){
        try {
            Connection conexao = Conexao.getConexao();
            PreparedStatement ps = conexao.prepareStatement("DELETE FROM CLIENTE WHERE id = " + id);
            ps.executeUpdate();
            Conexao.fecharConexao();
            return true;
        } catch (SQLException ex) {
            Logger.getLogger(ClienteDAO.class.getName()).log(Level.SEVERE, null, ex);
            Conexao.fecharConexao();
            return false;
        }
    }

    public List<Cliente> selecionar_tudo() {
        List<Cliente> clientes = new ArrayList<>();
        try {
            Connection conexao = Conexao.getConexao();
            PreparedStatement ps = conexao.prepareStatement("SELECT * FROM cliente");
            ResultSet rs = ps.executeQuery();
            Cliente cliente;
            while (rs.next()) {
                cliente = new Cliente();
                cliente.setId(rs.getInt("id") + "");
                cliente.setNome(rs.getString("nome"));
                cliente.setCpf(rs.getString("cpf"));
                cliente.setRg(rs.getString("rg"));
                cliente.setRua(rs.getString("rua"));
                cliente.setNum_rua(rs.getInt("num_rua"));
                cliente.setCidade(rs.getString(("cidade")));
                cliente.setEstado(rs.getString("estado"));
                cliente.setIdade(rs.getInt("idade"));
                clientes.add(cliente);
            }
            Conexao.fecharConexao();
            return clientes;
        } catch (SQLException ex) {
            Logger.getLogger(ClienteDAO.class.getName()).log(Level.SEVERE, null, ex);
            Conexao.fecharConexao();
            return clientes;
        }

    }
    
    public boolean updateCliente(Cliente cliente){
        try{
            Connection conexao = Conexao.getConexao();
            PreparedStatement ps = conexao.prepareStatement("UPDATE cliente SET nome=?, idade=?, cpf=?, rg=?, rua=?, num_rua=?, cidade=?,estado=? WHERE id=?");
            ps.setString(1, cliente.getNome());
            ps.setInt(2, cliente.getIdade());
            ps.setString(3, cliente.getCpf());
            ps.setString(4, cliente.getRg());
            ps.setString(5, cliente.getRua());
            ps.setInt(6, cliente.getNum_rua());
            ps.setString(7, cliente.getCidade());
            ps.setString(8, cliente.getEstado());
            ps.setInt(9, Integer.parseInt(cliente.getId()));
            return !ps.execute();
        }catch(SQLException ex){
            Logger.getLogger(ClienteDAO.class.getName()).log(Level.SEVERE, null, ex);
            Conexao.fecharConexao();
            return false;
        }
    }
}
