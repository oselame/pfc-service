package br.com.softal.pfc.model;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity(name="epfcquadrimestre")
public class Quadrimestre implements Serializable {

	private static final long serialVersionUID = -4744669541825923444L;

	@EmbeddedId
	private QuadrimestrePK quadrimestrePK;

	private Integer cdSociocampeao;
	private Integer cdTitulo;
	@Temporal(TemporalType.DATE)
	private Date dtInicio;
	@Temporal(TemporalType.DATE)
	private Date dtFim;
	private Integer nuJogos;
	private Integer flAnual;
	private Integer nuJogosCampeao;
	
	public Quadrimestre() {
		setQuadrimestrePK(new QuadrimestrePK());
	}

	public QuadrimestrePK getQuadrimestrePK() {
		return quadrimestrePK;
	}

	public void setQuadrimestrePK(QuadrimestrePK quadrimestrePK) {
		this.quadrimestrePK = quadrimestrePK;
	}

	public Integer getCdSociocampeao() {
		return cdSociocampeao;
	}

	public void setCdSociocampeao(Integer cdSociocampeao) {
		this.cdSociocampeao = cdSociocampeao;
	}

	public Integer getCdTitulo() {
		return cdTitulo;
	}

	public void setCdTitulo(Integer cdTitulo) {
		this.cdTitulo = cdTitulo;
	}

	public Date getDtInicio() {
		return dtInicio;
	}

	public void setDtInicio(Date dtInicio) {
		this.dtInicio = dtInicio;
	}

	public Date getDtFim() {
		return dtFim;
	}

	public void setDtFim(Date dtFim) {
		this.dtFim = dtFim;
	}

	public Integer getNuJogos() {
		return nuJogos;
	}

	public void setNuJogos(Integer nuJogos) {
		this.nuJogos = nuJogos;
	}

	public Integer getFlAnual() {
		return flAnual;
	}

	public void setFlAnual(Integer flAnual) {
		this.flAnual = flAnual;
	}

	public Integer getNuJogosCampeao() {
		return nuJogosCampeao;
	}

	public void setNuJogosCampeao(Integer nuJogosCampeao) {
		this.nuJogosCampeao = nuJogosCampeao;
	}

}
