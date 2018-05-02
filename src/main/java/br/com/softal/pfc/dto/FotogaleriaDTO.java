package br.com.softal.pfc.dto;

public class FotogaleriaDTO {

	private Integer cdGaleria;
	private Integer cdFotogaleria;
	private String deGaleria;
	private String dtGaleria;
	private String nmArqfoto;
	
	public FotogaleriaDTO(Integer cdFotogaleria, Integer cdGaleria, String deGaleria, String dtGaleria, String nmArqfoto) {
		super();
		this.cdFotogaleria = cdFotogaleria;
		this.cdGaleria = cdGaleria;
		this.deGaleria = deGaleria;
		this.dtGaleria = dtGaleria;
		this.nmArqfoto = nmArqfoto;
	}
	
	public FotogaleriaDTO() {
		this(null, null, null, null, null);
	}

	public Integer getCdGaleria() {
		return cdGaleria;
	}

	public void setCdGaleria(Integer cdGaleria) {
		this.cdGaleria = cdGaleria;
	}

	public String getDeGaleria() {
		return deGaleria;
	}

	public void setDeGaleria(String deGaleria) {
		this.deGaleria = deGaleria;
	}

	public String getDtGaleria() {
		return dtGaleria;
	}

	public void setDtGaleria(String dtGaleria) {
		this.dtGaleria = dtGaleria;
	}

	public String getNmArqfoto() {
		return nmArqfoto;
	}

	public void setNmArqfoto(String nmArqfoto) {
		this.nmArqfoto = nmArqfoto;
	}

	public Integer getCdFotogaleria() {
		return cdFotogaleria;
	}

	public void setCdFotogaleria(Integer cdFotogaleria) {
		this.cdFotogaleria = cdFotogaleria;
	}

}
