/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mvc.model.dao;

import java.math.BigDecimal;
import mvc.model.entities.Cliente;
import mvc.model.entities.Conta;
import mvc.model.entities.TipoUsuario;

/**
 *
 * @author pedro
 */
public class ContaDAO {
    final int nConta = 5;
    private final Conta conta[] = new Conta[nConta];
    
    public Conta adm(){
        for(Conta aux : conta){
            if(aux.getTitular().getTipo() == TipoUsuario.ADM) return aux;
        }
        return null;
    }
    
    public Conta busca(Cliente titular){
        for(Conta aux : conta){
            if(aux.getTitular()== titular) return aux;
        }
        return null;
    }
    
    public Conta busca(int id){
        for(Conta aux : conta){
            if(aux.getId() == id) return aux;
        }
        return null;
    }
    
    public void deposito(Conta origem, BigDecimal valor, String descricao){        
        origem.entrada(valor);
    }
    
    public void saque(Conta origem, BigDecimal valor, String descricao){        
        origem.retirada(valor);
    }
    
    public void pagamento(Conta origem, BigDecimal valor, String descricao){
        origem.retirada(valor);
        this.adm().entrada(valor);
    }
    
    public void transferencia(Conta origem, int idDestino, BigDecimal valor, String descricao){
        origem.retirada(valor);
        Conta aux;
        aux = busca(idDestino);
        aux.entrada(valor);
    }
    
    public boolean vazio(){
        for (Conta conta1 : conta) {
            if (conta1 != null) {
                return false;
            }
        }
        return true;
    }
    
    public boolean cheio(){
        for (Conta conta1 : conta) {
            if (conta1 == null) {
                return false;
            }
        }
        return true;
    }
    
    public int pegaPosicaoVazia(){
        for(int i =0; i < conta.length; i++){
            if(conta[i] == null) return i;
        }
        return -1;
    }
    
    public void create(Cliente titular){
        if(!(this.cheio())){
            final int pos = this.pegaPosicaoVazia();
            Conta novo = new Conta();
            
            novo.setTitular(titular);
            
            conta[pos] = novo;
        }
    }
    
    public void read(){
        
    }
    
    public void update(){
        
    }
    
    public void delete(){
        
    }
}
