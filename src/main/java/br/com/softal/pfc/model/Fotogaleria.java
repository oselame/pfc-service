package br.com.softal.pfc.model;

import java.io.Serializable;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.ResultSetExtractor;

@Entity(name="epfcfotogaleria")
public class Fotogaleria implements ResultSetExtractor<Fotogaleria>, Serializable {

	private static final long serialVersionUID = -3181784206586080850L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer cdFotogaleria;
	
	private Integer cdGaleria;
	
	private String nmArqfoto;

	public Integer getCdFotogaleria() {
		return cdFotogaleria;
	}

	public void setCdFotogaleria(Integer cdFotogaleria) {
		this.cdFotogaleria = cdFotogaleria;
	}

	public Integer getCdGaleria() {
		return cdGaleria;
	}

	public void setCdGaleria(Integer cdGaleria) {
		this.cdGaleria = cdGaleria;
	}

	public String getNmArqfoto() {
		return nmArqfoto;
	}

	public void setNmArqfoto(String nmArqfoto) {
		this.nmArqfoto = nmArqfoto;
	}

	@Override
	public Fotogaleria extractData(ResultSet rs) throws SQLException, DataAccessException {
		Fotogaleria fotogaleria = new Fotogaleria();
		if (rs != null && rs.next()) {
			fotogaleria.setCdFotogaleria(rs.getInt("cdFotogaleria"));
			fotogaleria.setCdGaleria(rs.getInt("cdGaleria"));
			fotogaleria.setNmArqfoto(rs.getString("nmArqfoto"));
		}
		return fotogaleria;
	}

}
