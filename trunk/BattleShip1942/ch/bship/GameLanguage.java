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
    
    static Properties props = new Properties();
    private String lang = Engine.language;
    
    public GameLanguage() {
        this.loadLangFile();
    }
    
    private void loadLangFile(){
    	lang = Engine.language;
    	try {
            props.load(new FileInputStream(lang));
        } catch (FileNotFoundException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }
    
    public String tr(String stringtotranslate){
    	// Wenn Sprache geändert hat muss das neue Langfile geladen werden
    	
    	if (Engine.language.equals(lang) == false){
    		loadLangFile();
    		System.out.println("lade neues langfile");
    	}
        String stringtr = props.getProperty(stringtotranslate); 
        return stringtr;
    }
}
