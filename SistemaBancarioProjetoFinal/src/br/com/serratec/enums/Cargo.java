 package br.com.serratec.enums;

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
}