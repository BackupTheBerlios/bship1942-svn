/*
 * Insert Comment
 *
 * Changelog:
 * 01.12.2004		MR		Creation
 */
package ch.bship;

import javax.swing.JButton;
import javax.swing.JPanel;

import java.awt.BorderLayout;
/**
 * @author metawave
 *
 * TODO To change the template for this generated type comment go to
 * Window - Preferences - Java - Code Style - Code Templates
 */
public class PanelShipNav extends JPanel {
	
	JButton navleftButton = null;
	JButton navrightButton = null;
	JButton navupButton = null;
	JButton navdownButton = null;
	
	
	/**
	 * This is the default constructor
	 */
	public PanelShipNav() {
		super();
		initialize();
	}
	/**
	 * This method initializes this
	 * 
	 * @return void
	 */
	private  void initialize() {
		this.setLayout(new BorderLayout());
		this.setSize(300,200);
		this.add(getNavleftButton(), java.awt.BorderLayout.WEST);
		this.add(getNavrightButton(), java.awt.BorderLayout.EAST);
		this.add(getNavupButton(), java.awt.BorderLayout.NORTH);
		this.add(getNavdownButton(), java.awt.BorderLayout.SOUTH);
	}
	
	/**
	 * This method initializes navleftButton	
	 * 	
	 * @return javax.swing.JButton	
	 */    
	private JButton getNavleftButton() {
		if (navleftButton == null) {
			navleftButton = new JButton();
			navleftButton.setText("<");
		}
		return navleftButton;
	}
	/**
	 * This method initializes navupButton	
	 * 	
	 * @return javax.swing.JButton	
	 */    
	private JButton getNavupButton() {
		if (navupButton == null) {
			navupButton = new JButton();
			navupButton.setText("^");
		}
		return navupButton;
	}
	/**
	 * This method initializes navdownButton	
	 * 	
	 * @return javax.swing.JButton	
	 */    
	private JButton getNavdownButton() {
		if (navdownButton == null) {
			navdownButton = new JButton();
			navdownButton.setText("v");
		}
		return navdownButton;
	}
	/**
	 * This method initializes navrightButton	
	 * 	
	 * @return javax.swing.JButton	
	 */    
	private JButton getNavrightButton() {
		if (navrightButton == null) {
			navrightButton = new JButton();
			navrightButton.setText(">");
		}
		return navrightButton;
	}
}
