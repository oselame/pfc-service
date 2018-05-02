package br.com.softal.pfc.repository.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import br.com.softal.pfc.dto.FotogaleriaDTO;

@Repository
public class GaleriaRepositoryImpl extends BaseRepositoryImpl {
	
	@Autowired
	private JdbcTemplate jdbcTemplate;
	
	public List<FotogaleriaDTO> findFotosGaleria(Integer cdGaleria) {
		List<FotogaleriaDTO> fotosGaleria = jdbcTemplate.query(
                "SELECT g.cdgaleria, g.degaleria, g.dtgaleria, fg.cdfotogaleria, fg.nmarqfoto \n" + 
                "FROM epfcfotogaleria fg\n" + 
                "JOIN epfcgaleria g on g.cdgaleria = fg.cdgaleria\n" + 
                "WHERE g.cdGaleria = ? ",                
                (rs, rowNum) -> new FotogaleriaDTO(
                		rs.getInt("cdfotogaleria"),
                		rs.getInt("cdgaleria"),
                		rs.getString("degaleria"), 
                		rs.getString("dtgaleria"),
                		rs.getString("nmarqfoto"))
                , new Object[] { cdGaleria }
        );
		return fotosGaleria;
	}
	
	


}
