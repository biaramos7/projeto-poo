package br.com.serratec.excecoes;

// Não é comum extender diretamente de throwable, geralmente se estende de Exception ou RuntimeException
public class ValorNegativoException extends Throwable {
	
	public ValorNegativoException(String mensagemErro) {
		super(mensagemErro);
	}
}