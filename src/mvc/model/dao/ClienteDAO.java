/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mvc.model.dao;

import mvc.model.entities.Cliente;

/**
 *
 * @author pedro
 */
public class ClienteDAO {
    final static int nCliente = 5;
    private Cliente usuario[] = new Cliente[nCliente];
    
    public int pegaPosicao(){
        for(int i =0; i < usuario.length; i++){
            if(usuario[i] == null) return i;
        }
        return -1;
    }
    
    public void adiciona(String nome){
        final int pos = this.pegaPosicao();
        
        //usuario[pos].setInfo(nome);
    }
}
