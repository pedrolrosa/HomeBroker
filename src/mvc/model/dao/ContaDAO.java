/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mvc.model.dao;

import java.math.BigDecimal;
import mvc.model.entities.Cliente;
import mvc.model.entities.Conta;
import mvc.model.enums.TipoUsuario;

/**
 *
 * @author pedro
 */
public class ContaDAO {
    final int nConta = 10;
    private final Conta conta[] = new Conta[nConta];
    
    public ContaDAO(){
        
    }
    
    public Conta adm(){
        for(Conta aux : conta){
            if(aux != null){
                if(aux.getTitular().getTipo() == TipoUsuario.ADM) return aux;
            }
        }
        return null;
    }
    
    public Conta busca(Cliente titular){
        for(Conta aux : conta){
            if(aux != null){
                if(aux.getTitular() == titular) return aux;
            }
            
        }
        return null;
    }
    
    public Conta busca(int id){
        for(Conta aux : conta){
            if(aux != null){
                if(aux.getId() == id){
                    return aux;
                }
            }
        }
        return null;
    }
    
    public boolean deposito(Conta origem, BigDecimal valor){        
        origem.entrada(valor);
        return true;
    }
    
    public boolean saque(Conta origem, BigDecimal valor){        
        if(origem.getSaldo().compareTo(valor) >= 0){
            origem.retirada(valor);
            return true;
        }
        return false;
    }
    
    public boolean pagamento(Conta origem, BigDecimal valor){
        if(origem.getSaldo().compareTo(valor) >= 0){
            origem.retirada(valor);
            this.adm().entrada(valor);
            return true;
        }
        return false;
    }
    
    public boolean transferencia(Conta origem, int idDestino, BigDecimal valor){
        if(origem.getSaldo().compareTo(valor) >= 0){
            origem.retirada(valor);
            Conta aux;
            aux = busca(idDestino);
            aux.entrada(valor);
            return true;
        }
        return false;
    }
    
    public String extrato(Conta atual, OperacaoDAO operacoes){
        return operacoes.read(atual);
    }
    
    public boolean vazio(){
        for (Conta conta1 : conta) {
            if (conta1 != null) {
                return false;
            }
        }
        return true;
    }
    
    public boolean vazio(Cliente atual){
        for (Conta conta1 : conta) {
            if (conta1 != null) {
                if(conta1.getTitular().equals(atual))
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
    
    public int posicaoLivre(){
        for(int i =0; i < conta.length; i++){
            if(conta[i] == null) return i;
        }
        return -1;
    }
    
    public void create(Conta novo){
        if(!(this.cheio())){
            final int pos = this.posicaoLivre();           
            
            novo.entrada(new BigDecimal(20000));
            
            conta[pos] = novo;
        }
    }
    
    public String read(){
        if(!(this.vazio())){
            StringBuilder result = new StringBuilder("");
            
            for(Conta aux : conta){
                if(aux != null) {
                    result.append(aux.toString()).append("\n");
                }
            }
            //System.out.println(result);
            return result.toString();
        } else {
            return "Nenhuma conta existente";
        }
    }
    
    public String read(Cliente atual){
        if(!(this.vazio(atual))){
            StringBuilder result = new StringBuilder("");
            
            for(Conta aux : conta){
                if(aux != null && aux.getTitular().equals(atual)) {
                    result.append(aux.toString()).append("\n");
                }
            }
            //System.out.println(result);
            return result.toString();
        } else {
            return "Nenhuma conta existente";
        }
    }
    
    public void update(Conta alvo, Conta altera){
        if(!(this.vazio())){
            
        }
    }
    
    public boolean delete(int id){
        if(!(this.vazio())){
            
            for(int i =0; i < nConta; i++){
                if(conta[i] != null && conta[i].getId() == id){
                    conta[i] = null;
                    return true;
                }
                
            }
        }
        return false;
    }
    
    public void imposto(){
        if(!(this.vazio())){
            
            for(Conta aux : conta){
                aux.retirada(new BigDecimal(15));
            }
        }
    }
}
