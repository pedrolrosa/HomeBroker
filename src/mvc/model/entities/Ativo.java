/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mvc.model.entities;

import java.math.BigDecimal;
import java.util.Objects;

/**
 *
 * @author pedro
 */
public class Ativo {
    private static int serial;
    private final int id;
    
    private String empresa;
    private String ticker;
    
    private BigDecimal total;
    private BigDecimal precoInicial;
    private BigDecimal precoAtual;
    
    private Data data;
    
    public Ativo(){
        this.id = ++Ativo.serial;
    }

    public int getId() {
        return id;
    }

    public String getEmpresa() {
        return empresa;
    }

    public String getTicker() {
        return ticker;
    }

    public BigDecimal getTotal() {
        return total;
    }

    public BigDecimal getPrecoInicial() {
        return precoInicial;
    }

    public BigDecimal getPrecoAtual() {
        return precoAtual;
    }

    public Data getData() {
        return data;
    }
    
    public void setInfo(String empresa, String ticker){
        this.empresa = empresa;
        this.ticker = ticker;
    }
    
    public void setValues(BigDecimal total, BigDecimal valor){
        this.total = total;
        this.precoInicial = valor;
    }

    public void setPrecoAtual(BigDecimal precoAtual) {
        this.precoAtual = precoAtual;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 59 * hash + this.id;
        hash = 59 * hash + Objects.hashCode(this.empresa);
        hash = 59 * hash + Objects.hashCode(this.ticker);
        hash = 59 * hash + Objects.hashCode(this.total);
        hash = 59 * hash + Objects.hashCode(this.precoInicial);
        hash = 59 * hash + Objects.hashCode(this.precoAtual);
        hash = 59 * hash + Objects.hashCode(this.data);
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
        final Ativo other = (Ativo) obj;
        if (this.id != other.id) {
            return false;
        }
        if (!Objects.equals(this.empresa, other.empresa)) {
            return false;
        }
        if (!Objects.equals(this.ticker, other.ticker)) {
            return false;
        }
        if (!Objects.equals(this.total, other.total)) {
            return false;
        }
        if (!Objects.equals(this.precoInicial, other.precoInicial)) {
            return false;
        }
        if (!Objects.equals(this.precoAtual, other.precoAtual)) {
            return false;
        }
        if (!Objects.equals(this.data, other.data)) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Ativo{" + "id=" + id + ", empresa=" + empresa + ", ticker=" + ticker + ", total=" + total + ", precoInicial=" + precoInicial + ", precoAtual=" + precoAtual + ", data=" + data + '}';
    }
}
