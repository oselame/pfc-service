package br.com.softal.pfc.dto;

import br.com.softal.pfc.model.Sociopartida;

public class SociopartidaDTO {

	private Integer cdPartida;
	private Integer cdSocio;
	private Integer cdTime;
	private Integer nuGol;
	private Integer nuGolcontra;
	private Integer flGoleiro;
	private Integer flCartaovermelho;
	private Integer flCartaoazul;
	private Integer flCartaoamarelo;
	private Integer flAtrazado;
	private String nmSocio;
	private String nmApelido;

	public Integer getCdPartida() {
		return cdPartida;
	}

	public void setCdPartida(Integer cdPartida) {
		this.cdPartida = cdPartida;
	}

	public Integer getCdSocio() {
		return cdSocio;
	}

	public void setCdSocio(Integer cdSocio) {
		this.cdSocio = cdSocio;
	}

	public Integer getCdTime() {
		return cdTime;
	}

	public void setCdTime(Integer cdTime) {
		this.cdTime = cdTime;
	}

	public Integer getNuGol() {
		return nuGol;
	}

	public void setNuGol(Integer nuGol) {
		this.nuGol = nuGol;
	}

	public Integer getNuGolcontra() {
		return nuGolcontra;
	}

	public void setNuGolcontra(Integer nuGolcontra) {
		this.nuGolcontra = nuGolcontra;
	}

	public Integer getFlGoleiro() {
		return flGoleiro;
	}

	public void setFlGoleiro(Integer flGoleiro) {
		this.flGoleiro = flGoleiro;
	}

	public Integer getFlCartaovermelho() {
		return flCartaovermelho;
	}

	public void setFlCartaovermelho(Integer flCartaovermelho) {
		this.flCartaovermelho = flCartaovermelho;
	}

	public Integer getFlCartaoazul() {
		return flCartaoazul;
	}

	public void setFlCartaoazul(Integer flCartaoazul) {
		this.flCartaoazul = flCartaoazul;
	}

	public Integer getFlCartaoamarelo() {
		return flCartaoamarelo;
	}

	public void setFlCartaoamarelo(Integer flCartaoamarelo) {
		this.flCartaoamarelo = flCartaoamarelo;
	}

	public Integer getFlAtrazado() {
		return flAtrazado;
	}

	public void setFlAtrazado(Integer flAtrazado) {
		this.flAtrazado = flAtrazado;
	}

	public String getNmSocio() {
		return nmSocio;
	}

	public void setNmSocio(String nmSocio) {
		this.nmSocio = nmSocio;
	}

	public String getNmApelido() {
		return nmApelido;
	}

	public void setNmApelido(String nmApelido) {
		this.nmApelido = nmApelido;
	}
	
	public static SociopartidaDTO extractFrom(Sociopartida sociopartida) {
		SociopartidaDTO sp = new SociopartidaDTO();
		sp.setCdPartida(sociopartida.getSociopartidaPK().getCdPartida());
		sp.setCdSocio(sociopartida.getSociopartidaPK().getCdSocio());
		sp.setCdTime(sociopartida.getCdTime());
		sp.setNuGol(sociopartida.getNuGol());
		sp.setNuGolcontra(sociopartida.getNuGolcontra());
		sp.setFlGoleiro(sociopartida.getFlGoleiro());
		sp.setFlCartaovermelho(sociopartida.getFlCartaovermelho());
		sp.setFlCartaoazul(sociopartida.getFlCartaoazul());
		sp.setFlCartaoamarelo(sociopartida.getFlCartaoamarelo());
		sp.setFlAtrazado(sociopartida.getFlAtrazado());
		sp.setNmSocio(sociopartida.getSocio().getNmSocio());
		sp.setNmApelido(sociopartida.getSocio().getNmApelido());
		return sp;
	}
	

}
