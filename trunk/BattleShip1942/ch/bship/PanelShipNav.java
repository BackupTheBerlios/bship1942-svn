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

import javax.swing.JButton;
import javax.swing.JPanel;

import java.awt.BorderLayout;

public class PanelShipNav extends JPanel {
	
	JButton navleftButton = null;
	JButton navrightButton = null;
	JButton navupButton = null;
	JButton navdownButton = null;
	
	private Engine _engine;
	private Field _field;
	private int nav = 1;
	
	private JButton jButton = null;
	/**
	 * This is the default constructor
	 */
	public PanelShipNav(Engine engine, Field field) {
		super();
		_engine = engine;
		_field = field;
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
		this.add(getJButton(), java.awt.BorderLayout.CENTER);
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
			navleftButton.addActionListener(new java.awt.event.ActionListener() { 
				public void actionPerformed(java.awt.event.ActionEvent e) {    
					((BattleShip)_engine.getSelectedBoat()).moveLeft(1);
					_field.zeichne();
				}
			});
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
			navupButton.addActionListener(new java.awt.event.ActionListener() { 
				public void actionPerformed(java.awt.event.ActionEvent e) {    
					((BattleShip)_engine.getSelectedBoat()).moveUp(1);
					_field.zeichne();
				}
			});
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
			navdownButton.addActionListener(new java.awt.event.ActionListener() { 
				public void actionPerformed(java.awt.event.ActionEvent e) {    
					((BattleShip)_engine.getSelectedBoat()).moveDown(1);
					_field.zeichne();
				}
			});
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
			navrightButton.addActionListener(new java.awt.event.ActionListener() { 
				public void actionPerformed(java.awt.event.ActionEvent e) {    
					((BattleShip)_engine.getSelectedBoat()).moveRight(1);
					_field.zeichne();
				}
			});
		}
		return navrightButton;
	}
	
	public void actualizebuttons() {
		// kein Schiff selektiert => alle buttons disablen
		boolean enabled;
		if (_engine.getSelectedBoat() == null) {
			enabled = false;
		}else{
			enabled = true;
		}
		getNavrightButton().setEnabled(enabled);
		getNavleftButton().setEnabled(enabled);
		getNavupButton().setEnabled(enabled);
		getNavdownButton().setEnabled(enabled);
		

	}
	/**
	 * This method initializes jButton	
	 * 	
	 * @return javax.swing.JButton	
	 */    
	private JButton getJButton() {
		if (jButton == null) {
			jButton = new JButton();
			jButton.setText("Nav / Battle");
			jButton.addActionListener(new java.awt.event.ActionListener() { 
				public void actionPerformed(java.awt.event.ActionEvent e) {    
					if (nav == 1) {
						getJButton().setText("Navigation Mode");
						nav = 2;
						_engine.setNavmode(true);
					}else{
						getJButton().setText("Battle Mode");
						_engine.setNavmode(false);
						nav = 1;
					}
				}
			});
		}
		return jButton;
	}
 }
