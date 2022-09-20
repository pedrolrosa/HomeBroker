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
    
    
    public Cliente validaLogin(String login, String senha){
        for (Cliente aux : usuario) {
            if (aux.getLogin().equals(login) && aux.getSenha().equals(senha)) {
                return aux;
            }
        }
        return null;
    }
    
    public boolean vazio(){
        for (Cliente aux : usuario) {
            if (aux != null) {
                return false;
            }
        }
        return true;
    }
    
    public boolean cheio(){
        for (Cliente aux : usuario) {
            if (aux == null) {
                return false;
            }
        }
        return true;
    }
    
    public int pegaPosicao(){
        for(int i =0; i < usuario.length; i++){
            if(usuario[i] == null) return i;
        }
        return -1;
    }
    
    public void create(String nome, String cpf, String endereco, String telefone, String login, String senha, TipoUsuario tipo){
        final int pos = this.pegaPosicao();
        
        Cliente novo = new Cliente(login, senha);
        
        novo.setInfo(nome, cpf, endereco, telefone);
        novo.setTipo(tipo);
        
        usuario[pos] = novo;
    }
    
    public void read(){
        
    }
    
    public void update(){
        
    }
    
    public void delete(){
        
    }
}
