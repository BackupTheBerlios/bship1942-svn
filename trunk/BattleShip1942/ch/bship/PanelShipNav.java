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
	
	private JButton navleftButton = null;
	private JButton navrightButton = null;
	private JButton navupButton = null;
	private JButton navdownButton = null;
	private JButton navbattleButton = null;
	
	private Engine _engine;
	
	/**
	 * constructor
	 */
	public PanelShipNav(Engine engine) {
		super();
		_engine = engine;
		initialize();
	}
	/**
	 * intitialize of guielements
	 */
	private  void initialize() {
		this.setLayout(new BorderLayout());
		this.setSize(300,200);
		this.add(getNavleftButton(), java.awt.BorderLayout.WEST);
		this.add(getNavrightButton(), java.awt.BorderLayout.EAST);
		this.add(getNavupButton(), java.awt.BorderLayout.NORTH);
		this.add(getNavdownButton(), java.awt.BorderLayout.SOUTH);
		this.add(getNavbattleButton(), java.awt.BorderLayout.CENTER);
	}
	
	/**
	 * following methods creates all the buttons for navigation and battle-nav-mode
	 */
	
	private JButton getNavleftButton() {
		if (navleftButton == null) {
			navleftButton = new JButton();
			navleftButton.setText("<");
			navleftButton.addActionListener(new java.awt.event.ActionListener() { 
				public void actionPerformed(java.awt.event.ActionEvent e) {    
					((BattleShip)_engine.getSelectedBoat()).moveLeft(1);
					_engine.reduceaction();
					_engine.repaintField();
					actualizebuttons();
				}
			});
		}
		return navleftButton;
	}
	
	private JButton getNavupButton() {
		if (navupButton == null) {
			navupButton = new JButton();
			navupButton.setText("^");
			navupButton.addActionListener(new java.awt.event.ActionListener() { 
				public void actionPerformed(java.awt.event.ActionEvent e) {    
					((BattleShip)_engine.getSelectedBoat()).moveUp(1);
					_engine.reduceaction();
					_engine.repaintField();
					actualizebuttons();
				}
			});
		}
		return navupButton;
	}
	
	private JButton getNavdownButton() {
		if (navdownButton == null) {
			navdownButton = new JButton();
			navdownButton.setText("v");
			navdownButton.addActionListener(new java.awt.event.ActionListener() { 
				public void actionPerformed(java.awt.event.ActionEvent e) {    
					((BattleShip)_engine.getSelectedBoat()).moveDown(1);
					_engine.reduceaction();
					_engine.repaintField();
					actualizebuttons();
				}
			});
		}
		return navdownButton;
	}
	
	private JButton getNavrightButton() {
		if (navrightButton == null) {
			navrightButton = new JButton();
			navrightButton.setText(">");
			navrightButton.addActionListener(new java.awt.event.ActionListener() { 
				public void actionPerformed(java.awt.event.ActionEvent e) {    
					((BattleShip)_engine.getSelectedBoat()).moveRight(1);
					_engine.reduceaction();
					_engine.repaintField();
					actualizebuttons();
				}
			});
		}
		return navrightButton;
	}
	
	private JButton getNavbattleButton() {
		if (navbattleButton == null) {
			navbattleButton = new JButton();
			navbattleButton.setText("Navigation Mode");
			navbattleButton.addActionListener(new java.awt.event.ActionListener() { 
				public void actionPerformed(java.awt.event.ActionEvent e) {    
					if (_engine.getNavmode()) {
						getNavbattleButton().setText("Battle Mode");
						_engine.setNavmode(false);
					}else{
						getNavbattleButton().setText("Navigation Mode");
						_engine.setNavmode(true);
					}
				}
			});
		}
		return navbattleButton;
	}
	
	/**
	 * actualize the buttons (enabled property)
	 */
	public void actualizebuttons() {
		// kein Schiff selektiert => alle buttons disablen
		boolean enabled;
		if (_engine.getSelectedBoat() == null || !_engine.isAtPlaying()) {
			enabled = false;
		}else{
			enabled = true;
		}
		getNavrightButton().setEnabled(enabled);
		getNavleftButton().setEnabled(enabled);
		getNavupButton().setEnabled(enabled);
		getNavdownButton().setEnabled(enabled);
		getNavbattleButton().setEnabled(enabled);
		
		if (_engine.getNavmode()) {
			getNavbattleButton().setText("Navigation Mode");
		} else {
			getNavbattleButton().setText("Battle Mode");
		}
	}
 }
