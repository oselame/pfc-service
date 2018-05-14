package br.com.softal.pfc.repository.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import br.com.softal.pfc.dto.QuadrimestreDTO;

@Repository
public class QuadrimestreRepositoryImpl extends BaseRepositoryImpl {
	
	@Autowired
	private JdbcTemplate jdbcTemplate;
	
	public List<QuadrimestreDTO> findListaQuadrimestre(Integer nuAno) {
		List<QuadrimestreDTO> lista = jdbcTemplate.query(
                "select distinct c.nuAno, c.cdQuadrimestre \n" + 
                "from epfcclassificacao c \n" + 
                "where c.nuAno = ? \n" +  
                "order by 1",                
                (rs, rowNum) -> new QuadrimestreDTO(rs)
                , new Object[] { nuAno }
        );
		return lista;
	}

	public QuadrimestreDTO findQuadrimestreAtual() {
		List<QuadrimestreDTO> query = jdbcTemplate.query(
            "select q.nuAno, q.cdQuadrimestre \n" + 
            "from epfcquadrimestre q \n" + 
            "where q.cdQuadrimestre <> 4 \n" + 
            "and exists (select 1 from epfcclassificacao c \n" + 
            "		    where c.nuAno = q.nuAno \n" + 
            "            and c.cdQuadrimestre = q.cdQuadrimestre \n" + 
            "			and c.cdPartida = (select max(x.cdPartida)from epfcclassificacao x) \n" + 
            ")  \n",                
            (rs, rowNum) -> new QuadrimestreDTO(rs)
        );
		if ( !query.isEmpty()) {
			return query.get(0);
		}
		return new QuadrimestreDTO();
	}
	

}
