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
import javax.imageio.ImageIO;
import javax.swing.JPanel;
import javax.swing.JProgressBar;
import javax.swing.JLabel;
import javax.swing.BoxLayout;
import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;
import java.io.IOException;

import javax.swing.ImageIcon;

public class PanelGameState extends JPanel {

	private static final long serialVersionUID = 2748071451941469718L;
	private JPanel panelPlayerName1 = null;
	private JPanel panelPlayer1State = null;
	private JPanel panelPlayerName2 = null;
	private JPanel panelPlayer2State = null;
	
	private JLabel lablePlayer1Name = null;
	
	private JLabel lablePlayer1Ship1 = null;
	private JLabel lablePlayer1Ship2 = null;
	private JLabel lablePlayer1Ship3 = null;
	private JLabel lablePlayer1Ship4 = null;
	
	private JProgressBar progressPlayer1Ship1 = null;
	private JProgressBar progressPlayer1Ship2 = null;
	private JProgressBar progressPlayer1Ship3 = null;
	private JProgressBar progressPlayer1Ship4 = null;
	
	private JLabel lablePlayer2Name = null;
	
	private JLabel lablePlayer2Ship1 = null;
	private JLabel lablePlayer2Ship2 = null;
	private JLabel lablePlayer2Ship3 = null;
	private JLabel lablePlayer2Ship4 = null;
	
	private JProgressBar progressPlayer2Ship1 = null;
	private JProgressBar progressPlayer2Ship2 = null;
	private JProgressBar progressPlayer2Ship3 = null;
	private JProgressBar progressPlayer2Ship4 = null;
	private Engine _engine;
	
	/**
	 * constructor
	 */
	public PanelGameState(Engine engine) {
		super();
		_engine = engine;
		initialize();
	}
	/**
	 * intitialize of guielements
	 */
	private  void initialize() {
		this.setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
		this.setSize(277, 187);
		this.add(getPanelPlayerName1(), null);
		this.add(getPanelPlayer1State(), null);
		this.add(getPanelPlayerName2(), null);
		this.add(getPanelPlayer2State(), null);
	}
	
	/**
	 * following 2 methods creates the player names
	 */
	private JPanel getPanelPlayerName1() {
		if (panelPlayerName1 == null) {
			lablePlayer1Name = new JLabel();
			panelPlayerName1 = new JPanel();
			panelPlayerName1.setLayout(new BoxLayout(panelPlayerName1, BoxLayout.X_AXIS));
			lablePlayer1Name.setText("Spieler 1");
			lablePlayer1Name.setHorizontalTextPosition(javax.swing.SwingConstants.LEADING);
			lablePlayer1Name.setHorizontalAlignment(javax.swing.SwingConstants.TRAILING);
			panelPlayerName1.add(lablePlayer1Name, null);
		}
		return panelPlayerName1;
	}
	
	private JPanel getPanelPlayerName2() {
		if (panelPlayerName2 == null) {
			lablePlayer2Name = new JLabel();
			panelPlayerName2 = new JPanel();
			panelPlayerName2.setLayout(new GridBagLayout());
			lablePlayer2Name.setText("Spieler 2");
			lablePlayer2Name.setHorizontalAlignment(javax.swing.SwingConstants.TRAILING);
			lablePlayer2Name.setHorizontalTextPosition(javax.swing.SwingConstants.LEADING);
			panelPlayerName2.add(lablePlayer2Name, new GridBagConstraints());
		}
		return panelPlayerName2;
	}
	
