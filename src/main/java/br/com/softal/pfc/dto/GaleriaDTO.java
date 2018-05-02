package br.com.softal.pfc.dto;

import java.util.Date;

import com.fasterxml.jackson.annotation.JsonFormat;

public class GaleriaDTO {

	private Integer cdGaleria;
	
	private String deGaleria;
	
	@JsonFormat(pattern="dd/MM/yyyy")
	private Date dtGaleria;

	public Integer getCdGaleria() {
		return cdGaleria;
	}

	public void setCdGaleria(Integer cdGaleria) {
		this.cdGaleria = cdGaleria;
	}

	public String getDeGaleria() {
		return deGaleria;
	}

	public void setDeGaleria(String deGaleria) {
		this.deGaleria = deGaleria;
	}

	public Date getDtGaleria() {
		return dtGaleria;
	}

	public void setDtGaleria(Date dtGaleria) {
		this.dtGaleria = dtGaleria;
	}
	
}
