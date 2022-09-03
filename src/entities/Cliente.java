package entities;

import java.util.Date;

public class Cliente {
    private Integer id;
    private String nome;
    private String endereco;
    private String cpf;
    private String telefone;
    
    private String login;
    private String senha;
    
    private TipoUsuario tipo;
    private Date dataCriacao;
    private Date dataModificacao;
    
    //private Conta conta;
    
    public Cliente() {
        
    }
    
    public Cliente(Integer id, String nome, String endereco, String cpf, String telefone, String login, String senha, TipoUsuario tipo) {
        this.id = id;
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

    public String getLogin() {
        return login;
    }

    public String getSenha() {
        return senha;
    }

    public TipoUsuario getTipo() {
        return tipo;
    }

    public Date getDataCriacao() {
        return dataCriacao;
    }

    public Date getDataModificacao() {
        return dataModificacao;
    }   

    @Override
    public String toString() {
        return "Cliente{" + "id=" + id + ", nome=" + nome + ", endereco=" + endereco + ", cpf=" + cpf + ", telefone=" + telefone + ", login=" + login + ", senha=" + senha + ", tipo=" + tipo + ", dataCriacao=" + dataCriacao + ", dataModificacao=" + dataModificacao + '}';
    }
    
    
}
