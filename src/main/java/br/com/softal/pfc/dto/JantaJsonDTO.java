package br.com.softal.pfc.dto;

import java.util.ArrayList;
import java.util.List;

public class JantaJsonDTO {

	private String atencao; 
	private List<SocioJantaDTO> jantas;

	public JantaJsonDTO() {
		setJantas(new ArrayList<SocioJantaDTO>());
	}

	public List<SocioJantaDTO> getJantas() {
		return jantas;
	}

	public void setJantas(List<SocioJantaDTO> jantas) {
		this.jantas = jantas;
	}

	public String getAtencao() {
		return atencao;
	}

	public void setAtencao(String atencao) {
		this.atencao = atencao;
	}
	
}
