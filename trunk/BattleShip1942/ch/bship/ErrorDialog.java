package ch.bship;

import javax.swing.*;
import java.awt.BorderLayout;
import javax.swing.JPanel;
import javax.swing.JButton;
/**
 * @author metawave
 *
 * TODO To change the template for this generated type comment go to
 * Window - Preferences - Java - Code Style - Code Templates
 */
public class ErrorDialog extends JFrame {

	private javax.swing.JPanel jContentPane = null;

	private JPanel jPanel1 = null;
	private JLabel jLabel = null;
	private JLabel iconlabel = null;
	private JLabel shlabel = null;
	private JLabel jLabel1 = null;
	
	// Getting some Icons
	Icon infoIcon 	= UIManager.getIcon("OptionPane.informationIcon");
	Icon errIcon 	= UIManager.getIcon("OptionPane.errorIcon");
	Icon warnIcon 	= UIManager.getIcon("OptionPane.warningIcon");
	
	// .. and constants for the icons
	public static final int ERROR_MESSAGE 	= 1;
	public static final int INFO_MESSAGE		= 2;
	public static final int WARN_MESSAGE		= 3; 
	
	public int actmsg;
	
	private JScrollPane jScrollPane = null;
	private JTextArea jTextArea = null;
	private JPanel jPanel = null;
	private JButton jButton = null;
	/**
	 * This is the default constructor
	 */
	public ErrorDialog(String title, int icon, String shorttext, String longtext) {
		super();
		this.setTitle(title);
		
		Icon ic = null;
		// Iconchoose
		switch(icon) {
			case ERROR_MESSAGE: ic = errIcon;break;
			case INFO_MESSAGE: ic = infoIcon;break;
			case WARN_MESSAGE: ic = warnIcon;break;
		}
		getJIconLabel().setIcon(ic);
		getJShortLabel().setText(shorttext);
		getJTextArea().setText(longtext);
		actmsg = icon;
		// Init
		initialize();
	}
	/**
	 * This method initializes this
	 * 
	 * @return void
	 */
	private void initialize() {
		this.setSize(462, 318);
		this.setContentPane(getJContentPane());
		this.setTitle("Fehler");
		this.setAlwaysOnTop(true);
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
			jContentPane.add(getJPanel1(), java.awt.BorderLayout.NORTH);
			jContentPane.add(getJScrollPane(), java.awt.BorderLayout.CENTER);
			jContentPane.add(getJPanel(), java.awt.BorderLayout.SOUTH);
		}
		return jContentPane;
	}
	/**
	 * This method initializes jPanel1	
	 * 	
	 * @return javax.swing.JPanel	
	 */    
	private JPanel getJPanel1() {
		if (jPanel1 == null) {
			jPanel1 = new JPanel();
			jPanel1.add(getJIconLabel(), null);
			jPanel1.add(getJShortLabel(), null);
		}
		return jPanel1;
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
	/**
	 * This method initializes jScrollPane	
	 * 	
	 * @return javax.swing.JScrollPane	
	 */    
	private JScrollPane getJScrollPane() {
		if (jScrollPane == null) {
			jScrollPane = new JScrollPane();
			jScrollPane.setViewportView(getJTextArea());
		}
		return jScrollPane;
	}
	/**
	 * This method initializes jTextPane	
	 * 	
	 * @return javax.swing.JTextPane	
	 */    
	private JTextArea getJTextArea() {
		if (jTextArea == null) {
			jTextArea = new JTextArea();
			
		}
		return jTextArea;
	}
	/**
	 * This method initializes jPanel	
	 * 	
	 * @return javax.swing.JPanel	
	 */    
	private JPanel getJPanel() {
		if (jPanel == null) {
			jPanel = new JPanel();
			jPanel.add(getJButton(), null);
		}
		return jPanel;
	}
	/**
	 * This method initializes jButton	
	 * 	
	 * @return javax.swing.JButton	
	 */    
	private JButton getJButton() {
		if (jButton == null) {
			jButton = new JButton();
			jButton.setText("OK");
			jButton.addActionListener(new java.awt.event.ActionListener() { 
				public void actionPerformed(java.awt.event.ActionEvent e) {   
					// Action depends on InfoBox
					switch(actmsg) {
						case ERROR_MESSAGE: System.exit(0);break; // Terminate App
						default: setVisible(false);
					}
					
				}
			});
		}
		return jButton;
	}
  }  //  @jve:decl-index=0:visual-constraint="10,10"
