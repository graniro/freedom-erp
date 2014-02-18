package org.freedom.persist.entity;

// Generated 18/02/2014 15:53:28 by Hibernate Tools 4.0.0

/**
 * FnsublancaId generated by hbm2java
 */
public class FnsublancaId implements java.io.Serializable {

	private int codsublanca;
	private int codlanca;
	private short codfilial;
	private int codemp;

	public FnsublancaId() {
	}

	public FnsublancaId(int codsublanca, int codlanca, short codfilial,
			int codemp) {
		this.codsublanca = codsublanca;
		this.codlanca = codlanca;
		this.codfilial = codfilial;
		this.codemp = codemp;
	}

	public int getCodsublanca() {
		return this.codsublanca;
	}

	public void setCodsublanca(int codsublanca) {
		this.codsublanca = codsublanca;
	}

	public int getCodlanca() {
		return this.codlanca;
	}

	public void setCodlanca(int codlanca) {
		this.codlanca = codlanca;
	}

	public short getCodfilial() {
		return this.codfilial;
	}

	public void setCodfilial(short codfilial) {
		this.codfilial = codfilial;
	}

	public int getCodemp() {
		return this.codemp;
	}

	public void setCodemp(int codemp) {
		this.codemp = codemp;
	}

	public boolean equals(Object other) {
		if ((this == other))
			return true;
		if ((other == null))
			return false;
		if (!(other instanceof FnsublancaId))
			return false;
		FnsublancaId castOther = (FnsublancaId) other;

		return (this.getCodsublanca() == castOther.getCodsublanca())
				&& (this.getCodlanca() == castOther.getCodlanca())
				&& (this.getCodfilial() == castOther.getCodfilial())
				&& (this.getCodemp() == castOther.getCodemp());
	}

	public int hashCode() {
		int result = 17;

		result = 37 * result + this.getCodsublanca();
		result = 37 * result + this.getCodlanca();
		result = 37 * result + this.getCodfilial();
		result = 37 * result + this.getCodemp();
		return result;
	}

}
