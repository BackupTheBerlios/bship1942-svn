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
    
    /**
     * Language
     * 1 = German
     * 2 = English
     * 3 = French
     */
    
    static String langfile[] = {"german.lng","english.lng","french.lng"};
    private static int langid = 0;
    static Properties props = new Properties();
    
    public GameLanguage() {
        try {
            props.load(new FileInputStream(langfile[langid]));
        } catch (FileNotFoundException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }
    
    public static void setLanguage(int lid) {
        langid = lid;
    }
    
    public String tr(String stringtotranslate){
        String stringtr = props.getProperty(stringtotranslate); 
        return stringtr;
    }
}
