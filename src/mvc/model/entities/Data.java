/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mvc.model.entities;

import java.util.Date;
import java.util.Objects;

/**
 *
 * @author pedro
 */
public class Data {
    private Date criacao;
    private Date modificacao;
    
    public Data(){
        
    }

    public Date getCriacao() {
        return criacao;
    }

    public Date getModificacao() {
        return modificacao;
    }

    public void setCriacao(Date criacao) {
        this.criacao = criacao;
    }

    public void setDataModificacao(Date dataModificacao) {
        this.modificacao = dataModificacao;
    }

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 67 * hash + Objects.hashCode(this.criacao);
        hash = 67 * hash + Objects.hashCode(this.modificacao);
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
        final Data other = (Data) obj;
        if (!Objects.equals(this.criacao, other.criacao)) {
            return false;
        }
        if (!Objects.equals(this.modificacao, other.modificacao)) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Datas{" + "criacao=" + criacao + ", modificacao=" + modificacao + '}';
    }
    
    
}
