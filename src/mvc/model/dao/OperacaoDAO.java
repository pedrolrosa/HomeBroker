/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mvc.model.dao;

import mvc.model.entities.Operacao;

/**
 *
 * @author pedro
 */
public class OperacaoDAO {
    final int nOperacao = 100;
    private Operacao operacao[] = new Operacao[nOperacao];
    
    public boolean vazio(){
        for(int i =0; i < operacao.length; i++){
            if(operacao[i] != null) return false;
        }
        return true;
    }
    
    public boolean cheio(){
        for(int i =0; i < operacao.length; i++){
            if(operacao[i] == null) return false;
        }
        return true;
    }
    
    public int pegaPosicao(){
        for(int i =0; i < operacao.length; i++){
            if(operacao[i] == null) return i;
        }
        return -1;
    }
    
    public void create(){
        
    }
    
    public void read(){
        
    }
    
    public void update(){
        
    }
    
    public void delete(){
        
    }
}
