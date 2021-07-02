/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import static dao.UsuarioDao.conexao;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import model.Cliente;
import model.Usuario;

/**
 *
 * @author Dayana
 */
public class ClienteDAO {
    
   private static Connection conexao;

    public ClienteDAO(Connection conexao) {
        this.conexao = conexao;
    }
    
    public void inserirCliente(Cliente cliente) throws SQLException{
     
        String sql = "insert into cliente "
                + "(nome, sexo, estado_civil, endereco, complemento, bairro, cep, cidade, estado, numero, cpf, rg, telefone, celular, email, dt_nascimento, dt_cadastro) "
                + "values (?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,now())";
        
        PreparedStatement comando = conexao.prepareStatement(sql);
        comando.setString(1, cliente.getNome());
        comando.setString(2, String.valueOf(cliente.getSexo()));
        comando.setString(3, cliente.getEstadoCivil());
        comando.setString(4, cliente.getEndereco());
        comando.setString(5, cliente.getComplemento());
        comando.setString(6, cliente.getBairro());
        comando.setString(7, cliente.getCep());
        comando.setString(8, cliente.getCidade());
        comando.setString(9, cliente.getEstado());
        comando.setString(10, cliente.getNumero());
        comando.setString(11, cliente.getCpf());
        comando.setString(12, cliente.getRg());
        comando.setString(13, cliente.getTelefone());
        comando.setString(14, cliente.getCelular());
        comando.setString(15, cliente.getEmail());
        comando.setDate(16, new java.sql.Date(cliente.getDataNascimento().getTime()));
//        comando.setDate(17, new java.sql.Date(new Date().getTime()));// pega data e hora atuais
        comando.execute();
        
    }
    public boolean verificarEmailExistente(Cliente c) throws SQLException{
        String sql = "SELECT COUNT(*) AS resultado FROM cliente WHERE email = ?";
        PreparedStatement comando = conexao.prepareStatement(sql);
        comando.setString(1, c.getEmail());
        ResultSet resultado = comando.executeQuery();
        resultado.next();
        
        return resultado.getInt("resultado") > 0; // pode virar uma condição booleana
    } 

    public boolean verificarCpfExistente(Cliente c) throws SQLException{
        String sql = "SELECT COUNT(*) AS resultado FROM cliente WHERE cpf = ?";
        PreparedStatement comando = conexao.prepareStatement(sql);
        comando.setString(1, c.getCpf());
        ResultSet resultado = comando.executeQuery();
        resultado.next();
        
        return resultado.getInt("resultado") > 0;
    
    }
    
    public List<Cliente> consultarClientes(String nome) throws SQLException{
        String sql = "SELECT * FROM cliente WHERE nome like ? ";
        PreparedStatement comando = conexao.prepareStatement(sql);// recebe conexão com bd e recebe sql
        comando.setString(1, nome + '%');
        ResultSet cursor = comando.executeQuery();
        
        List<Cliente> lista = new ArrayList<>();
        while (cursor.next()){
            Cliente cliente = new Cliente();
            cliente.setCodigo(cursor.getInt("codigo"));
            cliente.setNome(cursor.getString("nome"));
            cliente.setEmail(cursor.getString("email"));
            cliente.setCpf(cursor.getString("cpf"));
            cliente.setEndereco(cursor.getString("endereco"));
            cliente.setSexo(cursor.getString("sexo"));
            cliente.setEstadoCivil(cursor.getString("estado_civil"));
            cliente.setComplemento(cursor.getString("complemento"));
            cliente.setBairro(cursor.getString("bairro"));
            cliente.setCep(cursor.getString("cep"));
            cliente.setCidade(cursor.getString("cidade"));
            cliente.setEstado(cursor.getString("estado"));
            cliente.setNumero(cursor.getString("numero"));
            cliente.setRg(cursor.getString("numero"));
            cliente.setTelefone(cursor.getString("telefone"));
            cliente.setCelular(cursor.getString("celular"));
            cliente.setDataNascimento(cursor.getDate("dt_nascimento"));
            cliente.setDataCadastro(cursor.getDate("dt_cadastro"));
            lista.add(cliente);
        }
        return lista;
    }
    
    public void excluir(Long codigo) throws SQLException{
        String sql = "delete from cliente where codigo=?";
        PreparedStatement comando = conexao.prepareStatement(sql);
        comando.setLong(1, codigo);
        comando.execute();
    }
    
    public void alterar(Cliente cli) throws SQLException{
        String sql = "update cliente set nome = ?, sexo = ?, estado_civil = ?, endereco = ?, complemento = ?, bairro = ?, "
                + " cep = ?, cidade = ?, estado = ?, rg = ?, cpf = ?, email = ?, telefone = ?, celular = ? where codigo = ?";
        PreparedStatement comando = conexao.prepareStatement(sql);
        comando.setString(1, cli.getNome());
        comando.setString(2, cli.getSexo());
        comando.setString(3, cli.getEstadoCivil());
        comando.setString(4, cli.getEndereco());
        comando.setString(5, cli.getComplemento());
        comando.setString(6, cli.getBairro());
        comando.setString(7, cli.getCep());
        comando.setString(8, cli.getCidade());
        comando.setString(9, cli.getEstado());
        comando.setString(10, cli.getRg());
        comando.setString(11, cli.getCpf());
        comando.setString(12, cli.getEmail());
        comando.setString(13, cli.getTelefone());
        comando.setString(14, cli.getCelular());
        comando.setInt(15, cli.getCodigo());
        System.out.println(cli.toString());
        comando.executeUpdate();
    }
   
}
