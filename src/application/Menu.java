/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package application;

import entities.Cliente;

/**
 *
 * @author pedro
 */
public class Menu {
    
    public Menu(){
        
    }
    
    public void login(Cliente atual, Cliente adm, Cliente[] usuario){
        System.out.println("Login: ");
        String login = Global.scan.nextLine();

        System.out.println("Senha: ");
        String senha = Global.scan.nextLine();

        if(adm.getLogin(login, senha)) atual = adm;
        else{
            for(int i =0; i < usuario.length; i++){
                if(usuario[i].getLogin(login, senha)) {
                    atual = usuario[i];
                    break;
                }
            }
        }

        if(atual == null) System.out.println("Cliente nao encontrado");
        else if(atual == adm){
            // opções pos login adm
        } else {
            // opões pos login comum
        }
    }
}
