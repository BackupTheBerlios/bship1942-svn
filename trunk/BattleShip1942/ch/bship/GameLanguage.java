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
    	if (Engine.language == null) { Engine.language = "german.lng"; }
    	lang = Engine.language;
    	try {
    		FileInputStream fis = new FileInputStream(lang);
            props.load(fis);
            fis.close();
        } catch (FileNotFoundException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }
    
    public String tr(String stringtotranslate){
    	if (Engine.language.equals(lang) == false){
    		props.clear();
    		loadLangFile();
    	}
        String stringtr = props.getProperty(stringtotranslate); 
        return stringtr;
    }
}
