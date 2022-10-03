/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mvc.model.entities;

import mvc.model.enums.MeioOperacao;
import mvc.model.enums.TipoOperacao;
import java.math.BigDecimal;
import java.util.Objects;

/**
 *
 * @author pedro
 */
public class Operacao {
    private static int serial;
    private final int id;
    
    private BigDecimal valor;
    private MeioOperacao meio;
    private TipoOperacao tipo;
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

    public MeioOperacao getMeio() {
        return meio;
    }

    public TipoOperacao getTipo() {
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
    
    public void setInfo(MeioOperacao meio, TipoOperacao tipo, String descricao){
        this.valor = valor;
        this.meio = meio;
        this.tipo = tipo;
        this.descricao = descricao;
    }
    
    public void setInfo(BigDecimal valor){
        this.valor = valor;
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
        int hash = 5;
        hash = 29 * hash + this.id;
        hash = 29 * hash + Objects.hashCode(this.valor);
        hash = 29 * hash + Objects.hashCode(this.meio);
        hash = 29 * hash + Objects.hashCode(this.tipo);
        hash = 29 * hash + Objects.hashCode(this.descricao);
        hash = 29 * hash + Objects.hashCode(this.data);
        hash = 29 * hash + Objects.hashCode(this.origem);
        hash = 29 * hash + Objects.hashCode(this.destino);
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
        if (!Objects.equals(this.descricao, other.descricao)) {
            return false;
        }
        if (!Objects.equals(this.valor, other.valor)) {
            return false;
        }
        if (this.meio != other.meio) {
            return false;
        }
        if (this.tipo != other.tipo) {
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
        return "Operacao{" + "id=" + id + ", valor=" + valor + ", meio=" + meio + ", tipo=" + tipo + ", descricao=" + descricao + ", data=" + data + ", origem=" + origem + ", destino=" + destino + '}';
    }

}
