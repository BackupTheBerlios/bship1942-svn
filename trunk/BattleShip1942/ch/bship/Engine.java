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

import javax.swing.JButton;
import javax.swing.JCheckBoxMenuItem;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuItem;

public class Engine {
	
	private boolean _navmode = true;
	private int _playernumber = 1;
	private int _actualplayer;
    private int _actionsleft;
	private String _rivalsNick = "";
    private String _rivalsNationality = "";
    private String _myNick = "";
    private String _myNationality = "";
    private String _map = "logo";
    private Vector _battleShips = null;
    private Vector _guiElements = null;
    private GameLanguage _translator = null;
    private BattleShip _actBship = null;
    private MainFrame _frm = null;
    private Net _net = null;
    private StartDia _sdlg = null;
    
    
    /**
     * constructor
     */
    public Engine() {
    	getTranslator().setLanguage("german");
    	getStartDialog().setVisible(true);
    }
    
    /**
     * main method
     */
    public static void main(String[] args) {
        new Engine();
    }
    
    /**
     * getters and setters
     */
    private void setActionsLeft(int actionsleft) { _actionsleft = actionsleft; }
    private void setActualPlayer(int actplayer) { _actualplayer = actplayer; }
    private void setMyPlayernumber(int playernr) { _playernumber = playernr; }
    public void setNavmode(boolean navmode) { _navmode = navmode; }
    public void setRivalsNick(String nick) { _rivalsNick = nick; }
    public void setRivalsNationality(String nation) { _rivalsNationality = nation; }
    public void setMyNick(String nick) { _myNick = nick; }
    public void setMyNationality(String nation) { _myNationality = nation; }
    public void setMap(String map) { _map = map; }
    public void setSelectedBoat(BattleShip bs) { _actBship = bs; updateSelectedShipInformation(); }
    public int getActionsLeft() { return _actionsleft; }
    public int getActualPlayer() { return _actualplayer; }
    public int getMyPlayernumber() { return _playernumber; }
    public boolean getNavmode() { return _navmode; }
    public String getRivalsNick() { return _rivalsNick; }
    public String getRivalsNationality() { return _rivalsNationality; }
    public String getMyNick() { return _myNick; }
    public String getMyNationality() { return _myNationality; }
    public String getMap() { return _map; }
    public BattleShip getSelectedBoat() { return _actBship; }
    
    /**
     * getters for game's important classes and other
     */
    public MainFrame getMainFrame() {
    	if (_frm == null) {
    		_frm = new MainFrame(this);
    	}
    	return _frm;
    }
    
    public Net getNetInstance() {
    	if (_net == null) {
    		_net = new Net(this);
    	}
        return _net;
    }
    
    public GameLanguage getTranslator() {
    	if (_translator == null) {
    		_translator = GameLanguage.getInstance();
    	}
    	return _translator;
    }
    
    private StartDia getStartDialog() {
    	if (_sdlg == null) {
    		_sdlg = new StartDia(this);
    	}
    	return _sdlg;
    }
    
    public Vector getBattleShips() {
    	if (_battleShips == null){
    		_battleShips = new Vector();
    		
    		int shipnr = 0, player = 1;
            // Creating ship instances and adding ships to Vector
            for (int i = 0; i < 8;i++) {
                if (shipnr == 4) { shipnr = 0; player = 2; }
                BattleShip bship = new BattleShip(shipnr, player);
                _battleShips.addElement(bship);
                shipnr++;
            }
    	}
    	return _battleShips;
    }
    
    public Vector getGuiElements() {
    	if (_guiElements == null) {
    		_guiElements = new Vector();
    	}
    	return _guiElements;
    }
    
    /**
     * starting game with opening the mainframe
     */
    public void openMainFrame() {
    	getMainFrame().setVisible(true);
    	updateSelectedShipInformation();
    	repaintField();
    	setActualPlayer(1);
    	setActionsLeft(3);
    }
    
