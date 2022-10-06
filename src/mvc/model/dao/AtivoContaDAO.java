/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mvc.model.dao;

import mvc.model.entities.Ativo;
import mvc.model.entities.AtivoConta;
import mvc.model.entities.Conta;

/**
 *
 * @author pedro
 */
public class AtivoContaDAO {
    final int nAtivoConta = 100;
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
    
    public void create(AtivoConta novo, int quantidade){
        if(!(this.cheio())){
            for(int i = this.posicaoLivre(), cont =0; i < nAtivoConta && cont <= quantidade; i++, cont++){
                relacao[this.posicaoLivre()] = novo;
            }
        }
    }
    
    public String read(){
        if(!(this.vazio())){
            StringBuilder result = new StringBuilder("");
            
            for(AtivoConta aux : relacao){
                if(aux != null) {
                    result.append(aux.toString()).append("\n");
                }
            }
            //System.out.println(result);
            return result.toString();
        } else {
            return "Nenhum ativo existente";
        }
    }
    
    public String read(Conta atual){
        if(!(this.vazio())){
            StringBuilder result = new StringBuilder("");
            
            for(AtivoConta aux : relacao){
                if(aux != null) {
                    if(aux.getConta().equals(atual))
                        result.append(aux.toString()).append("\n");
                }
            }
            //System.out.println(result);
            return result.toString();
        } else {
            return "Nenhum ativo existente na conta";
        }
    }
    
    public String read(Ativo alvo){
        if(!(this.vazio())){
            StringBuilder result = new StringBuilder("");
            
            for(AtivoConta aux : relacao){
                if(aux != null) {
                    if(aux.getAtivo().equals(alvo))
                        result.append(aux.toString()).append("\n");
                }
            }
            //System.out.println(result);
            return result.toString();
        } else {
            return "Nenhum ativo existente na conta";
        }
    }
    
    public void update(){
        if(!(this.vazio())){
            
        }
    }
    
    public boolean delete(int id){
        if(!(this.vazio())){
            
            for(int i =0; i < nAtivoConta; i++){
                if(relacao[i] != null && relacao[i].getId() == id){
                    relacao[i] = null;
                    return true;
                }
            }
        }
        return false;
    }
}
