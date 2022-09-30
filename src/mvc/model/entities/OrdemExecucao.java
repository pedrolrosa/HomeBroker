/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mvc.model.entities;

import java.math.BigDecimal;
import java.util.Objects;
import mvc.model.enums.EstadoOrdem;

/**
 *
 * @author pedro
 */
public class OrdemExecucao {
    private static int serial;
    private final int id;
    
    private Ordem ordem;
    private Conta compra;
    private Conta venda;
    
    private BigDecimal quantidade;
    
    private Data data;
    
    public OrdemExecucao(){
        this.id = ++this.serial;
    }

    public Ordem getOrdem() {
        return ordem;
    }

    public void setOrdem(Ordem ordem) {
        this.ordem = ordem;
    }

    public Conta getCompra() {
        return compra;
    }

    public void setCompra(Conta compra) {
        this.compra = compra;
    }

    public Conta getVenda() {
        return venda;
    }

    public void setVenda(Conta venda) {
        this.venda = venda;
    }

    public BigDecimal getQuantidade() {
        return quantidade;
    }

    public void setQuantidade(BigDecimal quantidade) {
        this.quantidade = quantidade;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 37 * hash + this.id;
        hash = 37 * hash + Objects.hashCode(this.ordem);
        hash = 37 * hash + Objects.hashCode(this.compra);
        hash = 37 * hash + Objects.hashCode(this.venda);
        hash = 37 * hash + Objects.hashCode(this.quantidade);
        hash = 37 * hash + Objects.hashCode(this.data);
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
        final OrdemExecucao other = (OrdemExecucao) obj;
        if (this.id != other.id) {
            return false;
        }
        if (!Objects.equals(this.ordem, other.ordem)) {
            return false;
        }
        if (!Objects.equals(this.compra, other.compra)) {
            return false;
        }
        if (!Objects.equals(this.venda, other.venda)) {
            return false;
        }
        if (!Objects.equals(this.quantidade, other.quantidade)) {
            return false;
        }
        if (!Objects.equals(this.data, other.data)) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "OrdemExecucao{" + "id=" + id + ", ordem=" + ordem + ", compra=" + compra + ", venda=" + venda + ", quantidade=" + quantidade + ", data=" + data + '}';
    }
}
