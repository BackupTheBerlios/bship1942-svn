package ch.bship;

/**
 * @author metawave.ch
 * A Class to display Errors, Infos, Orders ...
 * 
 */
public class Error {

	/**
	 * @param string
	 */
	public static void addError(Exception b, String string) {
		String shmsg;
		if (!string.equals("")){
			shmsg = string;
		}else{
			shmsg = "Es ist ein Fehler aufgetreten!";
		}
		ErrorDialog ed = new ErrorDialog("Fehler", ErrorDialog.ERROR_MESSAGE, shmsg, getStackTrace(b));
		ed.setVisible(true);
	}
	
	public static void addInformation(String string) {
		ErrorDialog ed = new ErrorDialog("Info", ErrorDialog.INFO_MESSAGE, "Achtung!", string);
		ed.setVisible(true);
	}
	
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