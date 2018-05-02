package br.com.softal.pfc.model;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity(name = "epfctimecamisa")
public class Timecamisa implements Serializable {

	private static final long serialVersionUID = -6334981181962241078L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer cdTime;
	private String nmTime;
	private Integer flForauso;

	public Integer getCdTime() {
		return cdTime;
	}

	public void setCdTime(Integer cdTime) {
		this.cdTime = cdTime;
	}

	public String getNmTime() {
		return nmTime;
	}

	public void setNmTime(String nmTime) {
		this.nmTime = nmTime;
	}

	public Integer getFlForauso() {
		return flForauso;
	}

	public void setFlForauso(Integer flForauso) {
		this.flForauso = flForauso;
	}

}
