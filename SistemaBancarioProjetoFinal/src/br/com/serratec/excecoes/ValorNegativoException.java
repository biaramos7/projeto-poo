package br.com.serratec.excecoes;

public class ValorNegativoException extends Throwable {
	
	public ValorNegativoException(String mensagemErro) {
		super(mensagemErro);
	}
}