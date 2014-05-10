package org.freedom.persist.entity;

// Generated 10/05/2014 10:27:15 by Hibernate Tools 4.0.0

/**
 * SgbairroId generated by hbm2java
 */
public class SgbairroId implements java.io.Serializable {

	private int codbairro;
	private String codmunic;
	private String siglauf;
	private short codpais;

	public SgbairroId() {
	}

	public SgbairroId(int codbairro, String codmunic, String siglauf,
			short codpais) {
		this.codbairro = codbairro;
		this.codmunic = codmunic;
		this.siglauf = siglauf;
		this.codpais = codpais;
	}

	public int getCodbairro() {
		return this.codbairro;
	}

	public void setCodbairro(int codbairro) {
		this.codbairro = codbairro;
	}

	public String getCodmunic() {
		return this.codmunic;
	}

	public void setCodmunic(String codmunic) {
		this.codmunic = codmunic;
	}

	public String getSiglauf() {
		return this.siglauf;
	}

	public void setSiglauf(String siglauf) {
		this.siglauf = siglauf;
	}

	public short getCodpais() {
		return this.codpais;
	}

	public void setCodpais(short codpais) {
		this.codpais = codpais;
	}

	public boolean equals(Object other) {
		if ((this == other))
			return true;
		if ((other == null))
			return false;
		if (!(other instanceof SgbairroId))
			return false;
		SgbairroId castOther = (SgbairroId) other;

		return (this.getCodbairro() == castOther.getCodbairro())
				&& ((this.getCodmunic() == castOther.getCodmunic()) || (this
						.getCodmunic() != null
						&& castOther.getCodmunic() != null && this
						.getCodmunic().equals(castOther.getCodmunic())))
				&& ((this.getSiglauf() == castOther.getSiglauf()) || (this
						.getSiglauf() != null && castOther.getSiglauf() != null && this
						.getSiglauf().equals(castOther.getSiglauf())))
				&& (this.getCodpais() == castOther.getCodpais());
	}

	public int hashCode() {
		int result = 17;

		result = 37 * result + this.getCodbairro();
		result = 37 * result
				+ (getCodmunic() == null ? 0 : this.getCodmunic().hashCode());
		result = 37 * result
				+ (getSiglauf() == null ? 0 : this.getSiglauf().hashCode());
		result = 37 * result + this.getCodpais();
		return result;
	}

}
