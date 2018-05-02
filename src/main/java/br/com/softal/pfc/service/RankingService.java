package br.com.softal.pfc.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.softal.pfc.dto.RankingDTO;
import br.com.softal.pfc.repository.impl.RankingRepositoryImpl;

@Service
public class RankingService {
	
	@Autowired
	private RankingRepositoryImpl rankingRepositoryImpl;		
	
	public RankingDTO findRankingQuadrimestreAtual() {
		return rankingRepositoryImpl.findRankingQuadrimestreAtual();
	}
	
	public RankingDTO findRankingQuadrimestreAnual() {
		return rankingRepositoryImpl.findRankingQuadrimestreAnual();
	}
	
	
}
