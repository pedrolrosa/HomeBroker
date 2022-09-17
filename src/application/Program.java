package application;

import application.Menu;
import entities.Cliente;
import entities.Conta;
import entities.TipoUsuario;
import entities.TiposOperacao;
import entities.Transacao;
import java.math.BigDecimal;
import java.util.Scanner;

class Global{
    static Scanner scan = new Scanner(System.in);
}

public class Program {

    public static void main(String[] args) {
        
        Conta admConta = new Conta(new BigDecimal(500000));
        Cliente adm = new Cliente("Warren Buffet", "Jardim Espanha", "70148234690", "+55 31 96919088", "adm", "123", TipoUsuario.ADM);
        admConta.setTitular(adm);
        
        Cliente[] usuario = new Cliente[3];
        Conta[] conta = new Conta[3];
        
        usuario[0] = new Cliente("Jorge", "Volta Grande", "28586315220", "+55 31 68495132", "jorge", "123", TipoUsuario.COMUM);
        conta[0] = new Conta(new BigDecimal(20000));
        
        usuario[1] = new Cliente("Joao", "Leblon", "49283675918", "+55 31 794851649", "joao", "123", TipoUsuario.COMUM);
        conta[1] = new Conta(new BigDecimal(20000));
        
        usuario[2] = new Cliente("Toni", "Volta Grande", "65498237618", "+55 31 265948175", "toni", "123", TipoUsuario.COMUM);
        conta[2] = new Conta(new BigDecimal(20000));
        
        Integer esc =1;
        do{
            Cliente atual = null;
            Menu menu = new Menu();
            
            if(atual == null) System.out.println("1 - Logar");
            else System.out.println("2 - Trocar Usuario");
            System.out.println("0 - Sair do Programa");
            System.out.println("Sua escolha: ");
            esc = Integer.parseInt(Global.scan.nextLine());
            
            switch(esc){
                case 1:{
                    menu.login(atual, adm, usuario);
                break;}
                
                case 2:{
                    
                break;}
            }
        }while(esc != 0);
    }
}


