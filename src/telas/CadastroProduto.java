/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package telas;

import dao.ClienteDAO;
import dao.FornecedorDAO;
import dao.ProdutoDao;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.SQLException;
import java.text.DecimalFormat;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import model.Cliente;
import model.Fornecedor;
import model.Produto;
import util.ConnectionFactory;

/**
 *
 * @author Dayana
 */
public class CadastroProduto extends javax.swing.JFrame {

    public Produto produto;

    /**
     * Creates new form TelaProduto
     */
    public CadastroProduto(Produto produto) {
        this.produto = produto;
        this.initComponents();

        txtCodigo.setText(produto.getCodigo());
        txtQtdEstoque.setText(String.valueOf(produto.getQtdestoque()));
        txtDescProduto.setText(String.valueOf(produto.getDescProduto()));
        txtCusto.setText(String.valueOf(produto.getPrecoCusto()));
        txtVenda.setText(String.valueOf(produto.getPrecoVenda()));
        txtObservacao.setText(produto.getObservacao());
        comboFornecedor.addItem(produto.getFornecedor().getNome());
        comboFornecedor.setEnabled(false);

    }

    public CadastroProduto() {
        try {
            initComponents();

            Connection bd = ConnectionFactory.getConection();
            FornecedorDAO dao = new FornecedorDAO(bd);
            List<Fornecedor> lista = dao.listarTodosRetornaNomes();

            lista.stream().forEach(f -> {
                comboFornecedor.addItem(f.getNome());
            });

            bd.close();

        } catch (SQLException ex) {
            Logger.getLogger(CadastroProduto.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

//    public CadastroProduto(Produto produto){
//        this.produto = new produto;
//        this.initComponents();
//        
//       produto.setCodigo(txtCodigo.getText());
//       produto.setQtdestoque(Integer.valueOf(txtQtdEstoque.getText()));
//       produto.setDescProduto(txtDescProduto.getText());
//       produto.setCodFornecedor(1);
//       produto.setPrecoCusto(Double.valueOf(txtCusto.getText().replace(",", ".")));
//       produto.setPrecoVenda(Double.valueOf(txtVenda.getText().replace(",", ".")));
//       produto.setObservacao(txtObservacao.getText());
//          
//        
//        
//    }
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */

    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        txtCodigo = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        txtQtdEstoque = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        txtDescProduto = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        comboFornecedor = new javax.swing.JComboBox();
        jLabel6 = new javax.swing.JLabel();
        txtCusto = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();
        txtVenda = new javax.swing.JTextField();
        jPanel2 = new javax.swing.JPanel();
        radioLucro = new javax.swing.JRadioButton();
        comboLucro = new javax.swing.JComboBox();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        txtObservacao = new javax.swing.JTextField();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("..::: Cadastro de Produtos :::..");

        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder("Dados do Produto"));

        jLabel2.setText("Código:*");

        jLabel1.setText("Quantidade em estoque:*");

        jLabel3.setText("Descrição do Produto:*");

        jLabel5.setText("Fornecedor:*");

        jLabel6.setText("Preço de Custo:*");

        jLabel7.setText("Preço de Venda:*");

        jPanel2.setBorder(javax.swing.BorderFactory.createTitledBorder("Deseja calcular % do produto?"));

        radioLucro.setText("Calcular % do  lucro");
        radioLucro.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                radioLucroActionPerformed(evt);
            }
        });

        comboLucro.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "5", "10", "20", "30", "40", "50", "60", "70", "80", "90", "100", "200", "300", "500" }));
        comboLucro.addPropertyChangeListener(new java.beans.PropertyChangeListener() {
            public void propertyChange(java.beans.PropertyChangeEvent evt) {
                comboLucroPropertyChange(evt);
            }
        });

        jLabel8.setText("%");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(radioLucro)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(comboLucro, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel8)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(radioLucro)
                    .addComponent(comboLucro, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel8))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jLabel9.setText("Observação:");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel2)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtCodigo, javax.swing.GroupLayout.PREFERRED_SIZE, 129, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jLabel1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtQtdEstoque, javax.swing.GroupLayout.PREFERRED_SIZE, 135, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel3)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtDescProduto))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel5)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(comboFornecedor, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel1Layout.createSequentialGroup()
                                .addComponent(jLabel7)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(txtVenda))
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel1Layout.createSequentialGroup()
                                .addComponent(jLabel6)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(txtCusto, javax.swing.GroupLayout.PREFERRED_SIZE, 124, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel9)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtObservacao)))
                .addContainerGap(34, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(txtCodigo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel1)
                    .addComponent(txtQtdEstoque, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(txtDescProduto, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(36, 36, 36)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(comboFornecedor, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel6)
                            .addComponent(txtCusto, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel7)
                            .addComponent(txtVenda, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(15, 15, 15)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel9)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addComponent(txtObservacao, javax.swing.GroupLayout.DEFAULT_SIZE, 119, Short.MAX_VALUE))
                .addContainerGap())
        );

        jButton1.setText("Cadastrar");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jButton2.setText("Limpar Campos");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        jButton3.setText("Cancelar");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
            .addGroup(layout.createSequentialGroup()
                .addGap(92, 92, 92)
                .addComponent(jButton1)
                .addGap(37, 37, 37)
                .addComponent(jButton2)
                .addGap(42, 42, 42)
                .addComponent(jButton3)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(32, 32, 32)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton1)
                    .addComponent(jButton2)
                    .addComponent(jButton3))
                .addContainerGap(48, Short.MAX_VALUE))
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        try {
            Connection bd = ConnectionFactory.getConection();
            ProdutoDao produtoDao = new ProdutoDao(bd);
            FornecedorDAO fdao = new FornecedorDAO(bd);

            if (produto == null) {
                produto = new Produto();
                produto.setCodigo(txtCodigo.getText());
                produto.setQtdestoque(Integer.valueOf(txtQtdEstoque.getText()));
                produto.setDescProduto(txtDescProduto.getText());
                Fornecedor fornecedor = new Fornecedor();// uso qdo tenho um objeto dentro de outro objeto - relacionamentos(produto-fornecedor)
                fornecedor.setCodigo(fdao.buscarPorNome(comboFornecedor.getSelectedItem().toString()));
                produto.setFornecedor(fornecedor);
                produto.setPrecoCusto(Double.valueOf(txtCusto.getText().replace(",", ".")));
                produto.setPrecoVenda(Double.valueOf(txtVenda.getText().replace(",", ".")));
                produto.setObservacao(txtObservacao.getText());

                String msg = validarCampos(produto);

                if (!msg.equals("")) {// comparação de dados de uma string
                    JOptionPane.showMessageDialog(null, msg);
                    return;
                }

                if (produtoDao.verificarCodigoExistente(produto)) {
                    JOptionPane.showMessageDialog(null, "Código já existe, digite novamente!");
                    produto = null;
                } else {

                    produtoDao.inserirProduto(produto);
                    JOptionPane.showMessageDialog(null, "Cadastrado com sucesso!");

                    bd.close();
                    limparCampos();
                    produto= null;
                }
            } else {
                produto.setCodigo(txtCodigo.getText());
                produto.setQtdestoque(Integer.valueOf(txtQtdEstoque.getText()));
                produto.setDescProduto(txtDescProduto.getText());
                Fornecedor fornecedor = new Fornecedor();// uso qdo tenho um objeto dentro de outro objeto - relacionamentos(produto-fornecedor)
                fornecedor.setCodigo(fdao.buscarPorNome(comboFornecedor.getSelectedItem().toString()));
                produto.setFornecedor(fornecedor);
                produto.setPrecoCusto(Double.valueOf(txtCusto.getText().replace(",", ".")));
                produto.setPrecoVenda(Double.valueOf(txtVenda.getText().replace(",", ".")));
                produto.setObservacao(txtObservacao.getText());
                produtoDao.alterar(produto);
                JOptionPane.showMessageDialog(null, "Produto alterado com sucesso!");
                bd.close();
                new ConsultaProduto().setVisible(true);
                dispose();
            }
        } catch (SQLException ex) {
            Logger.getLogger(CadastroProduto.class.getName()).log(Level.SEVERE, null, ex);

        }
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        this.limparCampos();
    }//GEN-LAST:event_jButton2ActionPerformed

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        System.exit(0);
    }//GEN-LAST:event_jButton3ActionPerformed

    private void radioLucroActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_radioLucroActionPerformed
        // TODO add your handling code here:

    }//GEN-LAST:event_radioLucroActionPerformed

    private void comboLucroPropertyChange(java.beans.PropertyChangeEvent evt) {//GEN-FIRST:event_comboLucroPropertyChange
        if (radioLucro.isSelected()) {
            DecimalFormat decimalFormat = new DecimalFormat();
            double custo = Double.parseDouble(txtCusto.getText());
            double qtdporcentagem = Double.parseDouble(comboLucro.getSelectedItem().toString());
            double calculo = custo + ((qtdporcentagem / 100) * custo);
            String string = decimalFormat.format(calculo).replace(",", ".");
            txtVenda.setText(string);
        }
    }//GEN-LAST:event_comboLucroPropertyChange

    /**
     * @param args the command line arguments
     */
    public void limparCampos() {
        txtCodigo.setText("");
        txtQtdEstoque.setText("");
        txtDescProduto.setText("");
        comboFornecedor.setSelectedIndex(0);
        txtCusto.setText("");
        txtVenda.setText("");
        txtObservacao.setText("");
    }

    public String validarCampos(Produto prod) {
        String msgRetorno = "";

        if (prod.getCodigo().equals("")) {
            return "Código é obrigatório!";
        }
        if (prod.getQtdestoque().equals("")) {
            return "Quantidade de estoque é obrigatório!";
        }
        if (prod.getDescProduto().equals("")) {
            return "Descrição do produto é obrigatório!";
        }
        if (prod.getFornecedor().getCodigo().equals("")) {
            return "Código do fornecedor é obrigatório!";
        }
        if (txtCusto.getText().isEmpty()) {
            return "O preço de custo é obrigatório";
        }
        if (txtVenda.getText().isEmpty()) {
            return "O preço de venda é obrigatório!";
        }
        return msgRetorno;
    }

    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Windows".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(CadastroProduto.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(CadastroProduto.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(CadastroProduto.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(CadastroProduto.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new CadastroProduto().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JComboBox comboFornecedor;
    private javax.swing.JComboBox comboLucro;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JRadioButton radioLucro;
    private javax.swing.JTextField txtCodigo;
    private javax.swing.JTextField txtCusto;
    private javax.swing.JTextField txtDescProduto;
    private javax.swing.JTextField txtObservacao;
    private javax.swing.JTextField txtQtdEstoque;
    private javax.swing.JTextField txtVenda;
    // End of variables declaration//GEN-END:variables
}
