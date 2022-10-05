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
    
    public Cliente busca(int id){
        for(Cliente aux : usuario){
            if(aux.getId() == id) return aux;
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
    
    public void create(Cliente novo){
        if(!(this.cheio())){
            final int pos = this.posicaoLivre();
            
            usuario[pos] = novo;
        }
    }
    
    public String read(){
        if(!(this.vazio())){
            StringBuilder result = new StringBuilder("");
            
            for(Cliente aux : usuario){
                if(aux != null) {
                    result.append(aux.toString()).append("\n");
                }
            }
            //System.out.println(result);
            return result.toString();
        } else {
            return "Nenhum usuario existente";
        }
    }
    
    public void update(Cliente alvo, Cliente altera){
        if(!(this.vazio()) && alvo != null){
            alvo.setLogin(altera.getLogin(), altera.getSenha());
        }
    }
    
    public boolean delete(int id){
        if(!(this.vazio())){
            
            for(int i =0; i < nCliente; i++){
                if(usuario[i] != null && usuario[i].getId() == id){
                    usuario[i] = null;
                    return true;
                }
            }
        }
        return false;
    }
}
