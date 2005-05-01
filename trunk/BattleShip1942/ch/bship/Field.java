package ch.bship;

/**
 * @author Adrian Greiler, Marcel Ryser
 * 
 * PROJECT: Battleship 1942
 *
 * Changelog:
 *
 * 26.08.2004	AG	Erstellung
 * 
 */
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.image.BufferedImage;
import java.io.IOException;
import javax.imageio.ImageIO;
import javax.swing.JPanel;

public class Field extends JPanel {

	private javax.swing.JPanel jContentPane = null;
	private String _gridfile = "grid.dat";
    private String _pictfile = "map.jpg";
    private String _mappath = "maps";
    private String _mapdefault = "testkarte";
    private String _mapimgpath, _mapdatpath;
    private Engine _engine;
    private BufferedImage _mapimg = null;
    
	/**
	 * constructor
	 */
	public Field(Engine engine) {
		super();
		_engine = engine;
		initialize();
	}
	
	/**
	 * intitialise of guielements
	 */
	private void initialize() {
		this.setSize(589, 363);
		this.setMap("logo");
		this.setLayout(null);
		this.addMouseListener(new FieldMouseListener());
	}
	
	/**
	 * calculates grid to pixels
	 */
    private int[] grid2px(int[] grid) {
        int[] px = new int[2];
        px[0] = grid[0] * 15;
        px[1] = grid[1] * 15;
        return px;
    }
	
	/**
	 * setting actual map
	 */
	private void setMap(String mapname) {
        _mapimgpath = _mappath + "/" + mapname + "/" + _pictfile;
        _mapdatpath = _mappath + "/" + mapname + "/" + _gridfile;
    }
	
	/**
	 * getting map as BufferedImage
	 */
	private BufferedImage getMapImage() {
		if (_mapimg == null) {
			try {
				_mapimg = ImageIO.read(Utillib.getInputStreamFromJar(_mapimgpath));
			} catch (IOException e) {
				Error.addError(e, "Fehler beim laden der Karte");
			}
		}
		return _mapimg;
	}
	
    /**
     * draw all components such as ships and some textinformations
     */
    public void zeichne() {
    	BufferedImage bim;
		getGraphics().drawImage(getMapImage(), 0, 0, this);
		for (int i = _engine.getBattleShips().size()-1; i >= 0; i--) {
			BattleShip bs = (BattleShip)_engine.getBattleShips().elementAt(i);
			bim = bs.getShipPic();
			int j;
			if(_engine.getMyPlayernumber() == 1) { j = 0; }else{ j = 4; }
			while (j < 4) {
				BattleShip ba = (BattleShip)_engine.getBattleShips().elementAt(j);
				if (bs.isInSightRange(ba, bs.getShipRangeOfSight()) && bs.getShipStatePercent() > 0) {
					getGraphics().drawImage(bim, bs.getXPosition(), bs.getYPosition(), this);
				}
				j++;
			}
		}
		setInfo("Player: " + _engine.getActualPlayer());
    }
    
    /**
     * determines if there is a ship and select oder attack it
     */
    private void selectShipAtCoordinate(int x, int y) {
    	if (_engine.getNavmode()){
    		for (int i = 0; i < _engine.getBattleShips().size(); i++){
    			BattleShip bs = (BattleShip)_engine.getBattleShips().elementAt(i);
    			if (bs.isAtCoordinate(x,y)) {
    				if (bs.isMine(_engine.getMyPlayernumber())) {
    					_engine.setSelectedBoat(bs);
    				}else{
    					System.out.println("Not my Ship");
    				}
    				break;
    			}else{
    				_engine.setSelectedBoat(null);
    			}
    		}
    	}else{
    		for (int i = 0; i < _engine.getBattleShips().size(); i++){
    			BattleShip bs = (BattleShip)_engine.getBattleShips().elementAt(i);
    			if (bs.isAtCoordinate(x,y)) {
    				if (!bs.isMine(_engine.getMyPlayernumber())) {
    					bs.attackedbyship(_engine.getSelectedBoat().getShipStrength());
    					_engine.reduceaction();
    				}
    				_engine.updateSelectedShipInformation();
    				_engine.repaintField();
    				break;
    			}
    		}
    	}
	}
    
    /**
     * setting a text information in the middle of the field
     */
    public void setInfo(String what) {
    	getGraphics().setColor (java.awt.Color.red);
    	getGraphics().setFont (new java.awt.Font ("Monospaced",java.awt.Font.BOLD,24));

        java.awt.FontMetrics fm = getGraphics().getFontMetrics ();
        int msg_width = fm.stringWidth (what);

        int ascent = fm.getMaxAscent ();
        int descent= fm.getMaxDescent ();

        int msg_x = getSize ().width/2 - msg_width/2;
        int msg_y = getSize ().height/2 - descent/2 + ascent/2;

        getGraphics().drawString (what, msg_x, msg_y);
    }
    
    /**
     * a simple mouselistener to select ship at mouseclick
     */
    class FieldMouseListener implements MouseListener {
		public void mouseClicked(MouseEvent e) {
			if (_engine.isAtPlaying()) {
				selectShipAtCoordinate(e.getX(), e.getY());
			}
		}
		public void mousePressed(MouseEvent e) {}
		public void mouseReleased(MouseEvent e) {}
		public void mouseEntered(MouseEvent e) {}
		public void mouseExited(MouseEvent e) {}
	}
} 
	//  @jve:decl-index=0:visual-constraint="10,10"
