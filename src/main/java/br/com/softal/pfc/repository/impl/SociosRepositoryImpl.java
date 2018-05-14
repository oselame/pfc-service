package br.com.softal.pfc.repository.impl;

import java.util.Calendar;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import br.com.softal.pfc.dto.SocioAniversarianteDTO;
import br.com.softal.pfc.model.SocioEnum;

@Repository
public class SociosRepositoryImpl extends BaseRepositoryImpl {
	
	@Autowired
	private JdbcTemplate jdbcTemplate;
	
	private List<SocioAniversarianteDTO> findAllAniversariantesMesDia(Integer nuDia, Integer nuMes) {
		List<SocioAniversarianteDTO> sociosAniversariantes = jdbcTemplate.query(
                "SELECT cdSocio, nmSocio, nmApelido, extract(day from dtNascimento) as nuDia, extract(month from dtNascimento) as nuMes, imFoto \n" + 
                "FROM epfcsocio \n" + 
                "WHERE coalesce(flForauso,0) = 0 \n" +
                "AND ((extract(month from dtNascimento) = ? and extract(day from dtNascimento) >= ?) \n" + 
                "     or (extract(month from dtNascimento) > ?)) \n" +
                "AND tpSocio <> ? \n" +
                "ORDER BY 5, 4, 3 ",                
                (rs, rowNum) -> new SocioAniversarianteDTO( rs )
                , new Object[] { nuMes, nuDia, nuMes, SocioEnum.AVULSO.getTpSocio() }
        );
		return sociosAniversariantes;
	}
	
	public List<SocioAniversarianteDTO> findAllAniversariantes() {
		Calendar c = Calendar.getInstance();
		int nuDia = c.get(Calendar.DAY_OF_MONTH);
		int nuMes = c.get(Calendar.MONTH) + 1;
		List<SocioAniversarianteDTO> sociosMesDiaAnoAtual = findAllAniversariantesMesDia(nuDia, nuMes);
		List<SocioAniversarianteDTO> sociosProximoAno = findAllAniversariantesMesDia(1, 1);
		sociosMesDiaAnoAtual.addAll( sociosProximoAno );
		return sociosMesDiaAnoAtual.subList(0, sociosProximoAno.size());
	}


}