    /**
     * Eventhandler wich is used by the network interface
     */
	public void Eventhandler(String msg) {
        String[] tmpMsg = msg.split("\\|");
        
        if (tmpMsg[0].equals(Net.MSG_HELLO)) {
        	getNetInstance().send(Net.MSG_RESPONSE + "|" + getMyNick() + "|" + getMyNationality());
        	getNetInstance().setIP(tmpMsg[1]);
            setRivalsNick(tmpMsg[2]);
            setRivalsNationality(tmpMsg[3]);
            setMyPlayernumber(2);
            openMainFrame();
            updateSelectedShipInformation();
        } else if (tmpMsg[0].equals(Net.MSG_RESPONSE)) {
        	setRivalsNick(tmpMsg[1]);
        	setRivalsNationality(tmpMsg[2]);
        	setMyPlayernumber(1);
        	openMainFrame();
        	updateSelectedShipInformation();
        	
        } else if (tmpMsg[0].equals(Net.MSG_CHAT)) {
            ((Chat)getMainFrame().getGameChat()).receive(tmpMsg[1]);
        } else if (tmpMsg[0].equals(Net.MSG_SYNC)) {
        	setActualPlayer(getMyPlayernumber()); // jetzt bin ich dran!
        	// Ship (x, y, direction, percent)
        	int idx = 1;
        	for (int i = 0; i < getBattleShips().size()-1;i++) {
        		((BattleShip)getBattleShips().elementAt(i)).setXPosition(Integer.parseInt(tmpMsg[idx])); idx++;
        		((BattleShip)getBattleShips().elementAt(i)).setYPosition(Integer.parseInt(tmpMsg[idx])); idx++;
        		((BattleShip)getBattleShips().elementAt(i)).setDirection(Integer.parseInt(tmpMsg[idx])); idx++;
        		((BattleShip)getBattleShips().elementAt(i)).setShipStatePercent(Integer.parseInt(tmpMsg[idx])); idx++;
        	}
        	
        	setNavmode(true);
        	setSelectedBoat(null);
        	updateSelectedShipInformation();
        	repaintField();
        }
    }
	
	/**
	 * following methods give or set some general game informations
	 */
	public boolean isAtPlaying(){
    	if (getActualPlayer() == getMyPlayernumber()) {
    		return true;
    	}else{
    		return false;
    	}
    }
    
	public void reduceaction() {
		setActionsLeft(getActionsLeft()-1);
		if (getActionsLeft() == 0){
			syncwithrival();
			setActionsLeft(3);
		}
	}
	
	/**
     * method to start a comletely new game
     */
	public void startNewGame() {
		// TODO implementing a method to start a new game
	}
	
	/** 
	 * method to update the gui with information of the selected ship
	 */
	
	public void updateSelectedShipInformation() {
		((PanelShipNav) getMainFrame().getShipNavField()).actualizebuttons();
		((PanelShipState) getMainFrame().getShipState()).updateship();
		((PanelGameState) getMainFrame().getGameState()).updateShipStates();
	}
	
	/**
	 * method to repaint the field
	 */
	public void repaintField() {
		((Field) getMainFrame().getGameField()).zeichne();
	}
	
	/**
	 * this method sync all ship information with the rival
	 */
	private void syncwithrival() {
		String tosend = Net.MSG_SYNC + "|";
		for (int i = 0; i < getBattleShips().size()-1; i++){
			int x = ((BattleShip)getBattleShips().elementAt(i)).getXPosition();
    		int y = ((BattleShip)getBattleShips().elementAt(i)).getYPosition();
    		int dir = ((BattleShip)getBattleShips().elementAt(i)).getDirection();
    		int perc = ((BattleShip)getBattleShips().elementAt(i)).getShipStatePercent();
    		tosend += String.valueOf(x) + "|" + String.valueOf(y) + "|" + String.valueOf(dir) + "|" + String.valueOf(perc) + "|";
		}
		if (getActualPlayer() == getMyPlayernumber()) {
			if (getActualPlayer() == 1) { setActualPlayer(2); } else{ setActualPlayer(1); }
		}
		setNavmode(true);
		getNetInstance().send(tosend);
		updateSelectedShipInformation();
	}
    
	/**
	 * this method updates the general language of the application
	 */
    public void updateLanguage(String language) {
    	getTranslator().setLanguage(language);
        for (int i = 0; i < getGuiElements().size(); i++){
            if (getGuiElements().elementAt(i) instanceof JMenu){
                JMenu m = (JMenu) getGuiElements().elementAt(i);
                m.setText(getTranslator().tr(m.getName()));
            }
            if (getGuiElements().elementAt(i) instanceof JMenuItem){
                JMenuItem mi = (JMenuItem) getGuiElements().elementAt(i);
                mi.setText(getTranslator().tr(mi.getName()));
            }
            if (getGuiElements().elementAt(i) instanceof JCheckBoxMenuItem){
                JCheckBoxMenuItem cbmi = (JCheckBoxMenuItem) getGuiElements().elementAt(i);
                cbmi.setText(getTranslator().tr(cbmi.getName()));
            }
            if (getGuiElements().elementAt(i) instanceof JLabel){
                JLabel l = (JLabel) getGuiElements().elementAt(i);
                l.setText(getTranslator().tr(l.getName()));
            }
            if (getGuiElements().elementAt(i) instanceof JButton){
                JButton b = (JButton) getGuiElements().elementAt(i);
                b.setText(getTranslator().tr(b.getName()));
            }
        }
        if (_frm != null){
            getMainFrame().repaint();
        }
    }
}
