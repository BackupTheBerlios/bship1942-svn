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
    
    
	public static void main(String[] args) {
		MainFrame frm = new MainFrame();
		frm.setVisible(true);
		// Creating ship instances and adding ships to Vector
		BattleShip p1s1 = new BattleShip(0);
		BattleShip p1s2 = new BattleShip(1);
		BattleShip p1s3 = new BattleShip(2);
		BattleShip p1s4 = new BattleShip(3);
		BattleShip p2s1 = new BattleShip(0);
		BattleShip p2s2 = new BattleShip(1);
		BattleShip p2s3 = new BattleShip(2);
		BattleShip p2s4 = new BattleShip(3);
		
		BattleShips.addElement(p1s1);
		BattleShips.addElement(p1s2);
		BattleShips.addElement(p1s3);
		BattleShips.addElement(p1s4);
		BattleShips.addElement(p2s1);
		BattleShips.addElement(p2s2);
		BattleShips.addElement(p2s3);
		BattleShips.addElement(p2s4);
	}

	public void Eventhandler(String msg) {
		// TODO: Programming the new Eventhandler
	}

    /**
     * @return
     */
    public static BattleShip selectedBoat() {
        // TODO: Aktuell ausgewähltes schiff zurückliefern
        return null;
    }
	
}
