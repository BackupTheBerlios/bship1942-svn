/**
 * @author Adrian Greiler, Marcel Ryser
 * 
 * PROJECT: Battleship 1942
 *
 * Changelog:
 * 
 * 26.08.2004	MR		Erstellung
 * 
 */

package ch.bship;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

public class GameLanguage {
    
    private static Properties props = new Properties();
    private static GameLanguage _instance = null;
    private static String _lang = "german";

    private static String[] _availableLanguages = new String[] 
        {"german", "english", "french"}; // In future need to be dynamic perhaps
    
    public GameLanguage(String lang) {
    	setLanguage(lang);
        this.loadLangFile();
        _instance = this;
    }
    
    /**
     * getter and setters
     */
    public String[] getLanguages() { return _availableLanguages; }
    private static String getLanguage() { return _lang; };
    public void setLanguage(String lang) { _lang = lang; loadLangFile(); }
    
    /**
     * get instance of a GameLanguage
     */
    public static GameLanguage getInstance() {
        return getInstance(getLanguage());
    }

    public static GameLanguage getInstance(String lang) {
        if (_instance != null) {
            _instance.setLanguage(lang);
        } else {
            _instance = new GameLanguage(lang);
        }
        return _instance;
    }
    
    /**
     * loading the properties file to Properties hashtable
     */
    private void loadLangFile() {
    	try {
            FileInputStream fis = new FileInputStream(getLanguage() + ".lng");
            props.load(fis);
            fis.close();
        } catch (FileNotFoundException e) {
            Error.addError(e, "Sprachdatei " + getLanguage() + ".lng nicht gefunden");
        } catch (IOException e) {
            Error.addError(e, "Eingabe-/Ausgabefehler");
        }
    }
    
    /**
     * translates a string to the specified language
     */
    public String tr(String stringToTranslate){
        return props.getProperty(stringToTranslate); 
    }

    
}
