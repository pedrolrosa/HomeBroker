/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mvc.model.entities;

import java.util.Objects;

/**
 *
 * @author pedro
 */
public class AtivoConta {
    private static int serial;
    private final int id;
    
    private Ativo ativo;
    private Conta conta;
    
    public AtivoConta(){
        this.id = ++this.serial;
    }

    public int getId() {
        return id;
    }

    public Ativo getAtivo() {
        return ativo;
    }

    public void setAtivo(Ativo ativo) {
        this.ativo = ativo;
    }

    public Conta getConta() {
        return conta;
    }

    public void setConta(Conta conta) {
        this.conta = conta;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 37 * hash + this.id;
        hash = 37 * hash + Objects.hashCode(this.ativo);
        hash = 37 * hash + Objects.hashCode(this.conta);
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
        final AtivoConta other = (AtivoConta) obj;
        if (this.id != other.id) {
            return false;
        }
        if (!Objects.equals(this.ativo, other.ativo)) {
            return false;
        }
        if (!Objects.equals(this.conta, other.conta)) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "AtivoConta{" + "id=" + id + ", ativo=" + ativo + ", conta=" + conta + '}';
    }
}
