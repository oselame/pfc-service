package br.com.softal.pfc.dto;

import java.util.ArrayList;
import java.util.List;

public class SocioJantaDTO {

	private List<String> socios;
	private List<String> datas;

	public SocioJantaDTO() {
		setSocios(new ArrayList<String>());
		setDatas(new ArrayList<String>());
	}

	public List<String> getDatas() {
		return datas;
	}

	public void setDatas(List<String> datas) {
		this.datas = datas;
	}

	public List<String> getSocios() {
		return socios;
	}

	public void setSocios(List<String> socios) {
		this.socios = socios;
	}
	
	public String getSociosFmt() {
		String retorno = "";
		for (String socio: getSocios()) {
			retorno += ", " + socio;
		}
		return "".equalsIgnoreCase(retorno) ? "" : retorno.substring(2);
	}

}
