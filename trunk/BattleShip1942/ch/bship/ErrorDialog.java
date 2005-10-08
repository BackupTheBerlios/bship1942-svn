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
package ch.bship;

import java.awt.BorderLayout;
import javax.swing.Icon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JButton;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.UIManager;

public class ErrorDialog extends JFrame {

	private javax.swing.JPanel jContentPane = null;

	private JPanel headerInfopanel = null;
	private JLabel iconlabel = null;
	private JLabel shlabel = null;
	// Getting some Icons
	Icon infoIcon 	= UIManager.getIcon("OptionPane.informationIcon");
	Icon errIcon 	= UIManager.getIcon("OptionPane.errorIcon");
	Icon warnIcon 	= UIManager.getIcon("OptionPane.warningIcon");
	
	// .. and constants for the icons
	public static final int ERROR_MESSAGE 	= 1;
	public static final int INFO_MESSAGE		= 2;
	public static final int WARN_MESSAGE		= 3; 
	
	private int actmsg;
	
	private JScrollPane mainScrollPane = null;
	private JTextArea mainTextArea = null;
	private JPanel buttonPanel = null;
	private JButton okButton = null;
	/**
	 * This is the default constructor
	 */
	public ErrorDialog(String title, int icon, String shorttext, String longtext) {
		super();
		this.setTitle(title);
		
		// Iconchoose
		Icon ic = null;
		switch(icon) {
			case ERROR_MESSAGE: ic = errIcon;break;
			case INFO_MESSAGE: ic = infoIcon;break;
			case WARN_MESSAGE: ic = warnIcon;break;
		}
		getJIconLabel().setIcon(ic);
		getJShortLabel().setText(shorttext);
		getMainTextArea().setText(longtext);
		actmsg = icon;
		initialize(); // Init
	}
	/**
	 * This method initializes the guielements
	 */
	private void initialize() {
		this.setSize(462, 318);
		this.setContentPane(getJContentPane());
		this.setTitle("Fehler");
		this.setAlwaysOnTop(true);
	}
	
	private javax.swing.JPanel getJContentPane() {
		if(jContentPane == null) {
			jContentPane = new javax.swing.JPanel();
			jContentPane.setLayout(new BorderLayout());
			jContentPane.add(getHeaderInfopanel(), java.awt.BorderLayout.NORTH);
			jContentPane.add(getMainScrollPane(), java.awt.BorderLayout.CENTER);
			jContentPane.add(getButtonPanel(), java.awt.BorderLayout.SOUTH);
		}
		return jContentPane;
	}
	
	private JPanel getHeaderInfopanel() {
		if (headerInfopanel == null) {
			headerInfopanel = new JPanel();
			headerInfopanel.add(getJIconLabel(), null);
			headerInfopanel.add(getJShortLabel(), null);
		}
		return headerInfopanel;
	}
	
	private JLabel getJIconLabel() {
		if (iconlabel == null){
			iconlabel = new JLabel(UIManager.getIcon("OptionPane.informationIcon"));
			iconlabel.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
		}
		return iconlabel;
	}
	
	private JLabel getJShortLabel() {
		if (shlabel == null) {
			shlabel = new JLabel();
			shlabel.setText("");
		}
		return shlabel;
	}

	private JScrollPane getMainScrollPane() {
		if (mainScrollPane == null) {
			mainScrollPane = new JScrollPane();
			mainScrollPane.setViewportView(getMainTextArea());
		}
		return mainScrollPane;
	}

	private JTextArea getMainTextArea() {
		if (mainTextArea == null) {
			mainTextArea = new JTextArea();
		}
		return mainTextArea;
	}
 
	private JPanel getButtonPanel() {
		if (buttonPanel == null) {
			buttonPanel = new JPanel();
			buttonPanel.add(getOkButton(), null);
		}
		return buttonPanel;
	}
  
	private JButton getOkButton() {
		if (okButton == null) {
			okButton = new JButton();
			okButton.setText("OK");
			okButton.addActionListener(new java.awt.event.ActionListener() { 
				public void actionPerformed(java.awt.event.ActionEvent e) {   
					// Action depends on InfoBox
					switch(actmsg) {
						case ERROR_MESSAGE: System.exit(0);break; // Terminate App
						default: setVisible(false);
					}
					
				}
			});
		}
		return okButton;
	}
  }  //  @jve:decl-index=0:visual-constraint="10,10"
