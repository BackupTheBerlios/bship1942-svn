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
import java.util.*;
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
	private String _name;
	private String _pathToImage;
	private GameLanguage translator = new GameLanguage();
	
	
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
	 * sets the current position of the ship
	 *
	 * @param alignment
	 */
	public void setPosition(Vector position) {
		_positions = position;
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
}
