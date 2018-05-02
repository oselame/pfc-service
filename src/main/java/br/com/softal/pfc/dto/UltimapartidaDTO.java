package br.com.softal.pfc.dto;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonFormat;

public class UltimapartidaDTO {

	@JsonFormat(pattern="dd/MM/yyyy")
	private Date dtPartida;
	
	private String deResultado;
	private String deBolamurcha;
	private String deBolacheia;

	private List<SociopartidaDTO> sociostimea;
	private List<SociopartidaDTO> sociostimeb;

	public UltimapartidaDTO() {
		setSociostimea(new ArrayList<>());
		setSociostimeb(new ArrayList<>());
	}

	public List<SociopartidaDTO> getSociostimea() {
		return sociostimea;
	}

	public void setSociostimea(List<SociopartidaDTO> sociostimea) {
		this.sociostimea = sociostimea;
	}

	public List<SociopartidaDTO> getSociostimeb() {
		return sociostimeb;
	}

	public void setSociostimeb(List<SociopartidaDTO> sociostimeb) {
		this.sociostimeb = sociostimeb;
	}

	public String getDeResultado() {
		return deResultado;
	}

	public void setDeResultado(String deResultado) {
		this.deResultado = deResultado;
	}

	public Date getDtPartida() {
		return dtPartida;
	}

	public void setDtPartida(Date dtPartida) {
		this.dtPartida = dtPartida;
	}

	public String getDeBolamurcha() {
		return deBolamurcha;
	}

	public void setDeBolamurcha(String deBolamurcha) {
		this.deBolamurcha = deBolamurcha;
	}

	public String getDeBolacheia() {
		return deBolacheia;
	}

	public void setDeBolacheia(String deBolacheia) {
		this.deBolacheia = deBolacheia;
	}
	
}
