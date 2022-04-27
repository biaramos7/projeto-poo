package br.com.serratec.conta;

import br.com.serratec.enums.Agencia;
import br.com.serratec.enums.TipoConta;
import br.com.serratec.usuario.Cliente;

public class ContaCorrente extends Conta{
    private TipoConta tipo;

    public ContaCorrente(Cliente cpfTitular, int numeroConta, Agencia idAgencia, TipoConta tipo) {
        super(cpfTitular, numeroConta, idAgencia);
        this.tipo = tipo;
    }
}
