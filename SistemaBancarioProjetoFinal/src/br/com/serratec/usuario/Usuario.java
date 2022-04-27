package br.com.serratec.usuario;

public abstract class Usuario {
    protected String nome;
    protected String cpf;
    protected String senha;

    public Usuario(String nome, String cpf, String senha) {
        this.nome = nome;
        this.cpf = cpf;
        this.senha = senha;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getNome() {
        return nome;
    }

    public String getCpf() {
        return cpf;
    }

    public boolean Autenticar(){ //interface
        //TODO: Autenticar usuário
        return true;
    }

    public void Login(String nome, String senha){
        //TODO: Criar login
    }
}
