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

import java.util.Vector;

public class Engine {
    
    public static Vector BattleShips = new Vector();
    public static int language = 0;
    private static BattleShip actBship;
    private static int i, shipnr = 0;
    
    
	public static void main(String[] args) {
		MainFrame frm = new MainFrame();
		frm.setVisible(true);
		
		// Creating ship instances and adding ships to Vector
		for (i = 0; i < 7;i++) {
		    if (shipnr == 4) { shipnr = 0; }
		    BattleShip bship = new BattleShip(shipnr);
		    BattleShips.addElement(bship);
		    shipnr++;
		}
	}

	public void Eventhandler(String msg) {
		// TODO: Programming the new Eventhandler
	}

    /**
     * @return Actual selected BattleShip
     */
    public static BattleShip getSelectedBoat() {
        return actBship;
    }
    
    public static void setSelectedBoat(BattleShip bs) {
        actBship = bs;
    }
	
}
