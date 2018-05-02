package br.com.softal.pfc.model;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity(name = "epfcsocio")
public class Socio implements Serializable {

	private static final long serialVersionUID = 4556989860189613884L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer cdSocio;
	private String nmSocio;
	private String nmApelido;
	@Temporal(TemporalType.DATE)
	private Date dtNascimento;
	private String nmCidade;
	private String sgUF;
	private String nmProfissao;
	private String nmEmpresa;
	private String nmTime;
	private String nuCelular;
	private String nuCasa;
	private String nuTrabalho;
	private String deEmail;
	private String flForauso;
	private byte[] imFoto;
	private Integer flAdministrador;
	private String deSenha;
	private Integer tpSocio;
	private Integer nuOrdem;

	public Integer getCdSocio() {
		return cdSocio;
	}

	public void setCdSocio(Integer cdSocio) {
		this.cdSocio = cdSocio;
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

	public Date getDtNascimento() {
		return dtNascimento;
	}

	public void setDtNascimento(Date dtNascimento) {
		this.dtNascimento = dtNascimento;
	}

	public String getNmCidade() {
		return nmCidade;
	}

	public void setNmCidade(String nmCidade) {
		this.nmCidade = nmCidade;
	}

	public String getSgUF() {
		return sgUF;
	}

	public void setSgUF(String sgUF) {
		this.sgUF = sgUF;
	}

	public String getNmProfissao() {
		return nmProfissao;
	}

	public void setNmProfissao(String nmProfissao) {
		this.nmProfissao = nmProfissao;
	}

	public String getNmEmpresa() {
		return nmEmpresa;
	}

	public void setNmEmpresa(String nmEmpresa) {
		this.nmEmpresa = nmEmpresa;
	}

	public String getNmTime() {
		return nmTime;
	}

	public void setNmTime(String nmTime) {
		this.nmTime = nmTime;
	}

	public String getNuCelular() {
		return nuCelular;
	}

	public void setNuCelular(String nuCelular) {
		this.nuCelular = nuCelular;
	}

	public String getNuCasa() {
		return nuCasa;
	}

	public void setNuCasa(String nuCasa) {
		this.nuCasa = nuCasa;
	}

	public String getNuTrabalho() {
		return nuTrabalho;
	}

	public void setNuTrabalho(String nuTrabalho) {
		this.nuTrabalho = nuTrabalho;
	}

	public String getDeEmail() {
		return deEmail;
	}

	public void setDeEmail(String deEmail) {
		this.deEmail = deEmail;
	}

	public String getFlForauso() {
		return flForauso;
	}

	public void setFlForauso(String flForauso) {
		this.flForauso = flForauso;
	}

	public byte[] getImFoto() {
		return imFoto;
	}

	public void setImFoto(byte[] imFoto) {
		this.imFoto = imFoto;
	}

	public Integer getFlAdministrador() {
		return flAdministrador;
	}

	public void setFlAdministrador(Integer flAdministrador) {
		this.flAdministrador = flAdministrador;
	}

	public String getDeSenha() {
		return deSenha;
	}

	public void setDeSenha(String deSenha) {
		this.deSenha = deSenha;
	}

	public Integer getTpSocio() {
		return tpSocio;
	}

	public void setTpSocio(Integer tpSocio) {
		this.tpSocio = tpSocio;
	}

	public Integer getNuOrdem() {
		return nuOrdem;
	}

	public void setNuOrdem(Integer nuOrdem) {
		this.nuOrdem = nuOrdem;
	}

}
