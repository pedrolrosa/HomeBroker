/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mvc.view;

import java.math.BigDecimal;
import java.util.Scanner;
import javax.swing.JOptionPane;
import mvc.model.dao.AtivoDAO;
import mvc.model.dao.ClienteDAO;
import mvc.model.dao.ContaDAO;
import mvc.model.entities.Cliente;
import mvc.model.entities.Conta;
import mvc.model.enums.TipoUsuario;

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
        return Integer.parseInt(JOptionPane.showInputDialog("1 - Menu Cliente\n2 - Menu Ativo\nSua escolha: "));
    }
    
    public Integer telaADMCliente(){
        return Integer.parseInt(JOptionPane.showInputDialog("1 - Cadastrar Cliente\n2 - Ver Clientes\n3 - Atualizar Cliente\n4 - Excluir Cliente\n0 - Voltar\nSua escolha: "));
    }
    
    public Integer telaADMAtivo(){
        return Integer.parseInt(JOptionPane.showInputDialog("1 - Cadastrar Ativo\n2 - Ver Ativos\n3 - Atualizar Ativo\n4 - Excluir Ativo\n0 - Voltar\nSua escolha: "));
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
    
    public void verCliente(ClienteDAO usuarios){
        JOptionPane.showMessageDialog(null, usuarios.read());
    }
    
    public void atualizarCliente(ClienteDAO usuarios){
        final int id = Integer.parseInt(JOptionPane.showInputDialog(usuarios.read() + "\nExluir com ID: "));
        
    }
    
    public void excluirCliente(ClienteDAO usuarios){
        final int id = Integer.parseInt(JOptionPane.showInputDialog(usuarios.read() + "\nExluir com ID: "));
        
        boolean excluiu = usuarios.delete(id);
        
        if(excluiu) JOptionPane.showMessageDialog(null, "Cliente Excluido");
        else JOptionPane.showMessageDialog(null, "ID Inexistente");
    }
    
    public void cadastraAtivo(AtivoDAO ativos){
        String empresa = JOptionPane.showInputDialog("Empresa: ");
        String ticker = JOptionPane.showInputDialog("Ticker: ");
        
        BigDecimal valor = new BigDecimal(JOptionPane.showInputDialog("Valor: ", JOptionPane.INPUT_VALUE_PROPERTY));
        BigDecimal total = new BigDecimal(JOptionPane.showInputDialog("Total de ativos: ", JOptionPane.INPUT_VALUE_PROPERTY));
        
        ativos.create(empresa, ticker, total, valor);
    }
    
    public void verAtivo(AtivoDAO ativos){
        JOptionPane.showMessageDialog(null, ativos.read());
    }
    
    public void atualizarAtivo(AtivoDAO ativos){
        final int id = Integer.parseInt(JOptionPane.showInputDialog(ativos.read() + "\nExluir com ID: "));
        
    }
    
    public void excluirAtivo(AtivoDAO ativos){
        final int id = Integer.parseInt(JOptionPane.showInputDialog(ativos.read() + "\nExluir com ID: "));
        
        boolean excluiu = ativos.delete(id);
        
        if(excluiu) JOptionPane.showMessageDialog(null, "Cliente Excluido");
        else JOptionPane.showMessageDialog(null, "ID Inexistente");
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
