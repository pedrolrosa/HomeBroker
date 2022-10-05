/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mvc.model.dao;

import mvc.model.entities.Conta;
import mvc.model.entities.Operacao;

/**
 *
 * @author pedro
 */
public class OperacaoDAO {
    final int nOperacao = 100;
    private final Operacao operacao[] = new Operacao[nOperacao];
    
    public OperacaoDAO(){
        
    }
    
    public Operacao busca(int id){
        for(Operacao aux : operacao){
            if(aux.getId() == id) return aux;
        }
        return null;
    }
    
    public boolean vazio(){
        for(Operacao aux : operacao){
            if (aux != null) {
                return false;
            }
        }
        return true;
    }
    
    public boolean cheio(){
        for(Operacao aux : operacao){
            if(aux == null){
                return false;
            }
        }
        return true;
    }
    
    public int posicaoLivre(){
        for(int i =0; i < operacao.length; i++){
            if(operacao[i] == null) return i;
        }
        return -1;
    }
    
    public void create(Operacao novo){
        if(!(this.cheio())){
            final int pos = this.posicaoLivre();

            operacao[pos] = novo;
        }
    }
    
    public String read(){
        if(!(this.vazio())){
            StringBuilder result = new StringBuilder("");
            
            for(Operacao aux : operacao){
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
    
    public String read(Conta atual){
        if(!(this.vazio())){
            StringBuilder result = new StringBuilder("");
            
            for(Operacao aux : operacao){
                if(aux != null && (aux.getOrigem() == atual || aux.getDestino() == atual)) {
                    result.append(aux.toString()).append("\n");
                }
            }
            //System.out.println(result);
            return result.toString();
        } else {
            return "Nenhuma operacao existente";
        }
    }
    
    public void update(Operacao alvo, Operacao altera){
        if(!(this.vazio()) && alvo != null && altera != null){
            alvo.setInfo(altera.getValor());
        }
    }
    
    public boolean delete(int id){
        if(!(this.vazio())){
            
            for(int i =0; i < nOperacao; i++){
                if(operacao[i] != null && operacao[i].getId() == id){
                    operacao[i] = null;
                    return true;
                }
            }
        }
        return false;
    }
}
