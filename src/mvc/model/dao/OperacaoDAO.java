/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mvc.model.dao;

import java.math.BigDecimal;
import mvc.model.entities.Conta;
import mvc.model.entities.Operacao;
import mvc.model.enums.MeioOperacao;
import mvc.model.enums.TipoOperacao;

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
    
    public String busca(Conta atual){
        String result;
        result = " ";
        
        for(Operacao aux : operacao){
            if(aux.getOrigem().equals(atual) || aux.getDestino().equals(atual)) result.concat("\n" + aux.toString());
        }
        
        return result;
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
    
    public void create(Conta origem, Conta destino, BigDecimal valor, TipoOperacao tipo, MeioOperacao meio, String descricao){
        if(!(this.cheio())){
            final int pos = this.posicaoLivre();

            Operacao novo = new Operacao();

            novo.setAccounts(origem, destino);
            novo.setInfo(valor, meio, tipo, descricao);

            operacao[pos] = novo;
        }
    }
    
    public String read(){
        if(!(this.vazio())){
            String result = "";
            
            for(Operacao aux : operacao){
                if(aux != null) result.concat(aux.toString()+ "\n");
            }
            
            return result;
        } else {
            return "Nenhuma operacao existente";
        }
    }
    
    public void update(int id, Conta origem, Conta destino, BigDecimal valor, TipoOperacao tipo, MeioOperacao meio, String descricao){
        if(!(this.vazio())){
            Operacao aux = busca(id);
        
            aux.setAccounts(origem, destino);
            aux.setInfo(valor, meio, tipo, descricao);
        }
    }
    
    public void update(int id, BigDecimal valor){
        if(!(this.vazio())){
            Operacao aux = busca(id);

            aux.setInfo(valor);
        }
    }
    
    public void delete(int id){
        if(!(this.vazio())){
            final int pos = id - 1;
        
            operacao[pos] = null;
        }
    }
}
