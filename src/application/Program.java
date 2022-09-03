package application;

import entities.Cliente;
import entities.TipoUsuario;

public class Program {

    public static void main(String[] args) {
        Cliente adm = new Cliente(1, "Warren Buffet", "Jardim Espanha", "70148234690", "+55 31 96919088", "adm", "123", TipoUsuario.ADM);
        
        System.out.println(adm.toString());
    }
}
