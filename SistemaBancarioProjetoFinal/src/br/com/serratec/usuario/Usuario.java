 package br.com.serratec.usuario;

import java.util.Scanner;

public abstract class Usuario {
	Scanner leitor = new Scanner(System.in);
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

    public boolean Autenticar(String cpf, String senha){
        return this.cpf.equals(cpf) && this.senha.equals(senha);
    }
}