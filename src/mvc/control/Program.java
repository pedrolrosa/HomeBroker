package mvc.control;

import mvc.model.dao.ClienteDAO;
import mvc.model.dao.ContaDAO;
import mvc.model.dao.OperacaoDAO;
import mvc.model.entities.Cliente;

public class Program {
    ClienteDAO usuario = new ClienteDAO();
    ContaDAO conta = new ContaDAO();
    OperacaoDAO operacao = new OperacaoDAO();
    
    Cliente atual = null;
        
    public Program(){
        Integer esc =1;
        
        do{
                        
            
            switch(esc){
                case 1:{
                    
                break;}
                
                case 2:{
                break;}
            }
        }while(esc != 0);
    }
        

    public static void main(String[] args) {
        new Program();
    }
}


