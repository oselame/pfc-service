package br.com.softal.pfc.model;

import java.io.Serializable;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.ResultSetExtractor;

@Entity(name="epfcgaleria")
public class Galeria implements ResultSetExtractor<Galeria>, Serializable {

	private static final long serialVersionUID = -5502520656919978750L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer cdGaleria;
	
	private String deGaleria;
	
	@Temporal(TemporalType.DATE)
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

	@Override
	public Galeria extractData(ResultSet rs) throws SQLException, DataAccessException {
		Galeria galeria = new Galeria();
		if (rs != null && rs.next()) {
			galeria.setCdGaleria(rs.getInt("cdGaleria"));
			galeria.setDeGaleria(rs.getString("deGaleria"));
			galeria.setDtGaleria(rs.getDate("dtGaleria"));
		}
		return galeria;
	}

}
