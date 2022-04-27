package br.com.serratec.conta;

import br.com.serratec.enums.Agencia;
import br.com.serratec.excecao.DepositoNegativoException;
import br.com.serratec.usuario.Cliente;

public abstract class Conta {
    protected Cliente cpfTitular;
    protected int numeroConta;
    protected Agencia idAgencia;
    private double saldo;

    public Conta(Cliente cpfTitular, int numeroConta, Agencia idAgencia) {
        this.cpfTitular = cpfTitular;
        this.numeroConta = numeroConta;
        this.idAgencia = idAgencia;
    }

    public double getSaldo() {
        return saldo;
    }

    public void setSaldo(double saldo) {
        this.saldo = saldo;
    }

    public void depositar(double valor) {
        this.saldo +=valor;
        //TODO: tratar erro numero negativo
    }
    public void sacar(double valor){
        if (this.saldo > valor){
            saldo -= valor;
            System.out.println("Saque efetuado com sucesso.");
        }else{
            System.out.println("Saldo insuficiente.");
        }
    }
    public boolean transferir(double valor, Conta destino){
        if (this.saldo > valor){
            this.setSaldo(this.getSaldo() - valor);
            destino.setSaldo(destino.getSaldo()+valor);
            return true;
        }else{
            return false;
        }
    }
}
