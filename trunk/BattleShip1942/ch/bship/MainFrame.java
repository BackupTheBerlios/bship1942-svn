package ch.bship;
import javax.swing.*;
import java.awt.BorderLayout;
import javax.swing.JMenuItem;
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
	GameLanguage translator = new GameLanguage();

	private JPanel gameState = null;
	private JPanel gameField = null;
	private JPanel gameChat = null;
	private JPanel shipState = null;
	private JMenuBar jJMenuBar = null;
	private JMenu jMenuFile = null;
	private JMenuItem jMenuItemNewGame = null;
	private JMenuItem jMenuItemQuit = null;
	private JMenu jMenuOptions = null;
	private JMenu jMenuLanguage = null;
	private JCheckBoxMenuItem jCheckBoxGerman = null;
	private JCheckBoxMenuItem jCheckBoxEnglish = null;
	private JCheckBoxMenuItem jCheckBoxFrench = null;
	private JMenu jMenuHelp = null;
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
		this.initGuiComponents();
		this.setJMenuBar(getJJMenuBar());
		this.setTitle("BattleShip 1942");
		this.setSize(958, 641);
		this.setContentPane(getJContentPane());
	}
	/**
	 * 
	 */
	private void initGuiComponents() {
		Engine.guiElements.addElement(getJMenuFile());
		Engine.guiElements.addElement(getJMenuOptions());
		Engine.guiElements.addElement(getJMenuHelp());
		Engine.guiElements.addElement(getJMenuItemNewGame());
		Engine.guiElements.addElement(getJMenuItemQuit());
		Engine.guiElements.addElement(getJMenuLanguage());
		Engine.guiElements.addElement(getJCheckBoxGerman());
		Engine.guiElements.addElement(getJCheckBoxEnglish());
		Engine.guiElements.addElement(getJCheckBoxFrench());
		Engine.guiElements.addElement(getJMenuItemManual());
		Engine.guiElements.addElement(getJMenuItemInfo());
	}
	/**
	 * This method initializes jContentPane
	 * 
	 * @return javax.swing.JPanel
	 */
	private javax.swing.JPanel getJContentPane() {
		if(jContentPane == null) {
			jContentPane = new javax.swing.JPanel();
			jContentPane.setLayout(new BorderLayout());
			
			JPanel west = new JPanel();
			west.setLayout(new BoxLayout(west, BoxLayout.X_AXIS));
			west.add(getGameState());
			west.add(getGameChat());
			
			JPanel south = new JPanel();
			south.setLayout(new BoxLayout(south, BoxLayout.X_AXIS));
			south.add(getGameChat());
			south.add(getShipState());
			
			jContentPane.add(west, java.awt.BorderLayout.WEST);
			jContentPane.add(getGameField(), java.awt.BorderLayout.CENTER);
			jContentPane.add(south, java.awt.BorderLayout.SOUTH);
			
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
			jMenuFile.setName("File");
			jMenuFile.add(getJMenuItemNewGame());
			jMenuFile.add(getJMenuItemQuit());
		}
		return jMenuFile;
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
			jMenuItemNewGame.setName("NewGame");
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
			jMenuItemQuit.setName("Quit");
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
	 * This method initializes jMenuOptions	
	 * 	
	 * @return javax.swing.JMenu	
	 */    
	private JMenu getJMenuOptions() {
		if (jMenuOptions == null) {
			jMenuOptions = new JMenu();
			jMenuOptions.setText(translator.tr("Options"));
			jMenuOptions.setName("Options");
			jMenuOptions.add(getJMenuLanguage());
		}
		return jMenuOptions;
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
			jMenuLanguage.setName("Applanguage");
			jMenuLanguage.add(getJCheckBoxGerman());
			jMenuLanguage.add(getJCheckBoxEnglish());
			jMenuLanguage.add(getJCheckBoxFrench());
		}
		return jMenuLanguage;
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
			jCheckBoxGerman.setSelected(true);
			jCheckBoxGerman.setName("German");
			jCheckBoxGerman.addItemListener(new java.awt.event.ItemListener() { 
				public void itemStateChanged(java.awt.event.ItemEvent e) {
					getJCheckBoxEnglish().setSelected(false);
					getJCheckBoxFrench().setSelected(false);
				    Engine.language = "german.lng";
				    Engine.updateLanguage();
				}
			});
		}
		return jCheckBoxGerman;
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
			jCheckBoxEnglish.setName("English");
			jCheckBoxEnglish.addItemListener(new java.awt.event.ItemListener() { 
				public void itemStateChanged(java.awt.event.ItemEvent e) {
					getJCheckBoxGerman().setSelected(false);
					getJCheckBoxFrench().setSelected(false);
				    Engine.language = "english.lng";
				    Engine.updateLanguage();
				}
			});
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
			jCheckBoxFrench.setName("French");
			jCheckBoxFrench.addItemListener(new java.awt.event.ItemListener() { 
				public void itemStateChanged(java.awt.event.ItemEvent e) {
					getJCheckBoxEnglish().setSelected(false);
					getJCheckBoxFrench().setSelected(false);
				    Engine.language = "french.lng";
				    Engine.updateLanguage();
				}
			});
		}
		return jCheckBoxFrench;
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
			jMenuHelp.setName("Help");
			jMenuHelp.add(getJMenuItemManual());
			jMenuHelp.add(getJMenuItemInfo());
		}
		return jMenuHelp;
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
			jMenuItemManual.setName("Manual");
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
			jMenuItemInfo.setName("Info");
		}
		return jMenuItemInfo;
	}
}  //  @jve:decl-index=0:visual-constraint="10,10"
