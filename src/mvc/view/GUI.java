/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mvc.view;

import java.math.BigDecimal;
import java.time.LocalDate;
import javax.swing.JOptionPane;
import mvc.model.entities.Ativo;
import mvc.model.entities.AtivoConta;
import mvc.model.entities.Cliente;
import mvc.model.entities.Conta;
import mvc.model.entities.Operacao;
import mvc.model.entities.Ordem;
import mvc.model.enums.EstadoOrdem;
import mvc.model.enums.MeioOperacao;
import mvc.model.enums.TipoOperacao;
import mvc.model.enums.TipoOrdem;
import mvc.model.enums.TipoUsuario;

/**
 *
 * @author pedro
 */
public class GUI {    
    
    public GUI(){
        
    }
    
    public Integer entrar(Cliente atual){
        if(atual == null) return Integer.parseInt(JOptionPane.showInputDialog("1 - Logar\n0 - Sair\nSua escolha: "));
        else return Integer.parseInt(JOptionPane.showInputDialog("2 - Trocar Conta\n0 - Sair\nSua escolha: "));
    }
    
    public String getLogin(){
        String login = JOptionPane.showInputDialog("Login: ");
        
        return login;
    }
    
    public String getSenha(){
        String senha = JOptionPane.showInputDialog("Senha: ");
        
        return senha;
    }
    
    public int getId(){
        final int id = Integer.parseInt(JOptionPane.showInputDialog("Id : "));
        
        return id;
    }
    
    public String getTicker(){
        String ticker = JOptionPane.showInputDialog("Ticker: ");
        
        return ticker;
    }
    
    public long getDays(LocalDate data){
        return Long.parseLong(JOptionPane.showInputDialog("Data: "+ data +"Quantos dias deseja passar ? "));
    }
    
    public BigDecimal setValor(){
        final BigDecimal valor = new BigDecimal(JOptionPane.showInputDialog("Valor : "));
        
        return valor;
    }
    
