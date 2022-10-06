/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mvc.model.dao;

import mvc.model.entities.OrdemExecucao;

/**
 *
 * @author pedro
 */
public class OrdemExecucaoDAO {
    final int nOrdemExecucao = 100;
    private final OrdemExecucao[] ordemExecucao = new OrdemExecucao[nOrdemExecucao];
 
    public OrdemExecucaoDAO(){
    
    }
    
    public boolean vazio(){
        for(OrdemExecucao aux : ordemExecucao){
            if(aux != null) return false;
        }
        return true;
    }
    
    public boolean cheio(){
        for(OrdemExecucao aux : ordemExecucao){
            if(aux == null) return false;
        }
        return true;
    }
    
    public int posicaoLivre(){
        for(int i =0; i < ordemExecucao.length; i++){
            if(ordemExecucao[i] == null) return i;
        }
        return -1;
    }
    
    public void create(OrdemExecucao novo){
        if(!(this.cheio())){
            final int pos = this.posicaoLivre();
            
            ordemExecucao[pos] = novo;
        }
    }
    
    public String read(){
        if(!(this.vazio())){
            StringBuilder result = new StringBuilder("");
            
            for(OrdemExecucao aux : ordemExecucao){
                if(aux != null) {
                    result.append(aux.toString()).append("\n");
                }
            }
            //System.out.println(result);
            return result.toString();
        } else {
            return "Nenhuma operacao existente";
        }
    }
    
    public void update(){
        if(!(this.vazio())){
            
        }
    }
    
    public boolean delete(int id){
        if(!(this.vazio())){
            
            for(int i =0; i < nOrdemExecucao; i++){
                if(ordemExecucao[i] != null && ordemExecucao[i].getId() == id){
                    ordemExecucao[i] = null;
                    return true;
                }
            }
        }
        return false;
    }
}
