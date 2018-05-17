package br.com.softal.pfc.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.softal.pfc.dto.AnoDTO;
import br.com.softal.pfc.dto.QuadrimestreDTO;
import br.com.softal.pfc.repository.impl.QuadrimestreRepositoryImpl;

@Service
public class QuadrimestreService {
	
	@Autowired
	private QuadrimestreRepositoryImpl quadrimestreRepositoryImpl;

	public List<QuadrimestreDTO> findListaQuadrimestre(Integer nuAno) {
		return quadrimestreRepositoryImpl.findListaQuadrimestre(nuAno);
	}

	public QuadrimestreDTO findQuadrimestreAtual() {
		return quadrimestreRepositoryImpl.findQuadrimestreAtual();
	}
	
	public List<AnoDTO> findListaAnos() {
		return quadrimestreRepositoryImpl.findListaAnos();
	}
		
}
