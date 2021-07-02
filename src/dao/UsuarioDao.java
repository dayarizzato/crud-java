/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import model.Usuario;

/**
 *
 * @author Dayana
 */
public class UsuarioDao {
    
    public static Connection conexao;
    
    public UsuarioDao(Connection conexao){
        this.conexao = conexao;
    }
    
    public boolean autenticar(Usuario user) throws SQLException{
        String sql = "SELECT COUNT(*) AS resultado FROM usuarios WHERE usuario = ? AND senha = ?";
        PreparedStatement comando = conexao.prepareStatement(sql);
        comando.setString(1, user.getUsuario());
        comando.setString(2, user.getSenha());
        ResultSet resultado = comando.executeQuery();
        resultado.next();
        
        return resultado.getInt("resultado") > 0; // pode virar uma condição booleana
    } 
}
