/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mvc.model.dao;

import java.util.Date;
import mvc.model.entities.Cliente;
import mvc.model.entities.Conta;
import mvc.model.entities.TipoUsuario;

/**
 *
 * @author pedro
 */
public class ClienteDAO {
    final static int nCliente = 5;
    private Cliente usuario[] = new Cliente[nCliente];
    
    public boolean vazio(){
        for(int i =0; i < usuario.length; i++){
            if(usuario[i] != null) return false;
        }
        return true;
    }
    
    public boolean cheio(){
        for(int i =0; i < usuario.length; i++){
            if(usuario[i] == null) return false;
        }
        return true;
    }
    
    public int pegaPosicao(){
        for(int i =0; i < usuario.length; i++){
            if(usuario[i] == null) return i;
        }
        return -1;
    }
    
    public void create(String nome, String cpf, String endereco, String telefone, String login, String senha, TipoUsuario tipo, Conta conta){
        final int pos = this.pegaPosicao();
        
        Cliente novo = new Cliente();
        
        novo.setInfo(nome, cpf, endereco, telefone);
        novo.setLogin(login, senha);
        novo.setTipo(tipo);
        novo.setConta(conta);
        
        usuario[pos] = novo;
    }
    
    public void read(){
        
    }
    
    public void update(){
        
    }
    
    public void delete(){
        
    }
}
