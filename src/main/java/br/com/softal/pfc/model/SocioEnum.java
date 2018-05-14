package br.com.softal.pfc.model;

public enum SocioEnum {
	
	PATRIMONIAL(1), PREFERENCIAL(2), AVULSO(3), BENEMERITO(4);
	
	private int tpSocio;

	private SocioEnum(int tpSocio) {
		this.tpSocio = tpSocio;
	}
	
	public Integer getTpSocio() {
		return this.tpSocio;
	}

}
