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
			getGraphics().drawImage(bim, bs.getXPosition(), bs.getYPosition(), this);
		}
    }
    
    class FieldMouseListener implements MouseListener {
		public void mouseClicked(MouseEvent e) {
			selectShipAtCoordinate(e.getX(), e.getY());
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
    				_engine.setSelectedBoat((BattleShip)Engine.battleShips.elementAt(i));
    				break;
    			}else{
    				_engine.setSelectedBoat(null);
    			}
    		}
    	}else{
    		System.out.println("attacking");
    		for (int i = 0; i < Engine.battleShips.size(); i++){
    			if (((BattleShip)Engine.battleShips.elementAt(i)).isAtCoordinate(x,y)) {
    				((BattleShip)Engine.battleShips.elementAt(i)).attackedbyship(1);
    				_engine.updategui();
    				
    				break;
    			}else{
    				_engine.setSelectedBoat(null);
    			}
    		}
    	}
		
		
	}
} 
	//  @jve:decl-index=0:visual-constraint="10,10"
