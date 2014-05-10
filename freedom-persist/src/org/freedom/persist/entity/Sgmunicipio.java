package org.freedom.persist.entity;

// Generated 10/05/2014 10:27:15 by Hibernate Tools 4.0.0

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

/**
 * Sgmunicipio generated by hbm2java
 */
public class Sgmunicipio implements java.io.Serializable {

	private SgmunicipioId id;
	private Sguf sguf;
	private String nomemunic;
	private String dddmunic;
	private Date dtins;
	private Date hins;
	private String idusuins;
	private Date dtalt;
	private Date halt;
	private String idusualt;
	private Set vdtransps = new HashSet(0);
	private Set sgbairros = new HashSet(0);
	private Set vdclientesForVdclientefksgmunicent = new HashSet(0);
	private Set sgempresas = new HashSet(0);
	private Set tkcontatos = new HashSet(0);
	private Set cpforneceds = new HashSet(0);
	private Set vdveiculos = new HashSet(0);
	private Set vdclientesForVdclientefksgmuniccob = new HashSet(0);
	private Set sgfilials = new HashSet(0);
	private Set vdclientesForVdclientefksgmunic = new HashSet(0);
	private Set vdmotoristas = new HashSet(0);

	public Sgmunicipio() {
	}

	public Sgmunicipio(SgmunicipioId id, Sguf sguf, String nomemunic,
			String dddmunic, Date dtins, Date hins, String idusuins) {
		this.id = id;
		this.sguf = sguf;
		this.nomemunic = nomemunic;
		this.dddmunic = dddmunic;
		this.dtins = dtins;
		this.hins = hins;
		this.idusuins = idusuins;
	}

	public Sgmunicipio(SgmunicipioId id, Sguf sguf, String nomemunic,
			String dddmunic, Date dtins, Date hins, String idusuins,
			Date dtalt, Date halt, String idusualt, Set vdtransps,
			Set sgbairros, Set vdclientesForVdclientefksgmunicent,
			Set sgempresas, Set tkcontatos, Set cpforneceds, Set vdveiculos,
			Set vdclientesForVdclientefksgmuniccob, Set sgfilials,
			Set vdclientesForVdclientefksgmunic, Set vdmotoristas) {
		this.id = id;
		this.sguf = sguf;
		this.nomemunic = nomemunic;
		this.dddmunic = dddmunic;
		this.dtins = dtins;
		this.hins = hins;
		this.idusuins = idusuins;
		this.dtalt = dtalt;
		this.halt = halt;
		this.idusualt = idusualt;
		this.vdtransps = vdtransps;
		this.sgbairros = sgbairros;
		this.vdclientesForVdclientefksgmunicent = vdclientesForVdclientefksgmunicent;
		this.sgempresas = sgempresas;
		this.tkcontatos = tkcontatos;
		this.cpforneceds = cpforneceds;
		this.vdveiculos = vdveiculos;
		this.vdclientesForVdclientefksgmuniccob = vdclientesForVdclientefksgmuniccob;
		this.sgfilials = sgfilials;
		this.vdclientesForVdclientefksgmunic = vdclientesForVdclientefksgmunic;
		this.vdmotoristas = vdmotoristas;
	}

	public SgmunicipioId getId() {
		return this.id;
	}

	public void setId(SgmunicipioId id) {
		this.id = id;
	}

	public Sguf getSguf() {
		return this.sguf;
	}

	public void setSguf(Sguf sguf) {
		this.sguf = sguf;
	}

	public String getNomemunic() {
		return this.nomemunic;
	}

	public void setNomemunic(String nomemunic) {
		this.nomemunic = nomemunic;
	}

	public String getDddmunic() {
		return this.dddmunic;
	}

	public void setDddmunic(String dddmunic) {
		this.dddmunic = dddmunic;
	}

	public Date getDtins() {
		return this.dtins;
	}

	public void setDtins(Date dtins) {
		this.dtins = dtins;
	}

	public Date getHins() {
		return this.hins;
	}

	public void setHins(Date hins) {
		this.hins = hins;
	}

	public String getIdusuins() {
		return this.idusuins;
	}

	public void setIdusuins(String idusuins) {
		this.idusuins = idusuins;
	}

	public Date getDtalt() {
		return this.dtalt;
	}

	public void setDtalt(Date dtalt) {
		this.dtalt = dtalt;
	}

	public Date getHalt() {
		return this.halt;
	}

	public void setHalt(Date halt) {
		this.halt = halt;
	}

	public String getIdusualt() {
		return this.idusualt;
	}

	public void setIdusualt(String idusualt) {
		this.idusualt = idusualt;
	}

	public Set getVdtransps() {
		return this.vdtransps;
	}

	public void setVdtransps(Set vdtransps) {
		this.vdtransps = vdtransps;
	}

	public Set getSgbairros() {
		return this.sgbairros;
	}

	public void setSgbairros(Set sgbairros) {
		this.sgbairros = sgbairros;
	}

	public Set getVdclientesForVdclientefksgmunicent() {
		return this.vdclientesForVdclientefksgmunicent;
	}

	public void setVdclientesForVdclientefksgmunicent(
			Set vdclientesForVdclientefksgmunicent) {
		this.vdclientesForVdclientefksgmunicent = vdclientesForVdclientefksgmunicent;
	}

	public Set getSgempresas() {
		return this.sgempresas;
	}

	public void setSgempresas(Set sgempresas) {
		this.sgempresas = sgempresas;
	}

	public Set getTkcontatos() {
		return this.tkcontatos;
	}

	public void setTkcontatos(Set tkcontatos) {
		this.tkcontatos = tkcontatos;
	}

	public Set getCpforneceds() {
		return this.cpforneceds;
	}

	public void setCpforneceds(Set cpforneceds) {
		this.cpforneceds = cpforneceds;
	}

	public Set getVdveiculos() {
		return this.vdveiculos;
	}

	public void setVdveiculos(Set vdveiculos) {
		this.vdveiculos = vdveiculos;
	}

	public Set getVdclientesForVdclientefksgmuniccob() {
		return this.vdclientesForVdclientefksgmuniccob;
	}

	public void setVdclientesForVdclientefksgmuniccob(
			Set vdclientesForVdclientefksgmuniccob) {
		this.vdclientesForVdclientefksgmuniccob = vdclientesForVdclientefksgmuniccob;
	}

	public Set getSgfilials() {
		return this.sgfilials;
	}

	public void setSgfilials(Set sgfilials) {
		this.sgfilials = sgfilials;
	}

	public Set getVdclientesForVdclientefksgmunic() {
		return this.vdclientesForVdclientefksgmunic;
	}

	public void setVdclientesForVdclientefksgmunic(
			Set vdclientesForVdclientefksgmunic) {
		this.vdclientesForVdclientefksgmunic = vdclientesForVdclientefksgmunic;
	}

	public Set getVdmotoristas() {
		return this.vdmotoristas;
	}

	public void setVdmotoristas(Set vdmotoristas) {
		this.vdmotoristas = vdmotoristas;
	}

}
