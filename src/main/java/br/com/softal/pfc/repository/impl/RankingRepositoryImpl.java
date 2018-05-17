package br.com.softal.pfc.repository.impl;

import java.util.Collections;
import java.util.Comparator;
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
                        rs.getInt("nuPosicaoanterior"), 
                        0)
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
                        rs.getInt("nuPosicaoanterior"),
                        0)
        );
		ajustaApelido(rankingSocios);
		RankingDTO dto = new RankingDTO();
		dto.setCdQuadrimestre( rankingSocios.get(0).getCdQuadrimestre() );
		dto.setSocios(rankingSocios);
		return dto;
	}
	
	public RankingDTO findRankingQuadrimestre(Integer nuAno, Integer cdQuadrimestre, boolean isRanking) {
		StringBuilder sql = new StringBuilder();
		sql.append("\n Select s.cdSocio, s.nmApelido, s.nmSocio, ");
		sql.append("\n 		c.cdPartida, c.cdQuadrimestre, c.nuClassificacao, c.nuPontos,  ");
		sql.append("\n 		c.nuJogos, c.nuVitorias, c.nuEmpates, c.nuDerrotas, c.nuCartaovermelho,  ");
		sql.append("\n 		c.nuCartaoazul, c.nuCartaoamarelo, c.nuPosicaoanterior, y.nuGols  ");
		sql.append("\n from epfcsocio s  ");
		sql.append("\n join epfcclassificacao c on  ");
		sql.append("\n 		s.cdSocio = c.cdSocio   ");
		sql.append("\n 		and c.cdPartida = (	Select max(x.cdPartida) from epfcclassificacao x ");
		sql.append("\n 			           		where x.nuAno = c.nuAno ");
		sql.append("\n 					   		and x.cdQuadrimestre = c.cdQuadrimestre)  ");
		sql.append("\n left join (  ");
		sql.append("\n 		SELECT sp.cdSocio, sum(sp.nuGol) as nuGols  ");
		sql.append("\n 		FROM epfcsociopartida sp  ");
		sql.append("\n 		INNER JOIN epfcpartida p on sp.cdPartida = p.cdPartida  ");
		sql.append("\n 		WHERE p.nuAno = ? ");
		if (cdQuadrimestre.intValue() != 4) {
			sql.append("\n 		and p.cdQuadrimestre = ? ");
		}
		sql.append("\n 		GROUP BY sp.cdSocio ");
		sql.append("\n 	) y on y.cdSocio = s.cdSocio ");
		sql.append("\n Where coalesce(s.flForauso, 0) = 0 ");
		sql.append("\n and c.nuJogos <> 0  ");
		sql.append("\n and c.nuAno = ? ");
		sql.append("\n and c.cdQuadrimestre = ? ");
		if (isRanking) {
			sql.append("\n order by c.nuClassificacao asc ");
		} else {
			sql.append("\n and y.nuGols > 0  ");
			sql.append("\n order by y.nuGols desc ");
		}
		
		Object[] params = new Object[] { nuAno, nuAno, cdQuadrimestre };
		if (cdQuadrimestre.intValue() != 4) {
			params = new Object[] { nuAno, cdQuadrimestre, nuAno, cdQuadrimestre };
		}
		List<RankingSocioDTO> rankingSocios = jdbcTemplate.query(sql.toString(),
            (rs, rowNum) -> new RankingSocioDTO(rs),
            params
        );
		RankingDTO dto = new RankingDTO();
		dto.setNuAno( nuAno );
		dto.setCdQuadrimestre( cdQuadrimestre );
		if (!rankingSocios.isEmpty()) {
			ajustaApelido(rankingSocios);
			ordenaLista(rankingSocios, isRanking);
			dto.setSocios(rankingSocios);
		}
		return dto;
	}

	private void ordenaLista(List<RankingSocioDTO> rankingSocios, boolean isRanking) {
		if (isRanking) {
			return;
		}
		
		Collections.sort(rankingSocios, new Comparator<RankingSocioDTO>() {
			public int compare(RankingSocioDTO o1, RankingSocioDTO o2) {
				int ret = o2.getNuGols() - o1.getNuGols();
				if (ret == 0) {
					ret = o2.getNuPontos() - o1.getNuPontos();
				}
				if (ret == 0) {
					ret = o2.getNuPosicaoanterior() - o1.getNuPosicaoanterior();
				}
				return ret;
			}
		});
		
		int nuPosicao = 0;
		for (RankingSocioDTO dto: rankingSocios) {
			dto.setNuClassificacao(++nuPosicao);
		}
		
	}
	

}
