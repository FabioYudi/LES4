/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.query;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Lucas
 */

public class Conexao  {
    
    private static Connection conexao;
    private static final String url_conn = "jdbc:postgresql://localhost/banco";
    private static final String user = "postgres";
    private static final String senha = "123";

    public static Connection getConexao() 
    {
        if(conexao == null)
        {
            try
            {
                Class.forName("org.postgresql.Driver"); //carrega driver de conexão postgresql
                conexao = DriverManager.getConnection(url_conn, user, senha);
            } catch (SQLException ex) //algum erro de url, usuario ou senha
            {
                Logger.getLogger(Conexao.class.getName()).log(Level.SEVERE, null, ex);
            } catch (ClassNotFoundException ex) //erro no driver do postgre
            {
                    Logger.getLogger(Conexao.class.getName()).log(Level.SEVERE, null, ex);
            }            
        }
        return conexao;
    }
    
    public static void fecharConexao()
    {
        if(conexao != null)
        {
            try 
            {
                conexao.close();
            } catch (SQLException ex) { //erro na hora de fechar a conexao
                Logger.getLogger(Conexao.class.getName()).log(Level.SEVERE, null, ex);
            }
            conexao = null;
        }
    }

    
}