	/**
	 * following 2 methods creates the panel with the gamestate
	 */
	@SuppressWarnings("unchecked")
	private JPanel getPanelPlayer1State() {
		if (panelPlayer1State == null) {
			lablePlayer1Ship1 = new JLabel();
			lablePlayer1Ship2 = new JLabel();
			lablePlayer1Ship3 = new JLabel();
			lablePlayer1Ship4 = new JLabel();
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
			lablePlayer1Ship1.setText(_engine.getTranslator().tr("LandingCraft"));
			lablePlayer1Ship1.setName("LandingCraft");
			gridBagConstraints3.gridx = 1;
			gridBagConstraints3.gridy = 0;
			gridBagConstraints4.gridx = 0;
			gridBagConstraints4.gridy = 1;
			lablePlayer1Ship2.setText(_engine.getTranslator().tr("SpeedBoat"));
			lablePlayer1Ship2.setName("SpeedBoat");
			gridBagConstraints5.gridx = 1;
			gridBagConstraints5.gridy = 1;
			gridBagConstraints6.gridx = 0;
			gridBagConstraints6.gridy = 2;
			lablePlayer1Ship3.setText(_engine.getTranslator().tr("ArmoredBoat"));
			lablePlayer1Ship3.setName("ArmoredBoat");
			gridBagConstraints7.gridx = 1;
			gridBagConstraints7.gridy = 2;
			gridBagConstraints8.gridx = 0;
			gridBagConstraints8.gridy = 3;
			lablePlayer1Ship4.setText(_engine.getTranslator().tr("AirCraftCarrier"));
			lablePlayer1Ship4.setName("AirCraftCarrier");
			gridBagConstraints9.gridx = 1;
			gridBagConstraints9.gridy = 3;
			panelPlayer1State.setMinimumSize(new java.awt.Dimension(163,60));
			panelPlayer1State.add(lablePlayer1Ship1, gridBagConstraints2);
			panelPlayer1State.add(getProgressPlayer1Ship1(), gridBagConstraints3);
			panelPlayer1State.add(lablePlayer1Ship2, gridBagConstraints4);
			panelPlayer1State.add(getProgressPlayer1Ship2(), gridBagConstraints5);
			panelPlayer1State.add(lablePlayer1Ship3, gridBagConstraints6);
			panelPlayer1State.add(getProgressPlayer1Ship3(), gridBagConstraints7);
			panelPlayer1State.add(lablePlayer1Ship4, gridBagConstraints8);
			panelPlayer1State.add(getProgressPlayer1Ship4(), gridBagConstraints9);
			_engine.getGuiElements().addElement(lablePlayer1Ship1);
			_engine.getGuiElements().addElement(lablePlayer1Ship2);
			_engine.getGuiElements().addElement(lablePlayer1Ship3);
			_engine.getGuiElements().addElement(lablePlayer1Ship4);
		}
		return panelPlayer1State;
	}
	
	@SuppressWarnings("unchecked")
	private JPanel getPanelPlayer2State() {
		if (panelPlayer2State == null) {
			panelPlayer2State = new JPanel();
			lablePlayer2Ship1 = new JLabel();
			lablePlayer2Ship2 = new JLabel();
			lablePlayer2Ship3 = new JLabel();
			lablePlayer2Ship4 = new JLabel();
			java.awt.GridBagConstraints gridBagConstraints10 = new GridBagConstraints();
			java.awt.GridBagConstraints gridBagConstraints11 = new GridBagConstraints();
			java.awt.GridBagConstraints gridBagConstraints12 = new GridBagConstraints();
			java.awt.GridBagConstraints gridBagConstraints13 = new GridBagConstraints();
			java.awt.GridBagConstraints gridBagConstraints14 = new GridBagConstraints();
			java.awt.GridBagConstraints gridBagConstraints15 = new GridBagConstraints();
			java.awt.GridBagConstraints gridBagConstraints16 = new GridBagConstraints();
			java.awt.GridBagConstraints gridBagConstraints17 = new GridBagConstraints();
			panelPlayer2State.setLayout(new GridBagLayout());
			lablePlayer2Ship1.setText(_engine.getTranslator().tr("LandingCraft"));
			lablePlayer2Ship1.setName("LandingCraft");
			lablePlayer2Ship2.setText(_engine.getTranslator().tr("SpeedBoat"));
			lablePlayer2Ship2.setName("SpeedBoat");
			lablePlayer2Ship3.setText(_engine.getTranslator().tr("ArmoredBoat"));
			lablePlayer2Ship3.setName("ArmoredBoat");
			lablePlayer2Ship4.setText(_engine.getTranslator().tr("AirCraftCarrier"));
			lablePlayer2Ship4.setName("AirCraftCarrier");
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
			panelPlayer2State.add(lablePlayer2Ship1, gridBagConstraints10);
			panelPlayer2State.add(getProgressPlayer2Ship1(), gridBagConstraints11);
			panelPlayer2State.add(lablePlayer2Ship2, gridBagConstraints12);
			panelPlayer2State.add(getProgressPlayer2Ship2(), gridBagConstraints13);
			panelPlayer2State.add(lablePlayer2Ship3, gridBagConstraints14);
			panelPlayer2State.add(getProgressPlayer2Ship3(), gridBagConstraints15);
			panelPlayer2State.add(lablePlayer2Ship4, gridBagConstraints16);
			panelPlayer2State.add(getProgressPlayer2Ship4(), gridBagConstraints17);
			_engine.getGuiElements().addElement(lablePlayer2Ship1);
			_engine.getGuiElements().addElement(lablePlayer2Ship2);
			_engine.getGuiElements().addElement(lablePlayer2Ship3);
			_engine.getGuiElements().addElement(lablePlayer2Ship4);
		}
		return panelPlayer2State;
	}
	
