package br.com.softal.pfc.repository.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import br.com.softal.pfc.dto.RankingDTO;
import br.com.softal.pfc.dto.RankingSocioDTO;

@Repository
public class RankingRepositoryImpl extends BaseRepositoryImpl {
	
	@Autowired
	private JdbcTemplate jdbcTemplate;
	
	private void ajustaApelido(List<RankingSocioDTO> lista) {
		for (RankingSocioDTO dto : lista) {
			String nmApelido = dto.getNmApelido();
			if (nmApelido != null && nmApelido.length() > 25) {
				nmApelido = nmApelido.substring(0, 25).concat("...");
				dto.setNmApelido(nmApelido);
			}
		}
	}

	public RankingDTO findRankingQuadrimestreAtual() {
		List<RankingSocioDTO> rankingSocios = jdbcTemplate.query(
                " Select c.cdQuadrimestre, c.cdPartida, s.cdSocio, s.nmApelido, s.nmSocio, " +
                " 	c.nuClassificacao, c.nuPontos,  " +
                "	c.nuJogos, c.nuVitorias, c.nuEmpates, c.nuDerrotas, c.nuCartaovermelho, " +
                "	c.nuCartaoazul, c.nuCartaoamarelo, c.nuPosicaoanterior " +
				" from epfcclassificacao c" +  
				" join (select x.nuAno, max(x.cdPartida) as cdPartida " +  
				"       from epfcclassificacao x" +  
				"	    group by x.nuAno) TT on TT.nuAno = c.nuAno and c.cdPartida = TT.cdPartida" +  
				" join epfcsocio s on  s.cdSocio = c.cdSocio  " +  
				" Where coalesce(s.flForauso, 0) = 0 " +  
				" and c.cdQuadrimestre <> 4" +  
				" and c.nuAno = year(now())" + 
				" and (c.nuPontos + c.nuJogos + c.nuVitorias + c.nuEmpates) > 0 " +
				" order by c.nuClassificacao asc",
                (rs, rowNum) -> new RankingSocioDTO(
                		rs.getInt("cdQuadrimestre"),
                		rs.getInt("cdPartida"),
                		rs.getInt("cdSocio"),                		
                        rs.getString("nmApelido"), 
                        rs.getString("nmSocio"),                        
                        rs.getInt("nuClassificacao"),
                        rs.getInt("nuPontos"),
                        rs.getInt("nuJogos"),
                        rs.getInt("nuVitorias"),
                        rs.getInt("nuEmpates"),
                        rs.getInt("nuDerrotas"),
                        rs.getInt("nuCartaovermelho"),
                        rs.getInt("nuCartaoazul"),
                        rs.getInt("nuCartaoamarelo"),
                        rs.getInt("nuPosicaoanterior"))
        );
		
		ajustaApelido(rankingSocios);
		
		RankingDTO dto = new RankingDTO();
		dto.setCdQuadrimestre( rankingSocios.get(0).getCdQuadrimestre() );
		dto.setSocios(rankingSocios);
		return dto;
	}
	
	public RankingDTO findRankingQuadrimestreAnual() {
		List<RankingSocioDTO> rankingSocios = jdbcTemplate.query(
                " Select c.cdQuadrimestre, c.cdPartida, s.cdSocio, s.nmApelido, s.nmSocio, " +
                " 	c.nuClassificacao, c.nuPontos,  " +
                "	c.nuJogos, c.nuVitorias, c.nuEmpates, c.nuDerrotas, c.nuCartaovermelho, " +
                "	c.nuCartaoazul, c.nuCartaoamarelo, c.nuPosicaoanterior " +
				" from epfcclassificacao c" +  
				" join (select x.nuAno, max(x.cdPartida) as cdPartida " +  
				"       from epfcclassificacao x" +  
				"	    group by x.nuAno) TT on TT.nuAno = c.nuAno and c.cdPartida = TT.cdPartida" +  
				" join epfcsocio s on  s.cdSocio = c.cdSocio  " +  
				" Where coalesce(s.flForauso, 0) = 0 " +  
				" and c.cdQuadrimestre = 4" +  
				" and c.nuAno = year(now())" + 
				" and (c.nuPontos + c.nuJogos + c.nuVitorias + c.nuEmpates) > 0 " +
				" order by c.nuClassificacao asc",
                (rs, rowNum) -> new RankingSocioDTO(
                		rs.getInt("cdQuadrimestre"),
                		rs.getInt("cdPartida"),
                		rs.getInt("cdSocio"),                		
                        rs.getString("nmApelido"), 
                        rs.getString("nmSocio"),                        
                        rs.getInt("nuClassificacao"),
                        rs.getInt("nuPontos"),
                        rs.getInt("nuJogos"),
                        rs.getInt("nuVitorias"),
                        rs.getInt("nuEmpates"),
                        rs.getInt("nuDerrotas"),
                        rs.getInt("nuCartaovermelho"),
                        rs.getInt("nuCartaoazul"),
                        rs.getInt("nuCartaoamarelo"),
                        rs.getInt("nuPosicaoanterior"))
        );
		ajustaApelido(rankingSocios);
		RankingDTO dto = new RankingDTO();
		dto.setCdQuadrimestre( rankingSocios.get(0).getCdQuadrimestre() );
		dto.setSocios(rankingSocios);
		return dto;
	}

}
