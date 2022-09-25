/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mvc.model.dao;

import mvc.model.entities.Ordem;

/**
 *
 * @author pedro
 */
public class OrdemDAO {
    final int nOrdem = 100;
    private final Ordem[] ordem = new Ordem[nOrdem];
    
    public OrdemDAO(){
        
    }
    
    public boolean vazio(){
        for(Ordem aux : ordem){
            if(aux != null) return false;
        }
        return true;
    }
    
    public boolean cheio(){
        for(Ordem aux : ordem){
            if(aux == null) return false;
        }
        return true;
    }
    
    public int posicaoLivre(){
        for(int i =0; i < ordem.length; i++){
            if(ordem[i] == null) return i;
        }
        return -1;
    }
    
    public void create(){
        if(!(this.cheio())){
            
        }
    }
    
    public void read(){
        
    }
    
    public void update(){
        
    }
    
    public void delete(){
        
    }
}
