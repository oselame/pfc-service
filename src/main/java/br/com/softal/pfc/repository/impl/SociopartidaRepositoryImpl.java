package br.com.softal.pfc.repository.impl;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import br.com.softal.pfc.model.Sociopartida;

@Repository
public class SociopartidaRepositoryImpl extends BaseRepositoryImpl {
	
	@Autowired
	private JdbcTemplate jdbcTemplate;
	
	public List<Sociopartida> findSociosPartida(Integer cdPartida, Integer cdTime) {
		String sql = 
			" select sp.cdpartida, sp.cdsocio, sp.cdtime, sp.nugol, sp.nugolcontra, sp.flgoleiro, sp.flatrazado, sp.flcartaoazul, sp.flcartaovermelho, sp.flcartaoamarelo, s.nmapelido" + 
			" from epfcsociopartida sp" + 
			" join epfcsocio s on sp.cdsocio = s.cdsocio" + 
			" where sp.cdpartida = ?"+ 
			" and sp.cdtime = ?" +
			" order by sp.cdtime asc, sp.nugol desc, s.nmapelido asc";
		List<Map<String, Object>> rows = jdbcTemplate.queryForList(sql, new Object[] {cdPartida, cdTime});
		
		return Sociopartida.extractData(rows);
	}
	
}
