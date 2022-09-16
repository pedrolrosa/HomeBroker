/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entities;

import java.util.Date;

/**
 *
 * @author pedro
 */
public class Datas {
    private Date criacao;
    private Date modificacao;
    
    public Datas(){
        
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
    
    
}
