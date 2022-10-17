/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mvc.model.dao;

import mvc.model.entities.Conta;
import mvc.model.entities.Ordem;
import mvc.model.enums.EstadoOrdem;
import mvc.model.enums.TipoOrdem;

/**
 *
 * @author pedro
 */
public class OrdemDAO {
    final int nOrdem = 100;
    private final Ordem[] ordem = new Ordem[nOrdem];
    
    public OrdemDAO(){
        
    }
    
    // teste
    public Ordem satisfaz(Ordem ordem){
        if(ordem.getTipo().equals(TipoOrdem.COMPRA)){
            for(Ordem aux : this.ordem){
                if(aux != null){
                    if(!(aux.getTipo().equals(ordem.getTipo()))){
                        if(aux.getValor().compareTo(ordem.getValor()) <= 0){
                            if(ordem.getQtd() - aux.getQtd() > 0){
                                ordem.setTypes(EstadoOrdem.PARCIAL);
                                aux.setTypes(EstadoOrdem.TOTAL);
                            } else if(ordem.getQtd() - aux.getQtd() < 0){
                                aux.setTypes(EstadoOrdem.PARCIAL);
                                ordem.setTypes(EstadoOrdem.TOTAL);
                            } else {
                                aux.setTypes(EstadoOrdem.TOTAL);
                                ordem.setTypes(EstadoOrdem.TOTAL);
                            }
                            return aux;
                        }
                    }
                }
            }
        } else {
            for(Ordem aux : this.ordem){
                if(aux != null){
                    if(!(aux.getTipo().equals(ordem.getTipo()))){
                        if(aux.getValor().compareTo(ordem.getValor()) >= 0){
                            if(ordem.getQtd() - aux.getQtd() > 0){
                                ordem.setTypes(EstadoOrdem.PARCIAL);
                            } else if(ordem.getQtd() - aux.getQtd() < 0){
                                aux.setTypes(EstadoOrdem.PARCIAL);
                            }
                            return aux;
                        }
                    }
                }
            }
        }
        
        return null;
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
    
    public String read(String ticker){
        if(!(this.vazio())){
            StringBuilder result = new StringBuilder("");
            
            for(Ordem aux : ordem){
                if(aux != null) {
                    if(aux.getTicker().equals(ticker))
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
            alvo.setValues(altera.getQtd(), altera.getValor());
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
    
    public boolean delete(Ordem alvo){
        boolean flag = false;
        if(!(this.vazio())){
            
            for(int i =0; i < nOrdem; i++){
                if(ordem[i] != null && ordem[i].equals(alvo)){
                    ordem[i] = null;
                    flag = true;
                }
            }
        }
        return flag;
    }
}
