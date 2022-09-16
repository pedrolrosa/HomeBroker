/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entities;

import java.math.BigDecimal;

/**
 *
 * @author pedro
 */
public class Operacao {
    private static int nOperacao;
    private int id;
    private TiposOperacao tipo;
    private String descricao;
    
    private BigDecimal valor;
    
    private Datas data;
    
    public Operacao(){
        this.id = Operacao.nOperacao + 1;
        Operacao.nOperacao++;
    }

    public void addOperacao(TiposOperacao tipo, BigDecimal valor) {
        this.id = Operacao.nOperacao + 1;
        Operacao.nOperacao++;
        this.tipo = tipo;
        this.valor = valor;
    }
    
    
}
