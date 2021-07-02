/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import com.mysql.cj.xdevapi.PreparableStatement;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import model.Cliente;
import model.Fornecedor;
import model.Produto;

/**
 *
 * @author Dayana
 */
public class ProdutoDao {

    private Connection conexao;

    public ProdutoDao(Connection conexao) {
        this.conexao = conexao;
    }

    public void inserirProduto(Produto produto) throws SQLException {
        String sql = "insert into produtos" + "(codigo, qtd_estoque, desc_produto, cod_fornecedor, preco_custo, preco_venda,"
                + "observacao, dt_cad_prod)" + "values (?,?,?,?,?,?,?,now())";

        PreparedStatement comando = conexao.prepareStatement(sql);
        comando.setString(1, produto.getCodigo());
        comando.setInt(2, produto.getQtdestoque());
        comando.setString(3, produto.getDescProduto());
        comando.setInt(4, produto.getFornecedor().getCodigo());
        comando.setDouble(5, produto.getPrecoCusto());
        comando.setDouble(6, produto.getPrecoVenda());
        comando.setString(7, produto.getObservacao());

        comando.execute();

    }

    public List<Produto> consultarProdutos(String nome) throws SQLException {
        String sql = "SELECT p.id , p.codigo, p.desc_produto, p.preco_venda,p.preco_custo, p.qtd_estoque, p.observacao, p.dt_cad_prod, p.cod_fornecedor, f.nome\n" +
            "FROM produtos p \n" +
            "INNER JOIN fornecedor f\n" +
            "ON (f.codigo = p.cod_fornecedor) WHERE p.desc_produto like ? ";
        PreparedStatement comando = conexao.prepareStatement(sql);
        comando.setString(1, nome + '%');
        ResultSet cursor = comando.executeQuery();

        List<Produto> lista = new ArrayList<>();
        while (cursor.next()) {
            Produto produto = new Produto();
            produto.setId(cursor.getInt("id"));
            produto.setCodigo(cursor.getString("codigo"));
            produto.setQtdestoque(cursor.getInt("qtd_estoque"));
            produto.setDescProduto(cursor.getString("desc_produto"));
            Fornecedor fornecedor = new Fornecedor();
            produto.setFornecedor(fornecedor);
            produto.getFornecedor().setCodigo(cursor.getInt("cod_fornecedor"));
            produto.getFornecedor().setNome(cursor.getString("nome"));
            produto.setPrecoCusto(cursor.getDouble("preco_custo"));
            produto.setPrecoVenda(cursor.getDouble("preco_venda"));
            produto.setDtCadProd(cursor.getDate("dt_cad_prod"));
            lista.add(produto);

        }
        return lista;
    }
    public void alterar(Produto produto) throws SQLException{
        String sql = "update produtos set codigo = ?, qtd_estoque = ?, desc_produto = ?, preco_custo = ?, preco_venda = ?, observacao = ? where id = ?";
        PreparedStatement comando = conexao.prepareStatement(sql);
        comando.setString(1, produto.getCodigo());
        comando.setInt(2, produto.getQtdestoque());
        comando.setString(3, produto.getDescProduto());
        comando.setDouble(4, produto.getPrecoCusto());
        comando.setDouble(5, produto.getPrecoVenda());
        comando.setString(6, produto.getObservacao());
        comando.setInt(7, produto.getId());
        comando.executeUpdate();
    }
    public void excluir(Long codigo) throws SQLException{
        String sql = "delete from produtos where codigo=?";
        PreparedStatement comando = conexao.prepareStatement(sql);
        comando.setLong(1, codigo);
        comando.execute();
    }
    public boolean verificarCodigoExistente(Produto p) throws SQLException{
        String sql = "SELECT COUNT(*) AS resultado FROM produtos WHERE codigo = ?";
        PreparedStatement comando = conexao.prepareStatement(sql);
        comando.setString(1, p.getCodigo());
        ResultSet resultado = comando.executeQuery();
        resultado.next();
        
        return resultado.getInt("resultado") > 0;
    
    }
        
}
