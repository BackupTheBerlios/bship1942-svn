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

import java.io.File;
import java.util.Vector;
import javax.swing.*;

public class Engine {
    
    public static Vector BattleShips = new Vector();
    public static Vector guiElements = new Vector();
    static GameLanguage translator = new GameLanguage();
    public static String language = "german.lng";
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
	
	public static String[] getLanguages() {
    	File langs = new File(".");
    	File[] f = langs.listFiles();
    	
    	String out = "";
    	for (int i = 0; i < f.length; i++) {
    		if (f[i].isFile() && f[i].getName().endsWith(".lng")) {
    			out +=  f[i].getName().substring(0,f[i].getName().length()-4) + ":";
    		}
    	}
    	return out.split(":");
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
	
    public static void updateLanguage() {
    	for (int i = 0; i < guiElements.size(); i++){
    		if (guiElements.elementAt(i) instanceof JMenu){
    			JMenu m = (JMenu) guiElements.elementAt(i);
    			m.setText(translator.tr(m.getName()));
    		}
    		if (guiElements.elementAt(i) instanceof JMenuItem){
    			JMenuItem mi = (JMenuItem) guiElements.elementAt(i);
    			mi.setText(translator.tr(mi.getName()));
    		}
    		if (guiElements.elementAt(i) instanceof JCheckBoxMenuItem){
    			JCheckBoxMenuItem cbmi = (JCheckBoxMenuItem) guiElements.elementAt(i);
    			cbmi.setText(translator.tr(cbmi.getName()));
    		}
    		if (guiElements.elementAt(i) instanceof JLabel){
    			JLabel l = (JLabel) guiElements.elementAt(i);
    			l.setText(translator.tr(l.getName()));
    		}
    		if (guiElements.elementAt(i) instanceof JButton){
    			JButton b = (JButton) guiElements.elementAt(i);
    			b.setText(translator.tr(b.getName()));
    		}
    	}
    }
    
}
