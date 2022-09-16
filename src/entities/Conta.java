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
    
    public Conta(){
        this.id = Conta.totalConta + 1;
        Conta.totalConta++;
        //this.data.setCriacao();
    }

    public Conta(BigDecimal saldo) {
        this.id = Conta.totalConta + 1;
        Conta.totalConta++;
        this.saldo = saldo;
        
        if(this.titular.getTipo() == TipoUsuario.ADM){
            
        }
    }

    public int getId() {
        return id;
    }

    public void setTitular(Cliente titular) {
        this.titular = titular;
    }
    
    public void deposito(BigDecimal valor){
        saldo = saldo.add(valor);
        
    }
    
    public void saque(BigDecimal valor){
        saldo = saldo.subtract(valor);
        
    }
    
    public BigDecimal saldo(){
        return this.saldo;
    }
    
    public void pagamento(BigDecimal valor, Conta destino){
        saldo = this.saldo.subtract(valor);
        destino.saldo = destino.saldo.add(valor);
        
    }
    
    public void transferencia(BigDecimal valor, Conta destino){
        saldo = this.saldo.subtract(valor);
        destino.saldo = destino.saldo.add(valor);
        
    }

    @Override
    public String toString() {
        return "Conta{" + "id=" + id + ", saldo=" + saldo +", titular: "+ this.titular.getNome();
    }
}
