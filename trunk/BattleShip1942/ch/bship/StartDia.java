/**
 * @author Adrian Greiler, Marcel Ryser
 * 
 * PROJECT: Battleship 1942
 *
 * Changelog:
 * 
 * 27.08.2004	MR		Erstellung
 * 
 */
package ch.bship;

import javax.imageio.ImageIO;
import javax.swing.JFrame;

import javax.swing.JPanel;

import java.awt.Component;
import java.awt.Graphics;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.net.InetAddress;
import java.net.UnknownHostException;
import java.util.Vector;

import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JTextField;
import javax.swing.JComboBox;
import javax.swing.ListCellRenderer;

import javax.swing.BoxLayout;
import javax.swing.JButton;

import java.awt.BorderLayout;
public class StartDia extends JFrame implements ActionListener {

	private javax.swing.JPanel jContentPane = null;

	private JPanel optionsPanel = null;
	private JLabel nickFieldLabel = null;
	private JTextField nickField = null;
	private JLabel ipFieldLabel = null;
	private JTextField ipField = null;
	private JLabel nationComboLabel = null;
	private JComboBox nationCombo = null;
	private JLabel mapComboLabel = null;
	private JComboBox mapCombo = null;
	private JLabel langComboLabel = null;
	private JComboBox langCombo = null;
	private JPanel previewPanel = null;
	private JPanel buttonPanel = null;
	private JPanel seperatorPanel = null;
	private JPanel buttonsPanel = null;
	private JButton okButton = null;
	private JButton cancelButton = null;
	private JLabel previewLabel = null;
	private BufferedImage img = null;
	
