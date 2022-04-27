package br.com.serratec.usuario;

import br.com.serratec.enums.Cargo;

public class Presidente extends Funcionario {
    public Presidente(String nome, String cpf, String senha, Cargo cargo) {
        super(nome, cpf, senha, cargo);
    }
}
