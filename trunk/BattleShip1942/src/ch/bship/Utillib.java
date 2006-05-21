/**
 * @author Adrian Greiler, Marcel Ryser
 * 
 * PROJECT: Battleship 1942
 *
 * Changelog:
 * 
 * 27.08.2004	MR		Erstellung
 * 
 */
package ch.bship;

import java.io.IOException;
import java.io.InputStream;
import java.net.URL;

public class Utillib {

	/**
	 * Lädt eine Datei aus einem Jar-File und gibt sie als InputStream zurück
	 *
	 * @param fileName Der Name der Datei. (Ist case-sensitive!).
	 *
	 * @throws IOException Wenn ein Fehler beim Laden der Datei auftrat.
	 */
	public static InputStream getInputStreamFromJar(String fileName) throws IOException {
		if (fileName == null)
			throw new IllegalArgumentException("fileName == null");
		if (fileName.length() == 0)
			throw new IllegalArgumentException("fileName is empty");

		// Der Dateiname muss mit einem '/' anfangen, sonst wird er nicht gefunden.
		if ((fileName.charAt(0) != '/') && (fileName.charAt(0) != '\\')) {
			fileName = "/" + fileName;
		}
		
		InputStream in;
		in = Engine.class.getResourceAsStream(fileName);
		if (in == null) {
			throw new IOException("Resource not found: '" + fileName + "'");
		}
		return in;
	}
	
	
	
	/**
	 * gives back the jarname of file with given class
	 */
	public static String getJarName(Class c) {
	      String resource = c.getName().replace('.', '/') + ".class";
	      URL url = c.getClassLoader().getResource(resource);
	        if (url != null && url.toString().startsWith("jar")) {
	            String u = url.toString();
	            int endjarname = u.indexOf("!");
	            int startjarname = u.substring(0, endjarname).lastIndexOf("/")+1;
	            return u.substring(startjarname, endjarname);
	        }
	        return null;
	    }
}