/**
 * @version 10/06/2003 <BR>
 * @author Setpoint Inform�tica Ltda./Robson Sanchez <BR>
 * 
 * Projeto: Freedom <BR>
 * 
 * Pacote: org.freedom.modulos.pdv <BR>
 * Classe:
 * @(#)FVenda.java <BR>
 * 
 * Este programa � licenciado de acordo com a LPG-PC (Licen�a P�blica Geral para
 * Programas de Computador), <BR>
 * vers�o 2.1.0 ou qualquer vers�o posterior. <BR>
 * A LPG-PC deve acompanhar todas PUBLICA��ES, DISTRIBUI��ES e REPRODU��ES deste
 * Programa. <BR>
 * Caso uma c�pia da LPG-PC n�o esteja dispon�vel junto com este Programa, voc�
 * pode contatar <BR>
 * o LICENCIADOR ou ent�o pegar uma c�pia em: <BR>
 * Licen�a: http://www.lpg.adv.br/licencas/lpgpc.rtf <BR>
 * Para poder USAR, PUBLICAR, DISTRIBUIR, REPRODUZIR ou ALTERAR este Programa �
 * preciso estar <BR>
 * de acordo com os termos da LPG-PC <BR>
 * <BR>
 * 
 * Coment�rios sobre a classe...
 *  
 */

package org.freedom.modulos.pdv;

import java.awt.AWTException;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Robot;
import java.awt.event.ActionEvent;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.WindowEvent;
import java.math.BigDecimal;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Date;
import java.util.Properties;
import java.util.Vector;

import javax.swing.BorderFactory;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.SwingConstants;

import org.freedom.acao.CarregaEvent;
import org.freedom.acao.CarregaListener;
import org.freedom.acao.PostEvent;
import org.freedom.acao.PostListener;
import org.freedom.bmps.Icone;
import org.freedom.componentes.GuardaCampo;
import org.freedom.componentes.JButtonPad;
import org.freedom.componentes.JLabelPad;
import org.freedom.componentes.JPanelPad;
import org.freedom.componentes.JPasswordFieldPad;
import org.freedom.componentes.JTextFieldFK;
import org.freedom.componentes.JTextFieldPad;
import org.freedom.componentes.ListaCampos;
import org.freedom.componentes.StatusBar;
import org.freedom.componentes.StringDireita;
import org.freedom.componentes.Tabela;
import org.freedom.comutacao.Tef;
import org.freedom.drivers.JBemaFI32;
import org.freedom.funcoes.Funcoes;
import org.freedom.funcoes.Logger;
import org.freedom.telas.Aplicativo;
import org.freedom.telas.AplicativoPDV;
import org.freedom.telas.DlgCalc;
import org.freedom.telas.FDialogo;
import org.freedom.telas.FFDialogo;

