/**
 * @author Adrian Greiler, Marcel Ryser
 * 
 * PROJECT: Battleship 1942
 *
 * Changelog:
 * 
 * 24.08.2004	MR		Erstellung
 * 
 */
package ch.bship;

public class Error {

	/**
	 * method to add an important error
	 */
	public static void addError(Exception ex, String errortext) {
		String shmsg;
		if (!errortext.equals("")){
			shmsg = errortext;
		}else{
			shmsg = "Es ist ein Fehler aufgetreten!";
		}
		ErrorDialog ed = new ErrorDialog("Fehler", ErrorDialog.ERROR_MESSAGE, shmsg, getStackTrace(ex));
		ed.setVisible(true);
	}
	
	/**
	 * method to add an informationdialog single lined
	 */
	public static void addInformation(String string) {
		ErrorDialog ed = new ErrorDialog("Info", ErrorDialog.INFO_MESSAGE, "Achtung!", string);
		ed.setVisible(true);
	}
	
	/** 
	 * creates a string with the stacktrace of the given exception
	 */
	private static String getStackTrace(Exception b){
		String stacktext = b.getMessage() + "\n";
		
		StackTraceElement[] stack = b.getStackTrace();
		for (int i = 0; i < stack.length; i++) {
			StackTraceElement stackelement = stack[i];
			stacktext += "   at " + stackelement.toString() + "\n";
		}
		return stacktext;
	}	
}