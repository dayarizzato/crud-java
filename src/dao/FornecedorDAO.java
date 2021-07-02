/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import com.sun.javafx.scene.control.skin.VirtualFlow;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import model.Cliente;
import model.Fornecedor;

/**
 *
 * @author Dayana
 */
public class FornecedorDAO {

    private Connection conexao;

    public FornecedorDAO(Connection conexao) {
        this.conexao = conexao;
    }

    public void inserirFornecedor(Fornecedor fornecedor) throws SQLException {
        String sql = "insert into fornecedor "
                + "(nome, cnpj, endereco, numero, bairro, complemento, cep, cidade, estado, telefone, celular, email) "
                + "values (?,?,?,?,?,?,?,?,?,?,?,?)";

        PreparedStatement comando = conexao.prepareStatement(sql);
        comando.setString(1, fornecedor.getNome());
        comando.setString(2, fornecedor.getCnpj());
        comando.setString(3, fornecedor.getEndereco());
        comando.setString(4, fornecedor.getNumero());
        comando.setString(5, fornecedor.getBairro());
        comando.setString(6, fornecedor.getComplemento());
        comando.setString(7, fornecedor.getCep());
        comando.setString(8, fornecedor.getCidade());
        comando.setString(9, fornecedor.getEstado());
        comando.setString(10, fornecedor.getTelefone());
        comando.setString(11, fornecedor.getCelular());
        comando.setString(12, fornecedor.getEmail());
        comando.execute();
    }

    public boolean verificarEmailExistente(Fornecedor f) throws SQLException {
        String sql = "SELECT COUNT(*) AS resultado FROM fornecedor WHERE email = ?";
        PreparedStatement comando = conexao.prepareStatement(sql);
        comando.setString(1, f.getEmail());
        ResultSet resultado = comando.executeQuery();
        resultado.next();

        return resultado.getInt("resultado") > 0; // pode virar uma condição booleana
    }

    public boolean verificarCpfExistente(Fornecedor f) throws SQLException {
        String sql = "SELECT COUNT (*) AS resultado FROM fornecedor WHERE email = ?";
        PreparedStatement comando = conexao.prepareStatement(sql);
        comando.setString(1, f.getEmail());
        ResultSet resultado = comando.executeQuery();
        resultado.next();
        return resultado.getInt("resultado") > 0;

    }

    public List<Fornecedor> consultarFornecedor(String nome) throws SQLException {
        String sql = "SELECT * FROM fornecedor WHERE nome like ?";
        PreparedStatement comando = conexao.prepareStatement(sql);
        comando.setString(1, nome + '%');
        ResultSet cursor = comando.executeQuery();

        List<Fornecedor> lista = new ArrayList<>();

        while (cursor.next()) {
            Fornecedor fornecedor = new Fornecedor();
            fornecedor.setCodigo(cursor.getInt("codigo"));
            fornecedor.setNome(cursor.getString("nome"));
            fornecedor.setCnpj(cursor.getString("cnpj"));
            fornecedor.setEndereco(cursor.getString("endereco"));
            fornecedor.setNumero(cursor.getString("numero"));
            fornecedor.setBairro(cursor.getString("bairro"));
            fornecedor.setComplemento(cursor.getString("complemento"));
            fornecedor.setCep(cursor.getString("cep"));
            fornecedor.setCidade(cursor.getString("cidade"));
            fornecedor.setEstado(cursor.getString("estado"));
            fornecedor.setTelefone(cursor.getString("telefone"));
            fornecedor.setCelular(cursor.getString("celular"));
            fornecedor.setEmail(cursor.getString("email"));
            lista.add(fornecedor);
        }
        return lista;
    }

    public void excluir(Long codigo) throws SQLException {
        String sql = "delete from fornecedor where codigo= ? ";
        PreparedStatement comando = conexao.prepareStatement(sql);
        comando.setLong(1, codigo);
        comando.execute();
    }

    public void atualizar(Fornecedor f) throws SQLException {
        String sql = "update fornecedor set nome = ?, cnpj = ?, endereco = ?, numero = ?, bairro = ?, complemento = ?, cep = ?, "
                + "cidade = ?, estado = ?, telefone = ?, celular = ?, email = ? where codigo = ?";
        PreparedStatement comando = conexao.prepareStatement(sql);
        comando.setString(1, f.getNome());
        comando.setString(2, f.getCnpj());
        comando.setString(3, f.getEndereco());
        comando.setString(4, f.getNumero());
        comando.setString(5, f.getBairro());
        comando.setString(6, f.getComplemento());
        comando.setString(7, f.getCep());
        comando.setString(8, f.getCidade());
        comando.setString(9, f.getEstado());
        comando.setString(10, f.getTelefone());
        comando.setString(11, f.getCelular());
        comando.setString(12, f.getEmail());
        comando.setInt(13, f.getCodigo());
        comando.executeUpdate();

    }

    public List<Fornecedor> listarTodosRetornaNomes() throws SQLException {
        String sql = "SELECT * FROM fornecedor ";
        PreparedStatement comando = conexao.prepareStatement(sql);
        ResultSet cursor = comando.executeQuery();

        List<Fornecedor> lista = new ArrayList<>();

        while (cursor.next()) {
            Fornecedor fornecedor = new Fornecedor();
            fornecedor.setCodigo(cursor.getInt("codigo"));
            fornecedor.setNome(cursor.getString("nome"));
            lista.add(fornecedor);
        }
        return lista;
    }

    public Integer buscarPorNome(String nome) throws SQLException {
        String sql = "select codigo from fornecedor where nome = ?";
        PreparedStatement comando = conexao.prepareStatement(sql);
        comando.setString(1, nome);
        ResultSet cursor = comando.executeQuery();
        cursor.next();
        return cursor.getInt("codigo");
        
    }
}
