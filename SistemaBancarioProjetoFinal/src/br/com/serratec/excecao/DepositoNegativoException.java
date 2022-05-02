package br.com.serratec.excecao;

public class DepositoNegativoException extends Throwable {
	
	public DepositoNegativoException(String mensagemErro) {
		super(mensagemErro);
	}
}
