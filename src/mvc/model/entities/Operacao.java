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
public class Operacao {
    private static int serial;
    private int id;
    
    private BigDecimal valor;
    private TiposOperacao tipo;
    private String descricao;
    
    private Data data;
    private Conta origem;
    private Conta destino;
    
    public Operacao(){
        this.id = ++Operacao.serial;
    }

    public int getId() {
        return id;
    }

    public TiposOperacao getTipo() {
        return tipo;
    }

    public String getDescricao() {
        return descricao;
    }

    public BigDecimal getValor() {
        return valor;
    }

    public Data getData() {
        return data;
    }
    
    public Conta getOrigem() {
        return origem;
    }

    public Conta getDestino() {
        return destino;
    }
    
    public void setInfo(BigDecimal valor, TiposOperacao tipo, String descricao){
        this.valor = valor;
        this.tipo = tipo;
        this.descricao = descricao;
    }
    
    public void setAccounts(Conta origem, Conta destino){
        this.origem = origem;
        this.destino = destino;
    }

    public void setData(Data data) {
        this.data = data;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 19 * hash + this.id;
        hash = 19 * hash + Objects.hashCode(this.tipo);
        hash = 19 * hash + Objects.hashCode(this.data);
        hash = 19 * hash + Objects.hashCode(this.origem);
        hash = 19 * hash + Objects.hashCode(this.destino);
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
        final Operacao other = (Operacao) obj;
        if (this.id != other.id) {
            return false;
        }
        if (this.tipo != other.tipo) {
            return false;
        }
        if (!Objects.equals(this.valor, other.valor)) {
            return false;
        }
        if (!Objects.equals(this.data, other.data)) {
            return false;
        }
        if (!Objects.equals(this.origem, other.origem)) {
            return false;
        }
        if (!Objects.equals(this.destino, other.destino)) {
            return false;
        }
        return true;
    }
    @Override
    public String toString() {
        return "Origem: "+ origem.getId() +", Destino: "+ destino.getId() +", Tipo: "+ this.tipo + ", Valor: "+ this.valor;
    }
    
    
}
