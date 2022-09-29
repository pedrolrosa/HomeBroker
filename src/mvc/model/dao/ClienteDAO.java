/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mvc.model.dao;

import mvc.model.entities.Cliente;
import mvc.model.enums.TipoUsuario;

/**
 *
 * @author pedro
 */
public class ClienteDAO {
    final int nCliente = 5;
    private final Cliente usuario[] = new Cliente[nCliente];
    
    public ClienteDAO(){
        
    }    
    
    public Cliente validaLogin(String login, String senha){
        for (Cliente aux : usuario) {
            if (aux != null && aux.getLogin().equals(login) && aux.getSenha().equals(senha)) {
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
    
    public int posicaoLivre(){
        for(int i =0; i < usuario.length; i++){
            if(usuario[i] == null) return i;
        }
        return -1;
    }
    
    public void create(String nome, String cpf, String endereco, String telefone, String login, String senha, TipoUsuario tipo){
        if(!(this.cheio())){
            final int pos = this.posicaoLivre();

            Cliente novo = new Cliente(login, senha);

            novo.setInfo(nome, cpf, endereco, telefone);
            novo.setTipo(tipo);

            usuario[pos] = novo;
        }
    }
    
       public void read(){
         
         boolean temCliente = false;
        for (Cliente aux : usuario) {
            if (aux != null) {
                System.out.println(aux);
                temCliente = true;
            }
        }
        if (!temCliente) {
            System.out.println("não existe cliente cadastrado");
        }
        
    }
    
    public void update(){
        
    }
    
    public void delete(int id){
         final int pos = id - 1;
        
        usuario[pos] = null;
    }
}
