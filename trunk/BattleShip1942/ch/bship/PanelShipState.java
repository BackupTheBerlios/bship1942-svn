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
	private JLabel jLabel = null;
	/**
	 * This is the default constructor
	 */
	public PanelShipState() {
		super();
		initialize();
	}
	/**
	 * This method initializes this
	 * 
	 * @return void
	 */
	private  void initialize() {
		jLabel = new JLabel();
		this.setLayout(new BorderLayout());
		this.setSize(300,200);
		ImageIcon icon = new ImageIcon( "bild.jpg" );
		jLabel = new JLabel(icon);
		this.add(getPanelShipDetails(), java.awt.BorderLayout.CENTER);
		this.add(jLabel, java.awt.BorderLayout.EAST);
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
			labelBezShield.setName("labelBezShield");
			labelBezShield.setText("Schild");
			labelValueShield.setName("labelValueShield");
			labelValueShield.setText("0");
			labelBezStrength.setName("labelBezStrength");
			labelBezStrength.setText("Stärke");
			gridLayout6.setRows(5);
			labelValueStrength.setText("0");
			labelBezRangeOfSight.setText("Sichtweite");
			labelValueRangeOfSight.setText("0");
			labelBezShotRange.setText("Schussweite");
			labelValueShotRange.setText("0");
			labelBezSpeed.setText("Geschwindigkeit");
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
		}
		return panelShipDetails;
	}
}
