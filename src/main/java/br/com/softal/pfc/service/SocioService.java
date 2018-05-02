package br.com.softal.pfc.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.softal.pfc.dto.SocioAniversarianteDTO;
import br.com.softal.pfc.repository.impl.SociosRepositoryImpl;

@Service
public class SocioService {
	
	@Autowired
	private SociosRepositoryImpl sociosRepositoryImpl;	
	
	
	public List<SocioAniversarianteDTO> findAllAniversariantes() {
		return sociosRepositoryImpl.findAllAniversariantes();
	}
	
}
