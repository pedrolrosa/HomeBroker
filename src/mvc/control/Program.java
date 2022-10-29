package mvc.control;

import java.math.BigDecimal;
import java.time.LocalDate;
import mvc.model.dao.AtivoContaDAO;
import mvc.model.dao.AtivoDAO;
import mvc.model.dao.ClienteDAO;
import mvc.model.dao.ContaDAO;
import mvc.model.dao.OperacaoDAO;
import mvc.model.dao.OrdemDAO;
import mvc.model.dao.OrdemExecucaoDAO;
import mvc.model.entities.Ativo;
import mvc.model.entities.AtivoConta;
import mvc.model.entities.Cliente;
import mvc.model.entities.Conta;
import mvc.model.entities.Operacao;
import mvc.model.entities.Ordem;
import mvc.model.entities.OrdemExecucao;
import mvc.model.enums.EstadoOrdem;
import mvc.model.enums.MeioOperacao;
import mvc.model.enums.TipoUsuario;
import mvc.model.enums.TipoOrdem;
import mvc.view.GUI;

public class Program {
    private ClienteDAO usuario = new ClienteDAO();
    private ContaDAO conta = new ContaDAO();
    private OperacaoDAO operacao = new OperacaoDAO();
    private AtivoDAO ativo = new AtivoDAO();
    private OrdemDAO ordem = new OrdemDAO();
    private OrdemExecucaoDAO ordemExecucao = new OrdemExecucaoDAO();
    private AtivoContaDAO relacaoAtivoConta = new AtivoContaDAO();
    
    private Cliente atual = null;
    private Conta contaAtual = null;
    
    private GUI menu = new GUI();
    
    private LocalDate data = LocalDate.now();
        
    public Program(){
        
        // adm teste
        usuario.create("Joao", "25302", "Jardim Uberaba", "+55 34 99345821", "adm", "123", TipoUsuario.ADM);
        Conta bolsa = new Conta();
        bolsa.entrada(new BigDecimal(500000));
        bolsa.setTitular(usuario.adm());
        conta.create(bolsa);
        
        // usuario teste
        usuario.create("Pedro", "32145", "Vallim", "+55 34 99845404", "ped", "321", TipoUsuario.COMUM);
        
        // usuario teste
        usuario.create("Eduardo", "43211", "Jardim Espanha", "+55 34 12345667", "edu", "123", TipoUsuario.COMUM);
        
        // ativo teste
        ativo.create("tucos taxi", "tuc", 10, BigDecimal.TEN);
        
        // ativo teste
        ativo.create("carl johnson", "cj", 10, BigDecimal.TEN);
        
        // ativo teste
        ativo.create("tvn", "tvn", 10, BigDecimal.TEN);
        
        int esc, op;
        boolean on = true;
        
        System.out.println(data.toString());
        
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
                                
                                op = 1;
                                while(op != 0){
                                    // CRUD de cliente
                                    op = menu.telaADMCliente();
                                    
                                    switch(op){
                                        // cria um novo cliente
                                        case 1:{
                                            // criar um novo objeto  da classe cliente
                                            Cliente novo = new Cliente();
                                            
                                            // inseri os dados no novo objeto
                                            menu.cadastraCliente(novo);
                                            
                                            // adiciona novo cliente no vetor de cliente DAO
                                            usuario.create(novo);
                                        break;}

                                        // mostra todos os clientes registrados
                                        case 2:{
                                            // le o vetor de cliente DAO, mostrando todos os clientes registrados
                                            menu.verCliente(usuario.read());
                                        break;}

                                        // altera um cliente existente
                                        case 3:{
                                            // mostra os clientes para escolher um para alterar
                                            menu.verCliente(usuario.read());
                                            
                                            // recebe o id do cliente escolhido que sera alterado
                                            final int id = menu.getId();
                                            
                                            // cria um 'ponteiro' para o objeto do cliete buscado pelo id na cliente DAO
                                            Cliente alvo = usuario.busca(id);
                                            
                                            // altera o objeto do cliente pelo cliente DAO
                                            usuario.update(alvo, menu.atualizarCliente(alvo));
                                        break;}

                                        // exclui um cliente existente
                                        case 4:{
                                            // mostra os clientes para escolher um para excluir
                                            menu.verCliente(usuario.read());
                                            
                                            // recebe e passa o id do cliete que sera excluido como parametro do metodo de exclusao do cliete DAO
                                            menu.excluirCliente(usuario.delete(menu.getId()));
                                        break;}

                                        default:
                                            op = 0;
                                        break;
                                    }
                                }
                            break;}
                            
