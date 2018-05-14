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
	
	public RankingDTO findRankingQuadrimestre(Integer nuAno, Integer cdQuadrimestre) {
		List<RankingSocioDTO> rankingSocios = jdbcTemplate.query(
    		"\n Select s.cdSocio, s.nmApelido, s.nmSocio,  " + 
			"\n 	c.cdPartida, c.cdQuadrimestre, c.nuClassificacao, c.nuPontos,  " + 
			"\n 	c.nuJogos, c.nuVitorias, c.nuEmpates, c.nuDerrotas, c.nuCartaovermelho,  " + 
			"\n 	c.nuCartaoazul, c.nuCartaoamarelo, c.nuPosicaoanterior, y.nuGols  " + 
			"\n from epfcsocio s  " + 
			"\n join epfcclassificacao c on   " + 
			"\n 	s.cdSocio = c.cdSocio   " + 
			"\n 	and c.cdPartida = (Select max(x.cdPartida) from epfcclassificacao x " + 
			"\n 			           where x.nuAno = c.nuAno " + 
			"\n 					   and x.cdQuadrimestre = c.cdQuadrimestre)  " + 
			"\n left join (  " + 
			"\n 		SELECT p.nuAno, p.cdQuadrimestre, sp.cdSocio, sum(sp.nuGol) as nuGols  " + 
			"\n 		FROM epfcsociopartida sp  " + 
			"\n 		INNER JOIN epfcpartida p on sp.cdPartida = p.cdPartida  " + 
			"\n 		GROUP BY p.nuAno, p.cdQuadrimestre,sp.cdSocio " + 
			"\n 	) y on y.nuAno = c.nuAno and y.cdQuadrimestre = c.cdQuadrimestre and y.cdSocio = s.cdSocio " + 
			"\n Where coalesce(s.flForauso, 0) = 0 " + 
			"\n and c.nuJogos <> 0  " + 
			"\n and c.nuAno = ? " + 
			"\n and c.cdQuadrimestre = ? " + 
			"\n order by c.nuClassificacao asc ",
            (rs, rowNum) -> new RankingSocioDTO(rs),
            new Object[] { nuAno, cdQuadrimestre }
        );
		RankingDTO dto = new RankingDTO();
		dto.setNuAno( nuAno );
		dto.setCdQuadrimestre( cdQuadrimestre );
		if (!rankingSocios.isEmpty()) {
			ajustaApelido(rankingSocios);
			dto.setSocios(rankingSocios);
		}
		return dto;
	}
	
	
	

}
