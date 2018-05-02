package br.com.softal.pfc.model;

import java.io.Serializable;

import javax.persistence.Embeddable;

@Embeddable
public class SociopartidaPK implements Serializable {

	private static final long serialVersionUID = 6697691700678096189L;

	private Integer cdPartida;
	private Integer cdSocio;

	public Integer getCdPartida() {
		return cdPartida;
	}

	public void setCdPartida(Integer cdPartida) {
		this.cdPartida = cdPartida;
	}

	public Integer getCdSocio() {
		return cdSocio;
	}

	public void setCdSocio(Integer cdSocio) {
		this.cdSocio = cdSocio;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((cdPartida == null) ? 0 : cdPartida.hashCode());
		result = prime * result + ((cdSocio == null) ? 0 : cdSocio.hashCode());
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
		SociopartidaPK other = (SociopartidaPK) obj;
		if (cdPartida == null) {
			if (other.cdPartida != null)
				return false;
		} else if (!cdPartida.equals(other.cdPartida))
			return false;
		if (cdSocio == null) {
			if (other.cdSocio != null)
				return false;
		} else if (!cdSocio.equals(other.cdSocio))
			return false;
		return true;
	}

}