                            // menu ativo
                            case 2:{
                                
                                op = 1;
                                while(op != 0){
                                    // CRUD de ativo
                                    op = menu.telaADMAtivo();
                                    
                                    switch(op){
                                        // criar um novo ativo
                                        case 1:{
                                            // criar um novo objeto  da classe ativo
                                            Ativo novo = new Ativo();
                                            
                                            // inseri os dados no novo objeto
                                            menu.cadastraAtivo(novo);
                                            
                                            // adiciona novo ativo no vetor de ativo DAO
                                            ativo.create(novo);
                                        break;}

                                        // mostra todos os ativos registrados
                                        case 2:{
                                            // le o vetor de ativo DAO, mostrando todos os ativos registrados
                                            menu.verAtivo(ativo.read());
                                        break;}

                                        // altera um ativo existente
                                        case 3:{
                                            // mostra os ativos para escolher um para alterar
                                            menu.verAtivo(ativo.read());
                                            
                                            // recebe o id do ativo escolhido que sera alterado
                                            final int id = menu.getId();
                                            
                                            // cria um 'ponteiro' para o objeto do ativo buscado pelo id na ativo DAO
                                            Ativo alvo = ativo.busca(id);
                                            
                                            // altera o objeto do ativo pelo cliente DAO
                                            ativo.update(alvo, menu.atualizarAtivo(alvo));
                                        break;}

                                        // exclui um ativo existente
                                        case 4:{
                                            // mostra os clientes para escolher um para excluir
                                            menu.verAtivo(ativo.read());
                                            
                                            // recebe e passa o id do cliete que sera excluido como parametro do metodo de exclusao do cliete DAO
                                            menu.excluirAtivo(ativo.delete(menu.getId()));
                                        break;}

                                        default:
                                            op = 0;
                                        break;
                                    }
                                }
                            break;}
                            
                            // pagar dividendos
                            case 3:{
                                // mostra os ativos para escolher um do ativo DAO
                                menu.verAtivo(ativo.read());
                                
                                // recebe o id do ativo escolhido
                                final int id = menu.getId();
                                
                                // recebe o valor que sera pago para as contas que possuem o ativo
                                BigDecimal valor = menu.setValor();
                                
                                // executa o metodo pagarDividendos com os parametros do id do ativo e o valor que sera pago a conta
                                relacaoAtivoConta.pagarDividendos(id, valor);
                            break;}
                            
