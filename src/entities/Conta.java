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
public class Conta {
    private static int totalConta;
    private int id;
    private BigDecimal saldo;
    
    private Datas data;
    
    private Cliente titular;
    private int nTransacao = 0;
    private Transacao extrato[];
    
    
    public Conta(){
        this.id = Conta.totalConta + 1;
        Conta.totalConta++;
    }
    
    public void deposito(BigDecimal valor){
        saldo.add(valor);
        this.extrato[nTransacao].addTransacao(null, this, valor, TiposOperacao.DEPOSITO);
        nTransacao++;
    }
    
    public void saque(BigDecimal valor){
        saldo.subtract(valor);
        this.extrato[nTransacao].addTransacao(this, null, valor, TiposOperacao.SAQUE);
        nTransacao++;
    }
    
    public BigDecimal saldo(){
        return this.saldo;
    }
    
    public void pagamento(BigDecimal valor, Conta destino){
        this.saldo.subtract(valor);
        destino.saldo.add(valor);
        this.extrato[nTransacao].addTransacao(this, destino, valor, TiposOperacao.PAGAMENTO);
        nTransacao++;
    }
    
    public void transferencia(BigDecimal valor, Conta destino){
        this.saldo.subtract(valor);
        destino.saldo.add(valor);
        this.extrato[nTransacao].addTransacao(this, destino, valor, TiposOperacao.TRANSFERENCIA);
        nTransacao++;
    }
}
