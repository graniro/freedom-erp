package org.freedom.persist.entity;

// Generated 10/05/2014 10:27:15 by Hibernate Tools 4.0.0

import java.math.BigDecimal;
import java.util.Date;

/**
 * Ppitop generated by hbm2java
 */
public class Ppitop implements java.io.Serializable {

	private PpitopId id;
	private Eqproduto eqproduto;
	private Ppfase ppfase;
	private Ppopacaocorret ppopacaocorret;
	private Vdvenda vdvenda;
	private Cpcompra cpcompra;
	private Eqlote eqlote;
	private Ppop ppop;
	private String refprod;
	private BigDecimal qtditop;
	private Short seqitopcp;
	private String codloterat;
	private BigDecimal qtdcopiaitop;
	private char gerarma;
	private char bloqop;
	private Character permiteajusteitop;
	private Character tipoexterno;
	private char emmanut;
	private Date dtins;
	private Date hins;
	private String idusuins;
	private Date dtalt;
	private Date halt;
	private String idusualt;

	public Ppitop() {
	}

	public Ppitop(PpitopId id, Eqproduto eqproduto, Ppfase ppfase,
			Ppopacaocorret ppopacaocorret, Eqlote eqlote, Ppop ppop,
			String refprod, BigDecimal qtditop, char gerarma, char bloqop,
			char emmanut, Date dtins, Date hins, String idusuins) {
		this.id = id;
		this.eqproduto = eqproduto;
		this.ppfase = ppfase;
		this.ppopacaocorret = ppopacaocorret;
		this.eqlote = eqlote;
		this.ppop = ppop;
		this.refprod = refprod;
		this.qtditop = qtditop;
		this.gerarma = gerarma;
		this.bloqop = bloqop;
		this.emmanut = emmanut;
		this.dtins = dtins;
		this.hins = hins;
		this.idusuins = idusuins;
	}

	public Ppitop(PpitopId id, Eqproduto eqproduto, Ppfase ppfase,
			Ppopacaocorret ppopacaocorret, Vdvenda vdvenda, Cpcompra cpcompra,
			Eqlote eqlote, Ppop ppop, String refprod, BigDecimal qtditop,
			Short seqitopcp, String codloterat, BigDecimal qtdcopiaitop,
			char gerarma, char bloqop, Character permiteajusteitop,
			Character tipoexterno, char emmanut, Date dtins, Date hins,
			String idusuins, Date dtalt, Date halt, String idusualt) {
		this.id = id;
		this.eqproduto = eqproduto;
		this.ppfase = ppfase;
		this.ppopacaocorret = ppopacaocorret;
		this.vdvenda = vdvenda;
		this.cpcompra = cpcompra;
		this.eqlote = eqlote;
		this.ppop = ppop;
		this.refprod = refprod;
		this.qtditop = qtditop;
		this.seqitopcp = seqitopcp;
		this.codloterat = codloterat;
		this.qtdcopiaitop = qtdcopiaitop;
		this.gerarma = gerarma;
		this.bloqop = bloqop;
		this.permiteajusteitop = permiteajusteitop;
		this.tipoexterno = tipoexterno;
		this.emmanut = emmanut;
		this.dtins = dtins;
		this.hins = hins;
		this.idusuins = idusuins;
		this.dtalt = dtalt;
		this.halt = halt;
		this.idusualt = idusualt;
	}

	public PpitopId getId() {
		return this.id;
	}

	public void setId(PpitopId id) {
		this.id = id;
	}

	public Eqproduto getEqproduto() {
		return this.eqproduto;
	}

	public void setEqproduto(Eqproduto eqproduto) {
		this.eqproduto = eqproduto;
	}

	public Ppfase getPpfase() {
		return this.ppfase;
	}

	public void setPpfase(Ppfase ppfase) {
		this.ppfase = ppfase;
	}

	public Ppopacaocorret getPpopacaocorret() {
		return this.ppopacaocorret;
	}

	public void setPpopacaocorret(Ppopacaocorret ppopacaocorret) {
		this.ppopacaocorret = ppopacaocorret;
	}

	public Vdvenda getVdvenda() {
		return this.vdvenda;
	}

	public void setVdvenda(Vdvenda vdvenda) {
		this.vdvenda = vdvenda;
	}

	public Cpcompra getCpcompra() {
		return this.cpcompra;
	}

	public void setCpcompra(Cpcompra cpcompra) {
		this.cpcompra = cpcompra;
	}

	public Eqlote getEqlote() {
		return this.eqlote;
	}

	public void setEqlote(Eqlote eqlote) {
		this.eqlote = eqlote;
	}

	public Ppop getPpop() {
		return this.ppop;
	}

	public void setPpop(Ppop ppop) {
		this.ppop = ppop;
	}

	public String getRefprod() {
		return this.refprod;
	}

	public void setRefprod(String refprod) {
		this.refprod = refprod;
	}

	public BigDecimal getQtditop() {
		return this.qtditop;
	}

	public void setQtditop(BigDecimal qtditop) {
		this.qtditop = qtditop;
	}

	public Short getSeqitopcp() {
		return this.seqitopcp;
	}

	public void setSeqitopcp(Short seqitopcp) {
		this.seqitopcp = seqitopcp;
	}

	public String getCodloterat() {
		return this.codloterat;
	}

	public void setCodloterat(String codloterat) {
		this.codloterat = codloterat;
	}

	public BigDecimal getQtdcopiaitop() {
		return this.qtdcopiaitop;
	}

	public void setQtdcopiaitop(BigDecimal qtdcopiaitop) {
		this.qtdcopiaitop = qtdcopiaitop;
	}

	public char getGerarma() {
		return this.gerarma;
	}

	public void setGerarma(char gerarma) {
		this.gerarma = gerarma;
	}

	public char getBloqop() {
		return this.bloqop;
	}

	public void setBloqop(char bloqop) {
		this.bloqop = bloqop;
	}

	public Character getPermiteajusteitop() {
		return this.permiteajusteitop;
	}

	public void setPermiteajusteitop(Character permiteajusteitop) {
		this.permiteajusteitop = permiteajusteitop;
	}

	public Character getTipoexterno() {
		return this.tipoexterno;
	}

	public void setTipoexterno(Character tipoexterno) {
		this.tipoexterno = tipoexterno;
	}

	public char getEmmanut() {
		return this.emmanut;
	}

	public void setEmmanut(char emmanut) {
		this.emmanut = emmanut;
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

}
