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
	private JMenu jMenuFile = null;
	private JMenu jMenuOptions = null;
	private JMenu jMenuHelp = null;
	private JMenuItem jMenuItemNewGame = null;
	
	GameLanguage translator = new GameLanguage();
	private JMenuItem jMenuItemQuit = null;
	private JCheckBoxMenuItem jCheckBoxGerman = null;
	private JMenu jMenuLanguage = null;
	private JCheckBoxMenuItem jCheckBoxEnglish = null;
	private JCheckBoxMenuItem jCheckBoxFrench = null;
	private JMenuItem jMenuItemManual = null;
	private JMenuItem jMenuItemInfo = null;
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
			jJMenuBar.add(getJMenuFile());
			jJMenuBar.add(getJMenuOptions());
			jJMenuBar.add(getJMenuHelp());
		}
		return jJMenuBar;
	}
	/**
	 * This method initializes jMenuFile	
	 * 	
	 * @return javax.swing.JMenu	
	 */    
	private JMenu getJMenuFile() {
		if (jMenuFile == null) {
			jMenuFile = new JMenu();
			jMenuFile.setText(translator.tr("File"));
			jMenuFile.add(getJMenuItemNewGame());
			jMenuFile.add(getJMenuItemQuit());
		}
		return jMenuFile;
	}
	/**
	 * This method initializes jMenuOptions	
	 * 	
	 * @return javax.swing.JMenu	
	 */    
	private JMenu getJMenuOptions() {
		if (jMenuOptions == null) {
			jMenuOptions = new JMenu();
			jMenuOptions.setText(translator.tr("Options"));
			jMenuOptions.add(getJMenuLanguage());
		}
		return jMenuOptions;
	}
	/**
	 * This method initializes jMenuHelp	
	 * 	
	 * @return javax.swing.JMenu	
	 */    
	private JMenu getJMenuHelp() {
		if (jMenuHelp == null) {
			jMenuHelp = new JMenu();
			jMenuHelp.setText(translator.tr("Help"));
			jMenuHelp.add(getJMenuItemManual());
			jMenuHelp.add(getJMenuItemInfo());
		}
		return jMenuHelp;
	}
	/**
	 * This method initializes jMenuItemNewGame	
	 * 	
	 * @return javax.swing.JMenuItem	
	 */    
	private JMenuItem getJMenuItemNewGame() {
		if (jMenuItemNewGame == null) {
			jMenuItemNewGame = new JMenuItem();
			jMenuItemNewGame.setText(translator.tr("NewGame"));
			jMenuItemNewGame.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_N, java.awt.Event.CTRL_MASK, false));
		}
		return jMenuItemNewGame;
	}
	/**
	 * This method initializes jMenuItemQuit	
	 * 	
	 * @return javax.swing.JMenuItem	
	 */    
	private JMenuItem getJMenuItemQuit() {
		if (jMenuItemQuit == null) {
			jMenuItemQuit = new JMenuItem();
			jMenuItemQuit.setText(translator.tr("Quit"));
			jMenuItemQuit.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_Q, java.awt.Event.CTRL_MASK, false));
			jMenuItemQuit.addActionListener(new java.awt.event.ActionListener() { 
				public void actionPerformed(java.awt.event.ActionEvent e) {    
					System.exit(0);
				}
			});
		}
		return jMenuItemQuit;
	}
	/**
	 * This method initializes jCheckBoxGerman	
	 * 	
	 * @return javax.swing.JCheckBoxMenuItem	
	 */    
	private JCheckBoxMenuItem getJCheckBoxGerman() {
		if (jCheckBoxGerman == null) {
			jCheckBoxGerman = new JCheckBoxMenuItem();
			jCheckBoxGerman.setText(translator.tr("German"));
			jCheckBoxGerman.addChangeListener(new javax.swing.event.ChangeListener() { 
				public void stateChanged(javax.swing.event.ChangeEvent e) {    
					// Bei einem anchecken m�ssen die anderen Sprachen abgew�hlt werden
				    
				}
			});
		}
		return jCheckBoxGerman;
	}
	/**
	 * This method initializes jMenuLanguage	
	 * 	
	 * @return javax.swing.JMenu	
	 */    
	private JMenu getJMenuLanguage() {
		if (jMenuLanguage == null) {
			jMenuLanguage = new JMenu();
			jMenuLanguage.setText(translator.tr("Applanguage"));
			jMenuLanguage.add(getJCheckBoxGerman());
			jMenuLanguage.add(getJCheckBoxEnglish());
			jMenuLanguage.add(getJCheckBoxFrench());
		}
		return jMenuLanguage;
	}
	/**
	 * This method initializes jCheckBoxEnglish	
	 * 	
	 * @return javax.swing.JCheckBoxMenuItem	
	 */    
	private JCheckBoxMenuItem getJCheckBoxEnglish() {
		if (jCheckBoxEnglish == null) {
			jCheckBoxEnglish = new JCheckBoxMenuItem();
			jCheckBoxEnglish.setText(translator.tr("English"));
		}
		return jCheckBoxEnglish;
	}
	/**
	 * This method initializes jCheckBoxFrench	
	 * 	
	 * @return javax.swing.JCheckBoxMenuItem	
	 */    
	private JCheckBoxMenuItem getJCheckBoxFrench() {
		if (jCheckBoxFrench == null) {
			jCheckBoxFrench = new JCheckBoxMenuItem();
			jCheckBoxFrench.setText(translator.tr("French"));
		}
		return jCheckBoxFrench;
	}
	/**
	 * This method initializes jMenuItemManual	
	 * 	
	 * @return javax.swing.JMenuItem	
	 */    
	private JMenuItem getJMenuItemManual() {
		if (jMenuItemManual == null) {
			jMenuItemManual = new JMenuItem();
			jMenuItemManual.setText(translator.tr("Manual"));
			jMenuItemManual.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_F1, 0, false));
		}
		return jMenuItemManual;
	}
	/**
	 * This method initializes jMenuItemInfo	
	 * 	
	 * @return javax.swing.JMenuItem	
	 */    
	private JMenuItem getJMenuItemInfo() {
		if (jMenuItemInfo == null) {
			jMenuItemInfo = new JMenuItem();
			jMenuItemInfo.setText(translator.tr("Info"));
		}
		return jMenuItemInfo;
	}
                 }  //  @jve:decl-index=0:visual-constraint="10,10"
