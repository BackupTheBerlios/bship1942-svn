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

package ch.bship;
import java.awt.geom.AffineTransform;
import java.awt.geom.Rectangle2D;
import java.awt.image.AffineTransformOp;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.*;

import javax.imageio.ImageIO;
public class BattleShip {

	private int _alignment;
	private Vector _positions;
	private int _kind;
	private int _shield;
	private int _force;
	private int _rangeOfSight;
	private int _rangeOfShot;
	private int _speed;
	private int _actualShipStatePercent;
	private int _xpos;
	private int _ypos;
	private int _shipangle;
	private String _name;
	private String _pathToImage;
	private GameLanguage translator = GameLanguage.getInstance();
	
	
	/**
	 * constructor
	 */
	public BattleShip(int kind) {
	    _kind = kind;
		setInfos(_kind);
		_name = translator.tr(_name);
		/**
		 * TODO: pathToImage mit properties oder setinfos implementieren
		 */
		_pathToImage = "";
	}

    /**
	 * sets the variables with the values
	 * for the given kind of ship
	 */
	private void setInfos(int kind) {
		if (kind == 0) {
			_shield = 1;
			_force = 1;
			_rangeOfSight = 1;
			_rangeOfShot = 1;
			_speed = 1;
			_name = "LandingCraft";
		} else if (kind == 1) {
			_shield = 2;
			_force = 1;
			_rangeOfSight = 3;
			_rangeOfShot = 1;
			_speed = 3;
			_name = "SpeedBoat";
		} else if (kind == 2) {
			_shield = 4;
			_force = 2;
			_rangeOfSight = 2;
			_rangeOfShot = 2;
			_speed = 1;
			_name = "ArmoredBoat";
		} else if (kind == 3) {
			_shield = 3;
			_force = 4;
			_rangeOfSight = 4;
			_rangeOfShot = 4;
			_speed = 1;
			_name = "AirCraftCarrier";
		}
	}

	/**
	 * sets the current alignment of the ship
	 *
	 * @param alignment
	 */
	public void setAlignment(int alignment) {
		_alignment = alignment;
	}
	
    /**
     * get the current shipstate (in percent)
     */
    public int getShipStatePercent() {
        return _actualShipStatePercent;
    }

    /**
     * get the Ship Shield
     */
    public int getShipShield() {
        return  _shield;
    }

    /**
     * get the Ship Strength
     */
    public int getShipStrength() {
        return _force;
    }

    /**
     * get the Ship Range of Sight
     */
    public int getShipRangeOfSight() {
        return _rangeOfSight;
    }

    /**
     * get the Ship Shot Range
     */
    public int getShipShotRange() {
        return _rangeOfShot;
    }

    /**
     * get the Ship Speed
     */
    public int getShipSpeed() {
        return _speed;
    }

    /**
     * get the Ships own picture
     */
    public String getShipPicture() {
        return "bild.jpg";
    }
    
    /**
     * Graphical Part of the Ship
     */
    
    private BufferedImage getShipImage() {
    	File f = new File(getShipPicture());
    	BufferedImage bim = null;
    	try {
			bim = ImageIO.read(f);
		} catch (IOException e) {
			Error.addError(e, "Fehler beim laden des Schiffbildes");
		}
    	return bim;
    }
    
    public int getYPosition() {
    	return _ypos;
    }
    
    public int getXPosition() {
    	return _xpos;
    }
    
    public void rotateLeft() {
    	_shipangle -= 90;
    	if (_shipangle < 0) { _shipangle = 360 + _shipangle; }
    }
    
    public void rotateRight() {
    	_shipangle += 90;
    	if (_shipangle == 360) { _shipangle = 0; }
    }
    
    public void moveUp(int howmany) {
    	_ypos -= 15 * howmany;
    }
    
    public void moveDown(int howmany) {
    	_ypos += 15 * howmany;
    }
    
    public void moveLeft(int howmany) {
    	_xpos -= 15 * howmany;
    }
    
    public void moveRight(int howmany) {
    	_xpos += 15 * howmany;
    }
    
    private static BufferedImage rotate(BufferedImage bi, int angle){
		AffineTransform tx = AffineTransform.getRotateInstance(Math.toRadians(angle), bi.getWidth() / 2d, bi.getHeight() / 2d);
		AffineTransformOp op = new AffineTransformOp(tx, AffineTransformOp.TYPE_BILINEAR);
		Rectangle2D rect = op.getBounds2D(bi);
		tx.translate(-rect.getX(), rect.getY());
		op = new AffineTransformOp(tx, AffineTransformOp.TYPE_BILINEAR);
		bi = op.filter(bi, null);
		return bi;
	}
    
    public BufferedImage getShipPic() {
    	return rotate(getShipImage(), _shipangle);
    }
    
    public boolean isAtCoordinate(int x, int y){
    	BufferedImage img = getShipImage();
    	int imgheight = img.getHeight();
    	int imgwidth = img.getWidth();
    	if (x > getXPosition() && x < (getXPosition() + imgwidth) && y > getYPosition() && y < (getYPosition() + imgheight)) {
    		return true;
    	}else{
    		return false;
    	}
    }
}
