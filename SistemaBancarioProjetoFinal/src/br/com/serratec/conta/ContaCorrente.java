package br.com.serratec.conta;

import br.com.serratec.enums.Agencia;
import br.com.serratec.enums.TipoConta;
import br.com.serratec.usuario.Cliente;

public class ContaCorrente extends Conta {
	
    public ContaCorrente(Cliente cliente, int numeroConta, Agencia idAgencia) {
        super(cliente, numeroConta, idAgencia, TipoConta.CONTA_CORRENTE);
    }
	
}