	/**
	 * following methods creates all the progressbars
	 */
	
	private JProgressBar getProgressPlayer1Ship1() {
		if (progressPlayer1Ship1 == null) {
			progressPlayer1Ship1 = new JProgressBar();
			progressPlayer1Ship1.setStringPainted(true);
		}
		return progressPlayer1Ship1;
	}
	
	private JProgressBar getProgressPlayer1Ship2() {
		if (progressPlayer1Ship2 == null) {
			progressPlayer1Ship2 = new JProgressBar();
			progressPlayer1Ship2.setStringPainted(true);
		}
		return progressPlayer1Ship2;
	}
	
	private JProgressBar getProgressPlayer1Ship3() {
		if (progressPlayer1Ship3 == null) {
			progressPlayer1Ship3 = new JProgressBar();
			progressPlayer1Ship3.setStringPainted(true);
		}
		return progressPlayer1Ship3;
	}
	
	private JProgressBar getProgressPlayer1Ship4() {
		if (progressPlayer1Ship4 == null) {
			progressPlayer1Ship4 = new JProgressBar();
			progressPlayer1Ship4.setStringPainted(true);
		}
		return progressPlayer1Ship4;
	}
	
	private JProgressBar getProgressPlayer2Ship1() {
		if (progressPlayer2Ship1 == null) {
			progressPlayer2Ship1 = new JProgressBar();
			progressPlayer2Ship1.setStringPainted(true);
		}
		return progressPlayer2Ship1;
	}
	
	private JProgressBar getProgressPlayer2Ship2() {
		if (progressPlayer2Ship2 == null) {
			progressPlayer2Ship2 = new JProgressBar();
			progressPlayer2Ship2.setStringPainted(true);
		}
		return progressPlayer2Ship2;
	}
	
	private JProgressBar getProgressPlayer2Ship3() {
		if (progressPlayer2Ship3 == null) {
			progressPlayer2Ship3 = new JProgressBar();
			progressPlayer2Ship3.setStringPainted(true);
		}
		return progressPlayer2Ship3;
	}
	
	private JProgressBar getProgressPlayer2Ship4() {
		if (progressPlayer2Ship4 == null) {
			progressPlayer2Ship4 = new JProgressBar();
			progressPlayer2Ship4.setStringPainted(true);
		}
		return progressPlayer2Ship4;
	}
	
	/**
	 * setting the player names
	 */
	
	public void setPlayernames(String Player1Name, String Player2Name) {
	    lablePlayer1Name.setText(Player1Name);
	    lablePlayer2Name.setText(Player2Name);
	}
	
	/**
	 * updates all the informations
	 */
	public void updateShipStates() {
	    int shipperc[] = new int[8];
	    
	    for (int i = 0; i < _engine.getBattleShips().size(); i++){
	        BattleShip bs = (BattleShip) _engine.getBattleShips().elementAt(i);
	        shipperc[i] = bs.getShipStatePercent();
	    }
	    if (_engine.getMyPlayernumber() == 1) {
	    	setPlayernames(_engine.getMyNick(), _engine.getRivalsNick());
	    	try {
				lablePlayer1Name.setIcon(new ImageIcon(ImageIO.read(Utillib.getInputStreamFromJar("/nations/" + _engine.getMyNationality() + "/banner.jpg"))));
				lablePlayer2Name.setIcon(new ImageIcon(ImageIO.read(Utillib.getInputStreamFromJar("/nations/" + _engine.getRivalsNationality() + "/banner.jpg"))));
			} catch (IOException e) {
				Error.addError(e, "Nationalflag cannot be loaded");
			}
		    
	    }else{
	    	setPlayernames(_engine.getRivalsNick(),_engine.getMyNick());
	    	lablePlayer2Name.setIcon(new ImageIcon(getClass().getResource("/nations/" + _engine.getMyNationality() + "/banner.jpg")));
		    lablePlayer1Name.setIcon(new ImageIcon(getClass().getResource("/nations/" + _engine.getRivalsNationality() + "/banner.jpg")));
	    }
	    
	    progressPlayer1Ship1.setValue(shipperc[0]);
	    progressPlayer1Ship2.setValue(shipperc[1]);
	    progressPlayer1Ship3.setValue(shipperc[2]);
	    progressPlayer1Ship4.setValue(shipperc[3]);
	    progressPlayer2Ship1.setValue(shipperc[4]);
	    progressPlayer2Ship2.setValue(shipperc[5]);
	    progressPlayer2Ship3.setValue(shipperc[6]);
	    progressPlayer2Ship4.setValue(shipperc[7]);
	}
}  //  @jve:decl-index=0:visual-constraint="16,10"
