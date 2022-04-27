package br.com.serratec.conta;

import br.com.serratec.enums.Agencia;
import br.com.serratec.usuario.Cliente;

public class ContaPoupanca extends Conta{
    private String tipo;

    public ContaPoupanca(Cliente cpfTitular, int numeroConta, Agencia idAgencia, String tipo) {
        super(cpfTitular, numeroConta, idAgencia);
        this.tipo = tipo;
    }
}
