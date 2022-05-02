 package br.com.serratec.enums;

import br.com.serratec.excecoes.EnumInexistenteException;
import java.util.Locale;

public enum Cargo {
    GERENTE(1, "Gerente"),
    DIRETOR(2, "Diretor"),
    PRESIDENTE(3, "Presidente");

    private int idCargo;
    private String nomeAmigavel;

    Cargo(int idCargo, String nomeAmigavel) {
        this.idCargo = idCargo;
        this.nomeAmigavel = nomeAmigavel;
    }

	public int getIdCargo() {
		return idCargo;
	}

	public void setIdCargo(int idCargo) {
		this.idCargo = idCargo;
	}

	public String getNomeAmigavel() {
		return nomeAmigavel;
	}

	public void setNomeAmigavel(String nomeAmigavel) {
		this.nomeAmigavel = nomeAmigavel;
	}
 
//    Cargo getCargoPorNomeAmigavel(String nomeRecebido) throws EnumInexistenteException {
//    Cargo getCargoPorNomeAmigavel(String nomeRecebido) {
//        String nomeRecebidoMinusculo =nomeRecebido.toLowerCase(Locale.ROOT);
//        for(Cargo cargoAtual : Cargo.values()){
//            String nomeCargoAtualMinusculo = cargoAtual.nomeAmigavel.toLowerCase(Locale.ROOT);
//            if (nomeCargoAtualMinusculo.equals(nomeRecebidoMinusculo)){
//                return cargoAtual;
//            }
//        }
//        throw new EnumInexistenteException();
//    }
}