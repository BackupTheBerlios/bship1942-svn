package ch.bship;
import javax.swing.JFrame;
import javax.swing.JPanel;
import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;
import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import javax.swing.JCheckBoxMenuItem;
/**
 * @author Adrian Greiler, Marcel Ryser
 * 
 * PROJECT: Battleship 1942
 *
 * Changelog:
 * 
 * 24.08.2004	MR		Erstellung
 * 
 */

public class MainFrame extends JFrame {

	private javax.swing.JPanel jContentPane = null;

	private JPanel gameState = null;
	private JPanel gameField = null;
	private JPanel gameChat = null;
	private JPanel shipState = null;
	private JMenuBar jJMenuBar = null;
	private JMenu jMenu = null;
	private JMenu jMenu1 = null;
	private JMenu jMenu2 = null;
	private JMenuItem jMenuItem = null;
	
	GameLanguage translator = new GameLanguage();
	private JMenuItem jMenuItem1 = null;
	private JCheckBoxMenuItem jCheckBoxMenuItem = null;
	private JMenu jMenu3 = null;
	private JCheckBoxMenuItem jCheckBoxMenuItem1 = null;
	private JCheckBoxMenuItem jCheckBoxMenuItem2 = null;
	private JMenuItem jMenuItem2 = null;
	private JMenuItem jMenuItem3 = null;
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
		this.setJMenuBar(getJJMenuBar());
		this.setTitle("BattleShip 1942");
		this.setSize(655, 430);
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
			gameState = new PanelGameState();
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
			gameField = new Field();
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
			gameChat = new Chat();
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
			shipState = new PanelShipState();
		}
		return shipState;
	}
	/**
	 * This method initializes jJMenuBar	
	 * 	
	 * @return javax.swing.JMenuBar	
	 */    
	private JMenuBar getJJMenuBar() {
		if (jJMenuBar == null) {
			jJMenuBar = new JMenuBar();
			jJMenuBar.add(getJMenu());
			jJMenuBar.add(getJMenu1());
			jJMenuBar.add(getJMenu2());
		}
		return jJMenuBar;
	}
	/**
	 * This method initializes jMenu	
	 * 	
	 * @return javax.swing.JMenu	
	 */    
	private JMenu getJMenu() {
		if (jMenu == null) {
			jMenu = new JMenu();
			jMenu.setText("Datei");
			jMenu.add(getJMenuItem());
			jMenu.add(getJMenuItem1());
		}
		return jMenu;
	}
	/**
	 * This method initializes jMenu1	
	 * 	
	 * @return javax.swing.JMenu	
	 */    
	private JMenu getJMenu1() {
		if (jMenu1 == null) {
			jMenu1 = new JMenu();
			jMenu1.setText("Optionen");
			jMenu1.add(getJMenu3());
		}
		return jMenu1;
	}
	/**
	 * This method initializes jMenu2	
	 * 	
	 * @return javax.swing.JMenu	
	 */    
	private JMenu getJMenu2() {
		if (jMenu2 == null) {
			jMenu2 = new JMenu();
			jMenu2.setText("Hilfe");
			jMenu2.add(getJMenuItem2());
			jMenu2.add(getJMenuItem3());
		}
		return jMenu2;
	}
	/**
	 * This method initializes jMenuItem	
	 * 	
	 * @return javax.swing.JMenuItem	
	 */    
	private JMenuItem getJMenuItem() {
		if (jMenuItem == null) {
			jMenuItem = new JMenuItem();
			jMenuItem.setText("Neues Spiel");
			jMenuItem.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_N, java.awt.Event.CTRL_MASK, false));
		}
		return jMenuItem;
	}
	/**
	 * This method initializes jMenuItem1	
	 * 	
	 * @return javax.swing.JMenuItem	
	 */    
	private JMenuItem getJMenuItem1() {
		if (jMenuItem1 == null) {
			jMenuItem1 = new JMenuItem();
			jMenuItem1.setText("Beenden");
			jMenuItem1.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_Q, java.awt.Event.CTRL_MASK, false));
			jMenuItem1.addActionListener(new java.awt.event.ActionListener() { 
				public void actionPerformed(java.awt.event.ActionEvent e) {    
					System.exit(0);
				}
			});
		}
		return jMenuItem1;
	}
	/**
	 * This method initializes jCheckBoxMenuItem	
	 * 	
	 * @return javax.swing.JCheckBoxMenuItem	
	 */    
	private JCheckBoxMenuItem getJCheckBoxMenuItem() {
		if (jCheckBoxMenuItem == null) {
			jCheckBoxMenuItem = new JCheckBoxMenuItem();
			jCheckBoxMenuItem.setText("Deutsch");
		}
		return jCheckBoxMenuItem;
	}
	/**
	 * This method initializes jMenu3	
	 * 	
	 * @return javax.swing.JMenu	
	 */    
	private JMenu getJMenu3() {
		if (jMenu3 == null) {
			jMenu3 = new JMenu();
			jMenu3.setText("Applikationssprache");
			jMenu3.add(getJCheckBoxMenuItem());
			jMenu3.add(getJCheckBoxMenuItem1());
			jMenu3.add(getJCheckBoxMenuItem2());
		}
		return jMenu3;
	}
	/**
	 * This method initializes jCheckBoxMenuItem1	
	 * 	
	 * @return javax.swing.JCheckBoxMenuItem	
	 */    
	private JCheckBoxMenuItem getJCheckBoxMenuItem1() {
		if (jCheckBoxMenuItem1 == null) {
			jCheckBoxMenuItem1 = new JCheckBoxMenuItem();
			jCheckBoxMenuItem1.setText("English");
		}
		return jCheckBoxMenuItem1;
	}
	/**
	 * This method initializes jCheckBoxMenuItem2	
	 * 	
	 * @return javax.swing.JCheckBoxMenuItem	
	 */    
	private JCheckBoxMenuItem getJCheckBoxMenuItem2() {
		if (jCheckBoxMenuItem2 == null) {
			jCheckBoxMenuItem2 = new JCheckBoxMenuItem();
			jCheckBoxMenuItem2.setText("Französisch");
		}
		return jCheckBoxMenuItem2;
	}
	/**
	 * This method initializes jMenuItem2	
	 * 	
	 * @return javax.swing.JMenuItem	
	 */    
	private JMenuItem getJMenuItem2() {
		if (jMenuItem2 == null) {
			jMenuItem2 = new JMenuItem();
			jMenuItem2.setText("Anleitung");
			jMenuItem2.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_F1, 0, false));
		}
		return jMenuItem2;
	}
	/**
	 * This method initializes jMenuItem3	
	 * 	
	 * @return javax.swing.JMenuItem	
	 */    
	private JMenuItem getJMenuItem3() {
		if (jMenuItem3 == null) {
			jMenuItem3 = new JMenuItem();
			jMenuItem3.setText("Info");
		}
		return jMenuItem3;
	}
                 }  //  @jve:decl-index=0:visual-constraint="10,10"
