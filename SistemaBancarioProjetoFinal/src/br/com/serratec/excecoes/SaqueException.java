package br.com.serratec.excecoes;

// Não é comum extender diretamente de throwable, geralmente se estende de Exception ou RuntimeException
public class SaqueException extends Throwable {
	
	public SaqueException(String mensagemErro) {
		super(mensagemErro);
	}
}
