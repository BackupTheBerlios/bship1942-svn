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

	private JLabel jLabel = null;
	/**
	 * This is the default constructor
	 */
	public Field() {
		super();
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
	}
	
	private BufferedImage getMapImage() {
		File f = new File(_mapimgpath);
		BufferedImage img = null;
		try {
			img = ImageIO.read(f);
		} catch (IOException e) {
			e.printStackTrace();
		}
		return img;
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
		for (int i = 0; i < Engine.BattleShips.size(); i++) {
			bim = ((BattleShip)Engine.BattleShips.elementAt(i)).getShipPic();
			BattleShip bs = (BattleShip)Engine.BattleShips.elementAt(i);
			getGraphics().drawImage(bim, bs.getXPosition(), bs.getYPosition(), this);
		}
		//bim = ((BattleShip)Engine.BattleShips.elementAt(1)).rotateLeft();
		//getGraphics().drawImage(bim, 10, 10, this);
    }
}  //  @jve:decl-index=0:visual-constraint="10,10"
