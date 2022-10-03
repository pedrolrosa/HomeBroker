package mvc.control;

import java.math.BigDecimal;
import mvc.model.dao.AtivoDAO;
import mvc.model.dao.ClienteDAO;
import mvc.model.dao.ContaDAO;
import mvc.model.dao.OperacaoDAO;
import mvc.model.entities.Ativo;
import mvc.model.entities.Cliente;
import mvc.model.entities.Conta;
import mvc.model.enums.TipoUsuario;
import mvc.view.GUI;

public class Program {
    ClienteDAO usuario = new ClienteDAO();
    ContaDAO conta = new ContaDAO();
    OperacaoDAO operacao = new OperacaoDAO();
    AtivoDAO ativo = new AtivoDAO();
    
    Cliente atual = null;
    Conta contaAtual = null;
    
    GUI menu = new GUI();
        
    public Program(){
        
        // adm teste
        usuario.create("Joao", "25302", "Jardim Uberaba", "+55 34 99345821", "adm", "123", TipoUsuario.ADM);
        
        // usuario teste
        usuario.create("Pedro", "32145", "Vallim", "+55 34 99845404", "ped", "321", TipoUsuario.COMUM);
        
        int esc;
        boolean on = true;
        
        while(on){
            esc = menu.entrar(atual);
            
            switch(esc){
                case 0:
                    on = false;
                break;
                
                case 1:{
                    atual = usuario.validaLogin(menu.login());
                break;}
                
                case 2:{
                    atual = usuario.validaLogin(menu.login());
                break;}
                
                case 3:{
                    
                break;}
            }
            
            if(atual == null) continue;
            
            if(esc == 1 || esc == 2){
                if(atual.getTipo() == TipoUsuario.ADM){
                    while(esc != 0){
                        esc = menu.telaADM();
                        
                        switch(esc){
                            case 1:{
                                while(esc != 0){
                                    esc = menu.telaADMCliente();
                                    
                                    switch(esc){
                                        case 1:{
                                            Cliente novo = new Cliente();
                                            menu.cadastraCliente(novo);
                                            usuario.create(novo);
                                        break;}

                                        case 2:{
                                            menu.verCliente(usuario);
                                        break;}

                                        case 3:{
                                            menu.atualizarCliente(usuario);
                                        break;}

                                        case 4:{
                                            menu.excluirCliente(usuario);
                                        break;}

                                        default:
                                            esc = 0;
                                        break;
                                    }
                                }
                            break;}
                            
                            case 2:{
                                while(esc != 0){
                                    esc = menu.telaADMAtivo();
                                    
                                    switch(esc){
                                        case 1:{
                                            Ativo novo = new Ativo();
                                            menu.cadastraAtivo(novo);
                                            ativo.create(novo);
                                        break;}

                                        case 2:{
                                            menu.verAtivo(ativo);
                                        break;}

                                        case 3:{
                                            menu.atualizarAtivo(ativo);
                                        break;}

                                        case 4:{
                                            menu.excluirAtivo(ativo);
                                        break;}

                                        default:
                                            esc = 0;
                                        break;
                                    }
                                }
                            break;}
                        }
                    }
                } else {
                    while(esc != 0){
                        esc = menu.telaCOMUM();
                        
                        switch(esc){
                            case 1:{
                                while(esc != 0){
                                    
                                    menu.telaCOMUMConta();
                                    
                                    switch(esc){
                                        case 1:{
                                            Conta novo = new Conta();
                                            menu.cadastraConta(atual, novo);
                                            conta.create(novo);
                                        break;}
                                        
                                        case 2:{
                                            final int id = menu.trocaConta(atual);
                                            contaAtual = conta.busca(id);
                                        break;}
                                        
                                        case 3:{
                                            menu.verConta(atual, conta);
                                        break;}
                                        
                                        case 4:{
                                            menu.excluirConta(atual, conta);
                                        break;}
                                        
                                        default:
                                        esc = 0;
                                        break;
                                    }
                                }
                            break;}
                            
                            case 2:{
                                menu.telaCOMUMOperacao();
                            break;}
                            
                            case 3:{
                                menu.telaCOMUMAtivo();
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


