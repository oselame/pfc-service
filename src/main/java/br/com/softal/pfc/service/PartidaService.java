package br.com.softal.pfc.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.softal.pfc.dto.UltimapartidaDTO;
import br.com.softal.pfc.repository.impl.PartidasRepositoryImpl;

@Service
public class PartidaService {
	
	@Autowired
	private PartidasRepositoryImpl partidasRepositoryImpl;	
	
	public UltimapartidaDTO findUltimaPartidaResultado() {
		return partidasRepositoryImpl.findUltimaPartidaResultado();
	}
	
}
