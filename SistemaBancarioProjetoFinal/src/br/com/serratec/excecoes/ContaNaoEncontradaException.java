package br.com.serratec.excecoes;

public class ContaNaoEncontradaException extends Throwable {

	public ContaNaoEncontradaException(String mensagemErro) {
		super(mensagemErro);
	}
}