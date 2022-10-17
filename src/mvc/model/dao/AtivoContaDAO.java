/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mvc.model.dao;

import java.math.BigDecimal;
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
    
    public int nAtivos(Conta atual){
        int cont = 0;
        for(AtivoConta aux : relacao){
            if(aux != null){
                if(aux.getConta().equals(atual)) cont++;
            }
        }
        return cont;
    }
    
    public int nAtivos(Conta atual, Ativo alvo){
        int cont = 0;
        for(AtivoConta aux : relacao){
            if(aux != null){
                if(aux.getConta().equals(atual)){
                    if(aux.getAtivo().equals(alvo)) cont++;
                }
            }
        }
        return cont;
    }
    
    public void pagarDividendos(int id, BigDecimal valor){
        for(AtivoConta aux : relacao){
            if(aux != null){
                if(aux.getId() == (id)) aux.getConta().entrada(valor);
            }
        }
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
            for(int i = this.posicaoLivre(), cont =1; i < nAtivoConta && cont <= quantidade; i++, cont++){
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
    
    // teste
    public void delete(String ticker, Conta dono, int qtd){
        if(!(this.vazio())){
            for(int i =0, cont = 1; i < nAtivoConta && cont <= qtd; i++, cont++){
                if(relacao[i] != null){
                    if(relacao[i].getAtivo().getTicker().equals(ticker) && relacao[i].getConta().equals(dono)) relacao[i] = null;
                }
            }
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
