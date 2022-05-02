 package br.com.serratec.usuario;

import br.com.serratec.enums.Cargo;

public class Diretor extends Funcionario{
    public Diretor(String nome, String cpf, String senha, Cargo cargo) {
        super(nome, cpf, senha, cargo);
    }
}