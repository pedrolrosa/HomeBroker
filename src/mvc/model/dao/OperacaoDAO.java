/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mvc.model.dao;

import java.math.BigDecimal;
import mvc.model.entities.Conta;
import mvc.model.entities.Operacao;
import mvc.model.entities.TiposOperacao;

/**
 *
 * @author pedro
 */
public class OperacaoDAO {
    final int nOperacao = 100;
    private final Operacao operacao[] = new Operacao[nOperacao];
    
    public Operacao busca(int id){
        for(Operacao aux : operacao){
            if(aux.getId() == id) return aux;
        }
        return null;
    }
    
    public boolean vazio(){
        for (Operacao operacao1 : operacao) {
            if (operacao1 != null) {
                return false;
            }
        }
        return true;
    }
    
    public boolean cheio(){
        for (Operacao operacao1 : operacao) {
            if (operacao1 == null) {
                return false;
            }
        }
        return true;
    }
    
    public int pegaPosicaoVazia(){
        for(int i =0; i < operacao.length; i++){
            if(operacao[i] == null) return i;
        }
        return -1;
    }
    
    public void create(Conta origem, Conta destino, BigDecimal valor, TiposOperacao tipo, String descricao){
        final int pos = this.pegaPosicaoVazia();
        
        Operacao novo = new Operacao();
        
        novo.setAccounts(origem, destino);
        novo.setInfo(valor, tipo, descricao);
        
        operacao[pos] = novo;
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
    
    public void update(int id, Conta origem, Conta destino, BigDecimal valor, TiposOperacao tipo, String descricao){
        Operacao aux = busca(id);
        
        aux.setAccounts(origem, destino);
        aux.setInfo(valor, tipo, descricao);
    }
    
    public void update(int id, BigDecimal valor){
        Operacao aux = busca(id);
        
        aux.setInfo(valor);
    }
    
    public void delete(int id){
        final int pos = id - 1;
        
        operacao[pos] = null;
    }
}
