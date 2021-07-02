/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package util;

import java.sql.Connection;
import java.sql.DriverManager;

/**
 *
 * @author Dayana
 */
public class ConnectionFactory {
    
    public static Connection getConection(){
	final String driver = "com.mysql.cj.jdbc.Driver";
	final String url = "jdbc:mysql://localhost:3306/curso?createDatabaseIfNotExist=true&useTimezone=true&serverTimezone=UTC";
	final String login = "root";
	final String senha = "123456";
	
	Connection conexao = null;
	
	try{
		Class.forName(driver);
		conexao = DriverManager.getConnection(url, login, senha);
	} catch (ClassNotFoundException e) {
		System.out.println("Driver não encontrado!");
	} catch (Exception e) {
		System.out.println("Erro durante a conexão");
	}
	return conexao;
}
    
}
