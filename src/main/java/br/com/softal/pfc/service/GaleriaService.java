package br.com.softal.pfc.service;

import java.util.Collections;
import java.util.Comparator;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.softal.pfc.dto.FotogaleriaDTO;
import br.com.softal.pfc.dto.GaleriaDTO;
import br.com.softal.pfc.model.Galeria;
import br.com.softal.pfc.repository.GaleriaRepository;
import br.com.softal.pfc.repository.impl.GaleriaRepositoryImpl;
import br.com.softal.pfc.service.assembler.GaleriaAssembler;

@Service
public class GaleriaService {
	
	@Autowired
	GaleriaRepository galeriaRepository;
	
	@Autowired
	GaleriaRepositoryImpl galeriaRepositoryImpl; 

	public List<GaleriaDTO> findAllGalerias() {
		List<Galeria> galerias = galeriaRepository.findAll();
		Collections.sort(galerias, new Comparator<Galeria>() {

			@Override
			public int compare(Galeria o1, Galeria o2) {
				return o2.getDtGaleria().compareTo(o1.getDtGaleria());
			}
			
		});
		return GaleriaAssembler.assemblerToGaleriaDTO(galerias);
	}
	
	public List<FotogaleriaDTO> findFotosGaleria(Integer cdGaleria) {
		return galeriaRepositoryImpl.findFotosGaleria(cdGaleria);
	}
	
}
