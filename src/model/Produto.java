/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.util.Date;

/**
 *
 * @author Dayana
 */
public class Produto {
    
    private Integer id;
    private String codigo;
    private Integer qtdestoque;
    private String descProduto;
    private Fornecedor fornecedor;
    private Double precoCusto;
    private Double precoVenda;
    private String observacao;
    private Date dtCadProd;

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }
    /**
     * @return the qtdestoque
     */
    public Integer getQtdestoque() {
        return qtdestoque;
    }

    /**
     * @param qtdestoque the qtdestoque to set
     */
    public void setQtdestoque(Integer qtdestoque) {
        this.qtdestoque = qtdestoque;
    }

    /**
     * @return the descProduto
     */
    public String getDescProduto() {
        return descProduto;
    }

    /**
     * @param descProduto the descProduto to set
     */
    public void setDescProduto(String descProduto) {
        this.descProduto = descProduto;
    }

   
    

    /**
     * @return the observacao
     */
    public String getObservacao() {
        return observacao;
    }

    /**
     * @param observacao the observacao to set
     */
    public void setObservacao(String observacao) {
        this.observacao = observacao;
    }

    /**
     * @return the dtCadProd
     */
    public Date getDtCadProd() {
        return dtCadProd;
    }

    /**
     * @param dtCadProd the dtCadProd to set
     */
    public void setDtCadProd(Date dtCadProd) {
        this.dtCadProd = dtCadProd;
    }

    /**
     * @return the precoCusto
     */
    public Double getPrecoCusto() {
        return precoCusto;
    }

    /**
     * @param precoCusto the precoCusto to set
     */
    public void setPrecoCusto(Double precoCusto) {
        this.precoCusto = precoCusto;
    }

    /**
     * @return the precoVenda
     */
    public Double getPrecoVenda() {
        return precoVenda;
    }

    /**
     * @param precoVenda the precoVenda to set
     */
    public void setPrecoVenda(Double precoVenda) {
        this.precoVenda = precoVenda;
    }
    
    public static void main(String[] args){
        System.out.println(((5 / 100) * 50) + 50);
    }

    /**
     * @return the fornecedor
     */
    public Fornecedor getFornecedor() {
        return fornecedor;
    }

    /**
     * @param fornecedor the fornecedor to set
     */
    public void setFornecedor(Fornecedor fornecedor) {
        this.fornecedor = fornecedor;
    }
    
}
