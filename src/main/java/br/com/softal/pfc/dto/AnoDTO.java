package br.com.softal.pfc.dto;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class AnoDTO {

	private Integer nuAno;
	private List<QuadrimestreDTO> quadrimestres;

	public AnoDTO() {
		super();
		setQuadrimestres(new ArrayList<QuadrimestreDTO>());
	}

	public AnoDTO(ResultSet rs) throws SQLException {
		this();
		setNuAno(rs.getInt("nuAno"));
	}

	public Integer getNuAno() {
		return nuAno;
	}

	public void setNuAno(Integer nuAno) {
		this.nuAno = nuAno;
	}

	public List<QuadrimestreDTO> getQuadrimestres() {
		return quadrimestres;
	}

	public void setQuadrimestres(List<QuadrimestreDTO> quadrimestres) {
		this.quadrimestres = quadrimestres;
	}

}