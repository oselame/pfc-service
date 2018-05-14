package br.com.softal.pfc.dto;

public class JantaDTO {
	
	private String data;
	
	private String socios;

	public String getData() {
		return data;
	}	

	public void setData(String data) {
		this.data = data;
	}

	public String getSocios() {
		return socios;
	}

	public void setSocios(String socios) {
		this.socios = socios;
	}
	
	public String getDate() {
		String[] vDia = getData().split("/");
		String data = vDia[2];
		data += Integer.valueOf(vDia[1]) < 10 ? "0" + Integer.valueOf(vDia[1]) : vDia[1]; 
		data += Integer.valueOf(vDia[0]) < 10 ? "0" + Integer.valueOf(vDia[0]) : vDia[0];
		return data;
	}
	

}
