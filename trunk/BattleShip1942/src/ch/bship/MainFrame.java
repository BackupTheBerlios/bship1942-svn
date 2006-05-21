package ch.bship;

import java.awt.BorderLayout;
import java.awt.event.WindowAdapter;
import javax.swing.BoxLayout;
import javax.swing.JCheckBoxMenuItem;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
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

	
	private static final long serialVersionUID = 2500237607511627892L;

	private JPanel jContentPane = null;

	private PanelGameState gameState = null;
	private Field gameField = null;
	private Chat gameChat = null;
	private PanelShipState shipState = null;
	private Engine _engine;
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
		
	private JPanel shipNav = null;
	private JPanel northwest = null;
	
	/**
	 * constructor
	 */
	public MainFrame(Engine engine) {
		super();
		_engine = engine;
		initialize();
	}
	/**
	 * initialize gui components
	 */
	private void initialize() {
		this.initGuiComponents();
		this.setJMenuBar(getJJMenuBar());
		this.setTitle("BattleShip 1942");
		this.addWindowListener(new AppCloser());
		this.setSize(960, 730);
		this.setContentPane(getJContentPane());
	}
	
	/**
	 * application closer to terminate the application really
	 */
	protected static final class AppCloser extends WindowAdapter {
		public void windowClosing(java.awt.event.WindowEvent e) {
			System.exit(0);
		}
	}
	
	/**
	 * adding gui components to visualcomponent container
	 */
	@SuppressWarnings("unchecked")
	private void initGuiComponents() {
		_engine.getGuiElements().addElement(getJMenuFile());
		_engine.getGuiElements().addElement(getJMenuOptions());
		_engine.getGuiElements().addElement(getJMenuHelp());
		_engine.getGuiElements().addElement(getJMenuItemNewGame());
		_engine.getGuiElements().addElement(getJMenuItemQuit());
		_engine.getGuiElements().addElement(getJMenuLanguage());
		_engine.getGuiElements().addElement(getJCheckBoxGerman());
		_engine.getGuiElements().addElement(getJCheckBoxEnglish());
		_engine.getGuiElements().addElement(getJCheckBoxFrench());
		_engine.getGuiElements().addElement(getJMenuItemManual());
		_engine.getGuiElements().addElement(getJMenuItemInfo());
	}
	
	private javax.swing.JPanel getJContentPane() {
		if(jContentPane == null) {
			jContentPane = new JPanel();
			jContentPane.setLayout(new BorderLayout());
			
			JPanel west = new JPanel();
			west.setLayout(new BoxLayout(west, BoxLayout.X_AXIS));
			west.add(getGameChat());
			
			JPanel south = new JPanel();
			south.setLayout(new BoxLayout(south, BoxLayout.X_AXIS));
			south.add(getGameChat());
			south.add(getShipState());
			
			jContentPane.add(west, java.awt.BorderLayout.WEST);
			west.add(getNorthwest(), null);
			jContentPane.add(getGameField(), java.awt.BorderLayout.CENTER);
			jContentPane.add(south, java.awt.BorderLayout.SOUTH);
			south.add(getShipNavField(), null);
			
		}
		return jContentPane;
	}
	
	public JPanel getGameState() {
		if (gameState == null) {
			gameState = new PanelGameState(_engine);
		}
		return gameState;
	}
	
	public JPanel getGameField() {
		if (gameField == null) {
			gameField = new Field(_engine);
		}
		return gameField;
	}
	
	public JPanel getGameChat() {
		if (gameChat == null) {
			gameChat = new Chat(_engine);
		}
		return gameChat;
	}
	
	public JPanel getShipState() {
		if (shipState == null) {
			shipState = new PanelShipState(_engine);
		}
		return shipState;
	}
	
	public JPanel getShipNavField() {
		if (shipNav == null) {
			shipNav = new PanelShipNav(_engine);
		}
		return shipNav;
	}
	
	private JPanel getNorthwest() {
		if (northwest == null) {
			northwest = new JPanel();
			northwest.add(getGameState(), null);
		}
		return northwest;
	}
	
	public void paint(java.awt.Graphics g) {
		super.paint(g);
		_engine.repaintField();
	}
	
	/**
	 * following methods initializes the menu
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
	
	private JMenu getJMenuFile() {
		if (jMenuFile == null) {
			jMenuFile = new JMenu();
			jMenuFile.setText(_engine.getTranslator().tr("File"));
			jMenuFile.setName("File");
			jMenuFile.add(getJMenuItemNewGame());
			jMenuFile.add(getJMenuItemQuit());
		}
		return jMenuFile;
	}
	
	private JMenuItem getJMenuItemNewGame() {
		if (jMenuItemNewGame == null) {
			jMenuItemNewGame = new JMenuItem();
			jMenuItemNewGame.setText(_engine.getTranslator().tr("NewGame"));
			jMenuItemNewGame.setName("NewGame");
			jMenuItemNewGame.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_N, java.awt.Event.CTRL_MASK, false));
			jMenuItemNewGame.addActionListener(new java.awt.event.ActionListener() { 
				public void actionPerformed(java.awt.event.ActionEvent e) {    
					_engine.startNewGame();
				}
			});
		}
		return jMenuItemNewGame;
	}
	
	private JMenuItem getJMenuItemQuit() {
		if (jMenuItemQuit == null) {
			jMenuItemQuit = new JMenuItem();
			jMenuItemQuit.setText(_engine.getTranslator().tr("Quit"));
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
	
	private JMenu getJMenuOptions() {
		if (jMenuOptions == null) {
			jMenuOptions = new JMenu();
			jMenuOptions.setText(_engine.getTranslator().tr("Options"));
			jMenuOptions.setName("Options");
			jMenuOptions.add(getJMenuLanguage());
		}
		return jMenuOptions;
	}
	
	private JMenu getJMenuLanguage() {
		if (jMenuLanguage == null) {
			jMenuLanguage = new JMenu();
			jMenuLanguage.setText(_engine.getTranslator().tr("Applanguage"));
			jMenuLanguage.setName("Applanguage");
			jMenuLanguage.add(getJCheckBoxGerman());
			jMenuLanguage.add(getJCheckBoxEnglish());
			jMenuLanguage.add(getJCheckBoxFrench());
		}
		return jMenuLanguage;
	}
	
	private JCheckBoxMenuItem getJCheckBoxGerman() {
		if (jCheckBoxGerman == null) {
			jCheckBoxGerman = new JCheckBoxMenuItem();
			jCheckBoxGerman.setText(_engine.getTranslator().tr("German"));
			jCheckBoxGerman.setName("German");
			jCheckBoxGerman.addItemListener(new java.awt.event.ItemListener() { 
				public void itemStateChanged(java.awt.event.ItemEvent e) {
					getJCheckBoxEnglish().setSelected(false);
					getJCheckBoxFrench().setSelected(false);
				    _engine.updateLanguage("german");
				}
			});
		}
		return jCheckBoxGerman;
	}
	
	private JCheckBoxMenuItem getJCheckBoxEnglish() {
		if (jCheckBoxEnglish == null) {
			jCheckBoxEnglish = new JCheckBoxMenuItem();
			jCheckBoxEnglish.setText(_engine.getTranslator().tr("English"));
			jCheckBoxEnglish.setName("English");
			jCheckBoxEnglish.addItemListener(new java.awt.event.ItemListener() { 
				public void itemStateChanged(java.awt.event.ItemEvent e) {
					getJCheckBoxGerman().setSelected(false);
					getJCheckBoxFrench().setSelected(false);
				    _engine.updateLanguage("english");
				}
			});
		}
		return jCheckBoxEnglish;
	}
	
	private JCheckBoxMenuItem getJCheckBoxFrench() {
		if (jCheckBoxFrench == null) {
			jCheckBoxFrench = new JCheckBoxMenuItem();
			jCheckBoxFrench.setText(_engine.getTranslator().tr("French"));
			jCheckBoxFrench.setName("French");
			jCheckBoxFrench.addItemListener(new java.awt.event.ItemListener() { 
				public void itemStateChanged(java.awt.event.ItemEvent e) {
					getJCheckBoxGerman().setSelected(false);
					getJCheckBoxEnglish().setSelected(false);
					_engine.updateLanguage("french");
				}
			});
		}
		return jCheckBoxFrench;
	}
	
	private JMenu getJMenuHelp() {
		if (jMenuHelp == null) {
			jMenuHelp = new JMenu();
			jMenuHelp.setText(_engine.getTranslator().tr("Help"));
			jMenuHelp.setName("Help");
			jMenuHelp.add(getJMenuItemManual());
			jMenuHelp.add(getJMenuItemInfo());
		}
		return jMenuHelp;
	}
	
	private JMenuItem getJMenuItemManual() {
		if (jMenuItemManual == null) {
			jMenuItemManual = new JMenuItem();
			jMenuItemManual.setText(_engine.getTranslator().tr("Manual"));
			jMenuItemManual.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_F1, 0, false));
			jMenuItemManual.setName("Manual");
		}
		return jMenuItemManual;
	}
	
	private JMenuItem getJMenuItemInfo() {
		if (jMenuItemInfo == null) {
			jMenuItemInfo = new JMenuItem();
			jMenuItemInfo.setText(_engine.getTranslator().tr("Info"));
			jMenuItemInfo.setName("Info");
		}
		return jMenuItemInfo;
	}
}  //  @jve:decl-index=0:visual-constraint="10,10"