public class FVenda extends FDialogo implements KeyListener,CarregaListener,
		PostListener {

	private StatusBar sbVenda = new StatusBar(new BorderLayout());

	private JPanelPad pnStatusBar = new JPanelPad(JPanelPad.TP_JPANEL,
			new BorderLayout());

	private JPanelPad pnClienteGeral = new JPanelPad(JPanelPad.TP_JPANEL,
			new BorderLayout());

	private JPanelPad pnCliente = new JPanelPad(JPanelPad.TP_JPANEL,
			new BorderLayout());

	private JPanelPad pnTabela = new JPanelPad(JPanelPad.TP_JPANEL,
			new BorderLayout());

	private JPanelPad pnNorte = new JPanelPad(JPanelPad.TP_JPANEL,
			new BorderLayout());

	private JPanelPad pnEntrada = new JPanelPad(JPanelPad.TP_JPANEL,
			new BorderLayout());

	private JPanelPad pinBarra = new JPanelPad(798, 45);

	private JPanelPad pinCab = new JPanelPad(798, 45);

	private JPanelPad pinProduto = new JPanelPad(798, 130);

	private JPanelPad pinEntrada = new JPanelPad(190, 180);

	private JPanelPad pnRodTb = new JPanelPad(new BorderLayout());
	
	private JPanelPad pnTots = new JPanelPad(440, 45);

	private Tabela tbItem = new Tabela();

	private JScrollPane spTb = new JScrollPane(tbItem);

	private JButtonPad btF3 = new JButtonPad();

	private JButtonPad btCtrlF3 = new JButtonPad();

	private JButtonPad btF4 = new JButtonPad();

	private JButtonPad btF5 = new JButtonPad();

	private JButtonPad btF6 = new JButtonPad();

	private JButtonPad btF7 = new JButtonPad();

	private JButtonPad btF8 = new JButtonPad();

	private JButtonPad btF9 = new JButtonPad();

	private JButtonPad btF10 = new JButtonPad();

	private JTextFieldPad txtCodCli = new JTextFieldPad(
			JTextFieldPad.TP_INTEGER, 8, 0);

	private JTextFieldFK txtRazCli = new JTextFieldFK(JTextFieldPad.TP_STRING,
			40, 0);

	private JTextFieldPad txtCodPlanoPag = new JTextFieldPad(
			JTextFieldPad.TP_INTEGER, 8, 0);

	private JTextFieldFK txtDescPlanoPag = new JTextFieldFK(
			JTextFieldPad.TP_STRING, 40, 0);

	private JTextFieldPad txtCodVenda = new JTextFieldPad(
			JTextFieldPad.TP_INTEGER, 8, 0);

	private JTextFieldPad txtTipoVenda = new JTextFieldPad(
			JTextFieldPad.TP_STRING, 1, 0);

	private JTextFieldPad txtCodTipoMov = new JTextFieldPad(
			JTextFieldPad.TP_INTEGER, 8, 0);

	private JTextFieldPad txtDtEmitVenda = new JTextFieldPad(
			JTextFieldPad.TP_DATE, 10, 0);

	private JTextFieldPad txtDtSaidaVenda = new JTextFieldPad(
			JTextFieldPad.TP_DATE, 10, 0);

	private JTextFieldPad txtCodVend = new JTextFieldPad(
			JTextFieldPad.TP_INTEGER, 8, 0);

	private JTextFieldPad txtCodProd1 = new JTextFieldPad(
			JTextFieldPad.TP_INTEGER, 8, 0);

	private JTextFieldPad txtDescProd = new JTextFieldPad(
			JTextFieldPad.TP_STRING, 50, 0);

	private JTextFieldPad txtCodProd = new JTextFieldPad(
			JTextFieldPad.TP_INTEGER, 8, 0);

	private JTextFieldPad txtQtdade = new JTextFieldPad(
			JTextFieldPad.TP_DECIMAL, 9, 2);

	private JTextFieldPad txtPreco = new JTextFieldPad(
			JTextFieldPad.TP_DECIMAL, 15, 2);

	private JTextFieldPad txtBaseCalc = new JTextFieldPad(
			JTextFieldPad.TP_DECIMAL, 12, 2);

	private JTextFieldPad txtAliqIcms = new JTextFieldPad(
			JTextFieldPad.TP_DECIMAL, 7, 2);

	private JTextFieldPad txtTotalItem = new JTextFieldPad(
			JTextFieldPad.TP_DECIMAL, 12, 2);

	private JTextFieldPad txtValorIcms = new JTextFieldPad(
			JTextFieldPad.TP_DECIMAL, 12, 2);

	private JTextFieldPad txtBaseCalc1 = new JTextFieldPad(
			JTextFieldPad.TP_DECIMAL, 12, 2);

	private JTextFieldPad txtValorIcms1 = new JTextFieldPad(
			JTextFieldPad.TP_DECIMAL, 12, 2);

	private JTextFieldPad txtTotalCupom = new JTextFieldPad(
			JTextFieldPad.TP_DECIMAL, 12, 2);

	private JTextFieldPad txtNumeroCupom = new JTextFieldPad(
			JTextFieldPad.TP_INTEGER, 8, 0);

	private JTextFieldPad txtSerieCupom = new JTextFieldPad(
			JTextFieldPad.TP_STRING, 4, 0);

	private JTextFieldPad txtQtdadeItem = new JTextFieldPad(
			JTextFieldPad.TP_DECIMAL, 12, 2);

	private JTextFieldPad txtValorTotalItem = new JTextFieldPad(
			JTextFieldPad.TP_DECIMAL, 12, 2);

	private JTextFieldPad txtValorTotalCupom = new JTextFieldPad(
			JTextFieldPad.TP_DECIMAL, 12, 2);

	private JTextFieldPad txtCodFisc = new JTextFieldPad(
			JTextFieldPad.TP_STRING, 13, 0);

	private JTextFieldPad txtTipoFisc = new JTextFieldPad(
			JTextFieldPad.TP_STRING, 2, 0);

	private ListaCampos lcVenda = new ListaCampos(this);

	private ListaCampos lcTipoMov = new ListaCampos(this, "TM");

	private ListaCampos lcSerie = new ListaCampos(this, "SE");

	private ListaCampos lcCliente = new ListaCampos(this, "CL");

	private ListaCampos lcPlanoPag = new ListaCampos(this, "PG");

	private ListaCampos lcProduto = new ListaCampos(this, "PD");

	private ListaCampos lcClFiscal = new ListaCampos(this, "FC");

	private JLabelPad lCodCli = new JLabelPad("C�d.cli.");

	private JLabelPad lRazCli = new JLabelPad("Raz�o social do cliente");

	private JLabelPad lCodPlanoPag = new JLabelPad("C�d.p.pag.");

	private JLabelPad lDescPlanoPag = new JLabelPad(
			"Descri��o do plano de pagamento");

	private JLabelPad lCodVenda = new JLabelPad("N� seq.venda");

	private JLabelPad lCodProd1 = new JLabelPad("C�d.prod.");

	private JLabelPad lDescProd1 = new JLabelPad("Descri��o do produto");

	private JLabelPad lCodProd2 = new JLabelPad("C�d.prod.");

	private JLabelPad lQtd = new JLabelPad("Quantidade");

	private JLabelPad lPreco = new JLabelPad("Pre�o");

	private JLabelPad lBaseCalc1 = new JLabelPad("Base c�lculo");

	private JLabelPad lValorIcms1 = new JLabelPad("Total Icms");

	private JLabelPad lTotalCupom = new JLabelPad("Total cupom");

	private JLabelPad lNumeroCupom = new JLabelPad("N�mero cupom");

	private JLabelPad lSerieCupom = new JLabelPad("S�rie");

	private JLabelPad lBaseCalc2 = new JLabelPad("Base c�lc.");

	private JLabelPad lAliqIcms = new JLabelPad("% Icms");

	private JLabelPad lTotalItem = new JLabelPad("Total item");

	private JLabelPad lValorIcms = new JLabelPad("Valor Icms");

	private JLabelPad lQtdadeItem = new JLabelPad("Quantidade do item");

	private JLabelPad lValorTotalItem = new JLabelPad("Valor total do item");

	private JLabelPad lValorTotalCupom = new JLabelPad("Valor total do cupom");

	private JLabelPad lbAvisoImp = new JLabelPad();

	private JBemaFI32 bf = (FreedomPDV.bECFTerm ? new JBemaFI32() : null);

	private Font fntTotalItem = null;

	private Font fntTotalCupom = null;

	private Vector vCacheItem = new Vector();

	private Tef tef = null;

	public FVenda() {
		//   	  super(Aplicativo.telaPrincipal);
		setTitulo("Venda");
		setAtribos(798, 580);
		setToFrameLayout();
		setResizable(false);
		setLocation(0, 0);
		Dimension size = Aplicativo.telaPrincipal.getSize();
		size.height -= 9;
		size.width -= 9;
		setSize(size);

		txtPreco.setAtivo(false);
		txtCodVenda.setAtivo(false);
		txtSerieCupom.setAtivo(false);
		txtNumeroCupom.setAtivo(false);

		fntTotalItem = new Font(lValorTotalItem.getFont().getFontName(),
				lValorTotalItem.getFont().getStyle(), 26);
		fntTotalCupom = new Font(lValorTotalCupom.getFont().getFontName(),
				lValorTotalCupom.getFont().getStyle(), 26);

		lcCliente.add(new GuardaCampo(txtCodCli, "CodCli", "C�d.cli.",
				ListaCampos.DB_PK, false));
		lcCliente.add(new GuardaCampo(txtRazCli, "RazCli",
				"Raz�o Social do cliente", ListaCampos.DB_SI, false));
		lcCliente.montaSql(false, "CLIENTE", "VD");
		lcCliente.setReadOnly(true);
		txtCodCli.setTabelaExterna(lcCliente);
		txtCodCli.setFK(true);
		txtCodCli.setNomeCampo("CodCli");

		lcClFiscal.add(new GuardaCampo(txtCodFisc, "CodFisc", "C�d.fisc",
				ListaCampos.DB_PK, false));
		lcClFiscal.add(new GuardaCampo(txtTipoFisc, "TipoFisc", "C�d.tp.fisc.",
				ListaCampos.DB_SI, false));
		lcClFiscal.montaSql(false, "CLFISCAL", "LF");
		lcClFiscal.setReadOnly(true);
		txtCodFisc.setTabelaExterna(lcClFiscal);

		lcPlanoPag.add(new GuardaCampo(txtCodPlanoPag, "CodPlanoPag",
				"C�d.p.pag.", ListaCampos.DB_PK, false));
		lcPlanoPag.add(new GuardaCampo(txtDescPlanoPag, "DescPlanoPag",
				"Descri��o do plano de pagamento", ListaCampos.DB_SI, false));
		lcPlanoPag.montaSql(false, "PLANOPAG", "FN");
		lcPlanoPag.setReadOnly(true);
		txtCodPlanoPag.setTabelaExterna(lcPlanoPag);
		txtCodPlanoPag.setFK(true);

		txtCodPlanoPag.setNomeCampo("CodPlanoPag");

		lcSerie.add(new GuardaCampo(txtSerieCupom, "Serie", "Serie",
				ListaCampos.DB_PK, false));
		lcSerie.add(new GuardaCampo(txtNumeroCupom, "DocSerie", "Doc",
				ListaCampos.DB_SI, true));
		lcSerie.montaSql(false, "SERIE", "LF");
		lcSerie.setReadOnly(true);
		txtSerieCupom.setTabelaExterna(lcSerie);
		txtSerieCupom.setFK(true);
		txtSerieCupom.setNomeCampo("Serie");

		lcTipoMov.add(new GuardaCampo(txtCodTipoMov, "CodTipoMov",
				"C�d.tp.mov.", ListaCampos.DB_PK, true));
		lcTipoMov.add(new GuardaCampo(txtSerieCupom, "Serie", "Serie",
				ListaCampos.DB_FK, false));
		lcTipoMov.montaSql(false, "TIPOMOV", "EQ");
		lcTipoMov.setReadOnly(true);
		txtCodTipoMov.setTabelaExterna(lcTipoMov);
		txtCodTipoMov.setFK(true);
		txtCodTipoMov.setNomeCampo("CodTipoMov");

		lcVenda.add(new GuardaCampo(txtCodVenda, "CodVenda", "N� pedido",
				ListaCampos.DB_PK, true));
		lcVenda.add(new GuardaCampo(txtTipoVenda, "TipoVenda", "Tipo venda.",
				ListaCampos.DB_PK, true));
		lcVenda.add(new GuardaCampo(txtCodTipoMov, "CodTipoMov", "C�d.tp.mov.",
				ListaCampos.DB_FK, true));
		lcVenda.add(new GuardaCampo(txtSerieCupom, "Serie", "Serie",
				ListaCampos.DB_FK, false));
		lcVenda.add(new GuardaCampo(txtNumeroCupom, "DocVenda", "Doc",
				ListaCampos.DB_SI, false));
		lcVenda.add(new GuardaCampo(txtDtSaidaVenda, "DtSaidaVenda", "Sa�da",
				ListaCampos.DB_SI, true));
		lcVenda.add(new GuardaCampo(txtDtEmitVenda, "DtEmitVenda", "Emiss�o",
				ListaCampos.DB_SI, true));
		lcVenda.add(new GuardaCampo(txtCodCli, "CodCli", "C�d.cli.",
				ListaCampos.DB_FK, true));
		lcVenda.add(new GuardaCampo(txtCodPlanoPag, "CodPlanoPag",
				"C�d.p.pag.", ListaCampos.DB_FK, true));
		lcVenda.add(new GuardaCampo(txtCodVend, "CodVend", "C�d.comiss.",
				ListaCampos.DB_SI, true));
		lcVenda.montaSql(true, "VENDA", "VD");
		txtCodVenda.setListaCampos(lcVenda);
		txtCodVenda.setPK(true);
		txtCodVenda.setNomeCampo("CodVenda");

		lcProduto.add(new GuardaCampo(txtCodProd, "CodProd", "C�d.prod.",
				ListaCampos.DB_PK, true));
		lcProduto.add(new GuardaCampo(txtDescProd, "DescProd",
				"Descri��o do produto", ListaCampos.DB_SI, false));
		lcProduto.add(new GuardaCampo(txtCodProd1, "CodProd", "C�d.prod.",
				ListaCampos.DB_SI, false));
		lcProduto.add(new GuardaCampo(txtCodFisc, "CodFisc", "C�d.fisc.",
				ListaCampos.DB_FK, false));
		lcProduto.montaSql(false, "PRODUTO", "EQ");
		lcProduto.setReadOnly(true);
		txtCodProd.setTabelaExterna(lcProduto);
		txtCodProd.setFK(true);
		txtCodProd.setNomeCampo("CodProd");

		lbAvisoImp.setFont(new Font(lValorTotalItem.getFont().getFontName(),
				lValorTotalItem.getFont().getStyle(), 12));
		lbAvisoImp.setForeground(Color.RED);
		lbAvisoImp.setHorizontalAlignment(SwingConstants.CENTER);
		

		txtCodProd1.setSoLeitura(true);
		txtDescProd.setSoLeitura(true);
		txtPreco.setTipo(JTextFieldPad.TP_DECIMAL, 12, 2);
		txtBaseCalc.setSoLeitura(true);
		txtAliqIcms.setSoLeitura(true);
		txtTotalItem.setSoLeitura(true);
		txtValorIcms.setSoLeitura(true);

		txtBaseCalc1.setSoLeitura(true);
		txtValorIcms1.setSoLeitura(true);
		txtTotalCupom.setSoLeitura(true);
		txtQtdadeItem.setSoLeitura(true);
		txtValorTotalItem.setSoLeitura(true);
		txtValorTotalCupom.setSoLeitura(true);

		tbItem.adicColuna("Item");
		tbItem.adicColuna("C�d.prod.");
		tbItem.adicColuna("Descri��o do produto");
		tbItem.adicColuna("Qtd.");
		tbItem.adicColuna("Pre�o");
		tbItem.adicColuna("% Icms");
		tbItem.adicColuna("Base c�lc.");
		tbItem.adicColuna("Valor Icms");
		tbItem.adicColuna("C");

		tbItem.setTamColuna(40, 0);
		tbItem.setTamColuna(100, 1);
		tbItem.setTamColuna(250, 2);
		tbItem.setTamColuna(70, 3);
		tbItem.setTamColuna(90, 4);
		tbItem.setTamColuna(90, 5);
		tbItem.setTamColuna(90, 6);
		tbItem.setTamColuna(90, 7);
		tbItem.setTamColuna(20, 8);

		c.add(pnClienteGeral, BorderLayout.CENTER);

		btF3.setToolTipText("Cancela �ltimo item.");
		btCtrlF3.setToolTipText("Cancela item por posi��o.");
		btF4.setToolTipText("Fecha venda.");
		btF5.setToolTipText("Leitura X.");
		btF6.setToolTipText("Abre gaveta.");
		btF7.setToolTipText("Calculadora.");
		btF8.setToolTipText("Repete item.");
		btF9.setToolTipText("Seleciona cliente.");
		btF10.setToolTipText("Fecha caixa.");

		btF3.setIcon(Icone.novo("btPdvCancelaItem.gif"));
		btCtrlF3.setIcon(Icone.novo("btPdvCtrlCancelaItem.gif"));
		btF4.setIcon(Icone.novo("btPdvFechaVenda.gif"));
		btF5.setIcon(Icone.novo("btPdvLeituraX.gif"));
		btF6.setIcon(Icone.novo("btPdvGaveta.gif"));
		btF7.setIcon(Icone.novo("btPdvCalc.gif"));
		btF8.setIcon(Icone.novo("btPdvCopiaItem.gif"));
		btF9.setIcon(Icone.novo("btPdvSelCliente.gif"));
		btF10.setIcon(Icone.novo("btPdvFechaCaixa.gif"));
		pinBarra.adic(btF3, 5, 3, 60, 35);
		pinBarra.adic(btCtrlF3, 70, 3, 60, 35);
		pinBarra.adic(btF4, 135, 3, 60, 35);
		pinBarra.adic(btF5, 200, 3, 60, 35);
		pinBarra.adic(btF6, 265, 3, 60, 35);
		pinBarra.adic(btF7, 330, 3, 60, 35);
		pinBarra.adic(btF8, 395, 3, 60, 35);
		pinBarra.adic(btF9, 460, 3, 60, 35);
		pinBarra.adic(btF10, 525, 3, 60, 35);

		pinCab.adic(lCodCli, 5, 3, 70, 15);
		pinCab.adic(lRazCli, 75, 3, 200, 15);
		pinCab.adic(txtCodCli, 5, 20, 68, 20);
		pinCab.adic(txtRazCli, 75, 20, 200, 20);
		pinCab.adic(lCodPlanoPag, 283, 3, 70, 15);
		pinCab.adic(lDescPlanoPag, 353, 3, 200, 15);
		pinCab.adic(txtCodPlanoPag, 283, 20, 68, 20);
		pinCab.adic(txtDescPlanoPag, 353, 20, 200, 20);
		pinCab.adic(lCodVenda, 561, 3, 105, 15);
		pinCab.adic(txtCodVenda, 561, 20, 105, 20);

		txtDescProd.setFont(fntTotalItem);
		txtCodProd1.setFont(fntTotalItem);
		txtQtdadeItem.setFont(fntTotalItem);
		txtValorTotalItem.setFont(fntTotalItem);
		txtValorTotalCupom.setFont(fntTotalCupom);

		txtDescProd.setForeground(Color.BLUE);
		txtCodProd1.setForeground(Color.BLUE);
		txtQtdadeItem.setForeground(Color.BLUE);
		txtValorTotalItem.setForeground(Color.BLUE);
		txtValorTotalCupom.setForeground(Color.RED);

		pinProduto.adic(lDescProd1, 5, 3, 450, 15);
		pinProduto.adic(lCodProd1, 460, 3, 206, 15);
		pinProduto.adic(txtDescProd, 5, 20, 450, 40);
		pinProduto.adic(txtCodProd1, 460, 20, 206, 40);
		pinProduto.adic(lQtdadeItem, 5, 65, 215, 15);
		pinProduto.adic(lValorTotalItem, 225, 65, 215, 15);
		pinProduto.adic(lValorTotalCupom, 445, 65, 220, 15);
		pinProduto.adic(txtQtdadeItem, 5, 82, 215, 40);
		pinProduto.adic(txtValorTotalItem, 225, 82, 215, 40);
		pinProduto.adic(txtValorTotalCupom, 445, 82, 220, 40);

		pinEntrada.adic(lCodProd2, 5, 3, 70, 15);
		pinEntrada.adic(txtCodProd, 5, 20, 180, 20);
		pinEntrada.adic(lQtd, 5, 45, 85, 15);
		pinEntrada.adic(txtQtdade, 5, 62, 85, 20);
		pinEntrada.adic(lPreco, 95, 45, 90, 15);
		pinEntrada.adic(txtPreco, 95, 62, 90, 20);
		pinEntrada.adic(lTotalItem, 5, 87, 88, 15);
		pinEntrada.adic(txtTotalItem, 5, 104, 88, 20);
		pinEntrada.adic(lBaseCalc2, 98, 87, 87, 15);
		pinEntrada.adic(txtBaseCalc, 98, 104, 87, 20);
		pinEntrada.adic(lAliqIcms, 5, 129, 60, 15);
		pinEntrada.adic(txtAliqIcms, 5, 146, 60, 20);
		pinEntrada.adic(lValorIcms, 70, 129, 115, 15);
		pinEntrada.adic(txtValorIcms, 70, 146, 115, 20);

		pnTots.adic(lBaseCalc1, 5, 3, 90, 15);
		pnTots.adic(lValorIcms1, 100, 3, 90, 15);
		pnTots.adic(lTotalCupom, 195, 3, 90, 15);
		pnTots.adic(lNumeroCupom, 290, 3, 90, 15);
		pnTots.adic(lSerieCupom, 385, 3, 50, 15);

		pnTots.adic(txtBaseCalc1, 5, 20, 90, 20);
		pnTots.adic(txtValorIcms1, 100, 20, 90, 20);
		pnTots.adic(txtTotalCupom, 195, 20, 90, 20);
		pnTots.adic(txtNumeroCupom, 290, 20, 90, 20);
		pnTots.adic(txtSerieCupom, 385, 20, 50, 20);
		
		pnTots.tiraBorda();
		pnRodTb.add(pnTots,BorderLayout.WEST);
		pnRodTb.add(lbAvisoImp,BorderLayout.CENTER);
		pnRodTb.setBorder(BorderFactory.createEtchedBorder());

		pnNorte.add(pinBarra, BorderLayout.NORTH);
		pnNorte.add(pinCab, BorderLayout.SOUTH);
		pnTabela.add(pnRodTb, BorderLayout.SOUTH);
		pnTabela.add(spTb, BorderLayout.CENTER);
		pnEntrada.add(pinEntrada, BorderLayout.CENTER);
		pnCliente.add(pinProduto, BorderLayout.NORTH);
		pnCliente.add(pnEntrada, BorderLayout.EAST);
		pnCliente.add(pnTabela, BorderLayout.CENTER);
		pnClienteGeral.add(pnNorte, BorderLayout.NORTH);
		pnClienteGeral.add(pnCliente, BorderLayout.CENTER);

		txtCodProd.addKeyListener(this);
		txtQtdade.addKeyListener(this);
		lcProduto.addCarregaListener(this);
		addKeyListener(this);

		btF3.addActionListener(this);
		btCtrlF3.addActionListener(this);
		btF4.addActionListener(this);
		btF5.addActionListener(this);
		btF6.addActionListener(this);
		btF7.addActionListener(this);
		btF8.addActionListener(this);
		btF9.addActionListener(this);
		btF10.addActionListener(this);

		lcVenda.addPostListener(this);
		
		if (AplicativoPDV.bTEFTerm) {
			tef = new Tef(Aplicativo.strTefEnv, Aplicativo.strTefRet);
		}
		
		setPrimeiroFoco(txtCodProd);
		
	}

	private void insereItem() {
		int iCodItVenda = 0;
		String sSQL = "SELECT CODITVENDA,PERCICMSITVENDA,VLRBASEICMSITVENDA,"
				+ "VLRICMSITVENDA,VLRLIQITVENDA FROM VDADICITEMPDVSP(?,?,?,?,?,?,?,?)";
		try {
			PreparedStatement ps = con.prepareStatement(sSQL);
			ps.setInt(1, txtCodVenda.getVlrInteger().intValue());
			ps.setInt(2, Aplicativo.iCodEmp);
			ps.setInt(3, lcVenda.getCodFilial());
			ps.setInt(4, txtCodProd.getVlrInteger().intValue());
			ps.setInt(5, Aplicativo.iCodEmp);
			ps.setInt(6, lcProduto.getCodFilial());
			ps.setBigDecimal(7, txtQtdade.getVlrBigDecimal());
			ps.setBigDecimal(8, txtPreco.getVlrBigDecimal());
			ResultSet rs = ps.executeQuery();
			if (rs.next()) {
				iCodItVenda = rs.getInt("CodItVenda");
				txtAliqIcms.setVlrBigDecimal(rs
						.getBigDecimal("PercICMSItVenda"));
				txtBaseCalc.setVlrBigDecimal(rs
						.getBigDecimal("VlrBaseICMSItVenda"));
				txtValorIcms.setVlrBigDecimal(rs
						.getBigDecimal("VlrICMSItVenda"));
				txtValorTotalItem.setVlrBigDecimal(rs
						.getBigDecimal("VlrLiqItVenda"));
				txtQtdadeItem.setVlrBigDecimal(txtQtdade.getVlrBigDecimal());
			}
			if (!con.getAutoCommit())
				con.commit();
			tbItem.adicLinha(new Object[] { new Integer(iCodItVenda),
					txtCodProd.getVlrInteger(), txtDescProd.getVlrString(),
					txtQtdade.getVlrBigDecimal(),
					new StringDireita(txtPreco.getVlrString()),
					txtAliqIcms.getVlrBigDecimal(),
					txtBaseCalc.getVlrBigDecimal(),
					txtValorIcms.getVlrBigDecimal(), "" });
			if (FreedomPDV.bECFTerm)
				bf.vendaItem(Aplicativo.strUsuario, txtCodProd.getVlrInteger()
						.intValue(), txtDescProd.getVlrString(), txtTipoFisc
						.getVlrString(),
						txtQtdade.getVlrDouble().doubleValue(), txtPreco
								.getVlrDouble().doubleValue(), 0,
						FreedomPDV.bModoDemo);

			atualizaTot();
			vCacheItem.clear();
			vCacheItem.add(txtCodProd.getVlrInteger());
			vCacheItem.add(txtQtdade.getVlrBigDecimal());
		} catch (SQLException err) {
			Funcoes.mensagemErro(null,
					"Erro ao inserir o �tem.\nInforme esta mensagem ao administrador: \n"
							+ err.getMessage(),true,con,err);
			err.printStackTrace();
		}
	}

	private int retPlanoPag() {
		int iRet = 0;
		String sSQL = "SELECT CodPlanoPag FROM SGPREFERE4 WHERE "
				+ "CODEMP=? AND CODFILIAL=?";
		try {
			PreparedStatement ps = con.prepareStatement(sSQL);
			ps.setInt(1, Aplicativo.iCodEmp);
			ps.setInt(2, Aplicativo.iCodFilial);
			ResultSet rs = ps.executeQuery();
			if (rs.next()) {
				iRet = rs.getInt("CodPlanoPag");
			}
			rs.close();
			ps.close();
		} catch (SQLException err) {
			Funcoes.mensagemErro(this, "Erro ao buscar o plano de pagamento.\n"
					+

					"Provavelmente n�o foram gravadas corretamente as prefer�ncias!\n"
					+ err.getMessage());
			err.printStackTrace();
		}
		return iRet;
	}

	private String retCodCli() {
		String iRet = "";
		String sSQL = "SELECT CodCli FROM SGPREFERE4 WHERE "
				+ "CODEMP=? AND CODFILIAL=?";
		try {
			PreparedStatement ps = con.prepareStatement(sSQL);
			ps.setInt(1, Aplicativo.iCodEmp);
			ps.setInt(2, Aplicativo.iCodFilial);
			ResultSet rs = ps.executeQuery();
			if (rs.next()) {
				iRet = rs.getString("CodCli");
			}
			rs.close();
			ps.close();
		} catch (SQLException err) {
			Funcoes.mensagemErro(this, "Erro ao buscar o c�digo do cliente.\n" +

			"Provavelmente n�o foram gravadas corretamente as prefer�ncias!\n"
					+ err.getMessage());
			err.printStackTrace();
		}
		return iRet;
	}
	public void windowGainedFocus(WindowEvent e) {
	    txtCodProd.requestFocus();
	}
	public void windowLostFocus(WindowEvent e)  { }

	private int retTipoMov() {
		int iRet = 0;
		String sSQL = "SELECT CODTIPOMOV FROM SGPREFERE4 WHERE "
				+ "CODEMP=? AND CODFILIAL=?";
		try {
			PreparedStatement ps = con.prepareStatement(sSQL);
			ps.setInt(1, Aplicativo.iCodEmp);
			ps.setInt(2, Aplicativo.iCodFilial);
			ResultSet rs = ps.executeQuery();
			if (rs.next()) {
				iRet = rs.getInt("CodTipoMov");
			}
			rs.close();
			ps.close();
		} catch (SQLException err) {
			Funcoes.mensagemErro(this, "Erro ao buscar o tipo de movimento.\n" +

			"Provavelmente n�o foram gravadas corretamente as prefer�ncias!\n"
					+ err.getMessage());
			err.printStackTrace();
		}
		return iRet;
	}

	private int retVendedor() {
		int iRet = 0;
		String sSQL = "SELECT CODVEND FROM ATATENDENTE WHERE "
				+ "IDUSU=? AND CODEMPUS=? AND CODFILIALUS=?";
		try {
			PreparedStatement ps = con.prepareStatement(sSQL);
			ps.setString(1, Aplicativo.strUsuario);
			ps.setInt(2, Aplicativo.iCodEmp);
			ps.setInt(3, Aplicativo.iCodFilialPad);
			ResultSet rs = ps.executeQuery();
			if (rs.next()) {
				iRet = rs.getInt("CodVend");
			}
			rs.close();
			ps.close();
		} catch (SQLException err) {
			Funcoes.mensagemErro(this, "Erro ao buscar o comissionado.\n"
					+ "O usu�rio '" + Aplicativo.strUsuario
					+ "' � um comissionado?\n" + err.getMessage());
			err.printStackTrace();
		}
		return iRet;
	}

	private void buscaPreco() {
		String sSQL = "SELECT PRECO FROM VDBUSCAPRECOSP(?,?,?,?,?,?,?,?,?,?,?,?)";
		PreparedStatement ps = null;
		ResultSet rs = null;
		try {
			ps = con.prepareStatement(sSQL);
			ps.setInt(1, txtCodProd.getVlrInteger().intValue());
			ps.setInt(2, txtCodCli.getVlrInteger().intValue());
			ps.setInt(3, Aplicativo.iCodEmp);
			ps.setInt(4, lcCliente.getCodFilial());
			ps.setInt(5, txtCodPlanoPag.getVlrInteger().intValue());
			ps.setInt(6, Aplicativo.iCodEmp);
			ps.setInt(7, lcPlanoPag.getCodFilial());
			ps.setInt(8, txtCodTipoMov.getVlrInteger().intValue());
			ps.setInt(9, Aplicativo.iCodEmp);
			ps.setInt(10, ListaCampos.getMasterFilial("EQTIPOMOV"));
			ps.setInt(11, Aplicativo.iCodEmp);
			ps.setInt(12, Aplicativo.iCodFilial);
			rs = ps.executeQuery();
			if (rs.next())
				;
			txtPreco
					.setVlrBigDecimal(rs.getString(1) != null ? (new BigDecimal(
							rs.getString(1)))
							: (new BigDecimal("0")));
			rs.close();
			ps.close();
			if (!con.getAutoCommit())
				con.commit();
		} catch (SQLException err) {
			Funcoes.mensagemErro(this, "Erro ao carregar o pre�o!\n"
					+ err.getMessage(),true,con,err);
		}
	}

	private void atualizaTot() {
		String sSQL = "SELECT VLRLIQVENDA,VLRBASEICMSVENDA,VLRICMSVENDA"
				+ " FROM VDVENDA WHERE "
				+ "CODVENDA=? AND CODEMP=? AND CODFILIAL=?";
		try {
			PreparedStatement ps = con.prepareStatement(sSQL);
			ps.setInt(1, txtCodVenda.getVlrInteger().intValue());
			ps.setInt(2, Aplicativo.iCodEmp);
			ps.setInt(3, lcVenda.getCodFilial());
			ResultSet rs = ps.executeQuery();
			if (rs.next()) {
				txtValorTotalCupom.setVlrBigDecimal(rs
						.getBigDecimal("VlrLiqVenda"));
				txtBaseCalc1.setVlrBigDecimal(rs
						.getBigDecimal("VlrBaseICMSVenda"));
				txtValorIcms1
						.setVlrBigDecimal(rs.getBigDecimal("VlrICMSVenda"));
				txtTotalCupom.setVlrBigDecimal(rs.getBigDecimal("VlrLiqVenda"));
			}
			rs.close();
			ps.close();
			if (!con.getAutoCommit())
				con.commit();
		} catch (SQLException err) {
			Funcoes.mensagemErro(null, "Erro ao atualizar o saldo!\n"
					+ "Talvez esta venda ainda n�o esteja salva!\n"
					+ err.getMessage(),true,con,err);
			err.printStackTrace();
		}
	}

	private void iniVenda() {
		lcVenda.insert(true);
		txtTipoVenda.setVlrString("E");
		txtCodCli.setVlrString(retCodCli());
		lcCliente.carregaDados();
		lcProduto.limpaCampos(true);
		txtCodPlanoPag.setVlrInteger(new Integer(retPlanoPag()));
		txtQtdadeItem.setVlrString("");
		txtValorTotalItem.setVlrString("");
		txtValorTotalCupom.setVlrString("");
		lcPlanoPag.carregaDados();
		txtCodTipoMov.setVlrInteger(new Integer(retTipoMov()));
		lcTipoMov.carregaDados();
		txtCodVend.setVlrInteger(new Integer(retVendedor()));
		txtDtEmitVenda.setVlrDate(new Date());
		txtDtSaidaVenda.setVlrDate(new Date());
		if (AplicativoPDV.bECFTerm) {
			txtNumeroCupom.setVlrInteger(new Integer(bf.numeroCupom(
					Aplicativo.strUsuario, AplicativoPDV.bModoDemo) + 1));
		}
		tbItem.limpa();
		mostraInfoImp();
		iniItem();
	}
	
	private void iniItem() {
		txtQtdade.setVlrBigDecimal(new BigDecimal(1));
		txtPreco.setVlrString("");
		txtCodProd.requestFocus();
	}

	public void setConexao(Connection con) {
		super.setConexao(con);
		lcCliente.setConexao(con);
		lcPlanoPag.setConexao(con);
		lcVenda.setConexao(con);
		lcProduto.setConexao(con);
		lcTipoMov.setConexao(con);
		lcSerie.setConexao(con);
		lcClFiscal.setConexao(con);
		txtCodTipoMov.setVlrInteger(new Integer(retTipoMov()));
		txtCodCli.setVlrInteger(new Integer(retTipoMov()));
		pnStatusBar.add(sbVenda, BorderLayout.CENTER);
		pnRodape.add(pnStatusBar, BorderLayout.CENTER);
		iniVenda();
		sbVenda.setUsuario(Aplicativo.strUsuario);
		sbVenda.setCodFilial(Aplicativo.iCodFilial);
		sbVenda.setRazFilial(Aplicativo.sRazFilial);
		sbVenda.setNumEst(Aplicativo.iNumEst);
		sbVenda.setDescEst(getDescEst());
	}
    private void mostraInfoImp() {
		if (AplicativoPDV.bECFTerm) {
			String sStatus = bf.leStatus(Aplicativo.strUsuario, AplicativoPDV.bModoDemo);
			if (!sStatus.equals("")) {
				sStatus = sStatus.replaceAll("\n","<BR>");
				sStatus = "<HTML><CENTER>"+sStatus+"</CENTER></HTML>";
			}
			lbAvisoImp.setText(sStatus);
		}
		else
			lbAvisoImp.setText("");
    }
	private boolean mostraTelaPass() {
		boolean bRet = false;
		JTextFieldPad txtUsu = new JTextFieldPad(JTextFieldPad.TP_STRING, 8, 0);
		txtUsu.setText(Aplicativo.strUsuario);
		JPasswordFieldPad txtPass = new JPasswordFieldPad(8);
		FFDialogo diag = new FFDialogo(this);
		diag.setTitulo("Permiss�o");
		diag.setAtribos(300, 140);
		diag.adic(new JLabelPad("Usu�rio: "), 7, 10, 100, 20);
		diag.adic(new JLabelPad("Senha: "), 7, 30, 100, 20);
		diag.adic(txtUsu, 110, 10, 150, 20);
		diag.adic(txtPass, 110, 30, 150, 20);
		diag.adic(new JLabelPad("Senha: "), 7, 30, 100, 20);
		do {
			try {
				diag.setVisible(true);
				if (diag.OK) {
					Properties props = new Properties();
					props.put("user", txtUsu.getVlrString());
					props.put("password", txtPass.getVlrString());
					if (txtUsu.getVlrString().trim().equals("")
							|| txtPass.getVlrString().trim().equals("")) {
						Funcoes.mensagemErro(this, "Campo em branco!");
						continue;
					}
					DriverManager.getConnection(Aplicativo.strBanco, props)
							.close();
					String sSQL = "SELECT ABREGAVETAUSU FROM SGUSUARIO WHERE "
							+ "IDUSU = ? AND CODEMP=? AND CODFILIAL=?";
					PreparedStatement ps = con.prepareStatement(sSQL);
					ps.setString(1, txtUsu.getVlrString());
					ps.setInt(2, Aplicativo.iCodEmp);
					ps.setInt(3, Aplicativo.iCodFilial);
					ResultSet rs = ps.executeQuery();
					if (rs.next()) {
						if ((rs.getString(1) != null ? rs.getString(1) : "")
								.equals("S")) {
							bRet = true;
						}
					}
					if (!bRet)
						Funcoes.mensagemErro(this,
								"A��o n�o permitida para este usu�rio.");
					rs.close();
					ps.close();
				}
			} catch (java.sql.SQLException e) {
				if (e.getErrorCode() == 335544472) {
					Funcoes.mensagemErro(this,
							"Nome do usu�rio ou senha inv�lidos ! ! !");
					continue;
				}
				Funcoes.mensagemErro(this,
						"N�o foi poss�vel estabelecer conex�o com o banco de dados.\n"
								+ e.getMessage());
			}
			break;
		} while (true);
		diag.dispose();
		return bRet;
	}

	private boolean cancItem(int iItem) {
		boolean bRet = false;
		String sSQL = "UPDATE VDITVENDA SET CANCITVENDA='S' WHERE CODEMP=?"
				+ " AND CODFILIAL=? AND CODVENDA=? AND TIPOVENDA='E' AND CODITVENDA=?";
		try {
			PreparedStatement ps = con.prepareStatement(sSQL);
			ps.setInt(1, Aplicativo.iCodEmp);
			ps.setInt(2, ListaCampos.getMasterFilial("VDVENDA"));
			ps.setInt(3, txtCodVenda.getVlrInteger().intValue());
			ps.setInt(4, iItem);
			ps.executeUpdate();
			if (!con.getAutoCommit()) {
				con.commit();
			}
			bRet = true;
		} catch (SQLException err) {
			Logger.gravaLogTxt("", Aplicativo.strUsuario, Logger.LGEB_BD,
					"Erro cancelar o item " + err.getMessage());
		}
		return bRet;
	}

	private void leituraX() {
		if (lcVenda.getStatus() == ListaCampos.LCS_SELECT) {
			Funcoes.mensagemInforma(this, "Ainda existe uma venda ativa!");
			return;
		}
		if (Funcoes.mensagemConfirma(null, "Confirma impress�o de leitura X?") == JOptionPane.YES_OPTION) {
			JBemaFI32 bf = (AplicativoPDV.bECFTerm ? new JBemaFI32() : null);
			bf.leituraX(Aplicativo.strUsuario, AplicativoPDV.bModoDemo);
		}
	}
    
	private void abreGaveta() {
		if (mostraTelaPass()) {
			JBemaFI32 bf = (AplicativoPDV.bECFTerm ? new JBemaFI32() : null);
			bf.abreGaveta(Aplicativo.strUsuario, AplicativoPDV.bModoDemo);
		}
	}

	private void repeteItem() {
		if (vCacheItem.size() == 2) {
			try {
				Robot robo = new Robot();
				txtCodProd.requestFocus();
				txtCodProd.setVlrInteger((Integer) vCacheItem.elementAt(0));
				robo.keyPress(KeyEvent.VK_ENTER);
				txtQtdade.requestFocus();
				txtQtdade
						.setVlrBigDecimal((BigDecimal) vCacheItem.elementAt(1));
				robo.keyPress(KeyEvent.VK_ENTER);
			} catch (AWTException err) {
			}
		}
	}

	private void trocaCli() {
		try {
			Robot robo = new Robot();
			txtCodCli.requestFocus();
			robo.keyPress(KeyEvent.VK_F2);
		} catch (AWTException err) {
		}
	}

	private void cancItem() {
		if (tbItem.getNumLinhas() < 1) {
			Funcoes.mensagemErro(this,
					"N�o existe nenhum item para ser cancelado!");
			return;
		}
		int iItem = ((Integer) tbItem.getValor(tbItem.getNumLinhas() - 1, 0))
				.intValue();
		if (Funcoes.mensagemConfirma(null,
				"Deseja realmente cancelar o item anterior?") == JOptionPane.YES_OPTION) {
			if (cancItem(iItem)) {
				if (AplicativoPDV.bECFTerm)
					if (bf.cancelaItemAnterior(Aplicativo.strUsuario,
							AplicativoPDV.bModoDemo))
						btOK.doClick();
			} else {
				Funcoes.mensagemErro(null, "N�o foi poss�vel cancelar o item.");
			}
		}
	}

	private void cancCupom() {
		if (lcVenda.getStatus() != ListaCampos.LCS_SELECT) {
			Funcoes.mensagemErro(this, "N�o existe nenhuma venda ativa!");
			return;
		}
		DLCancCupom canc = new DLCancCupom();
		canc.setVenda(txtCodVenda.getVlrInteger().intValue());
		canc.setConexao(con);
		canc.setVisible(true);
		if (canc.OK) {
			if (canc.isCancCupom())
				iniVenda();
			else {
				int iItemCanc = canc.getCancItem();
				marcaLinha(iItemCanc);
			}

		}
		canc.dispose();
	}

	private void marcaLinha(int iItem) {
		for (int i = 0; i < tbItem.getNumLinhas(); i++) {
			if (iItem == ((Integer) tbItem.getValor(i, 0)).intValue()) {
				tbItem.setRowBackGround(i, new Color(254, 213, 192));
				tbItem.updateUI();
				break;
			}
		}
	}

	private void fechaVenda() {
		if (lcVenda.getStatus() != ListaCampos.LCS_SELECT) {
			Funcoes.mensagemErro(this, "N�o existe nenhuma venda ativa!");
			return;
		} 
		DLFechaVenda fecha = new DLFechaVenda(txtTotalCupom.getVlrBigDecimal(),
				txtCodVenda.getVlrInteger().intValue(), txtNumeroCupom
						.getVlrInteger().intValue());
		fecha.setConexao(con);
		if (tef != null)
			fecha.setTef(tef);
		fecha.setVisible(true);
		if (fecha.OK) {
			iniVenda();
		}
		fecha.dispose();
	}

	private void fechaCaixa() {
		if (lcVenda.getStatus() == ListaCampos.LCS_SELECT) {
			Funcoes.mensagemInforma(this, "Ainda existe uma venda ativa!");
			return;
		}
		DLFechaDia fecha = new DLFechaDia();
		fecha.setConexao(con);
		fecha.setVisible(true);
		if (fecha.OK) {
			fecha.dispose();
			this.dispose();
		}
		fecha.dispose();
	}

	public void keyPressed(KeyEvent kevt) {
		switch (kevt.getKeyCode()) {
		case KeyEvent.VK_F3:
			btF3.doClick();
			break;
		case KeyEvent.VK_F4:
			btF4.doClick();
			break;
		case KeyEvent.VK_F5:
			btF5.doClick();
			break;
		case KeyEvent.VK_F6:
			btF6.doClick();
			break;
		case KeyEvent.VK_F7:
			btF7.doClick();
			break;
		case KeyEvent.VK_F8:
			btF8.doClick();
			break;
		case KeyEvent.VK_F9:
			btF9.doClick();
			break;
		case KeyEvent.VK_F10:
			btF10.doClick();
			break;
		}
		if (kevt.getKeyCode() == KeyEvent.VK_ENTER) {
			if (kevt.getSource() == txtQtdade) {
				if (txtCodProd.getVlrDouble().doubleValue() == 0)
					Funcoes.mensagemInforma(null, "Produto em branco.");
				else if (txtQtdade.getVlrDouble().doubleValue() == 0)
					Funcoes.mensagemInforma(null, "Quantidade em branco.");
				else {
					if (lcVenda.getStatus() == ListaCampos.LCS_INSERT) {
						if (lcVenda.post()) {
							insereItem();
							iniItem();
						}
					} else if (lcVenda.getStatus() == ListaCampos.LCS_SELECT) {
						insereItem();
						iniItem();
						lcVenda.carregaDados();
					}
				}
			}
		}
	}

	public void afterCarrega(CarregaEvent cevt) {
		if (cevt.getListaCampos() == lcProduto
				&& txtCodProd.getVlrInteger().intValue() > 0)
			buscaPreco();
	}

	public void beforeCarrega(CarregaEvent cevt) {
	}

	public void afterPost(PostEvent pevt) {
		if (pevt.getListaCampos() == lcVenda && pevt.ok) {
			if (AplicativoPDV.bECFTerm)
				bf.abreCupom("", Aplicativo.strUsuario, AplicativoPDV.bModoDemo);
			else
				return;
		}
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.freedom.acao.PostListener#beforePost(org.freedom.acao.PostEvent)
	 */
	public void actionPerformed(ActionEvent evt) {
		if (evt.getSource() == btF3)
			cancItem();
		else if (evt.getSource() == btCtrlF3)
			cancCupom();
		else if (evt.getSource() == btF4)
			fechaVenda();
		else if (evt.getSource() == btF5)
			leituraX();
		else if (evt.getSource() == btF6)
			abreGaveta();
		else if (evt.getSource() == btF7) {
			DlgCalc calc = new DlgCalc();
			Aplicativo.telaPrincipal.criatela("Calc", calc, con);
			calc.setTelaPrim(Aplicativo.telaPrincipal);			
		}
		else if (evt.getSource() == btF8)
			repeteItem();
		else if (evt.getSource() == btF9)
			trocaCli();
		else if (evt.getSource() == btF10)
			fechaCaixa();
	}
	//O bot�o sair execute este m�todo para sair:
	public void setVisible(boolean bVal) {
		if (!bVal) {
			if (bf.verificaCupomAberto(Aplicativo.strUsuario,AplicativoPDV.bModoDemo)) {
				Funcoes.mensagemInforma(null,"Cupom fiscal est� aberto!");
				return;	
			}
		}
		super.setVisible(bVal);
	}

	public void beforePost(PostEvent pevt) {
	}

	public String getDescEst() {
		String sSQL = "SELECT DESCEST FROM SGESTACAO WHERE CODEST="
				+ Aplicativo.iNumEst + " AND CODEMP=" + Aplicativo.iCodEmp
				+ " AND CODFILIAL=" + Aplicativo.iCodFilial;
		PreparedStatement ps = null;
		ResultSet rs = null;
		String sDesc = "";
		try {
			ps = con.prepareStatement(sSQL);
			rs = ps.executeQuery();
			if (!rs.next())
				sDesc = "ESTA��O DE TRABALHO N�O CADASTRADA";
			else
				sDesc = rs.getString("DescEst");
			if (!con.getAutoCommit())
				con.commit();
		} catch (SQLException err) {
			Funcoes.mensagemErro(null, err.getMessage());
			return "N�O FOI POSS�VEL REGISTRAR A ESTA��O DE TRABALHO! ! !";
		}
		return sDesc;
	}

}