	private final static String OK = "OK_CMD";
    private final static String CANCEL = "CANCEL_CMD";
    private final static String MAP_CHANGED = "MAP_CHANGED_CMD";
	private Net _net;
	private Engine _engine;
	private GameLanguage _lang = GameLanguage.getInstance();
	private Vector _flags;
	private JLabel jLabel = null;
	private JPanel subButtonPanel = null;
	private JPanel optionPanel = null;
	private JPanel jPanel1 = null;
	/**
	 * This is the default constructor
	 */
	public StartDia(Net net, Engine engine) {
		super();
		_lang = GameLanguage.getInstance();
        _net = net;
        _engine = engine;
		initialize();
	}
	/**
	 * This method initializes this
	 * 
	 * @return void
	 */
	private void initialize() {
		this.setSize(640, 280);
		this.setContentPane(getJContentPane());
		this.setTitle("BattleShip 1942");
		this.addWindowListener(new AppCloser());
        _flags = listDir("nations", "banner.jpg");
	}
	protected static final class AppCloser extends WindowAdapter {
		public void windowClosing(java.awt.event.WindowEvent e) {
			System.exit(0);
		}
	}
	/**
	 * This method initializes jContentPane
	 * 
	 * @return javax.swing.JPanel
	 */
	private javax.swing.JPanel getJContentPane() {
		if(jContentPane == null) {
			jContentPane = new javax.swing.JPanel();
			jContentPane.setLayout(new java.awt.BorderLayout());
			jContentPane.add(getOptionPanel(), java.awt.BorderLayout.WEST);
			jContentPane.add(getPreviewPanel(), java.awt.BorderLayout.CENTER);
			jContentPane.add(getButtonPanel(), java.awt.BorderLayout.SOUTH);
		}
		return jContentPane;
	}
	/**
	 * This method initializes optionsPanel	
	 * 	
	 * @return javax.swing.JPanel	
	 */    
	private JPanel getOptionsPanel() {
		if (optionsPanel == null) {
			nickFieldLabel = new JLabel();
			ipFieldLabel = new JLabel();
			nationComboLabel = new JLabel();
			mapComboLabel = new JLabel();
			langComboLabel = new JLabel();
			GridLayout gridLayout1 = new GridLayout();
			optionsPanel = new JPanel();
			optionsPanel.setLayout(gridLayout1);
			gridLayout1.setRows(5);
			gridLayout1.setColumns(2);
			nickFieldLabel.setText(_lang.tr("Nick"));
			nickFieldLabel.setName("Nick");
			ipFieldLabel.setText(_lang.tr("IP"));
			ipFieldLabel.setName("IP");
			nationComboLabel.setText(_lang.tr("Nation"));
			nationComboLabel.setName("Nation");
			mapComboLabel.setText(_lang.tr("Map"));
			mapComboLabel.setName("Map");
			langComboLabel.setText(_lang.tr("Language"));
			langComboLabel.setName("Language");
			Engine.guiElements.addElement(nickFieldLabel);
			Engine.guiElements.addElement(ipFieldLabel);
			Engine.guiElements.addElement(nationComboLabel);
			Engine.guiElements.addElement(mapComboLabel);
			Engine.guiElements.addElement(langComboLabel);
			optionsPanel.add(nickFieldLabel, null);
			optionsPanel.add(getNickField(), null);
			optionsPanel.add(ipFieldLabel, null);
			optionsPanel.add(getIpField(), null);
			optionsPanel.add(nationComboLabel, null);
			optionsPanel.add(getNationCombo(), null);
			optionsPanel.add(mapComboLabel, null);
			optionsPanel.add(getMapCombo(), null);
			optionsPanel.add(langComboLabel, null);
			optionsPanel.add(getLangCombo(), null);
		}
		return optionsPanel;
	}
	/**
	 * This method initializes nickField	
	 * 	
	 * @return javax.swing.JTextField	
	 */    
	private JTextField getNickField() {
		if (nickField == null) {
			nickField = new JTextField();
		}
		return nickField;
	}
	/**
	 * This method initializes ipField	
	 * 	
	 * @return javax.swing.JTextField	
	 */    
	private JTextField getIpField() {
		if (ipField == null) {
			ipField = new JTextField();
			try {
				ipField.setText((InetAddress.getLocalHost()).getHostAddress());
			} catch (UnknownHostException e) {
				Error.addError(e, "Konnte lokale IP-Adresse nicht finden");
			}
		}
		return ipField;
	}
	/**
	 * This method initializes nationCombo	
	 * 	
	 * @return javax.swing.JComboBox	
	 */    
	private JComboBox getNationCombo() {
		if (nationCombo == null) {
			nationCombo = new JComboBox(listDir("nations", ""));
			nationCombo.setRenderer(new NationsCBoxRenderer());
		}
		return nationCombo;
	}
	/**
	 * This method initializes mapCombo	
	 * 	
	 * @return javax.swing.JComboBox	
	 */    
	private JComboBox getMapCombo() {
		if (mapCombo == null) {
			mapCombo = new JComboBox(listDir("./maps", ""));
			mapCombo.addActionListener(this);
			mapCombo.setActionCommand(MAP_CHANGED);
		}
		return mapCombo;
	}
	/**
	 * This method initializes langCombo	
	 * 	
	 * @return javax.swing.JComboBox	
	 */    
	private JComboBox getLangCombo() {
		if (langCombo == null) {
			langCombo = new JComboBox(_lang.getLanguages());
			langCombo.addItemListener(new java.awt.event.ItemListener() { 
				public void itemStateChanged(java.awt.event.ItemEvent e) {    
					_lang.setLanguage(langCombo.getSelectedItem().toString());
					_engine.updateLanguage();
					drawPreviewPic();
				}
			});
		}
		return langCombo;
	}
	/**
	 * This method initializes previewPanel	
	 * 	
	 * @return javax.swing.JPanel	
	 */    
	private JPanel getPreviewPanel() {
		if (previewPanel == null) {
			previewPanel = new JPanel();
			previewPanel.add(getPreviewLabel());
		}
		return previewPanel;
	}
	
	private JLabel getPreviewLabel() {
		if (previewLabel == null) {
			previewLabel = new JLabel();
			previewLabel.setText("");
		}
		return previewLabel;
	}
	
	/**
	 * This method initializes buttonPanel	
	 * 	
	 * @return javax.swing.JPanel	
	 */    
	private JPanel getButtonPanel() {
		if (buttonPanel == null) {
			buttonPanel = new JPanel();
			buttonPanel.setLayout(new BoxLayout(buttonPanel, BoxLayout.X_AXIS));
			buttonPanel.add(getButtonsPanel(), null);
		}
		return buttonPanel;
	}
	/**
	 * This method initializes buttonsPanel	
	 * 	
	 * @return javax.swing.JPanel	
	 */    
	private JPanel getButtonsPanel() {
		if (buttonsPanel == null) {
			buttonsPanel = new JPanel();
			buttonsPanel.setLayout(new BorderLayout());
			buttonsPanel.add(getSubButtonPanel(), java.awt.BorderLayout.EAST);
		}
		return buttonsPanel;
	}
	/**
	 * This method initializes okButton	
	 * 	
	 * @return javax.swing.JButton	
	 */    
	private JButton getOkButton() {
		if (okButton == null) {
			okButton = new JButton();
			okButton.setText("Ok");
			okButton.addActionListener(this);
			okButton.setActionCommand(OK);
		}
		return okButton;
	}
	/**
	 * This method initializes cancelButton	
	 * 	
	 * @return javax.swing.JButton	
	 */    
	private JButton getCancelButton() {
		if (cancelButton == null) {
			cancelButton = new JButton();
			cancelButton.setText("Cancel");
			cancelButton.addActionListener(this);
			cancelButton.setActionCommand(CANCEL);
		}
		return cancelButton;
	}
	
