/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mvc.model.dao;

import mvc.model.entities.AtivoConta;

/**
 *
 * @author pedro
 */
public class AtivoContaDAO {
    final int nAtivoConta = 50;
    private final AtivoConta[] relacao = new AtivoConta[nAtivoConta];
    
    public AtivoContaDAO(){
        
    }
    
    public boolean vazio(){
        for(AtivoConta aux : relacao){
            if(aux != null) return false;
        }
        return true;
    }
    
    public boolean cheio(){
        for(AtivoConta aux : relacao){
            if(aux == null) return false;
        }
        return true;
    }
    
    public int posicaoLivre(){
        for(int i =0; i < relacao.length; i++){
            if(relacao[i] == null) return i;
        }
        return -1;
    }
    
    public void create(){
        if(!(this.cheio())){
            
        }
    }
    
    public void read(){
        if(!(this.vazio())){
            
        }
    }
    
    public void update(){
        if(!(this.vazio())){
            
        }
    }
    
    public void delete(){
        if(!(this.vazio())){
            
        }
    }
}
