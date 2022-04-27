package br.com.serratec.usuario;

import br.com.serratec.enums.Cargo;

public abstract class Funcionario extends Usuario{
    protected Cargo cargo;

    public Funcionario(String nome, String cpf, String senha, Cargo cargo) {
        super(nome, cpf, senha);
        this.cargo = cargo;
    }
}