	public void actionPerformed(ActionEvent e) {
        if ((e.getActionCommand()).equals(OK)) {
            _lang.setLanguage((getLangCombo().getSelectedItem()).toString());
            _net.setIP(getIpField().getText());
            _engine.setMyNick(getNickField().getText());
            _engine.setMyNationality((String)(getNationCombo().getSelectedItem()));
            _engine.setMap((String)(getMapCombo().getSelectedItem()));
            _engine.openMainFrame();
            String message = Net.MSG_HELLO + "|" + 
                getIpField().getText() + "|" +
                getNickField().getText() + "|" +
                ((String)(getNationCombo().getSelectedItem())) + "|" +
                ((String)(getMapCombo().getSelectedItem()));
            _net.send(message);
            setVisible(false);
        } else if ((e.getActionCommand()).equals(CANCEL)) {
            System.exit(0);
        } else if ((e.getActionCommand()).equals(MAP_CHANGED)) {
            // set new image to map... 
        	drawPreviewPic();
        }else{
        	repaint();
        	drawPreviewPic();
        	
        }
        
    }
	
	private BufferedImage getMapPreviewImage() {
		if (img == null) {
			File f = new File("maps" + File.separator + (getMapCombo().getSelectedItem().toString()) + File.separator + "map.jpg");
			if (f.exists()){
				try {
					img = ImageIO.read(f);
				} catch (IOException e) {
					e.printStackTrace();
				}
				img.getScaledInstance(300,214,java.awt.Image.SCALE_FAST);
			}else{ img = null; }
		}
		return img;
	}
	
	private Vector listDir(String dirName, String filename) {
        Vector list = new Vector();

        File file = new File(dirName);
        File[] dirs = file.listFiles();
        for (int i = 0; i < dirs.length; i++) {
            if (dirs[i].isDirectory() && !dirs[i].getName().equals("CVS")) {
                if (filename.equals("")) {
                    list.addElement(dirs[i].getName());
                } else {
                    list.addElement(dirs[i].getName() + 
                        File.separator + "banner.jpg");
                }
            }
        }
        return list;
    }
	class NationsCBoxRenderer extends JLabel implements ListCellRenderer {
        
        public NationsCBoxRenderer() {
            setOpaque(true);
        }
        public Component getListCellRendererComponent(
            JList list,
            Object value,
            int index,
            boolean isSelected,
            boolean cellHasFocus)
        {
            setIcon(new ImageIcon("nations" + File.separator + (String)value + File.separator + "banner.jpg"));
            setText((String)value);
            return this;
        }
    }
	/**
	 * This method initializes subButtonPanel	
	 * 	
	 * @return javax.swing.JPanel	
	 */    
	private JPanel getSubButtonPanel() {
		if (subButtonPanel == null) {
			subButtonPanel = new JPanel();
			subButtonPanel.add(getOkButton(), null);
			subButtonPanel.add(getCancelButton(), null);
		}
		return subButtonPanel;
	}

	/**
	 * This method initializes optionPanel	
	 * 	
	 * @return javax.swing.JPanel	
	 */    
	private JPanel getOptionPanel() {
		if (optionPanel == null) {
			optionPanel = new JPanel();
			optionPanel.add(getOptionsPanel(), null);
		}
		return optionPanel;
	}
	
	private void drawPreviewPic() {
		if (getMapPreviewImage() != null) {
			System.out.println("Draw image");
			getPreviewPanel().getGraphics().drawImage(getMapPreviewImage(),0,0,300,214,getPreviewPanel());
		}
	}
	
	public void paint(Graphics g) {
		super.paint(g);
		drawPreviewPic();
	}
   }  //  @jve:decl-index=0:visual-constraint="10,10"
