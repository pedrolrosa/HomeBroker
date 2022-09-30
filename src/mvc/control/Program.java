package mvc.control;

import mvc.model.dao.ClienteDAO;
import mvc.model.dao.ContaDAO;
import mvc.model.dao.OperacaoDAO;
import mvc.model.entities.Cliente;
import mvc.model.enums.TipoUsuario;
import mvc.view.GUI;

public class Program {
    ClienteDAO usuario = new ClienteDAO();
    ContaDAO conta = new ContaDAO();
    OperacaoDAO operacao = new OperacaoDAO();
    
    Cliente atual = null;
    
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
                    atual = menu.login(usuario);
                break;}
                
                case 2:{
                    atual = menu.login(usuario);
                break;}
                
                case 3:{
                    
                break;}
            }
            
            if(atual != null || esc == 1 || esc == 2){
                if(atual.getTipo() == TipoUsuario.ADM){
                    while(esc != 0){
                        esc = menu.telaADM();
                        
                        switch(esc){
                            case 1:{
                                menu.cadastraCliente(usuario);
                            break;}
                        }
                    }
                } else {
                    while(esc != 0){
                        esc = menu.telaCOMUM();
                        
                        switch(esc){
                            case 1:{
                                menu.cadastraConta(atual, conta);
                            break;}
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


