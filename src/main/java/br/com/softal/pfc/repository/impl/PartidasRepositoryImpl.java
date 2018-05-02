package br.com.softal.pfc.repository.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import br.com.softal.pfc.dto.UltimapartidaDTO;
import br.com.softal.pfc.dto.SociopartidaDTO;
import br.com.softal.pfc.model.Partida;
import br.com.softal.pfc.model.Sociopartida;

@Repository
public class PartidasRepositoryImpl extends BaseRepositoryImpl {
	
	@Autowired
	private JdbcTemplate jdbcTemplate;
	
	@Autowired
	private SociopartidaRepositoryImpl sociopartidaImpl;
	
	public Partida findUltimaPartida() {
		//FIXME: remover o '-2' do sql
		String sql = 
			" select p.* " + 
		    " from epfcpartida p" +
			" where p.cdpartida in (select max(cdpartida)  as cdpartida " + 
			"					 from epfcpartida " + 
			"				     where flconcluida = 1)";
		
		return jdbcTemplate.query(sql, new Partida());
	}
	
	private String getResultado(Partida partida) {
		String nuGolsTimeVencedor = partida.getNuGolvencedor().toString();
		String nuGolsTimePerdedor = partida.getNuGolperdedor().toString();
		if (partida.getCdTimevencedor().equals(2)) {
			return nuGolsTimePerdedor + " x " + nuGolsTimeVencedor;
		} 
		return nuGolsTimeVencedor + " x " + nuGolsTimePerdedor;
	}

	public UltimapartidaDTO findUltimaPartidaResultado() {
		UltimapartidaDTO partidaDTO = new UltimapartidaDTO();
		
		Partida partida = this.findUltimaPartida();
		partidaDTO.setDtPartida(partida.getDtPartida());
		partidaDTO.setDeResultado(getResultado(partida));
		partidaDTO.setDeBolamurcha(partida.getDeBolamurcha().replaceAll("\r", "").replaceAll("\n", "").replaceAll("<p>&nbsp;</p>", ""));
		partidaDTO.setDeBolacheia(partida.getDeBolacheia().replaceAll("\r", "").replaceAll("\n", "").replaceAll("<p>&nbsp;</p>", ""));
		
		List<Sociopartida> sociostimea = sociopartidaImpl.findSociosPartida(partida.getCdPartida(), 1);
		for (Sociopartida sp : sociostimea) {
			partidaDTO.getSociostimea().add( SociopartidaDTO.extractFrom(sp) );
		}
		
		List<Sociopartida> sociostimeb = sociopartidaImpl.findSociosPartida(partida.getCdPartida(), 2);
		for (Sociopartida sp : sociostimeb) {
			partidaDTO.getSociostimeb().add( SociopartidaDTO.extractFrom(sp) );
		}
		
		return partidaDTO;
	}
	
}
