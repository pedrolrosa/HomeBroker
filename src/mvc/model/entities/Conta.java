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
public class Conta {
    private static int serial;
    private int id;
    
    private BigDecimal saldo;
    
    private Data data;
    
    private Cliente titular;
    
    public Conta(){
        this.id = ++Conta.serial;
    }

    public int getId() {
        return id;
    }

    public BigDecimal getSaldo() {
        return saldo;
    }

    public Data getData() {
        return data;
    }

    public Cliente getTitular() {
        return titular;
    }

    public void setData(Data data) {
        this.data = data;
    }

    public void setTitular(Cliente titular) {
        this.titular = titular;
    }

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 79 * hash + this.id;
        hash = 79 * hash + Objects.hashCode(this.saldo);
        hash = 79 * hash + Objects.hashCode(this.data);
        hash = 79 * hash + Objects.hashCode(this.titular);
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
        final Conta other = (Conta) obj;
        if (this.id != other.id) {
            return false;
        }
        if (!Objects.equals(this.saldo, other.saldo)) {
            return false;
        }
        if (!Objects.equals(this.data, other.data)) {
            return false;
        }
        if (!Objects.equals(this.titular, other.titular)) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Conta{" + "id=" + id + ", saldo=" + saldo +", titular: "+ this.titular.getNome();
    }
}
