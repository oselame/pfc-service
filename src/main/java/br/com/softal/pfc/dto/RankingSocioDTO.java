package br.com.softal.pfc.dto;

import java.sql.ResultSet;
import java.sql.SQLException;

public class RankingSocioDTO {

	private Integer cdQuadrimestre;
	private Integer cdPartida;
	private Integer cdSocio;
	private String nmApelido;
	private String nmSocio;
	private Integer nuClassificacao;
	private Integer nuPontos;
	private Integer nuJogos;
	private Integer nuVitorias;
	private Integer nuEmpates;
	private Integer nuDerrotas;
	private Integer nuCartaovermelho;
	private Integer nuCartaoazul;
	private Integer nuCartaoamarelo;
	private Integer nuPosicaoanterior;
	private Integer nuGols;
	
	public RankingSocioDTO() {
		super();
	}
	
	public RankingSocioDTO(ResultSet rs) throws SQLException {
		setCdQuadrimestre(rs.getInt("cdQuadrimestre"));
		setCdPartida(rs.getInt("cdPartida"));
		setCdSocio(rs.getInt("cdSocio"));                		
        setNmApelido(rs.getString("nmApelido")); 
        setNmSocio(rs.getString("nmSocio"));                        
        setNuClassificacao(rs.getInt("nuClassificacao"));
        setNuPontos(rs.getInt("nuPontos"));
        setNuJogos(rs.getInt("nuJogos"));
        setNuVitorias(rs.getInt("nuVitorias"));
        setNuEmpates(rs.getInt("nuEmpates"));
        setNuDerrotas(rs.getInt("nuDerrotas"));
        setNuCartaovermelho(rs.getInt("nuCartaovermelho"));
        setNuCartaoazul(rs.getInt("nuCartaoazul"));
        setNuCartaoamarelo(rs.getInt("nuCartaoamarelo"));
        setNuPosicaoanterior(rs.getInt("nuPosicaoanterior"));
        setNuGols(rs.getInt("nuGols"));
	}
	
	public RankingSocioDTO(Integer cdQuadrimestre, Integer cdPartida, Integer cdSocio, String nmApelido, String nmSocio,
			Integer nuClassificacao, Integer nuPontos, Integer nuJogos, Integer nuVitorias, Integer nuEmpates,
			Integer nuDerrotas, Integer nuCartaovermelho, Integer nuCartaoazul, Integer nuCartaoamarelo,
			Integer nuPosicaoanterior, Integer nuGols) {
		super();
		this.cdQuadrimestre = cdQuadrimestre;
		this.cdPartida = cdPartida;
		this.cdSocio = cdSocio;
		this.nmApelido = nmApelido;
		this.nmSocio = nmSocio;
		this.nuClassificacao = nuClassificacao;
		this.nuPontos = nuPontos;
		this.nuJogos = nuJogos;
		this.nuVitorias = nuVitorias;
		this.nuEmpates = nuEmpates;
		this.nuDerrotas = nuDerrotas;
		this.nuCartaovermelho = nuCartaovermelho;
		this.nuCartaoazul = nuCartaoazul;
		this.nuCartaoamarelo = nuCartaoamarelo;
		this.nuPosicaoanterior = nuPosicaoanterior;
		this.nuGols = nuGols;
	}

	public Integer getCdSocio() {
		return cdSocio;
	}

	public void setCdSocio(Integer cdSocio) {
		this.cdSocio = cdSocio;
	}

	public String getNmApelido() {
		return nmApelido;
	}

	public void setNmApelido(String nmApelido) {
		this.nmApelido = nmApelido;
	}

	public String getNmSocio() {
		return nmSocio;
	}

	public void setNmSocio(String nmSocio) {
		this.nmSocio = nmSocio;
	}

	public Integer getCdPartida() {
		return cdPartida;
	}

	public void setCdPartida(Integer cdPartida) {
		this.cdPartida = cdPartida;
	}

	public Integer getCdQuadrimestre() {
		return cdQuadrimestre;
	}

	public void setCdQuadrimestre(Integer cdQuadrimestre) {
		this.cdQuadrimestre = cdQuadrimestre;
	}

	public Integer getNuClassificacao() {
		return nuClassificacao;
	}

	public void setNuClassificacao(Integer nuClassificacao) {
		this.nuClassificacao = nuClassificacao;
	}

	public Integer getNuPontos() {
		return nuPontos;
	}

	public void setNuPontos(Integer nuPontos) {
		this.nuPontos = nuPontos;
	}

	public Integer getNuJogos() {
		return nuJogos;
	}

	public void setNuJogos(Integer nuJogos) {
		this.nuJogos = nuJogos;
	}

	public Integer getNuVitorias() {
		return nuVitorias;
	}

	public void setNuVitorias(Integer nuVitorias) {
		this.nuVitorias = nuVitorias;
	}

	public Integer getNuEmpates() {
		return nuEmpates;
	}

	public void setNuEmpates(Integer nuEmpates) {
		this.nuEmpates = nuEmpates;
	}

	public Integer getNuDerrotas() {
		return nuDerrotas;
	}

	public void setNuDerrotas(Integer nuDerrotas) {
		this.nuDerrotas = nuDerrotas;
	}

	public Integer getNuCartaovermelho() {
		return nuCartaovermelho;
	}

	public void setNuCartaovermelho(Integer nuCartaovermelho) {
		this.nuCartaovermelho = nuCartaovermelho;
	}

	public Integer getNuCartaoazul() {
		return nuCartaoazul;
	}

	public void setNuCartaoazul(Integer nuCartaoazul) {
		this.nuCartaoazul = nuCartaoazul;
	}

	public Integer getNuCartaoamarelo() {
		return nuCartaoamarelo;
	}

	public void setNuCartaoamarelo(Integer nuCartaoamarelo) {
		this.nuCartaoamarelo = nuCartaoamarelo;
	}

	public Integer getNuPosicaoanterior() {
		return nuPosicaoanterior;
	}

	public void setNuPosicaoanterior(Integer nuPosicaoanterior) {
		this.nuPosicaoanterior = nuPosicaoanterior;
	}

	public Integer getNuGols() {
		return nuGols;
	}

	public void setNuGols(Integer nuGols) {
		this.nuGols = nuGols;
	}
	

}
