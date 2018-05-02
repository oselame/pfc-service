package br.com.softal.pfc.dto;

import java.util.ArrayList;
import java.util.List;

public class RankingDTO {

	private Integer cdQuadrimestre;
	private List<RankingSocioDTO> socios;

	public RankingDTO() {
		super();
		setSocios(new ArrayList<RankingSocioDTO>());
	}

	public Integer getCdQuadrimestre() {
		return cdQuadrimestre;
	}

	public void setCdQuadrimestre(Integer cdQuadrimestre) {
		this.cdQuadrimestre = cdQuadrimestre;
	}

	public List<RankingSocioDTO> getSocios() {
		return socios;
	}

	public void setSocios(List<RankingSocioDTO> socios) {
		this.socios = socios;
	}

}
