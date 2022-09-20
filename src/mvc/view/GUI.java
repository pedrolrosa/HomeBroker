/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mvc.view;

import java.util.Scanner;
import mvc.model.dao.ClienteDAO;
import mvc.model.entities.Cliente;

/**
 *
 * @author pedro
 */
public class GUI {
    Scanner scan = new Scanner(System.in);
    StringBuilder builder = new StringBuilder("");
    
    public GUI(){
        
    }
    
    public int entrar(Cliente atual){
        builder.delete(0, builder.length());
        if(atual == null) builder.append("\n1 - Logar");
        else builder.append("\n2 - Trocar");
        builder.append("\n3 - Pedir Cadastro*");
        builder.append("\n0 - Sair");
        builder.append("\nSua escolha: ");
        
        System.out.println(builder.toString());
        
        return Integer.parseInt(scan.nextLine());
    }
    
    public Cliente login(ClienteDAO usuarios){
        builder.delete(0, builder.length());
        System.out.println("Login: ");
        String login = scan.nextLine();
        System.out.println("Senha: ");
        String senha = scan.nextLine();
        
        Cliente usuario = usuarios.validaLogin(login, senha);
        
        if(usuario == null) builder.append("\nUsuario nao encontrado");
        
        System.out.println(builder.toString());
        
        return usuario;
    }
}
