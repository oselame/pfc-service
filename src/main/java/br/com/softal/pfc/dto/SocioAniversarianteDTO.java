package br.com.softal.pfc.dto;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.util.Base64Utils;

public class SocioAniversarianteDTO {

	private Integer cdSocio;
	private String nmApelido;
	private Integer nuDia;
	private Integer nuMes;
	private byte[] foto;
	
	public SocioAniversarianteDTO() {
		super();
	}
	
	public SocioAniversarianteDTO(ResultSet rs) throws SQLException {
		setCdSocio(rs.getInt("cdSocio"));
		setNmApelido(rs.getString("nmApelido"));
		setNuDia(rs.getInt("nuDia"));
		setNuMes(rs.getInt("nuMes"));
		setFoto(rs.getBytes("imFoto"));
	}
	
	public SocioAniversarianteDTO(Integer cdSocio, String nmApelido, Integer nuDia, Integer nuMes, byte[] foto) {
		super();
		this.cdSocio = cdSocio;
		this.nmApelido = nmApelido;
		this.nuDia = nuDia;
		this.nuMes = nuMes;
		this.foto = foto;
	}

	public Integer getCdSocio() {
		return cdSocio;
	}

	public void setCdSocio(Integer cdSocio) {
		this.cdSocio = cdSocio;
	}

	public Integer getNuMes() {
		return nuMes;
	}

	public void setNuMes(Integer nuMes) {
		this.nuMes = nuMes;
	}

	public Integer getNuDia() {
		return nuDia;
	}

	public void setNuDia(Integer nuDia) {
		this.nuDia = nuDia;
	}

	public String getNmApelido() {
		return nmApelido;
	}

	public void setNmApelido(String nmApelido) {
		this.nmApelido = nmApelido;
	}
	
	public String getData() {
		String[] meses = {"Janeiro", "Fevereiro", "Março", "Abril", "Maio", "Junho", "Julho", "Agosto", "Setembo", "Outubro", "Novembro", "Dezembro"}; 
		String data = "" + (this.getNuDia() < 10 ? "0" + this.getNuDia() : this.getNuDia());
		data += " de " + meses[this.getNuMes() - 1];
		return data;
	}

	public String getFoto() {
		return Base64Utils.encodeToString(foto);
	}

	public void setFoto(byte[] foto) {
		this.foto = foto;
	}
	
}
