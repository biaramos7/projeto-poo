package br.com.serratec.excecao;

public class ContaNaoEncontradaException extends Throwable {

	public ContaNaoEncontradaException(String mensagemErro) {
		super(mensagemErro);
	}
}
