package entities;

public class Cliente {
    private static int totalCliente;
    private int id;
    private String nome;
    private String endereco;
    private String cpf;
    private String telefone;
    
    private String login;
    private String senha;
    
    private TipoUsuario tipo;
    private Datas data;
    
    private Conta conta;
    
    public Cliente() {
        this.id = Cliente.totalCliente+1;
        Cliente.totalCliente++;
    }
    
    public Cliente(String nome, String endereco, String cpf, String telefone, String login, String senha, TipoUsuario tipo, Conta conta) {
        this.id = Cliente.totalCliente+1;
        Cliente.totalCliente++;
        this.nome = nome;
        this.endereco = endereco;
        this.cpf = cpf;
        this.telefone = telefone;
        this.login = login;
        this.senha = senha;
        this.tipo = tipo;
        this.conta = conta;
    }

    public Integer getId() {
        return id;
    }

    public String getNome() {
        return nome;
    }

    public String getEndereco() {
        return endereco;
    }

    public String getCpf() {
        return cpf;
    }

    public String getTelefone() {
        return telefone;
    }

    public String getLogin() {
        return login;
    }

    public String getSenha() {
        return senha;
    }

    public TipoUsuario getTipo() {
        return tipo;
    } 

    @Override
    public String toString() {
        return "Cliente{id="+ id + ", nome=" + nome + ", endereco=" + endereco + ", cpf=" + cpf + ", telefone=" + telefone + ", login=" + login + ", senha=" + senha + ", tipo=" + tipo + ", data=" + data + ", conta=" + conta + '}';
    }
}
