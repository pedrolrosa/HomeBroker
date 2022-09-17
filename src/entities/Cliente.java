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
    
    public Cliente() {
        this.id = Cliente.totalCliente+1;
        Cliente.totalCliente++;
    }
    
    public Cliente(String nome, String endereco, String cpf, String telefone, String login, String senha, TipoUsuario tipo) {
        this.id = Cliente.totalCliente+1;
        Cliente.totalCliente++;
        this.nome = nome;
        this.endereco = endereco;
        this.cpf = cpf;
        this.telefone = telefone;
        this.login = login;
        this.senha = senha;
        this.tipo = tipo;
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

    public Boolean getLogin(String login, String senha){
        if(this.login.equals(login) && this.senha.equals(senha)) return true;
        else return false;
    }

    public TipoUsuario getTipo() {
        return tipo;
    } 

    public void setNome(String nome) {
        this.nome = nome;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    @Override
    public String toString() {
        return "Cliente{id="+ id + ", nome=" + nome + ", endereco=" + endereco + ", cpf=" + cpf + ", telefone=" + telefone + ", login=" + login + ", senha=" + senha + ", tipo=" + tipo + '}';
    }
}
