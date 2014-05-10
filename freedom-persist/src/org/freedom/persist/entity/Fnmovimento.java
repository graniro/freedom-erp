package org.freedom.persist.entity;

// Generated 10/05/2014 10:27:15 by Hibernate Tools 4.0.0

import java.math.BigDecimal;
import java.util.Date;

/**
 * Fnmovimento generated by hbm2java
 */
public class Fnmovimento implements java.io.Serializable {

	private long id;
	private Fnitpagar fnitpagar;
	private Fnitreceber fnitreceber;
	private char tipomov;
	private char sitmov;
	private Date dtmov;
	private String statusold;
	private BigDecimal vlrtitulo;
	private BigDecimal vlrparc;
	private BigDecimal vlrapag;
	private BigDecimal vlrpago;
	private BigDecimal vlrdev;
	private BigDecimal vlrjuros;
	private BigDecimal vlrdesc;
	private char emmanut;
	private Date dtins;
	private Date hins;
	private String idusuins;
	private Date dtalt;
	private Date halt;
	private String idusualt;

	public Fnmovimento() {
	}

	public Fnmovimento(long id, char tipomov, char sitmov, Date dtmov,
			String statusold, BigDecimal vlrtitulo, BigDecimal vlrparc,
			BigDecimal vlrapag, BigDecimal vlrpago, BigDecimal vlrdev,
			BigDecimal vlrjuros, BigDecimal vlrdesc, char emmanut, Date dtins,
			Date hins, String idusuins, Date dtalt, Date halt) {
		this.id = id;
		this.tipomov = tipomov;
		this.sitmov = sitmov;
		this.dtmov = dtmov;
		this.statusold = statusold;
		this.vlrtitulo = vlrtitulo;
		this.vlrparc = vlrparc;
		this.vlrapag = vlrapag;
		this.vlrpago = vlrpago;
		this.vlrdev = vlrdev;
		this.vlrjuros = vlrjuros;
		this.vlrdesc = vlrdesc;
		this.emmanut = emmanut;
		this.dtins = dtins;
		this.hins = hins;
		this.idusuins = idusuins;
		this.dtalt = dtalt;
		this.halt = halt;
	}

	public Fnmovimento(long id, Fnitpagar fnitpagar, Fnitreceber fnitreceber,
			char tipomov, char sitmov, Date dtmov, String statusold,
			BigDecimal vlrtitulo, BigDecimal vlrparc, BigDecimal vlrapag,
			BigDecimal vlrpago, BigDecimal vlrdev, BigDecimal vlrjuros,
			BigDecimal vlrdesc, char emmanut, Date dtins, Date hins,
			String idusuins, Date dtalt, Date halt, String idusualt) {
		this.id = id;
		this.fnitpagar = fnitpagar;
		this.fnitreceber = fnitreceber;
		this.tipomov = tipomov;
		this.sitmov = sitmov;
		this.dtmov = dtmov;
		this.statusold = statusold;
		this.vlrtitulo = vlrtitulo;
		this.vlrparc = vlrparc;
		this.vlrapag = vlrapag;
		this.vlrpago = vlrpago;
		this.vlrdev = vlrdev;
		this.vlrjuros = vlrjuros;
		this.vlrdesc = vlrdesc;
		this.emmanut = emmanut;
		this.dtins = dtins;
		this.hins = hins;
		this.idusuins = idusuins;
		this.dtalt = dtalt;
		this.halt = halt;
		this.idusualt = idusualt;
	}

	public long getId() {
		return this.id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public Fnitpagar getFnitpagar() {
		return this.fnitpagar;
	}

	public void setFnitpagar(Fnitpagar fnitpagar) {
		this.fnitpagar = fnitpagar;
	}

	public Fnitreceber getFnitreceber() {
		return this.fnitreceber;
	}

	public void setFnitreceber(Fnitreceber fnitreceber) {
		this.fnitreceber = fnitreceber;
	}

	public char getTipomov() {
		return this.tipomov;
	}

	public void setTipomov(char tipomov) {
		this.tipomov = tipomov;
	}

	public char getSitmov() {
		return this.sitmov;
	}

	public void setSitmov(char sitmov) {
		this.sitmov = sitmov;
	}

	public Date getDtmov() {
		return this.dtmov;
	}

	public void setDtmov(Date dtmov) {
		this.dtmov = dtmov;
	}

	public String getStatusold() {
		return this.statusold;
	}

	public void setStatusold(String statusold) {
		this.statusold = statusold;
	}

	public BigDecimal getVlrtitulo() {
		return this.vlrtitulo;
	}

	public void setVlrtitulo(BigDecimal vlrtitulo) {
		this.vlrtitulo = vlrtitulo;
	}

	public BigDecimal getVlrparc() {
		return this.vlrparc;
	}

	public void setVlrparc(BigDecimal vlrparc) {
		this.vlrparc = vlrparc;
	}

	public BigDecimal getVlrapag() {
		return this.vlrapag;
	}

	public void setVlrapag(BigDecimal vlrapag) {
		this.vlrapag = vlrapag;
	}

	public BigDecimal getVlrpago() {
		return this.vlrpago;
	}

	public void setVlrpago(BigDecimal vlrpago) {
		this.vlrpago = vlrpago;
	}

	public BigDecimal getVlrdev() {
		return this.vlrdev;
	}

	public void setVlrdev(BigDecimal vlrdev) {
		this.vlrdev = vlrdev;
	}

	public BigDecimal getVlrjuros() {
		return this.vlrjuros;
	}

	public void setVlrjuros(BigDecimal vlrjuros) {
		this.vlrjuros = vlrjuros;
	}

	public BigDecimal getVlrdesc() {
		return this.vlrdesc;
	}

	public void setVlrdesc(BigDecimal vlrdesc) {
		this.vlrdesc = vlrdesc;
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
