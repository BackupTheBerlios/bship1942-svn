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
    private MainFrame _frm;
    private Net _net = null;
    private int shipnr = 0;

    private String _rivalsNick = "";
    private String _rivalsNationality = "";
    private String _myNick = "";
    private String _myNationality = "";
    private String _map = "logo";

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
        
    	shipnr = 1;
        // Creating ship instances and adding ships to Vector
        for (int i = 0; i < 7;i++) {
            if (shipnr == 4) { shipnr = 1; }
            BattleShip bship = new BattleShip(shipnr);
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
    }

    public void Eventhandler(String msg) {
        String[] tmpMsg = msg.split("\\|");
        
        if (tmpMsg[0].equals(Net.MSG_HELLO)) {
            _net.setIP(tmpMsg[1]);
            _rivalsNick = (tmpMsg[2]);
            _rivalsNationality = (tmpMsg[3]);
        } else if (tmpMsg[0].equals(Net.MSG_CHAT)) {
            String parts = "";
            for (int i = 0; i < (tmpMsg.length - 1); i++) {
                parts = parts + tmpMsg[i+1];
                ((Chat)(_frm.getGameChat())).receive(parts);
            }
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
    }
}
