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

import java.awt.event.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.JPanel;

import javax.swing.JLabel;

public class Field extends JPanel {

	private javax.swing.JPanel jContentPane = null;
	
	private BufferedImage bim;
	
	private static String gridfile = "grid.dat";
    private static String pictfile = "map.jpg";
    private String _mappath = "maps";
    private String _mapdefault = "testkarte";
    private String folderdivider = File.separator;
    private String _mapimgpath, _mapdatpath;
    private Engine _engine;
    private boolean _defeated = false;
    
    private BufferedImage mapimg = null;
	private JLabel jLabel = null;
	/**
	 * This is the default constructor
	 */
	public Field(Engine engine) {
		super();
		_engine = engine;
		initialize();
	}
	/**
	 * This method initializes this
	 * 
	 * @return void
	 */
	private void initialize() {
		this.setSize(589, 363);
		this.setMap("logo");
		this.setLayout(null);
		this.addMouseListener(new FieldMouseListener());
	}
	
	private BufferedImage getMapImage() {
		if (mapimg == null) {
			File f = new File(_mapimgpath);
			try {
				mapimg = ImageIO.read(f);
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		
		return mapimg;
	}
	
    private int[] grid2px(int[] grid) {
        int[] px = new int[2];
        px[0] = grid[0] * 15;
        px[1] = grid[1] * 15;
        return px;
    }
        
    private void setMap(String mapname) {
        _mapimgpath = _mappath + folderdivider + mapname + folderdivider + pictfile;
        _mapdatpath = _mappath + folderdivider + mapname + folderdivider + gridfile;
    }
    
    public void zeichne() {
		getGraphics().drawImage(getMapImage(), 0, 0, this);
		for (int i = Engine.battleShips.size()-1; i >= 0; i--) {
			bim = ((BattleShip)Engine.battleShips.elementAt(i)).getShipPic();
			BattleShip bs = (BattleShip)Engine.battleShips.elementAt(i);
			if (bs.getShipStatePercent() > 0) {
				getGraphics().drawImage(bim, bs.getXPosition(), bs.getYPosition(), this);
			}
		}
		if (!_defeated) {
			setInfo("Player " +_engine.actualplayer);
		}else{
			setInfo("You are defeated!");
		}
    }
    
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
    
    private void selectShipAtCoordinate(int x, int y) {
    	if (_engine.getNavmode()){
    		for (int i = 0; i < Engine.battleShips.size(); i++){
    			if (((BattleShip)Engine.battleShips.elementAt(i)).isAtCoordinate(x,y)) {
    				if (((BattleShip)Engine.battleShips.elementAt(i)).isMine(_engine.playernumber)) {
    					_engine.setSelectedBoat((BattleShip)Engine.battleShips.elementAt(i));
    				}else{
    					System.out.println("Not my Ship");
    				}
    				break;
    			}else{
    				_engine.setSelectedBoat(null);
    			}
    		}
    	}else{
    		for (int i = 0; i < Engine.battleShips.size(); i++){
    			if (((BattleShip)Engine.battleShips.elementAt(i)).isAtCoordinate(x,y)) {
    				if (!((BattleShip)Engine.battleShips.elementAt(i)).isMine(_engine.playernumber)) {
    					((BattleShip)Engine.battleShips.elementAt(i)).attackedbyship(_engine.getSelectedBoat().getShipStrength());
    					_engine.reduceaction();
    				}else{
    					System.out.println("Hey, don't shoot at yourself");
    				}
    				_engine.updategui();
    				_engine.repaintField();
    				break;
    			}
    		}
    	}
	}
    
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
	 * @param b
	 */
	public void setDefeated(boolean b) {
		_defeated = b;
	}
} 
	//  @jve:decl-index=0:visual-constraint="10,10"
