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
	private String _picture;
	private int _shield;
	private int _force;
	private int _rangeOfSight;
	private int _rangeOfShot;
	private int _speed;
	private int _actualShipStatePercent = 100;
	private int _xpos;
	private int _ypos;
	private int _player;
	private int _direction = 1;
	private String _name;
	private String _pathToImage;
	private GameLanguage translator = GameLanguage.getInstance();
	private BufferedImage shippic;
	
	
	/**
	 * constructor
	 */
	public BattleShip(int kind, int player) {
	    _kind = kind;
	    _player = player;
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
			_picture = "pics/ships/Landungsboot.jpg";
		} else if (kind == 1) {
			_shield = 2;
			_force = 1;
			_rangeOfSight = 3;
			_rangeOfShot = 1;
			_speed = 3;
			_name = "SpeedBoat";
			_picture = "pics/ships/SpeedBoot.jpg";
		} else if (kind == 2) {
			_shield = 4;
			_force = 2;
			_rangeOfSight = 2;
			_rangeOfShot = 2;
			_speed = 1;
			_name = "ArmoredBoat";
			_picture = "pics/ships/Panzerboot.jpg";
		} else if (kind == 3) {
			_shield = 3;
			_force = 4;
			_rangeOfSight = 4;
			_rangeOfShot = 4;
			_speed = 1;
			_name = "AirCraftCarrier";
			_picture = "pics/ships/Flugzeugtraeger.jpg";
		}
		
		if (_player == 1) {
			_xpos = 30; _ypos = 310 + kind * 45;
		}else{
			_xpos = 610; _ypos = 150 - kind * 45;
			_direction = 3;
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
    	return _picture;
    }
    
    /**
     * Graphical Part of the Ship
     */
    
    private BufferedImage getShipImage() {
    	if (shippic == null) {
    		System.out.println("Loding now pic: " + getShipPicture());
    		File f = new File(getShipPicture());
        	try {
        		shippic = ImageIO.read(f);
    		} catch (IOException e) {
    			Error.addError(e, "Fehler beim laden des Schiffbildes");
    		}
    	}
    	return shippic;
    }
    
    public int getYPosition() {
    	return _ypos;
    }
    
    public int getXPosition() {
    	return _xpos;
    }
    
    // Following Methods just for sync function
    public void setYPosition(int y) {
    	_ypos = y;
    }
    
    public void setXPosition(int x) {
    	_xpos = x;
    }
    
    public void setDirection(int dir) {
    	_direction = dir;
    }
    
    public void setShipStatePercent(int perc){
    	_actualShipStatePercent = perc;
    }
    
    public void moveUp(int howmany) {
    	_ypos -= 15 * howmany;
    	_direction = 0;
    }
    
    public void moveDown(int howmany) {
    	_ypos += 15 * howmany;
    	_direction = 2;
    }
    
    public void moveLeft(int howmany) {
    	_xpos -= 15 * howmany;
    	_direction = 3;
    }
    
    public void moveRight(int howmany) {
    	_xpos += 15 * howmany;
    	_direction = 1;
    }
    
    private BufferedImage rotate(BufferedImage bi, int angle){
		AffineTransform tx = AffineTransform.getRotateInstance(Math.toRadians(angle), bi.getWidth() / 2d, bi.getHeight() / 2d);
		AffineTransformOp op = new AffineTransformOp(tx, AffineTransformOp.TYPE_BILINEAR);
		Rectangle2D rect = op.getBounds2D(bi);
		tx.translate(-rect.getX(), rect.getY());
		op = new AffineTransformOp(tx, AffineTransformOp.TYPE_BILINEAR);
		bi = op.filter(bi, null);
		return bi;
	}
    
    public BufferedImage getShipPic() {
    	return rotate(getShipImage(), _direction * 90);
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
    
    public boolean isMine(int playernr) {
    	if (_player == playernr) {
    		return true;
    	}else{
    		return false;
    	}
    }
    
    public void attackedbyship(int strength){
    	_actualShipStatePercent -= 10 * strength;
    	System.out.println("Ship: " +_actualShipStatePercent+"");
    }
    
	/**
	 * @return Returns the _direction.
	 */
	public int getDirection() {
		return _direction;
	}
}
