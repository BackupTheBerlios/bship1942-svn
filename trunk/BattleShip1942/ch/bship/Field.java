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

import Verschieber;

import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.geom.AffineTransform;
import java.awt.geom.Rectangle2D;
import java.awt.image.AffineTransformOp;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.JPanel;

import javax.swing.JLabel;

public class Field extends JPanel {

	private javax.swing.JPanel jContentPane = null;
	
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
		this.addKeyListener(new KeyAdapter() {
			public void keyPressed(KeyEvent evt) {
				int keyCode = evt.getKeyCode();
				switch (keyCode) {
					case KeyEvent.VK_UP: {
						File f = new File("c:/arrow.gif");
						BufferedImage img = null;
						try {
							img = ImageIO.read(f);
						} catch (IOException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
						ag += 20;
						BufferedImage bim = Verschieber.versch(img,ag);
						getContentPane().getGraphics().drawImage(bim, 10, 10, v);
					}
				}
			}
		});
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
    
    private void verschieben(int xmove, int ymove) {
    	int actx, acty;
    	//actx = getJ
    }
    
    public void zeichne() {
		getGraphics().drawImage(getMapImage(), 0, 0, this);
    }
    
    public static BufferedImage versch(BufferedImage bi, int angle){
		AffineTransform tx = AffineTransform.getRotateInstance(Math.toRadians(angle), bi.getWidth() / 2d, bi.getHeight() / 2d);
		AffineTransformOp op = new AffineTransformOp(tx, AffineTransformOp.TYPE_BILINEAR);
		Rectangle2D rect = op.getBounds2D(bi);
		tx.translate(-rect.getX(), rect.getY());
		op = new AffineTransformOp(tx, AffineTransformOp.TYPE_BILINEAR);
		bi = op.filter(bi, null);
		return bi;
	}
}  //  @jve:decl-index=0:visual-constraint="10,10"
