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

import java.io.*;
import java.util.Properties;

public class GameLanguage {
    
    private static Properties props = new Properties();
    private static GameLanguage _instance = null;
    private static String _lang = "german.lng";

    private static String[] _availableLanguages = new String[] 
        {"german", "english", "french"};
    
    public GameLanguage(String lang) {
        _lang = lang + ".lng";
        this.loadLangFile();
        _instance = this;
    }

    public static GameLanguage getInstance() {
        return getInstance(_lang);
    }

    public static GameLanguage getInstance(String lang) {
        if (_instance != null) {
            _instance.setLanguage(lang);
            return _instance;
        } else {
            _instance = new GameLanguage(lang);
            return _instance;
        }
    }

    public void setLanguage(String lang) {
        _lang = lang + ".lng";
        loadLangFile();
    }
        
    private void loadLangFile() {
    	//if (Engine.language == null) { Engine.language = "german.lng"; }
    	//lang = Engine.language;
    	try {
            FileInputStream fis = new FileInputStream(_lang);
            props.load(fis);
            fis.close();
        } catch (FileNotFoundException e) {
            //e.printStackTrace();
        } catch (IOException e) {
            //e.printStackTrace();
        }
    }
    
    public String tr(String stringToTranslate){
        String stringtr = props.getProperty(stringToTranslate); 

        //-----------zum testen-------------
        return stringToTranslate;
        //    return stringtr;
        ////////////////////////////////////
    }

    public String[] getLanguages() {
        return _availableLanguages;
    }
}
