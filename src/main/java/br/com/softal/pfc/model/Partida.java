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

@Entity(name="epfcpartida")
public class Partida implements ResultSetExtractor<Partida>, Serializable {

	private static final long serialVersionUID = 8302584893161245524L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer cdPartida;

	private Integer nuAno;
	private Integer cdQuadrimestre;
	private Integer cdTimeperdedor;
	private Integer cdTimevencedor;
	@Temporal(TemporalType.DATE)
	private Date dtPartida;
	private Integer flEmpate;
	private Integer nuGolvencedor;
	private Integer nuGolperdedor;
	private String nmJuiz;
	private String deBolamurcha;
	private String deBolacheia;
	private String deObservacao;
	private Integer flConcluida;
	private Integer nuJogadorportime;
	
	public Partida(Integer cdPartida) {
		super();
		setCdPartida(cdPartida);
	}
	
	public Partida() {
		this(null);
	}
	
	public Integer getCdPartida() {
		return cdPartida;
	}

	public void setCdPartida(Integer cdPartida) {
		this.cdPartida = cdPartida;
	}

	public Integer getNuAno() {
		return nuAno;
	}

	public void setNuAno(Integer nuAno) {
		this.nuAno = nuAno;
	}

	public Integer getCdQuadrimestre() {
		return cdQuadrimestre;
	}

	public void setCdQuadrimestre(Integer cdQuadrimestre) {
		this.cdQuadrimestre = cdQuadrimestre;
	}

	public Integer getCdTimeperdedor() {
		return cdTimeperdedor;
	}

	public void setCdTimeperdedor(Integer cdTimeperdedor) {
		this.cdTimeperdedor = cdTimeperdedor;
	}

	public Integer getCdTimevencedor() {
		return cdTimevencedor;
	}

	public void setCdTimevencedor(Integer cdTimevencedor) {
		this.cdTimevencedor = cdTimevencedor;
	}

	public Date getDtPartida() {
		return dtPartida;
	}

	public void setDtPartida(Date dtPartida) {
		this.dtPartida = dtPartida;
	}

	public Integer getFlEmpate() {
		return flEmpate;
	}

	public void setFlEmpate(Integer flEmpate) {
		this.flEmpate = flEmpate;
	}

	public Integer getNuGolvencedor() {
		return nuGolvencedor;
	}

	public void setNuGolvencedor(Integer nuGolvencedor) {
		this.nuGolvencedor = nuGolvencedor;
	}

	public Integer getNuGolperdedor() {
		return nuGolperdedor;
	}

	public void setNuGolperdedor(Integer nuGolperdedor) {
		this.nuGolperdedor = nuGolperdedor;
	}

	public String getNmJuiz() {
		return nmJuiz;
	}

	public void setNmJuiz(String nmJuiz) {
		this.nmJuiz = nmJuiz;
	}

	public String getDeBolamurcha() {
		return deBolamurcha;
	}

	public void setDeBolamurcha(String deBolamurcha) {
		this.deBolamurcha = deBolamurcha;
	}

	public String getDeBolacheia() {
		return deBolacheia;
	}

	public void setDeBolacheia(String deBolacheia) {
		this.deBolacheia = deBolacheia;
	}

	public String getDeObservacao() {
		return deObservacao;
	}

	public void setDeObservacao(String deObservacao) {
		this.deObservacao = deObservacao;
	}

	public Integer getFlConcluida() {
		return flConcluida;
	}

	public void setFlConcluida(Integer flConcluida) {
		this.flConcluida = flConcluida;
	}

	public Integer getNuJogadorportime() {
		return nuJogadorportime;
	}

	public void setNuJogadorportime(Integer nuJogadorportime) {
		this.nuJogadorportime = nuJogadorportime;
	}

	@Override
	public Partida extractData(ResultSet rs) throws SQLException, DataAccessException {
		Partida partida = new Partida();
		if (rs != null && rs.next()) {
			partida.setCdPartida(rs.getInt("cdpartida"));
			partida.setNuAno(rs.getInt("nuano"));
			partida.setCdQuadrimestre(rs.getInt("cdquadrimestre"));
			partida.setCdTimeperdedor(rs.getInt("cdtimeperdedor"));
			partida.setCdTimevencedor(rs.getInt("cdtimevencedor"));
			partida.setDtPartida(rs.getDate("dtpartida"));
			partida.setFlEmpate(rs.getInt("flempate"));
			partida.setNuGolvencedor(rs.getInt("nugolvencedor"));
			partida.setNuGolperdedor(rs.getInt("nugolperdedor"));
			partida.setNmJuiz(rs.getString("nmjuiz"));
			partida.setDeBolamurcha(rs.getString("debolamurcha"));
			partida.setDeBolacheia(rs.getString("debolacheia"));
			partida.setDeObservacao(rs.getString("deobservacao"));
			partida.setFlConcluida(rs.getInt("flconcluida"));
			partida.setNuJogadorportime(rs.getInt("nujogadorportime"));
		}
		return partida;
	}

}