                            // manipular data
                            case 4:{
                                int mesPassado = data.getMonthValue();
                                data = data.plusDays(menu.getDays(data));
                                int mesAtual = data.getMonthValue();
                                
                                if(mesAtual > mesPassado)
                                    conta.imposto();
                                
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
                                                                // CRUD de operacao na conta
                                                                op = menu.telaCOMUMOperacao();
                                                                
                                                                switch(op){
                                                                    //deposito
                                                                    case 1:{
                                                                        // cria um objeto novo de operacao
                                                                        Operacao novo = new Operacao();
                                                                        
                                                                        // recebe o valor do operacao
                                                                        BigDecimal valor = menu.setValor();
                                                                        
                                                                        // inseri o valor ao novo objeo
                                                                        novo.setInfo(valor);
                                                                        
                                                                        // se a operacao for realizada, ela sera cadastrada no vetor de operacao DAO
                                                                        if(menu.operacaoRealizada(conta.deposito(contaAtual, valor))){
                                                                            menu.novaOperacao(novo, MeioOperacao.DEPOSITO, null, contaAtual);
                                                                            operacao.create(novo);
                                                                        }
                                                                    break;}
                                                                    
                                                                    //saque
                                                                    case 2:{
                                                                        // cria um objeto novo de operacao
                                                                        Operacao novo = new Operacao();
                                                                        
                                                                        // recebe o valor do operacao
                                                                        BigDecimal valor = menu.setValor();
                                                                        
                                                                        // inseri o valor ao novo objeo
                                                                        novo.setInfo(valor);
                                                                        
                                                                        // se a operacao for realizada, ela sera cadastrada no vetor de operacao DAO
                                                                        if(menu.operacaoRealizada(conta.saque(contaAtual, valor))){
                                                                            menu.novaOperacao(novo, MeioOperacao.SAQUE, contaAtual, null);
                                                                            operacao.create(novo);
                                                                        }
                                                                    break;}
                                                                    
                                                                    //pagamento
                                                                    case 3:{
                                                                        // cria um objeto novo de operacao
                                                                        Operacao novo = new Operacao();
                                                                        
                                                                        // recebe o valor do operacao
                                                                        BigDecimal valor = menu.setValor();
                                                                        
                                                                        // inseri o valor ao novo objeo
                                                                        novo.setInfo(valor);
                                                                        
                                                                        // se a operacao for realizada, ela sera cadastrada no vetor de operacao DAO
                                                                        if(menu.operacaoRealizada(conta.pagamento(contaAtual, valor))){
                                                                            menu.novaOperacao(novo, MeioOperacao.PAGAMENTO, contaAtual, conta.adm());
                                                                            operacao.create(novo);
                                                                        }
                                                                    break;}
                                                                    
                                                                    //transferencia
                                                                    case 4:{
                                                                        // cria um objeto novo de operacao
                                                                        Operacao novo = new Operacao();
                                                                        
                                                                        // recebe o valor do operacao
                                                                        BigDecimal valor = menu.setValor();
                                                                        
                                                                        // inseri o valor ao novo objeo
                                                                        novo.setInfo(valor);
                                                                        
                                                                        //mostra as contas existentes para escolher uma conta de destino para realizar a transferencia
                                                                        menu.verConta(conta.read());
                                                                        
                                                                        // recebe o id da conta de destino
                                                                        final int id = menu.getId();
                                                                        
                                                                        // verfica se a conta de destino nao é a conta origem
                                                                        if(contaAtual.getId() != id){
                                                                            // se a operacao for realizada, ela sera cadastrada no vetor de operacao DAO
                                                                            if(menu.operacaoRealizada(conta.transferencia(contaAtual, id, valor))){
                                                                                menu.novaOperacao(novo, MeioOperacao.TRANSFERENCIA, contaAtual, conta.busca(id));
                                                                                operacao.create(novo);
                                                                            }
                                                                        }
                                                                        
                                                                        
                                                                    break;}
                                                                    
                                                                    //extrato
                                                                    case 5:{
                                                                        // mostra todas as operacoes da conta atual
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
                                                                    // gera uma nova ordem
                                                                    case 1:{
                                                                        // verifica se existe ativos registrados
                                                                        if(!(ativo.vazio())){
                                                                            // mostra todos os ativos existentes
                                                                            menu.verAtivo(ativo.read());
                                                                            
                                                                            Ativo ativoAlvo = ativo.busca(menu.getTicker());
                                                                            
                                                                            // cria uma nova ordem
                                                                            Ordem ordemNova = menu.novaOrdem(contaAtual, ativoAlvo, relacaoAtivoConta.nAtivos(contaAtual, ativoAlvo));
                                                                            
                                                                            // verifica se a ordem foi criada
                                                                            if(ordemNova != null){
                                                                                // verifica se a ordem é de tipo zero
                                                                                if(ordemNova.getTipo().equals(TipoOrdem.ZERO)){
                                                                                    
                                                                                    // seta as informacoes para a execucao da ordem
                                                                                    OrdemExecucao ordemExecutada = new OrdemExecucao();
                                                                                    ordemExecutada.setOrdem(ordemNova);
                                                                                    ordemExecutada.setCompra(contaAtual);
                                                                                    ordemExecutada.setVenda(bolsa);
                                                                                    
                                                                                    // seta a relacao do ativo com a conta que o possui
                                                                                    AtivoConta relacaoZero = new AtivoConta();
                                                                                    relacaoZero.setAtivo(ativo.busca(ordemNova.getTicker()));
                                                                                    relacaoZero.setConta(ordemNova.getConta());
                                                                                    
                                                                                    // a conta compradora paga o valor total da ordem
                                                                                    contaAtual.retirada(ordemNova.getValorTotal());
                                                                                    
                                                                                    // remove os ativos vendidos para a conta, do vetor de ativos existentes 
                                                                                    ativo.subAtivo(ordemNova.getTicker(), ordemNova.getQtd());
                                                                                    
                                                                                    // adiciona a relacao do ativo com a conta ao registro
                                                                                    relacaoAtivoConta.create(relacaoZero, ordemNova.getQtd());
                                                                                    
                                                                                    // adiciona o registro da ordem ja executada
                                                                                    ordemExecucao.create(ordemExecutada);
                                                                                } else {
                                                                                    ordem.create(ordemNova);
                                                                                    Ordem satisfaz = ordem.satisfaz(ordemNova);
                                                                                    
                                                                                    // verifica se existe uma ordem que satisfaça a nova ordem
                                                                                    if(satisfaz != null){
                                                                                        OrdemExecucao ordemExecutada = new OrdemExecucao();
                                                                                        
                                                                                        AtivoConta relacaoOrdem = new AtivoConta();
                                                                                        relacaoOrdem.setAtivo(ativo.busca(ordemNova.getTicker()));
                                                                                        
                                                                                        if(ordemNova.getTipo().equals(TipoOrdem.COMPRA)){
                                                                                            // seta as informacoes para a execucao da ordem
                                                                                            ordemExecutada.setCompra(ordemNova.getConta());
                                                                                            ordemExecutada.setVenda(satisfaz.getConta());
                                                                                            ordemExecutada.setOrdem(ordemNova);
                                                                                            
                                                                                            relacaoOrdem.setConta(ordemNova.getConta());
                                                                                            
                                                                                            // compra a quantidade para a conta compradora
                                                                                            if(ordemNova.getEstado().equals(EstadoOrdem.TOTAL)){
                                                                                                relacaoAtivoConta.create(relacaoOrdem, ordemNova.getQtd());
                                                                                                ordemExecutada.setQuantidade(ordemNova.getQtd());
                                                                                                ordemNova.getConta().retirada(ordemNova.getValorTotal());
                                                                                                satisfaz.getConta().entrada(ordemNova.getValorTotal());
                                                                                            } else {
                                                                                                relacaoAtivoConta.create(relacaoOrdem, satisfaz.getQtd());
                                                                                                ordemExecutada.setQuantidade(satisfaz.getQtd());
                                                                                                ordemNova.getConta().retirada(satisfaz.getValorTotal());
                                                                                                satisfaz.getConta().entrada(satisfaz.getValorTotal());
                                                                                                
                                                                                                // ajusta a quantidade de ativos que estao na ordem parcial
                                                                                                ordemNova.subQtd(satisfaz.getQtd());
                                                                                            }
                                                                                            
                                                                                            // vende a quantidade na conta vendedora
                                                                                            if(satisfaz.getEstado().equals(EstadoOrdem.TOTAL)){
                                                                                                relacaoAtivoConta.delete(ordemNova.getTicker(), satisfaz.getConta(), satisfaz.getQtd());
                                                                                            } else {
                                                                                                relacaoAtivoConta.delete(ordemNova.getTicker(), satisfaz.getConta(), ordemNova.getQtd());
                                                                                                
                                                                                                // ajusta a quantidade de ativos que estao na ordem parcial
                                                                                                satisfaz.subQtd(ordemNova.getQtd());
                                                                                            }
                                                                                            
                                                                                        } else {
                                                                                            // seta as informacoes para a execucao da ordem
                                                                                            ordemExecutada.setCompra(satisfaz.getConta());
                                                                                            ordemExecutada.setVenda(ordemNova.getConta());
                                                                                            ordemExecutada.setOrdem(ordemNova);
                                                                                            
                                                                                            relacaoOrdem.setConta(satisfaz.getConta());
                                                                                            
                                                                                            if(satisfaz.getEstado().equals(EstadoOrdem.TOTAL)){
                                                                                                relacaoAtivoConta.create(relacaoOrdem, satisfaz.getQtd());
                                                                                                ordemExecutada.setQuantidade(satisfaz.getQtd());
                                                                                                satisfaz.getConta().retirada(satisfaz.getValorTotal());
                                                                                                ordemNova.getConta().entrada(satisfaz.getValorTotal());
                                                                                            } else {
                                                                                                relacaoAtivoConta.create(relacaoOrdem, ordemNova.getQtd());
                                                                                                ordemExecutada.setQuantidade(ordemNova.getQtd());
                                                                                                satisfaz.getConta().retirada(ordemNova.getValorTotal());
                                                                                                ordemNova.getConta().entrada(ordemNova.getValorTotal());
                                                                                                
                                                                                                // ajusta a quantidade de ativos que estao na ordem parcial
                                                                                                satisfaz.subQtd(ordemNova.getQtd());
                                                                                            }
                                                                                            
                                                                                            if(ordemNova.getEstado().equals(EstadoOrdem.TOTAL)){
                                                                                                relacaoAtivoConta.delete(ordemNova.getTicker(), ordemNova.getConta(), ordemNova.getQtd());
                                                                                            } else {
                                                                                                relacaoAtivoConta.delete(ordemNova.getTicker(), ordemNova.getConta(), satisfaz.getQtd());
                                                                                                
                                                                                                // ajusta a quantidade de ativos que estao na ordem parcial
                                                                                                ordemNova.subQtd(satisfaz.getQtd());
                                                                                            }
                                                                                        }
                                                                                        
                                                                                        // registra a ordem executada
                                                                                        ordemExecucao.create(ordemExecutada);
                                                                                        
                                                                                        // deleta as ordens que forem satisfeitas 
                                                                                        if(ordemNova.getEstado().equals(EstadoOrdem.TOTAL)) ordem.delete(ordemNova);
                                                                                        if(satisfaz.getEstado().equals(EstadoOrdem.TOTAL)) ordem.delete(satisfaz);
                                                                                    }
                                                                                }
                                                                            }
                                                                        }
                                                                    break;}
                                                                    
                                                                    // mostra as ordens do usuario
                                                                    case 2:{
                                                                        menu.verOrdem(ordem.read(contaAtual));
                                                                    break;}
                                                                    
                                                                    // mostra os ativos que o usuario possui
                                                                    case 3:{
                                                                        menu.verAtivo(relacaoAtivoConta.read(contaAtual));
                                                                    break;}
                                                                    
                                                                    default:
                                                                    op = 0;
                                                                    break;
                                                                }
                                                            }
                                                        break;}
                                                        
