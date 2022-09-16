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
public class Transacao {
    private static int nTransacao;
    private int id;
    private TiposOperacao tipo;
    private String descricao;
    
    private BigDecimal valor;
    
    private Datas data;
    private Conta origem;
    private Conta destino;
    
    public void addTransacao(Conta origem, Conta destino, BigDecimal valor, TiposOperacao tipo){
        this.id = nTransacao + 1;
        nTransacao++;
        this.origem = origem;
        this.destino = destino;
        this.tipo = tipo;
        this.valor = valor;
    }

    @Override
    public String toString() {
        return "Origem: "+ origem.getId() +", Destino: "+ destino.getId() +", Tipo: "+ this.tipo + ", Valor: "+ this.valor;
    }
    
    
}
