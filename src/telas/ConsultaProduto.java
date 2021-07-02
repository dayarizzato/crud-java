/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package telas;


import dao.ClienteDAO;
import dao.ProdutoDao;
import java.sql.Connection;
import java.sql.SQLException;
import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import model.Fornecedor;
import model.Produto;
import util.ConnectionFactory;

/**
 *
 * @author Dayana
 */
public class ConsultaProduto extends javax.swing.JFrame {

    /**
     * Creates new form ConsultaProduto
     */
    public ConsultaProduto() {
        initComponents();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        txtConsultaProduto = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        tabelaProduto = new javax.swing.JTable();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("..:::Consulta de Produtos:::..");

        jPanel1.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));

        txtConsultaProduto.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtConsultaProdutoKeyReleased(evt);
            }
        });

        jLabel1.setText("Produtos:");

        jButton1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/novo.png"))); // NOI18N
        jButton1.setText("Adicionar");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jButton2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/alterar.png"))); // NOI18N
        jButton2.setText("Alterar");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        jButton3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/excluir.png"))); // NOI18N
        jButton3.setText("Excluir");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(27, 27, 27)
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 64, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtConsultaProduto, javax.swing.GroupLayout.PREFERRED_SIZE, 358, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 196, Short.MAX_VALUE)
                .addComponent(jButton1)
                .addGap(18, 18, 18)
                .addComponent(jButton2)
                .addGap(18, 18, 18)
                .addComponent(jButton3)
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(15, 15, 15)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton2)
                    .addComponent(jButton1)
                    .addComponent(jButton3)
                    .addComponent(txtConsultaProduto, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel1))
                .addContainerGap(30, Short.MAX_VALUE))
        );

        tabelaProduto.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "ID", "Código", "Quantidade em estoque", "Descrição do produto", "Fornecedor", "Preço de Custo", "Preço de Venda", "Observação", "Data de Cadastro "
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane1.setViewportView(tabelaProduto);
        if (tabelaProduto.getColumnModel().getColumnCount() > 0) {
            tabelaProduto.getColumnModel().getColumn(0).setResizable(false);
            tabelaProduto.getColumnModel().getColumn(1).setResizable(false);
            tabelaProduto.getColumnModel().getColumn(2).setResizable(false);
            tabelaProduto.getColumnModel().getColumn(2).setPreferredWidth(150);
            tabelaProduto.getColumnModel().getColumn(3).setResizable(false);
            tabelaProduto.getColumnModel().getColumn(3).setPreferredWidth(300);
            tabelaProduto.getColumnModel().getColumn(4).setResizable(false);
            tabelaProduto.getColumnModel().getColumn(4).setPreferredWidth(300);
            tabelaProduto.getColumnModel().getColumn(5).setResizable(false);
            tabelaProduto.getColumnModel().getColumn(5).setPreferredWidth(200);
            tabelaProduto.getColumnModel().getColumn(6).setResizable(false);
            tabelaProduto.getColumnModel().getColumn(6).setPreferredWidth(200);
            tabelaProduto.getColumnModel().getColumn(7).setResizable(false);
            tabelaProduto.getColumnModel().getColumn(7).setPreferredWidth(300);
            tabelaProduto.getColumnModel().getColumn(8).setResizable(false);
            tabelaProduto.getColumnModel().getColumn(8).setPreferredWidth(200);
        }

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jScrollPane1))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 467, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // novo
        dispose();
        new CadastroProduto().setVisible(true);
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        // alterar
       if(tabelaProduto.getSelectedRowCount() == 1){
           Produto produto = new Produto();
           produto.setId(Integer.parseInt((String)tabelaProduto.getValueAt(tabelaProduto.getSelectedRow(), 0)));
           produto.setCodigo((String)tabelaProduto.getValueAt(tabelaProduto.getSelectedRow(), 1));
           produto.setQtdestoque(Integer.parseInt((String)tabelaProduto.getValueAt(tabelaProduto.getSelectedRow(), 2)));
           produto.setDescProduto((String)tabelaProduto.getValueAt(tabelaProduto.getSelectedRow(), 3));
           Fornecedor fornecedor = new Fornecedor();
           produto.setFornecedor(fornecedor);
           produto.getFornecedor().setNome((String)tabelaProduto.getValueAt(tabelaProduto.getSelectedRow(), 4));
           produto.setPrecoCusto(Double.valueOf(String.valueOf(tabelaProduto.getValueAt(tabelaProduto.getSelectedRow(), 5)).replace(",", ".")));
           produto.setPrecoVenda(Double.valueOf(String.valueOf(tabelaProduto.getValueAt(tabelaProduto.getSelectedRow(), 6)).replace(",", ".")));
           produto.setObservacao((String)tabelaProduto.getValueAt(tabelaProduto.getSelectedRow(), 7));
           new CadastroProduto(produto).setVisible(true);
           dispose();
                      
       }else{
           JOptionPane.showMessageDialog(null, "Selecione um único registro para alterar.");
       }
            
    }//GEN-LAST:event_jButton2ActionPerformed

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        //excluir
        try {
            if(tabelaProduto.getSelectedRowCount()== 1){//selecione uma linha - selected row retorna a quantidade de linhas selecionado
                Connection bd = ConnectionFactory.getConection();
                ClienteDAO clienteDao = new ClienteDAO(bd);
                Long codigo = Long.parseLong(tabelaProduto.getValueAt(tabelaProduto.getSelectedRow(), 0) + "");
                clienteDao.excluir(codigo);

                ((DefaultTableModel) tabelaProduto.getModel()).removeRow(tabelaProduto.getSelectedRow());
                tabelaProduto.repaint();// recarrega tabela
                tabelaProduto.revalidate();
            }else{
                JOptionPane.showMessageDialog(null, "Selecione ao menos um registro para excluir!");
            }
            
        } catch (SQLException ex) {
            Logger.getLogger(ConsultaCliente.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_jButton3ActionPerformed

    private void txtConsultaProdutoKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtConsultaProdutoKeyReleased
        try {
            String nome = txtConsultaProduto.getText();
            
            Connection bd = ConnectionFactory.getConection();
            ProdutoDao dao = new ProdutoDao(bd);
            
            List<Produto> lista = dao.consultarProdutos(nome);
            popularTabela(lista);
        } catch (SQLException ex) {
            Logger.getLogger(ConsultaProduto.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_txtConsultaProdutoKeyReleased

    
    
    public void popularTabela(List<Produto> lista){
        tabelaProduto.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
        DefaultTableModel modelo = (DefaultTableModel)tabelaProduto.getModel();
        modelo.setNumRows(0);
        
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
        DecimalFormat dcf = new DecimalFormat("0.00");
        lista.forEach(p ->{
            modelo.addRow(new String[]{String.valueOf(p.getId()), p.getCodigo(), p.getQtdestoque()+"", 
                p.getDescProduto(), p.getFornecedor().getNome(), dcf.format(p.getPrecoCusto()), dcf.format(p.getPrecoVenda()), p.getObservacao(), sdf.format(p.getDtCadProd())});
        });
        
    }
    /**
     * @param args the command line arguments
     */
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
            java.util.logging.Logger.getLogger(ConsultaProduto.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(ConsultaProduto.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(ConsultaProduto.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(ConsultaProduto.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new ConsultaProduto().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable tabelaProduto;
    private javax.swing.JTextField txtConsultaProduto;
    // End of variables declaration//GEN-END:variables
}