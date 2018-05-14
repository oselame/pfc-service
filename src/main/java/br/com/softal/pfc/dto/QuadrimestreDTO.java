package br.com.softal.pfc.dto;

import java.sql.ResultSet;
import java.sql.SQLException;

public class QuadrimestreDTO {

	private Integer nuAno;
	private Integer cdQuadrimestre;

	public QuadrimestreDTO() {
		super();
	}

	public QuadrimestreDTO(ResultSet rs) throws SQLException {
		this();
		setNuAno(rs.getInt("nuAno"));
		setCdQuadrimestre(rs.getInt("cdQuadrimestre"));
	}

	public Integer getCdQuadrimestre() {
		return cdQuadrimestre;
	}

	public void setCdQuadrimestre(Integer cdQuadrimestre) {
		this.cdQuadrimestre = cdQuadrimestre;
	}

	public Integer getNuAno() {
		return nuAno;
	}

	public void setNuAno(Integer nuAno) {
		this.nuAno = nuAno;
	}

}
