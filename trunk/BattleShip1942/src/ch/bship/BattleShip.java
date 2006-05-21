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
import java.io.IOException;

import javax.imageio.ImageIO;
public class BattleShip {

	private int _kind;
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
	private String _picture;
	private BufferedImage _shippic;
	
	/**
	 * constructor of BattleShip
	 * 
	 * @param kind the kind of ship
	 * @param player the number of the player who the ship belongs to
	 */
	public BattleShip(int kind, int player) {
	    _kind = kind;
	    _player = player;
		setInfos(_kind);
	}
	
	/**
     * getters for various functions
     */	
    public int getShipStatePercent() { return _actualShipStatePercent; } // actual health of the ship
    public int getShipShield() { return  _shield; } // shield strength
    public int getShipStrength() { return _force; } // shooting strength
    public int getShipRangeOfSight() { return _rangeOfSight; } // range of sight
    public int getShipShotRange() { return _rangeOfShot; } // shooting range of ship
    public int getShipSpeed() { return _speed; } // ship's speed
    public int getXPosition() { return _xpos; } // ship's x position in coordinate system
    public int getYPosition() { return _ypos; } // ship's y position in coordinate system
    public int getDirection() { return _direction; } // get direction
    public String getShipPicture() { return _picture; } // picture of this ship
    public BufferedImage getShipPic() { return rotate(getShipImage(), _direction * 90); } // returns ship image for display
    
    //  Following setters just for sync function
    public void setShipStatePercent(int perc){ _actualShipStatePercent = perc; } // setting health percent
    public void setXPosition(int x) { _xpos = x; } // setting x position
    public void setYPosition(int y) { _ypos = y; } // setting y position
    public void setDirection(int dir) { _direction = dir; } // setting direction
    
    /**
     * ship navigation
     */
    public void moveUp(int howmany) { _ypos -= 15 * howmany; _direction = 0; }
    public void moveDown(int howmany) { _ypos += 15 * howmany; _direction = 2; }
    public void moveLeft(int howmany) { _xpos -= 15 * howmany; _direction = 3; }
    public void moveRight(int howmany) { _xpos += 15 * howmany; _direction = 1; }

    /**
	 * sets the variables with the values for the given kind of ship
	 */
	private void setInfos(int kind) {
		if (kind == 0) {
			_shield = 1;
			_force = 1;
			_rangeOfSight = 1;
			_rangeOfShot = 1;
			_speed = 1;
			_picture = "/pics/ships/Landungsboot.jpg";
		} else if (kind == 1) {
			_shield = 2;
			_force = 1;
			_rangeOfSight = 3;
			_rangeOfShot = 1;
			_speed = 3;
			_picture = "/pics/ships/SpeedBoot.jpg";
		} else if (kind == 2) {
			_shield = 4;
			_force = 2;
			_rangeOfSight = 2;
			_rangeOfShot = 2;
			_speed = 1;
			_picture = "/pics/ships/Panzerboot.jpg";
		} else if (kind == 3) {
			_shield = 3;
			_force = 4;
			_rangeOfSight = 4;
			_rangeOfShot = 4;
			_speed = 1;
			_picture = "/pics/ships/Flugzeugtraeger.jpg";
		}
		
		// placing ships in left under and right upper corner (need to be implmented dynamicly)
		if (_player == 1) {
			_xpos = 30; _ypos = 310 + kind * 45;
		}else{
			_xpos = 610; _ypos = 150 - kind * 45;
			_direction = 3;
		}
	}
	
    /**
     * some methods for general ship functions
     */
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
    	_actualShipStatePercent -= (10 * strength) / _shield;
    	System.out.println("Ship: " +_actualShipStatePercent+"");
    }
    
    /**
     * methoden zur kollisionserkennung
     */
        
    public boolean isInSightRange(BattleShip actingbs, int range){
    	int x, y, width, heigth;
    	x = actingbs.getXPosition() - actingbs.getShipRangeOfSight() * 15;
    	y = actingbs.getYPosition() - actingbs.getShipRangeOfSight() * 15;
    	width = getShipImage().getWidth();
    	heigth = getShipImage().getHeight();
    	x -= range * 15;
    	y -= range * 15;
    	heigth += range * 15 * 2;
    	width += range * 15 * 2;
    	if (x > getXPosition() && x < (getXPosition() + width) && y > getYPosition() && y < (getYPosition() + heigth)) {
    		return true;
    	}else{
    		return false;
    	}
    }
    
    /**
     * graphical part of the ship
     */
    
    private BufferedImage getShipImage() {
    	if (_shippic == null) {
        	try {
        		_shippic = ImageIO.read(Utillib.getInputStreamFromJar(getShipPicture()));
    		} catch (IOException e) {
    			Error.addError(e, "Fehler beim Laden des Schiffbildes");
    		}
    	}
    	return _shippic;
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
}
