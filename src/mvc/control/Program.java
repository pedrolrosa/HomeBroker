package mvc.control;

import mvc.model.dao.ClienteDAO;
import mvc.model.dao.ContaDAO;
import mvc.model.dao.OperacaoDAO;
import mvc.model.entities.Cliente;
import mvc.model.entities.TipoUsuario;
import mvc.view.GUI;

public class Program {
    ClienteDAO usuario = new ClienteDAO();
    ContaDAO conta = new ContaDAO();
    OperacaoDAO operacao = new OperacaoDAO();
    
    Cliente atual = null;
    
    GUI menu = new GUI();
        
    public Program(){
        usuario.create("Joao", "25302", "Jardim Uberaba", "+55 34 99345821", "jao chocolate branco", "oaj", TipoUsuario.ADM);
        
        int esc;
        
        do{
            esc = menu.entrar(atual);    
            
            switch(esc){
                case 1:{
                    atual = menu.login(usuario);
                break;}
                
                case 2:{
                    atual = menu.login(usuario);
                break;}
                
                case 3:{
                    
                break;}
            }
            
            if(esc == 1 || esc == 2){
                if(atual.getTipo() == TipoUsuario.ADM){
                    //opção adm
                } else {
                    //opção comum
                }
            }
        }while(esc != 0);
    }
        

    public static void main(String[] args) {
        Program program = new Program();
    }
}


