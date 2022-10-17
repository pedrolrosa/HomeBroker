/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mvc.model.entities;

import java.math.BigDecimal;
import java.util.Objects;
import mvc.model.enums.EstadoOrdem;
import mvc.model.enums.TipoOrdem;

/**
 *
 * @author pedro
 */
public class Ordem {
    private static int serial;
    private final int id;
    
    private Conta conta;
    
    private TipoOrdem tipo;
    private EstadoOrdem estado;
    
    private String ticker;
    
    private int qtd;
    private BigDecimal valor;
    private BigDecimal valorTotal;
    
    private Data data;    
    
    public Ordem(){
        this.id = ++Ordem.serial;
    }

    public int getId() {
        return id;
    }

    public Conta getConta() {
        return conta;
    }

    public TipoOrdem getTipo() {
        return tipo;
    }

    public EstadoOrdem getEstado() {
        return estado;
    }

    public String getTicker() {
        return ticker;
    }

    public int getQtd() {
        return qtd;
    }

    public BigDecimal getValor() {
        return valor;
    }

    public BigDecimal getValorTotal() {
        return valorTotal;
    }

    public Data getData() {
        return data;
    }
    
    public void setConta(Conta conta){
        this.conta = conta;
    }
    
    public void setTicker(String ticker){
        this.ticker = ticker;
    }
    
    public void setTypes(TipoOrdem tipo, EstadoOrdem estado){
        this.tipo = tipo;
        this.estado = estado;
    }
    
    public void setTypes(EstadoOrdem estado){
        this.estado = estado;
    }
    
    public void setValues(int qtd, BigDecimal valor){
        this.qtd = qtd;
        this.valor = valor;
        this.valorTotal = valor.multiply(BigDecimal.valueOf(qtd));
    }
    
    public void subQtd(int qtd){
        this.qtd -= qtd;
        this.valorTotal = this.valor.multiply(BigDecimal.valueOf(this.qtd));
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 19 * hash + this.id;
        hash = 19 * hash + Objects.hashCode(this.conta);
        hash = 19 * hash + Objects.hashCode(this.tipo);
        hash = 19 * hash + Objects.hashCode(this.estado);
        hash = 19 * hash + Objects.hashCode(this.ticker);
        hash = 19 * hash + Objects.hashCode(this.qtd);
        hash = 19 * hash + Objects.hashCode(this.valor);
        hash = 19 * hash + Objects.hashCode(this.valorTotal);
        hash = 19 * hash + Objects.hashCode(this.data);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Ordem other = (Ordem) obj;
        if (this.id != other.id) {
            return false;
        }
        if (!Objects.equals(this.ticker, other.ticker)) {
            return false;
        }
        if (!Objects.equals(this.conta, other.conta)) {
            return false;
        }
        if (this.tipo != other.tipo) {
            return false;
        }
        if (this.estado != other.estado) {
            return false;
        }
        if (!Objects.equals(this.qtd, other.qtd)) {
            return false;
        }
        if (!Objects.equals(this.valor, other.valor)) {
            return false;
        }
        if (!Objects.equals(this.valorTotal, other.valorTotal)) {
            return false;
        }
        return Objects.equals(this.data, other.data);
    }

    @Override
    public String toString() {
        return "Ordem{" + "id=" + id + ", conta=" + conta + ", tipo=" + tipo + ", estado=" + estado + ", ticker=" + ticker + ", qtd=" + qtd + ", valor=" + valor + ", valorTotal=" + valorTotal + ", data=" + data + '}';
    }
    
}
