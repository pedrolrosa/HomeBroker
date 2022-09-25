/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mvc.view;

import java.util.Scanner;
import javax.swing.JOptionPane;
import mvc.model.dao.ClienteDAO;
import mvc.model.dao.ContaDAO;
import mvc.model.entities.Cliente;
import mvc.model.entities.Conta;
import mvc.model.entities.TipoUsuario;

/**
 *
 * @author pedro
 */
public class GUI {
    Scanner scan = new Scanner(System.in);
    
    public GUI(){
        
    }
    
    public Integer entrar(Cliente atual){
        if(atual == null) return Integer.parseInt(JOptionPane.showInputDialog("1 - Logar\n0 - Sair\nSua escolha: "));
        else return Integer.parseInt(JOptionPane.showInputDialog("2 - Trocar Conta\n0 - Sair\nSua escolha: "));
    }
    
    public Cliente login(ClienteDAO usuarios){
        String login = JOptionPane.showInputDialog("Login: ");
        String senha = JOptionPane.showInputDialog("Senha: ");
        
        Cliente usuario = usuarios.validaLogin(login, senha);
        
        if(usuario == null) JOptionPane.showMessageDialog(null, "Usuario nao existe");
        
        return usuario;
    }
    
    public Integer telaADM(){
        return Integer.parseInt(JOptionPane.showInputDialog("1 - Cadastrar Cliente\n0 - Voltar\nSua escolha: "));
    }
    
    public void cadastraCliente(ClienteDAO usuarios){
        String nome = JOptionPane.showInputDialog("Nome: ");
        String cpf = JOptionPane.showInputDialog("Cpf: ");
        String endereco = JOptionPane.showInputDialog("Endereco: ");
        String telefone = JOptionPane.showInputDialog("Telefone: ");
        
        String login = JOptionPane.showInputDialog("Login: ");
        String senha = JOptionPane.showInputDialog("Senha: ");
        
        TipoUsuario tipo = TipoUsuario.valueOf(JOptionPane.showInputDialog("Tipo: "));
        
        usuarios.create(nome, cpf, endereco, telefone, login, senha, tipo);
    }
    
    public Integer telaCOMUM(){
        return Integer.parseInt(JOptionPane.showInputDialog("1 - Criar Conta\n0 - Voltar\nSua escolha: "));
    }
    
    public void cadastraConta(Cliente atual, ContaDAO contas){
        Integer escolha = JOptionPane.showConfirmDialog(null, "Deseja criar uma conta ?", "Conta",JOptionPane.YES_NO_OPTION);
        if(escolha != 1){
            if(atual.getConta() == null){
                contas.create(atual);
                atual.setConta(contas.busca(atual));
                JOptionPane.showMessageDialog(null, "Conta criada");
            } else JOptionPane.showMessageDialog(null, "Ja possui uma conta", "Conta", JOptionPane.WARNING_MESSAGE);
        } 
    }
}
