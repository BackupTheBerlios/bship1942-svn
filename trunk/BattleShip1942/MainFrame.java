import javax.swing.JFrame;
import javax.swing.JPanel;
import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;
/*
 * Created on 24.08.2004
 *
 * TODO To change the template for this generated file go to
 * Window - Preferences - Java - Code Style - Code Templates
 */

/**
 * @author metawave
 *
 * TODO To change the template for this generated type comment go to
 * Window - Preferences - Java - Code Style - Code Templates
 */
public class MainFrame extends JFrame {

	private javax.swing.JPanel jContentPane = null;

	private JPanel gameState = null;
	private JPanel gameField = null;
	private JPanel gameChat = null;
	private JPanel shipState = null;
	/**
	 * This is the default constructor
	 */
	public MainFrame() {
		super();
		initialize();
	}
	/**
	 * This method initializes this
	 * 
	 * @return void
	 */
	private void initialize() {
		this.setTitle("BattleShip 1942");
		this.setSize(558, 340);
		this.setContentPane(getJContentPane());
	}
	/**
	 * This method initializes jContentPane
	 * 
	 * @return javax.swing.JPanel
	 */
	private javax.swing.JPanel getJContentPane() {
		if(jContentPane == null) {
			java.awt.GridBagConstraints gridBagConstraintsShipState = new GridBagConstraints();
			java.awt.GridBagConstraints gridBagConstraintsGameField = new GridBagConstraints();
			java.awt.GridBagConstraints gridBagConstraintsGameChat = new GridBagConstraints();
			java.awt.GridBagConstraints gridBagConstraintsGameState = new GridBagConstraints();
			jContentPane = new javax.swing.JPanel();
			jContentPane.setLayout(new GridBagLayout());
			gridBagConstraintsGameState.gridx = 1;
			gridBagConstraintsGameState.gridy = 1;
			gridBagConstraintsGameState.weightx = 822;
			gridBagConstraintsGameState.weighty = 22;
			gridBagConstraintsGameField.gridx = 2;
			gridBagConstraintsGameField.gridy = 1;
			gridBagConstraintsGameField.weightx = 27;
			gridBagConstraintsGameField.weighty = 22;
			gridBagConstraintsGameChat.gridx = 1;
			gridBagConstraintsGameChat.gridy = 2;
			gridBagConstraintsGameChat.weightx = 8;
			gridBagConstraintsGameChat.weighty = 6;
			gridBagConstraintsShipState.gridx = 2;
			gridBagConstraintsShipState.gridy = 2;
			gridBagConstraintsShipState.weightx = 27;
			gridBagConstraintsShipState.weighty = 6;
			jContentPane.add(getGameState(), gridBagConstraintsGameState);
			jContentPane.add(getGameField(), gridBagConstraintsGameField);
			jContentPane.add(getGameChat(), gridBagConstraintsGameChat);
			jContentPane.add(getShipState(), gridBagConstraintsShipState);
			
		}
		return jContentPane;
	}
	/**
	 * This method initializes gameState	
	 * 	
	 * @return javax.swing.JPanel	
	 */    
	private JPanel getGameState() {
		if (gameState == null) {
			gameState = new JPanel();
		}
		return gameState;
	}
	/**
	 * This method initializes gameField	
	 * 	
	 * @return javax.swing.JPanel	
	 */    
	private JPanel getGameField() {
		if (gameField == null) {
			gameField = new JPanel();
		}
		return gameField;
	}
	/**
	 * This method initializes gameChat	
	 * 	
	 * @return javax.swing.JPanel	
	 */    
	private JPanel getGameChat() {
		if (gameChat == null) {
			gameChat = new JPanel();
		}
		return gameChat;
	}
	/**
	 * This method initializes shipState	
	 * 	
	 * @return javax.swing.JPanel	
	 */    
	private JPanel getShipState() {
		if (shipState == null) {
			shipState = new JPanel();
		}
		return shipState;
	}
    }  //  @jve:decl-index=0:visual-constraint="10,10"
