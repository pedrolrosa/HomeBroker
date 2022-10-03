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
import mvc.model.entities.Ativo;
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
    
    public Cliente login(){
        String login = JOptionPane.showInputDialog("Login: ");
        String senha = JOptionPane.showInputDialog("Senha: ");
        
        Cliente usuario = new Cliente(login, senha);
        return usuario;
    }
    
    public Integer telaADM(){
        return Integer.parseInt(JOptionPane.showInputDialog("1 - Menu Cliente\n2 - Menu Ativo\n0 - Voltar\nSua escolha: "));
    }
    
    public Integer telaADMCliente(){
        return Integer.parseInt(JOptionPane.showInputDialog("1 - Cadastrar Cliente\n2 - Ver Clientes\n3 - Atualizar Cliente\n4 - Excluir Cliente\n0 - Voltar\nSua escolha: "));
    }
    
    public void cadastraCliente(Cliente novo){
        String nome = JOptionPane.showInputDialog("Nome: ");
        String cpf = JOptionPane.showInputDialog("Cpf: ");
        String endereco = JOptionPane.showInputDialog("Endereco: ");
        String telefone = JOptionPane.showInputDialog("Telefone: ");
        
        String login = JOptionPane.showInputDialog("Login: ");
        String senha = JOptionPane.showInputDialog("Senha: ");
        
        TipoUsuario tipo = TipoUsuario.valueOf(JOptionPane.showInputDialog("Tipo: "));
        
        novo.setInfo(nome, cpf, endereco, telefone);
        novo.setLogin(login, senha);
        novo.setTipo(tipo);
    }
    
    public void verCliente(ClienteDAO usuarios){
        JOptionPane.showMessageDialog(null, usuarios.read());
    }
    
    public void atualizarCliente(ClienteDAO usuarios){
        //final int id = Integer.parseInt(JOptionPane.showInputDialog(usuarios.read() + "\nExluir com ID: "));
        
    }
    
    public void excluirCliente(ClienteDAO usuarios){
        final int id = Integer.parseInt(JOptionPane.showInputDialog(usuarios.read() + "\nExluir com ID: "));
        
        boolean excluiu = usuarios.delete(id);
        
        if(excluiu) JOptionPane.showMessageDialog(null, "Cliente Excluido");
        else JOptionPane.showMessageDialog(null, "ID Inexistente");
    }
    
    public Integer telaADMAtivo(){
        return Integer.parseInt(JOptionPane.showInputDialog("1 - Cadastrar Ativo\n2 - Ver Ativos\n3 - Atualizar Ativo\n4 - Excluir Ativo\n0 - Voltar\nSua escolha: "));
    }
    
    public void cadastraAtivo(Ativo novo){
        String empresa = JOptionPane.showInputDialog("Empresa: ");
        String ticker = JOptionPane.showInputDialog("Ticker: ");
        
        BigDecimal valor = new BigDecimal(JOptionPane.showInputDialog("Valor: ", JOptionPane.INPUT_VALUE_PROPERTY));
        BigDecimal total = new BigDecimal(JOptionPane.showInputDialog("Total de ativos: ", JOptionPane.INPUT_VALUE_PROPERTY));
        
        novo.setInfo(empresa, ticker);
        novo.setValues(total, valor);
    }
    
    public void verAtivo(AtivoDAO ativos){
        JOptionPane.showMessageDialog(null, ativos.read());
    }
    
    public void atualizarAtivo(AtivoDAO ativos){
        //final int id = Integer.parseInt(JOptionPane.showInputDialog(ativos.read() + "\nExluir com ID: "));
        
    }
    
    public void excluirAtivo(AtivoDAO ativos){
        final int id = Integer.parseInt(JOptionPane.showInputDialog(ativos.read() + "\nExluir com ID: "));
        
        boolean excluiu = ativos.delete(id);
        
        if(excluiu) JOptionPane.showMessageDialog(null, "Cliente Excluido");
        else JOptionPane.showMessageDialog(null, "ID Inexistente");
    }
    
    public Integer telaCOMUM(){
        return Integer.parseInt(JOptionPane.showInputDialog("1 - Menu Conta\n2 - Menu Operacao\n3 - Menu Ativo\n0 - Voltar\nSua escolha: "));
    }
    
    public Integer telaCOMUMConta(){
        return Integer.parseInt(JOptionPane.showInputDialog("1 - Criar Conta\n0 - Voltar\nSua escolha: "));
    }
    
    public void cadastraConta(Cliente atual, Conta novo){
        Integer escolha = JOptionPane.showConfirmDialog(null, "Deseja criar uma conta ?", "Conta",JOptionPane.YES_NO_OPTION);
        if(escolha != 1){
            novo.setTitular(atual);
            JOptionPane.showMessageDialog(null, "Conta criada");
        } 
    }
    
    public int trocaConta(Cliente atual){
        final int id = Integer.parseInt(JOptionPane.showInputDialog(null,"\nSelecionar pelo ID: "));
        return id;
    }
    
    public void verConta(Cliente atual, ContaDAO contas){
        JOptionPane.showMessageDialog(null, contas.read(atual));
    }
    
    public void excluirConta(Cliente atual, ContaDAO contas){
        final int id = Integer.parseInt(JOptionPane.showInputDialog(contas.read(atual) + "Excluir com o ID: "));
        
        boolean excluiu = contas.delete(id);
        
        if(excluiu) JOptionPane.showMessageDialog(null, "Conta Excluido");
        else JOptionPane.showMessageDialog(null, "ID Inexistente");
    }
    
    public Integer telaCOMUMOperacao(){
        return Integer.parseInt(JOptionPane.showInputDialog("\n0 - Voltar\nSua escolha: "));
    }
    
    public Integer telaCOMUMAtivo(){
        return Integer.parseInt(JOptionPane.showInputDialog("\n0 - Voltar\nSua escolha: "));
    }
}
