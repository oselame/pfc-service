package br.com.softal.pfc.service.assembler;

import java.util.ArrayList;
import java.util.List;

import br.com.softal.pfc.dto.GaleriaDTO;
import br.com.softal.pfc.model.Galeria;

public class GaleriaAssembler {
	
	public static GaleriaDTO assemblerToGaleriaDTO(Galeria galeria) {
		GaleriaDTO dto = new GaleriaDTO();
		dto.setCdGaleria(galeria.getCdGaleria());
		dto.setDeGaleria(galeria.getDeGaleria());
		dto.setDtGaleria(galeria.getDtGaleria());
		return dto;
	}
	
	public static Galeria assemblerToGaleria(GaleriaDTO galeriaDto) {
		Galeria galeria = new Galeria();
		galeria.setCdGaleria(galeriaDto.getCdGaleria());
		galeria.setDeGaleria(galeriaDto.getDeGaleria());
		galeria.setDtGaleria(galeriaDto.getDtGaleria());
		return galeria;
	}
	
	public static List<GaleriaDTO> assemblerToGaleriaDTO(List<Galeria> galerias) {
		List<GaleriaDTO> lista = new ArrayList<>();
		for (Galeria galeria: galerias) {
			lista.add( assemblerToGaleriaDTO(galeria) );
		}
		return lista;
		
	}

}
