/**
 * @author Adrian Greiler, Marcel Ryser
 * 
 * PROJECT: Battleship 1942
 *
 * Changelog:
 * 
 * 24.08.2004	MR		Erstellung
 * 6.12.2004    AG              Instanzierung
 * 
 */
package ch.bship;

import java.util.Vector;
import javax.swing.*;

public class Engine {

    public static Vector battleShips = new Vector();
    public static Vector guiElements = new Vector();
    public static String language = "german.lng";
    private static GameLanguage translator = GameLanguage.getInstance();
    private static BattleShip actBship = null;
    private boolean navmode = true;
    private MainFrame _frm;
    private Net _net = null;

    private String _rivalsNick = "";
    private String _rivalsNationality = "";
    private String _myNick = "";
    private String _myNationality = "";
    private String _map = "logo";
    private int playernumber = 1;
    public int actualplayer;
    private int actionsleft;

    public void setRivalsNick(String nick) { _rivalsNick = nick; }
    public void setRivalsNationality(String nation) { _rivalsNationality = nation; }
    public void setMyNick(String nick) { _myNick = nick; }
    public void setMyNationality(String nation) { _myNationality = nation; }
    public void setMap(String map) { _map = map; }
    public String getRivalsNick() { return _rivalsNick; }
    public String getRivalsNationality() { return _rivalsNationality; }
    public String getMyNick() { return _myNick; }
    public String getMyNationality() { return _myNationality; }
    public String getMap() { return _map; }

    public static void main(String[] args) {
        new Engine();
    }

    /**
     * constructor
     */
    public Engine() {
    	_net = new Net(this);
    	translator.setLanguage("german");
    	openStartDialog();
        
    	int shipnr = 0;
    	int player = 1;
        // Creating ship instances and adding ships to Vector
        for (int i = 0; i < 8;i++) {
            if (shipnr == 4) { shipnr = 0; player = 2; }
            BattleShip bship = new BattleShip(shipnr, player);
            battleShips.addElement(bship);
            shipnr++;
        }
    }

    public Net getNetInstance() {
        return _net;
    }
    
    public void openStartDialog() {
    	StartDia sdlg = new StartDia(_net, this);
    	sdlg.setVisible(true);
    }
    
    public void openMainFrame() {
        _frm = new MainFrame(this);
        _frm.updateselected();
        _frm.initField();
        actualplayer = 1;
        actionsleft = 3;
    }

    public void Eventhandler(String msg) {
        String[] tmpMsg = msg.split("\\|");
        
        if (tmpMsg[0].equals(Net.MSG_HELLO)) {
            _net.setIP(tmpMsg[1]);
            _rivalsNick = (tmpMsg[2]);
            _rivalsNationality = (tmpMsg[3]);
            playernumber = 2;
            updategui();
        } else if (tmpMsg[0].equals(Net.MSG_CHAT)) {
            String parts = "";
            for (int i = 0; i < (tmpMsg.length - 1); i++) {
                parts = parts + tmpMsg[i+1];
                ((Chat)(_frm.getGameChat())).receive(parts);
            }
        } else if (tmpMsg[0].equals(Net.MSG_SYNC)) {
        	int shipid = 0;
        	int idx = 1;
        	if (playernumber == 1){
    			// Second Part ist to sync
    			shipid = 4;
    		}
        	// Ship (x, y, direction, percent)
        	for (int i = 0; i < 4;i++) {
        		((BattleShip)battleShips.elementAt(shipid + i)).setXPosition(Integer.parseInt(tmpMsg[idx])); idx++;
        		((BattleShip)battleShips.elementAt(shipid + i)).setYPosition(Integer.parseInt(tmpMsg[idx])); idx++;
        		((BattleShip)battleShips.elementAt(shipid + i)).setDirection(Integer.parseInt(tmpMsg[idx])); idx++;
        		((BattleShip)battleShips.elementAt(shipid + i)).setShipStatePercent(Integer.parseInt(tmpMsg[idx])); idx++;
        	}
        	actualplayer = playernumber;
        	updategui();
        }
        //TODO
    }

    /**
     * @return Actual selected BattleShip
     */
    public BattleShip getSelectedBoat() {
        return actBship;
    }

    public void setSelectedBoat(BattleShip bs) {
        actBship = bs;
        _frm.updateselected();
    }
    
    public void updategui() {
    	_frm.updateselected();
    }

    public void updateLanguage() {
        translator.setLanguage(language);
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
        if (_frm != null){  _frm.repaint();}
    }
    
    public boolean isAtPlaying(){
    	if (actualplayer == playernumber) {
    		System.out.println("Is at play");
    		return true;
    	}else{
    		System.out.println("Is not at playing");
    		return false;
    	}
    }
    
	public void setNavmode(boolean b) {
		navmode = b;	
	}
	public boolean getNavmode() {
		return navmode;
	}
	/**
	 * 
	 */
	public void reduceaction() {
		actionsleft--;
		System.out.println("Actions left: " + actionsleft);
		if (actionsleft == 0){
			syncwithrival();
			if (actualplayer == 1) {
				actualplayer = 2;
			}else{
				actualplayer = 1;
			}
			actionsleft = 3;
		}
	}

	private void syncwithrival() {
		// TODO Auto-generated method stub
		int shipid = 0;
		if (playernumber == 1) {
			shipid = 4;
		}
		String tosend = Net.MSG_SYNC + "|";
		for (int i = 0; i < 4; i++){
			int x = ((BattleShip)battleShips.elementAt(shipid + i)).getXPosition();
    		int y = ((BattleShip)battleShips.elementAt(shipid + i)).getYPosition();
    		int dir = ((BattleShip)battleShips.elementAt(shipid + i)).getDirection();
    		int perc = ((BattleShip)battleShips.elementAt(shipid + i)).getShipStatePercent();
    		tosend += String.valueOf(x) + "|" + String.valueOf(y) + "|" + String.valueOf(dir) + "|" + String.valueOf(perc) + "|";
		}
		_net.send(tosend);
		updategui();
	}
	
}
