/**
 * @author Adrian Greiler, Marcel Ryser
 * 
 * PROJECT: Battleship 1942
 *
 * Changelog:
 * 
 * 26.08.2004	MR		Erstellung
 * 
 */
package ch.bship;

import javax.swing.JPanel;
import java.awt.Toolkit;
import javax.swing.JProgressBar;
import javax.swing.JLabel;
import javax.swing.BoxLayout;
import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;
import javax.swing.ImageIcon;
/**
 * @author metawave
 *
 * TODO To change the template for this generated type comment go to
 * Window - Preferences - Java - Code Style - Code Templates
 */
public class PanelGameState extends JPanel {

	private JPanel panelPlayer1State = null;
	private JLabel jLabel = null;
	private JProgressBar jProgressBar = null;
	private JLabel jLabel1 = null;
	private JProgressBar jProgressBar1 = null;
	private JLabel jLabel2 = null;
	private JProgressBar jProgressBar2 = null;
	private JLabel jLabel3 = null;
	private JProgressBar jProgressBar3 = null;
	private JPanel panelPlayerName1 = null;
	private JPanel panelPlayerName2 = null;
	private JPanel panelPlayer2State = null;
	private JLabel jLabel4 = null;
	private JProgressBar jProgressBar4 = null;
	private JLabel jLabel5 = null;
	private JProgressBar jProgressBar5 = null;
	private JLabel jLabel6 = null;
	private JProgressBar jProgressBar6 = null;
	private JLabel jLabel7 = null;
	private JProgressBar jProgressBar7 = null;
	private JLabel jLabel8 = null;
	private JLabel jLabel9 = null;
	/**
	 * This is the default constructor
	 */
	public PanelGameState() {
		super();
		initialize();
	}
	/**
	 * This method initializes this
	 * 
	 * @return void
	 */
	private  void initialize() {
		this.setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
		this.setSize(300,200);
		this.add(getPanelPlayerName1(), null);
		this.add(getPanelPlayer1State(), null);
		this.add(getPanelPlayerName2(), null);
		this.add(getPanelPlayer2State(), null);
		Toolkit.getDefaultToolkit().getImage("bild.gif");
	}
	/**
	 * This method initializes panelPlayer1State	
	 * 	
	 * @return javax.swing.JPanel	
	 */    
	private JPanel getPanelPlayer1State() {
		if (panelPlayer1State == null) {
			jLabel3 = new JLabel();
			jLabel2 = new JLabel();
			jLabel1 = new JLabel();
			jLabel = new JLabel();
			java.awt.GridBagConstraints gridBagConstraints2 = new GridBagConstraints();
			java.awt.GridBagConstraints gridBagConstraints3 = new GridBagConstraints();
			java.awt.GridBagConstraints gridBagConstraints4 = new GridBagConstraints();
			java.awt.GridBagConstraints gridBagConstraints5 = new GridBagConstraints();
			java.awt.GridBagConstraints gridBagConstraints6 = new GridBagConstraints();
			java.awt.GridBagConstraints gridBagConstraints7 = new GridBagConstraints();
			java.awt.GridBagConstraints gridBagConstraints8 = new GridBagConstraints();
			java.awt.GridBagConstraints gridBagConstraints9 = new GridBagConstraints();
			panelPlayer1State = new JPanel();
			panelPlayer1State.setLayout(new GridBagLayout());
			gridBagConstraints2.gridx = 0;
			gridBagConstraints2.gridy = 0;
			jLabel.setText("Landungsboot");
			jLabel.setIcon(new ImageIcon(getClass().getResource("/pics/karte/urcool.gif")));
			gridBagConstraints3.gridx = 1;
			gridBagConstraints3.gridy = 0;
			gridBagConstraints4.gridx = 0;
			gridBagConstraints4.gridy = 1;
			jLabel1.setText("Speedboot");
			jLabel1.setIcon(new ImageIcon(getClass().getResource("/pics/karte/urcool.gif")));
			gridBagConstraints5.gridx = 1;
			gridBagConstraints5.gridy = 1;
			gridBagConstraints6.gridx = 0;
			gridBagConstraints6.gridy = 2;
			jLabel2.setText("Panzerboot");
			jLabel2.setIcon(new ImageIcon(getClass().getResource("/pics/karte/urcool.gif")));
			gridBagConstraints7.gridx = 1;
			gridBagConstraints7.gridy = 2;
			gridBagConstraints8.gridx = 0;
			gridBagConstraints8.gridy = 3;
			jLabel3.setText("Flugzeugträger");
			jLabel3.setIcon(new ImageIcon(getClass().getResource("/pics/karte/urcool.gif")));
			gridBagConstraints9.gridx = 1;
			gridBagConstraints9.gridy = 3;
			panelPlayer1State.add(jLabel, gridBagConstraints2);
			panelPlayer1State.add(getJProgressBar(), gridBagConstraints3);
			panelPlayer1State.add(jLabel1, gridBagConstraints4);
			panelPlayer1State.add(getJProgressBar1(), gridBagConstraints5);
			panelPlayer1State.add(jLabel2, gridBagConstraints6);
			panelPlayer1State.add(getJProgressBar2(), gridBagConstraints7);
			panelPlayer1State.add(jLabel3, gridBagConstraints8);
			panelPlayer1State.add(getJProgressBar3(), gridBagConstraints9);
		}
		return panelPlayer1State;
	}
	/**
	 * This method initializes jProgressBar	
	 * 	
	 * @return javax.swing.JProgressBar	
	 */    
	private JProgressBar getJProgressBar() {
		if (jProgressBar == null) {
			jProgressBar = new JProgressBar();
		}
		return jProgressBar;
	}
	/**
	 * This method initializes jProgressBar1	
	 * 	
	 * @return javax.swing.JProgressBar	
	 */    
	private JProgressBar getJProgressBar1() {
		if (jProgressBar1 == null) {
			jProgressBar1 = new JProgressBar();
		}
		return jProgressBar1;
	}
	/**
	 * This method initializes jProgressBar2	
	 * 	
	 * @return javax.swing.JProgressBar	
	 */    
	private JProgressBar getJProgressBar2() {
		if (jProgressBar2 == null) {
			jProgressBar2 = new JProgressBar();
		}
		return jProgressBar2;
	}
	/**
	 * This method initializes jProgressBar3	
	 * 	
	 * @return javax.swing.JProgressBar	
	 */    
	private JProgressBar getJProgressBar3() {
		if (jProgressBar3 == null) {
			jProgressBar3 = new JProgressBar();
		}
		return jProgressBar3;
	}
	/**
	 * This method initializes panelPlayerName1	
	 * 	
	 * @return javax.swing.JPanel	
	 */    
	private JPanel getPanelPlayerName1() {
		if (panelPlayerName1 == null) {
			jLabel8 = new JLabel();
			panelPlayerName1 = new JPanel();
			panelPlayerName1.setLayout(new BoxLayout(panelPlayerName1, BoxLayout.X_AXIS));
			jLabel8.setText("Spieler 1");
			jLabel8.setIcon(new ImageIcon(getClass().getResource("/pics/karte/urcool.gif")));
			jLabel8.setHorizontalTextPosition(javax.swing.SwingConstants.LEADING);
			jLabel8.setHorizontalAlignment(javax.swing.SwingConstants.TRAILING);
			panelPlayerName1.add(jLabel8, null);
		}
		return panelPlayerName1;
	}
	/**
	 * This method initializes panelPlayerName2	
	 * 	
	 * @return javax.swing.JPanel	
	 */    
	private JPanel getPanelPlayerName2() {
		if (panelPlayerName2 == null) {
			jLabel9 = new JLabel();
			panelPlayerName2 = new JPanel();
			panelPlayerName2.setLayout(new GridBagLayout());
			jLabel9.setText("Spieler 2");
			jLabel9.setIcon(new ImageIcon(getClass().getResource("/pics/karte/urcool.gif")));
			jLabel9.setHorizontalAlignment(javax.swing.SwingConstants.TRAILING);
			jLabel9.setHorizontalTextPosition(javax.swing.SwingConstants.LEADING);
			panelPlayerName2.add(jLabel9, new GridBagConstraints());
		}
		return panelPlayerName2;
	}
	/**
	 * This method initializes panelPlayer2State	
	 * 	
	 * @return javax.swing.JPanel	
	 */    
	private JPanel getPanelPlayer2State() {
		if (panelPlayer2State == null) {
			panelPlayer2State = new JPanel();
			jLabel4 = new JLabel();
			jLabel5 = new JLabel();
			jLabel6 = new JLabel();
			jLabel7 = new JLabel();
			java.awt.GridBagConstraints gridBagConstraints10 = new GridBagConstraints();
			java.awt.GridBagConstraints gridBagConstraints11 = new GridBagConstraints();
			java.awt.GridBagConstraints gridBagConstraints12 = new GridBagConstraints();
			java.awt.GridBagConstraints gridBagConstraints13 = new GridBagConstraints();
			java.awt.GridBagConstraints gridBagConstraints14 = new GridBagConstraints();
			java.awt.GridBagConstraints gridBagConstraints15 = new GridBagConstraints();
			java.awt.GridBagConstraints gridBagConstraints16 = new GridBagConstraints();
			java.awt.GridBagConstraints gridBagConstraints17 = new GridBagConstraints();
			panelPlayer2State.setLayout(new GridBagLayout());
			jLabel4.setText("Landungsboot");
			jLabel4.setIcon(new ImageIcon(getClass().getResource("/pics/karte/urcool.gif")));
			jLabel5.setText("Speedboot");
			jLabel5.setIcon(new ImageIcon(getClass().getResource("/pics/karte/urcool.gif")));
			jLabel6.setText("Panzerboot");
			jLabel6.setIcon(new ImageIcon(getClass().getResource("/pics/karte/urcool.gif")));
			jLabel7.setText("Flugzeugträger");
			jLabel7.setIcon(new ImageIcon(getClass().getResource("/pics/karte/urcool.gif")));
			gridBagConstraints10.gridx = 0;
			gridBagConstraints10.gridy = 0;
			gridBagConstraints11.gridx = 1;
			gridBagConstraints11.gridy = 0;
			gridBagConstraints12.gridx = 0;
			gridBagConstraints12.gridy = 1;
			gridBagConstraints13.gridx = 1;
			gridBagConstraints13.gridy = 1;
			gridBagConstraints14.gridx = 0;
			gridBagConstraints14.gridy = 2;
			gridBagConstraints15.gridx = 1;
			gridBagConstraints15.gridy = 2;
			gridBagConstraints16.gridx = 0;
			gridBagConstraints16.gridy = 3;
			gridBagConstraints17.gridx = 1;
			gridBagConstraints17.gridy = 3;
			panelPlayer2State.add(jLabel4, gridBagConstraints10);
			panelPlayer2State.add(getJProgressBar4(), gridBagConstraints11);
			panelPlayer2State.add(jLabel5, gridBagConstraints12);
			panelPlayer2State.add(getJProgressBar5(), gridBagConstraints13);
			panelPlayer2State.add(jLabel6, gridBagConstraints14);
			panelPlayer2State.add(getJProgressBar6(), gridBagConstraints15);
			panelPlayer2State.add(jLabel7, gridBagConstraints16);
			panelPlayer2State.add(getJProgressBar7(), gridBagConstraints17);
		}
		return panelPlayer2State;
	}
	/**
	 * This method initializes jProgressBar4	
	 * 	
	 * @return javax.swing.JProgressBar	
	 */    
	private JProgressBar getJProgressBar4() {
		if (jProgressBar4 == null) {
			jProgressBar4 = new JProgressBar();
		}
		return jProgressBar4;
	}
	/**
	 * This method initializes jProgressBar5	
	 * 	
	 * @return javax.swing.JProgressBar	
	 */    
	private JProgressBar getJProgressBar5() {
		if (jProgressBar5 == null) {
			jProgressBar5 = new JProgressBar();
		}
		return jProgressBar5;
	}
	/**
	 * This method initializes jProgressBar6	
	 * 	
	 * @return javax.swing.JProgressBar	
	 */    
	private JProgressBar getJProgressBar6() {
		if (jProgressBar6 == null) {
			jProgressBar6 = new JProgressBar();
		}
		return jProgressBar6;
	}
	/**
	 * This method initializes jProgressBar7	
	 * 	
	 * @return javax.swing.JProgressBar	
	 */    
	private JProgressBar getJProgressBar7() {
		if (jProgressBar7 == null) {
			jProgressBar7 = new JProgressBar();
		}
		return jProgressBar7;
	}
             }
