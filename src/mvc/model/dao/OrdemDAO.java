/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mvc.model.dao;

import mvc.model.entities.Conta;
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
    
    public void create(Ordem novo){
        if(!(this.cheio())){
            final int pos = this.posicaoLivre();           
            
            ordem[pos] = novo;
        }
    }
    
    public String read(){
        if(!(this.vazio())){
            StringBuilder result = new StringBuilder("");
            
            for(Ordem aux : ordem){
                if(aux != null) {
                    result.append(aux.toString()).append("\n");
                }
            }
            //System.out.println(result);
            return result.toString();
        } else {
            return "Nenhuma ordem existente";
        }
    }
    
    public String read(Conta atual){
        if(!(this.vazio())){
            StringBuilder result = new StringBuilder("");
            
            for(Ordem aux : ordem){
                if(aux != null && aux.getConta().equals(atual)) {
                    result.append(aux.toString()).append("\n");
                }
            }
            //System.out.println(result);
            return result.toString();
        } else {
            return "Nenhuma ordem existente na conta";
        }
    }
    
    public void update(Ordem alvo, Ordem altera){
        if(!(this.vazio()) && alvo != null && altera != null){
            alvo.setValues(altera.getQtd(), altera.getValor(), altera.getValorTotal());
        }
    }
    
    public boolean delete(int id){
        if(!(this.vazio())){
            
            for(int i =0; i < nOrdem; i++){
                if(ordem[i] != null && ordem[i].getId() == id){
                    ordem[i] = null;
                    return true;
                }
            }
        }
        return false;
    }
}
