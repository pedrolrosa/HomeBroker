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
    private Conta origem;
    private Conta destino;
    private Operacao operacao;
    
    public void addTransacao(Conta origem, Conta destino, BigDecimal valor, TiposOperacao tipo){
        this.origem = origem;
        this.destino = destino;
        this.operacao.addOperacao(tipo, valor);
    }
}
