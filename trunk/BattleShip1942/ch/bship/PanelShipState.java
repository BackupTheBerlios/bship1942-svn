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

import javax.swing.ImageIcon;
import javax.swing.JPanel;
import java.awt.BorderLayout;
import javax.swing.JLabel;
import java.awt.GridLayout;

public class PanelShipState extends JPanel {

	private JPanel panelShipDetails = null;
	private JLabel labelBezShield = null;
	private JLabel labelValueShield = null;
	private JLabel labelBezStrength = null;
	private JLabel labelValueStrength = null;
	private JLabel labelBezRangeOfSight = null;
	private JLabel labelValueRangeOfSight = null;
	private JLabel labelBezShotRange = null;
	private JLabel labelValueShotRange = null;
	private JLabel labelBezSpeed = null;
	private JLabel labelValueSpeed = null;
	private JLabel jShipPicture = null;
	private Engine _engine;
	
	private GameLanguage gl = GameLanguage.getInstance();
	
	/**
	 * This is the default constructor
	 */
	public PanelShipState(Engine engine) {
		super();
		_engine = engine;
		initialize();
	}
	/**
	 * This method initializes this
	 * 
	 * @return void
	 */
	private  void initialize() {
		jShipPicture = new JLabel();
		this.setLayout(new BorderLayout());
		this.setSize(300,200);
		ImageIcon icon = new ImageIcon( "bild.jpg" );
		jShipPicture = new JLabel(icon);
		this.add(getPanelShipDetails(), java.awt.BorderLayout.CENTER);
		this.add(jShipPicture, java.awt.BorderLayout.EAST);
		
	}
	/**
	 * This method initializes panelShipDetails	
	 * 	
	 * @return javax.swing.JPanel	
	 */    
	private JPanel getPanelShipDetails() {
		if (panelShipDetails == null) {
			labelValueSpeed = new JLabel();
			labelBezSpeed = new JLabel();
			labelValueShotRange = new JLabel();
			labelBezShotRange = new JLabel();
			labelValueRangeOfSight = new JLabel();
			labelBezRangeOfSight = new JLabel();
			labelValueStrength = new JLabel();
			labelBezStrength = new JLabel();
			labelValueShield = new JLabel();
			labelBezShield = new JLabel();
			java.awt.GridLayout gridLayout6 = new GridLayout();
			panelShipDetails = new JPanel();
			panelShipDetails.setLayout(gridLayout6);
			labelBezShield.setText(gl.tr("Shield"));
			labelBezShield.setName("Shield");
			labelValueShield.setText("0");
			labelBezStrength.setText(gl.tr("Strength"));
			labelBezStrength.setName("Strength");
			gridLayout6.setRows(5);
			labelValueStrength.setText("0");
			labelBezRangeOfSight.setText(gl.tr("RangeOfSight"));
			labelBezRangeOfSight.setName("RangeOfSight");
			labelValueRangeOfSight.setText("0");
			labelBezShotRange.setText(gl.tr("Shootrange"));
			labelBezShotRange.setName("Shootrange");
			labelValueShotRange.setText("0");
			labelBezSpeed.setText(gl.tr("Speed"));
			labelBezSpeed.setName("Speed");
			labelValueSpeed.setText("0");
			panelShipDetails.add(labelBezShield, null);
			panelShipDetails.add(labelValueShield, null);
			panelShipDetails.add(labelBezStrength, null);
			panelShipDetails.add(labelValueStrength, null);
			panelShipDetails.add(labelBezRangeOfSight, null);
			panelShipDetails.add(labelValueRangeOfSight, null);
			panelShipDetails.add(labelBezShotRange, null);
			panelShipDetails.add(labelValueShotRange, null);
			panelShipDetails.add(labelBezSpeed, null);
			panelShipDetails.add(labelValueSpeed, null);
			Engine.guiElements.addElement(labelBezShield);
			Engine.guiElements.addElement(labelBezStrength);
			Engine.guiElements.addElement(labelBezRangeOfSight);
			Engine.guiElements.addElement(labelBezShotRange);
			Engine.guiElements.addElement(labelBezSpeed);
		}
		return panelShipDetails;
	}
	
	public void updateship() {
	    BattleShip acbs = _engine.getSelectedBoat();
	    if (acbs != null) {
	    	labelValueShield.setText(""+acbs.getShipShield()+"");
		    labelValueStrength.setText(""+acbs.getShipStrength()+"");
		    labelValueRangeOfSight.setText(""+acbs.getShipRangeOfSight()+"");
		    labelValueShotRange.setText(""+acbs.getShipShotRange()+"");
		    labelValueSpeed.setText(""+acbs.getShipSpeed()+"");
		    
		    this.remove(jShipPicture);
		    ImageIcon icon = new ImageIcon(acbs.getShipPicture());
			jShipPicture = new JLabel(icon);
			this.add(jShipPicture, java.awt.BorderLayout.EAST);
	    }else{
	    	labelValueShield.setText("0");
		    labelValueStrength.setText("0");
		    labelValueRangeOfSight.setText("0");
		    labelValueShotRange.setText("0");
		    labelValueSpeed.setText("0");
		    
		    this.remove(jShipPicture);
	    }
	}
}