                                                        // book de ofertas
                                                        case 3:{
                                                            menu.verAtivo(ativo.read());
                                                            final String ticker = menu.getTicker();
                                                            menu.verOrdem(ordem.read(ticker));
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
                                        
                                        // criar conta
                                        case 2:{
                                            // cria um novo objeto conta
                                            Conta novo = new Conta();
                                            
                                            // registra o titular no novo objeto
                                            menu.cadastraConta(atual, novo);
                                            
                                            // registra a nova conta do vetor de conta DAO
                                            conta.create(novo);
                                            
                                            // a conta atual do usuario logado passa a ser a conta que acabou de ser criada
                                            contaAtual = novo;
                                        break;}
                                        
                                        // trocar conta pelo id
                                        case 3:{
                                            // mostra as contas do cliente logado
                                            menu.verConta(conta.read(atual));
                                            
                                            // se o usuario possuir conta registrada, sera mostrado todas as contas dele e o mesmo passara o id da conta para qual sera trocada
                                            if(!(conta.vazio(atual)))contaAtual = conta.busca(menu.trocaConta(atual));
                                        break;}
                                        
                                        // ver contas
                                        case 4:{
                                            // mostra as contas do cliente logado
                                            menu.verConta(conta.read(atual));
                                        break;}
                                        
                                        // excluir conta pelo id
                                        case 5:{
                                            // mostra as contas do cliente logado
                                            menu.verConta(conta.read(atual));
                                            
                                            // inicializa um objeto Integer chamado id para receber o id da conta que sera excluida futuramente
                                            Integer id = null;
                                            
                                            // verifica se o cliente logado possui conta
                                            if(!(conta.vazio(atual))){
                                                // se possuir ele informa o id da conta que sera excluida
                                                id = menu.getId();
                                                
                                                // valida se a conta foi excluida ou nao, executando o metodo de exclusao como parametro
                                                menu.excluirConta(conta.delete(id));
                                            }
                                            
                                            // se ele trocou a conta, ele alterou o valor do objeo id e entao entrara no if
                                            if(id != null){
                                                // verifica se a conta excluida foi a atual, se sim, o cliente entrara automaticamente em outra conta, caso ele possui
                                                if(contaAtual.getId() == id) contaAtual = conta.busca(atual);
                                            }
                                        break;}
                                        
                                        default:
                                        op = 0;
                                        break;
                                    }
                                }
                            break;}
                            
                            default:
                                esc = 0;
                            break;
                        }
                    }                    
                }
            }
        }
    }
        

    public static void main(String[] args) {
        Program program = new Program();
    }
}


