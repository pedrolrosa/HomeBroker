package application;

import entities.Cliente;
import entities.Conta;
import entities.TipoUsuario;

public class Program {

    public static void main(String[] args) {
        Conta admConta = new Conta();
        Cliente adm = new Cliente("Warren Buffet", "Jardim Espanha", "70148234690", "+55 31 96919088", "adm", "123", TipoUsuario.ADM, admConta);
        Cliente adm2 = new Cliente();
        Cliente adm3 = new Cliente();
        
        System.out.println(adm.toString());
        System.out.println(adm2.toString());
        System.out.println(adm3.toString());
    }
}
