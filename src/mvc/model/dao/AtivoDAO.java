/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mvc.model.dao;

import java.math.BigDecimal;
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
    
    public int posicaoLivre(){
        for(int i =0; i < ativo.length; i++){
            if(ativo[i] == null) return i;
        }
        return -1;
    }
    
    public void create(String empresa, String ticker, BigDecimal total, BigDecimal valor){
        if(!(this.cheio())){
            final int pos = this.posicaoLivre();

            Ativo novo = new Ativo();

            novo.setInfo(empresa, ticker);
            novo.setValues(total, valor);

            ativo[pos] = novo;
        }
    }
    
    public void create(Ativo novo){
        if(!(this.cheio())){
            final int pos = this.posicaoLivre();

            ativo[pos] = novo;
        }
    }
    
    public String read(){
        if(!(this.vazio())){
            StringBuilder result = new StringBuilder("");
            
            for(Ativo aux : ativo){
                if(aux != null) {
                    result.append(aux.toString() + "\n");
                }
            }
            //System.out.println(result);
            return result.toString();
        } else {
            return "Nenhum ativo existente";
        }
    }
    
    public void update(){
        if(!(this.vazio())){
            
        }
    }
    
    public boolean delete(int id){
        if(!(this.vazio())){
            
            for(int i =0; i < nAtivo; i++){
                if(ativo[i] != null && ativo[i].getId() == id){
                    ativo[i] = null;
                    return true;
                }
            }
        }
        return false;
    }
}
