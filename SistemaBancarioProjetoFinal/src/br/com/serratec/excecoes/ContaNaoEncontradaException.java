package br.com.serratec.excecoes;

// Não é comum extender diretamente de throwable, geralmente se estende de Exception ou RuntimeException
public class ContaNaoEncontradaException extends Throwable {

	public ContaNaoEncontradaException(String mensagemErro) {
		super(mensagemErro);
	}
}