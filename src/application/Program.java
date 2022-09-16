package application;

import entities.Cliente;
import entities.Conta;
import entities.TipoUsuario;
import java.math.BigDecimal;

public class Program {

    public static void main(String[] args) {
        Conta admConta = new Conta(new BigDecimal(500000));
        Cliente adm = new Cliente("Warren Buffet", "Jardim Espanha", "70148234690", "+55 31 96919088", "adm", "123", TipoUsuario.ADM, admConta);
        admConta.setTitular(adm);
        
        Cliente[] usuario = new Cliente[3];
        Conta[] conta = new Conta[3];
        
        for(int i =0; i < usuario.length; i++){
            usuario[i].setConta(conta[i]);
            conta[i].setTitular(usuario[i]);
        }
    }
}
