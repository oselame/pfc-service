package br.com.softal.pfc.model;

import java.io.Serializable;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.ResultSetExtractor;

@Entity(name="epfcsociopartida")
public class Sociopartida implements Serializable, ResultSetExtractor<Sociopartida> {

	private static final long serialVersionUID = -5739126390696314824L;

	@EmbeddedId
	private SociopartidaPK sociopartidaPK;

	private Integer cdTime;
	private Integer nuGol;
	private Integer nuGolcontra;
	private Integer flGoleiro;
	private Integer flCartaovermelho;
	private Integer flCartaoazul;
	private Integer flCartaoamarelo;
	private Integer flAtrazado;
	
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name = "cdTime", insertable=false, updatable=false)
	private Timecamisa timecamisa;
	
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name = "cdSocio", insertable=false, updatable=false)
	private Socio socio;
	
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name = "cdPartida", insertable=false, updatable=false)
	private Partida partida;
	
	public Sociopartida() {
		setSociopartidaPK(new SociopartidaPK());
		setTimecamisa(new Timecamisa());
		setSocio(new Socio());
		setPartida(new Partida());
	}

	public SociopartidaPK getSociopartidaPK() {
		return sociopartidaPK;
	}

	public void setSociopartidaPK(SociopartidaPK sociopartidaPK) {
		this.sociopartidaPK = sociopartidaPK;
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

	public Timecamisa getTimecamisa() {
		return timecamisa;
	}

	public void setTimecamisa(Timecamisa timecamisa) {
		this.timecamisa = timecamisa;
	}

	public Socio getSocio() {
		return socio;
	}

	public void setSocio(Socio socio) {
		this.socio = socio;
	}

	public Partida getPartida() {
		return partida;
	}

	public void setPartida(Partida partida) {
		this.partida = partida;
	}

	@Override
	public Sociopartida extractData(ResultSet rs) throws SQLException, DataAccessException {
		Sociopartida sp = new Sociopartida();
		if (rs != null && rs.next()) {
			sp.getSociopartidaPK().setCdPartida(rs.getInt("cdpartida"));
			sp.getSociopartidaPK().setCdSocio(rs.getInt("cdsocio"));
			sp.setCdTime(rs.getInt("cdtime"));
			sp.setNuGol(rs.getInt("nugol"));
			sp.setNuGolcontra(rs.getInt("nugolcontra"));
			sp.setFlGoleiro(rs.getInt("flgoleiro"));
			sp.setFlCartaovermelho(rs.getInt("flcartaovermelho"));
			sp.setFlCartaoazul(rs.getInt("flcartaoazul"));
			sp.setFlCartaoamarelo(rs.getInt("flcartaoamarelo"));
			sp.setFlAtrazado(rs.getInt("flatrazado"));
			
			sp.getSocio().setCdSocio(rs.getInt("cdsocio"));
			sp.getSocio().setNmApelido(rs.getString("nmapelido"));
		}
		return sp;
	}
	
	public static Sociopartida extractData(Map<String, Object> row) {
		Sociopartida sp = new Sociopartida();
		sp.getSociopartidaPK().setCdPartida(Integer.valueOf(row.get("cdpartida").toString()));
		sp.getSociopartidaPK().setCdSocio(Integer.valueOf(row.get("cdsocio").toString()));
		sp.setCdTime(Integer.valueOf(row.get("cdtime").toString()));
		sp.setNuGol(Integer.valueOf(row.get("nugol").toString()));
		sp.setNuGolcontra(Integer.valueOf(row.get("nugolcontra").toString()));
		sp.setFlGoleiro(Integer.valueOf(row.get("flgoleiro").toString()));
		sp.setFlCartaovermelho(Integer.valueOf(row.get("flcartaovermelho").toString()));
		sp.setFlCartaoazul(Integer.valueOf(row.get("flcartaoazul").toString()));
		sp.setFlCartaoamarelo(Integer.valueOf(row.get("flcartaoamarelo").toString()));
		sp.setFlAtrazado(Integer.valueOf(row.get("flatrazado").toString()));
		
		sp.getSocio().setCdSocio(Integer.valueOf(row.get("cdsocio").toString()));
		sp.getSocio().setNmApelido(row.get("nmapelido").toString());
		return sp;
	}
	
	public static List<Sociopartida> extractData(List<Map<String, Object>> rows) {
		List<Sociopartida> lista = new ArrayList<>();
		for (Map<String, Object> row : rows) {
			lista.add( Sociopartida.extractData(row) );
		}
		return lista;
	}
	
}
