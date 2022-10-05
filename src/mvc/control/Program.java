package mvc.control;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Date;
import javax.swing.JOptionPane;
import mvc.model.dao.AtivoDAO;
import mvc.model.dao.ClienteDAO;
import mvc.model.dao.ContaDAO;
import mvc.model.dao.OperacaoDAO;
import mvc.model.entities.Ativo;
import mvc.model.entities.Cliente;
import mvc.model.entities.Conta;
import mvc.model.entities.Operacao;
import mvc.model.enums.MeioOperacao;
import mvc.model.enums.TipoUsuario;
import mvc.view.GUI;

public class Program {
    private ClienteDAO usuario = new ClienteDAO();
    private ContaDAO conta = new ContaDAO();
    private OperacaoDAO operacao = new OperacaoDAO();
    private AtivoDAO ativo = new AtivoDAO();
    
    private Cliente atual = null;
    private Conta contaAtual = null;
    
    private GUI menu = new GUI();
    
    private LocalDateTime data = LocalDateTime.now();
        
    public Program(){
        
        // adm teste
        usuario.create("Joao", "25302", "Jardim Uberaba", "+55 34 99345821", "adm", "123", TipoUsuario.ADM);
        
        // usuario teste
        usuario.create("Pedro", "32145", "Vallim", "+55 34 99845404", "ped", "321", TipoUsuario.COMUM);
        
        Integer esc = null, op = null;
        boolean on = true;
        
        while(on){
            // inicializa o programa pedindo login ou para sair
            esc = menu.entrar(atual);
            
            switch(esc){
                case 0:
                    on = false;
                break;
                
                case 1:{
                    // valida o primeiro login
                    atual = usuario.validaLogin(menu.getLogin(), menu.getSenha());
                break;}
                
                case 2:{
                    // caso queira trocar de usuario 
                    atual = usuario.validaLogin(menu.getLogin(), menu.getSenha());
                break;}
                
                case 3:{
                    
                break;}
            }
            
            // se o login nao existir o programa retorna a tela inicial
            if(atual == null) continue;
            
            // verifica se a escolha do cliente foi logar
            if(esc == 1 || esc == 2){
                // verifica se o cliente logado é adm
                if(atual.getTipo() == TipoUsuario.ADM){
                    while(esc != 0){
                        // opcoes para o usuario do tipo adm
                        esc = menu.telaADM();
                        
                        switch(esc){
                            // menu cliente
                            case 1:{
                                // CRUD de cliente
                                op = 1;
                                while(op != 0){
                                    op = menu.telaADMCliente();
                                    
                                    switch(op){
                                        case 1:{
                                            // criar cliente
                                            Cliente novo = new Cliente();
                                            menu.cadastraCliente(novo);
                                            usuario.create(novo);
                                        break;}

                                        case 2:{
                                            // ver clientes
                                            menu.verCliente(usuario.read());
                                        break;}

                                        case 3:{
                                            // editar cliente pelo id
                                            menu.verCliente(usuario.read());
                                            final int id = menu.getId();
                                            Cliente alvo = usuario.busca(id);
                                            usuario.update(alvo, menu.atualizarCliente(alvo));
                                        break;}

                                        case 4:{
                                            // excluir cliente pelo id
                                            menu.verCliente(usuario.read());
                                            menu.excluirCliente(usuario.delete(menu.getId()));
                                        break;}

                                        default:
                                            op = 0;
                                        break;
                                    }
                                }
                            break;}
                            
                            case 2:{
                                // CRUD de ativo
                                op = 1;
                                while(op != 0){
                                    op = menu.telaADMAtivo();
                                    
                                    switch(op){
                                        // criar ativo
                                        case 1:{
                                            Ativo novo = new Ativo();
                                            menu.cadastraAtivo(novo);
                                            ativo.create(novo);
                                        break;}

                                        // ver ativos
                                        case 2:{
                                            menu.verAtivo(ativo.read());
                                        break;}

                                        // editar ativo pelo id
                                        case 3:{
                                            menu.verAtivo(ativo.read());
                                            final int id = menu.getId();
                                            Ativo alvo = ativo.busca(id);
                                            ativo.update(alvo, menu.atualizarAtivo(alvo));
                                        break;}

                                        // excluir ativo pelo id
                                        case 4:{
                                            menu.verAtivo(ativo.read());
                                            menu.excluirAtivo(ativo.delete(menu.getId()));
                                        break;}

                                        default:
                                            op = 0;
                                        break;
                                    }
                                }
                            break;}
                        }
                    }
                // se o cliente logado nao for adm, entao ele sera comum
                } else {
                    esc = 1;
                    while(esc != 0){
                        // opcoes para o usuario do tipo comum
                        esc = menu.telaCOMUM();
                        
                        switch(esc){
                            // CRUD e administração da conta atual do usuario comum
                            case 1:{
                                op = 1;
                                while(op != 0){
                                    
                                    op = menu.telaCOMUMConta(contaAtual);
                                    
                                    switch(op){
                                        // operacoes, gerenciamento de ativos e book de ofertas para o usuario comum
                                        case 1:{
                                            if(contaAtual != null){
                                                esc = 1;
                                                while(esc != 0){
                                                    esc = menu.telaCOMUMConta();
                                                    
                                                    switch(esc){
                                                        // cliente faz uma operacao na conta atual do mesmo
                                                        case 1:{
                                                            op = 1;
                                                            while(op != 0){
                                                                op = menu.telaCOMUMOperacao();
                                                                
                                                                switch(op){
                                                                    //deposito
                                                                    case 1:{
                                                                        Operacao novo = new Operacao();
                                                                        BigDecimal valor = menu.setValor();
                                                                        novo.setInfo(valor);
                                                                        
                                                                        boolean verifica = menu.operacaoRealizada(conta.deposito(contaAtual, valor));
                                                                        
                                                                        if(verifica){
                                                                            menu.novaOperacao(novo, MeioOperacao.DEPOSITO, null, contaAtual);
                                                                            operacao.create(novo);
                                                                        }
                                                                    break;}
                                                                    
                                                                    //saque
                                                                    case 2:{
                                                                        Operacao novo = new Operacao();
                                                                        BigDecimal valor = menu.setValor();
                                                                        novo.setInfo(valor);
                                                                        
                                                                        if(menu.operacaoRealizada(conta.saque(contaAtual, valor))){
                                                                            menu.novaOperacao(novo, MeioOperacao.SAQUE, contaAtual, null);
                                                                            operacao.create(novo);
                                                                        }
                                                                    break;}
                                                                    
                                                                    //pagamento
                                                                    case 3:{
                                                                        Operacao novo = new Operacao();
                                                                        BigDecimal valor = menu.setValor();
                                                                        novo.setInfo(valor);
                                                                        
                                                                        if(menu.operacaoRealizada(conta.pagamento(contaAtual, valor))){
                                                                            menu.novaOperacao(novo, MeioOperacao.PAGAMENTO, contaAtual, conta.adm());
                                                                            operacao.create(novo);
                                                                        }
                                                                    break;}
                                                                    
                                                                    //transferencia
                                                                    case 4:{
                                                                        Operacao novo = new Operacao();
                                                                        BigDecimal valor = menu.setValor();
                                                                        novo.setInfo(valor);
                                                                        
                                                                        menu.verConta(conta.read());
                                                                        final int id = menu.getId();
                                                                        
                                                                        if(menu.operacaoRealizada(conta.transferencia(contaAtual, id, valor))){
                                                                            menu.novaOperacao(novo, MeioOperacao.TRANSFERENCIA, contaAtual, conta.busca(id));
                                                                            operacao.create(novo);
                                                                        }
                                                                    break;}
                                                                    
                                                                    //extrato
                                                                    case 5:{
                                                                        menu.verOperacao(operacao.read(contaAtual));
                                                                    break;}
                                                                    
                                                                    default:
                                                                    op = 0;
                                                                    break;
                                                                }
                                                            }
                                                        break;}
                                                        
                                                        // tela ativos
                                                        case 2:{
                                                            op = 1;
                                                            while(op != 0){
                                                                op = menu.telaCOMUMAtivo();
                                                                
                                                                switch(op){
                                                                    
                                                                }
                                                            }
                                                        break;}
                                                        
                                                        // book de ofertas
                                                        case 3:{
                                                            
                                                        break;}
                                                        
                                                        // ver saldo da conta
                                                        case 4:{
                                                            menu.verContaSaldo(contaAtual.getSaldo().toString());
                                                        break;}
                                                        
                                                        default:
                                                        esc = 0;
                                                        break;
                                                    }
                                                }
                                                op =1;
                                            } 
                                        break;}
                                        
                                        // CRUD de conta do cliente logado 
                                        
                                        case 2:{
                                            // criar conta
                                            Conta novo = new Conta();
                                            menu.cadastraConta(atual, novo);
                                            conta.create(novo);
                                            contaAtual = novo;
                                        break;}
                                        
                                        case 3:{
                                            // trocar conta pelo id
                                            menu.verConta(conta.read(atual));
                                            contaAtual = conta.busca(menu.trocaConta(atual));
                                        break;}
                                        
                                        case 4:{
                                            // ver contas
                                            menu.verConta(conta.read(atual));
                                        break;}
                                        
                                        case 5:{
                                            // excluir conta pelo id
                                            menu.verConta(conta.read(atual));
                                            menu.excluirConta(conta.delete(menu.getId()));
                                        break;}
                                        
                                        default:
                                        op = 0;
                                        break;
                                    }
                                }
                            break;}
                            
                            case 2:{
                                
                            break;}
                            
                            case 3:{
                                
                            break;}
                            
                            default:
                                esc = 0;
                            break;
                        }
                    }                    
                }
            }
        };
    }
        

    public static void main(String[] args) {
        new Program();
    }
}


