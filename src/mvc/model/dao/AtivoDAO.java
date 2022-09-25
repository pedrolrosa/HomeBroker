/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mvc.model.dao;

import mvc.model.entities.Ativo;

/**
 *
 * @author pedro
 */
public class AtivoDAO {
    final int nAtivo = 10;
    private final Ativo ativo[] = new Ativo[nAtivo];
    
    public AtivoDAO(){
        
    }
    
    public boolean vazio(){
        for(Ativo aux : ativo){
            if(aux != null) return false;
        }
        return true;
    }
    
    public boolean cheio(){
        for(Ativo aux : ativo){
            if(aux == null) return false;
        }
        return true;
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
