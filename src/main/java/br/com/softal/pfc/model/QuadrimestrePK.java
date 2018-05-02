package br.com.softal.pfc.model;

import java.io.Serializable;

import javax.persistence.Embeddable;

@Embeddable
public class QuadrimestrePK implements Serializable {

	private static final long serialVersionUID = -9016521623726537225L;

	private Integer nuAno;
	private Integer cdQuadrimestre;

	public Integer getCdQuadrimestre() {
		return cdQuadrimestre;
	}

	public void setCdQuadrimestre(Integer cdQuadrimestre) {
		this.cdQuadrimestre = cdQuadrimestre;
	}

	public Integer getNuAno() {
		return nuAno;
	}

	public void setNuAno(Integer nuAno) {
		this.nuAno = nuAno;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((cdQuadrimestre == null) ? 0 : cdQuadrimestre.hashCode());
		result = prime * result + ((nuAno == null) ? 0 : nuAno.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		QuadrimestrePK other = (QuadrimestrePK) obj;
		if (cdQuadrimestre == null) {
			if (other.cdQuadrimestre != null)
				return false;
		} else if (!cdQuadrimestre.equals(other.cdQuadrimestre))
			return false;
		if (nuAno == null) {
			if (other.nuAno != null)
				return false;
		} else if (!nuAno.equals(other.nuAno))
			return false;
		return true;
	}

}