    public Integer telaADM(){
        return Integer.parseInt(JOptionPane.showInputDialog("1 - Menu Cliente\n2 - Menu Ativo\n3 - Pagar Dividendos\n4 - Manipular Data\n0 - Voltar\nSua escolha: "));
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
    
    public void verCliente(String usuarios){
        JOptionPane.showMessageDialog(null, usuarios);
    }
    
    public Cliente atualizarCliente(Cliente altera){
        String login = JOptionPane.showInputDialog("Login: ");
        String senha = JOptionPane.showInputDialog("Senha: ");
        
        altera.setLogin(login, senha);
        
        return altera;
    }
    
    public void excluirCliente(boolean excluiu){
        if(excluiu) JOptionPane.showMessageDialog(null, "Cliente Excluido");
        else JOptionPane.showMessageDialog(null, "Id inexistente");
    }
    
    public Integer telaADMAtivo(){
        return Integer.parseInt(JOptionPane.showInputDialog("1 - Cadastrar Ativo\n2 - Ver Ativos\n3 - Atualizar Ativo\n4 - Excluir Ativo\n0 - Voltar\nSua escolha: "));
    }
    
    public void cadastraAtivo(Ativo novo){
        String empresa = JOptionPane.showInputDialog("Empresa: ");
        String ticker = JOptionPane.showInputDialog("Ticker: ");
        
        BigDecimal valor = new BigDecimal(JOptionPane.showInputDialog("Valor: "));
        int total = Integer.parseInt(JOptionPane.showInputDialog("Total de ativos: "));
        
        novo.setInfo(empresa, ticker);
        novo.setValues(total, valor);
    }
    
    public void verAtivo(String ativos){
        JOptionPane.showMessageDialog(null, ativos);
    }
    
    public Ativo atualizarAtivo(Ativo altera){
        String empresa = JOptionPane.showInputDialog("Empresa: ");
        String ticker = JOptionPane.showInputDialog("Ticker: ");
        
        altera.setInfo(empresa, ticker);
        
        return altera;
    }
    
    public void excluirAtivo(boolean excluiu){
        if(excluiu) JOptionPane.showMessageDialog(null, "Cliente Excluido");
        else JOptionPane.showMessageDialog(null, "Id inexistente");
    }
    
    public Integer telaCOMUM(){
        return Integer.parseInt(JOptionPane.showInputDialog("1 - Menu Conta\n0 - Voltar\nSua escolha: "));
    }
    
    public Integer telaCOMUMConta(Conta contaAtual){
        if(contaAtual != null) return Integer.parseInt(JOptionPane.showInputDialog("1 - Entrar\n2 - Criar Conta\n3 - Trocar Conta\n4 - Ver Contas\n5 - Excluir Conta\n0 - Voltar\nSua escolha: "));
        else return Integer.parseInt(JOptionPane.showInputDialog("2 - Criar Conta\n3 - Trocar Conta\n4 - Ver Contas\n5 - Excluir Conta\n0 - Voltar\nSua escolha: "));
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
    
    public void verConta(String atual){
        JOptionPane.showMessageDialog(null, atual);
    }
    
    public void verContaSaldo(String saldo){
        JOptionPane.showMessageDialog(null, "Saldo: " + saldo);
    }
    
    public void excluirConta(boolean excluiu){
        if(excluiu) JOptionPane.showMessageDialog(null, "Conta Excluido");
        else JOptionPane.showMessageDialog(null, "Id nao existe");
    }
    
    public Integer telaCOMUMConta(){
        return Integer.parseInt(JOptionPane.showInputDialog("1 - Operacao\n2 - Ativo\n3 - Book de Oferta\n4 - Saldo\n0 - Voltar\nSua escolha: "));
    }
    
    public Integer telaCOMUMOperacao(){
        return Integer.parseInt(JOptionPane.showInputDialog("1 - Deposito\n2 - Saque\n3 - Pagamento\n4 - Transferencia\n5 - Extrato\n0 - Voltar\nSua escolha: "));
    }
    
    public void novaOperacao(Operacao novo, MeioOperacao meio, Conta origem, Conta destino){
        TipoOperacao tipo;
        if(!(meio.equals(MeioOperacao.DEPOSITO) || meio.equals(MeioOperacao.SAQUE))) tipo = TipoOperacao.valueOf(JOptionPane.showInputDialog("Tipo: "));
        else tipo = TipoOperacao.DEBITO;
        String descricao = JOptionPane.showInputDialog("Descricao: ");
        
        novo.setInfo(meio, tipo, descricao);
        novo.setAccounts(origem, destino);        
    }
    
    public void verOperacao(String operacoes){
        JOptionPane.showMessageDialog(null, operacoes);
    }
    
    public void alteraOperacao(){
        
    }
    
    public void excluirOperacao(boolean excluiu){
        if(excluiu) JOptionPane.showMessageDialog(null, "Operacao Excluida");
        else JOptionPane.showMessageDialog(null, "Id inexistente");
    }
    
    public boolean operacaoRealizada(boolean operacao){
        if(operacao) JOptionPane.showMessageDialog(null, "Operacao feita");
        else JOptionPane.showMessageDialog(null, "Nao foi possivel realizar a operacao");
        return operacao;
    }
    
    public Integer telaCOMUMAtivo(){
        return Integer.parseInt(JOptionPane.showInputDialog("1 - Comprar / Vender\n2 - Minhas Ordens\n3 - Meus Ativos\n0 - Voltar\nSua escolha: "));
    }
    
    public Ordem novaOrdem(Conta atual, Ativo ativo, int nAtivo){
        // recebe as informacoes da ordem
        TipoOrdem tipo = TipoOrdem.valueOf(JOptionPane.showInputDialog("Tipo : "));
        
        BigDecimal valor;
        if(tipo.equals(TipoOrdem.ZERO)){
            valor = ativo.getPrecoInicial();
        } else {
            valor = new BigDecimal(JOptionPane.showInputDialog("Valor : "));
        }
        
        int qtd = Integer.parseInt(JOptionPane.showInputDialog("Quantidade : "));
        
        // verifica o saldo e a quantidade de ativos disponivel
        if(atual.getSaldo().subtract(valor.multiply(BigDecimal.valueOf(qtd))).compareTo(BigDecimal.ZERO) >= 0){
            if(tipo.equals(TipoOrdem.ZERO)){
                // verifica se possui a quantidade necessaria para a compra do tipo ordem zero
                if(ativo.getTotal() - qtd >= 0){
                    Ordem novo = new Ordem();
            
                    novo.setConta(atual);
                    novo.setTicker(ativo.getTicker());
                    novo.setTypes(tipo, EstadoOrdem.TOTAL);
                    novo.setValues(qtd, valor);
                    
                    JOptionPane.showMessageDialog(null, "Ordem Criada");
            
                    return novo;
                } else {
                    JOptionPane.showMessageDialog(null, "Nao possui essa quantidade de ativos disponivel");
                }
            } else {
                Ordem novo = new Ordem();
            
                novo.setConta(atual);
                novo.setTicker(ativo.getTicker());
                novo.setTypes(tipo, EstadoOrdem.TOTAL);
                novo.setValues(qtd, valor);
                
                if(tipo.equals(TipoOrdem.VENDA)){
                    if(qtd <= nAtivo){
                        JOptionPane.showMessageDialog(null, "Ordem Criada");
                        return novo;
                    } else {
                        JOptionPane.showMessageDialog(null, "Nao possui essa quantidade de ativos disponivel");
                    }
                } else {
                    JOptionPane.showMessageDialog(null, "Ordem Criada");
                    return novo;
                }
            }
        } else {
            JOptionPane.showMessageDialog(null, "Saldo insuficiente");
        }
        
        return null;
    }
    
    public void verOrdem(String ordens){
        JOptionPane.showMessageDialog(null, ordens);
    }
    
    public void ordemExecutada(boolean ordem){
        if(ordem){
            JOptionPane.showMessageDialog(null, "Ordem Executada");
        } else {
            JOptionPane.showMessageDialog(null, "Ordem na Fila");
        }
    }
    
    public void gerarRelacaoAtivoConta(Conta atual, Ativo alvo, AtivoConta novo){
        novo.setAtivo(alvo);
        novo.setConta(atual);
    }
}
