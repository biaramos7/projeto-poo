package br.com.serratec.usuario;

import br.com.serratec.enums.Agencia;
import br.com.serratec.enums.Cargo;

public class Gerente extends Funcionario{
    protected Agencia idAgencia;

    public Gerente(String nome, String cpf, String senha, Cargo cargo, Agencia idAgencia) {
        super(nome, cpf, senha, cargo);
        this.idAgencia = idAgencia;
    }

    @Override
    public String toString() {
        return "Gerente{" +
                "idAgencia=" + idAgencia +
                ", cargo=" + cargo +
                ", nome='" + nome + '\'' +
                ", cpf='" + cpf + '\'' +
                '}';
    }

    //metodos especificos de cada tipo de funcionario
}