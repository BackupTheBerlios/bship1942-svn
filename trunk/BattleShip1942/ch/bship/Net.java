/**
 * @author Adrian Greiler, Marcel Ryser
 * 
 * PROJECT: Battleship 1942
 * 
 * Changelog:
 * 
 * 26.08.2004 AG Erstellung
 *  
 */

package ch.bship;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;



public class Net extends Thread {

	private Engine _engine;
	private InputStream _in = null;
	private OutputStream _out = null;
	private Socket _con = null;
	private ServerSocket _s = null;
	private String _ip;
	public static String MSG_HELLO = "HELLO";
	public static String MSG_RESPONSE = "RESPONSE";
	public static String MSG_CHAT = "MSG";
	public static String MSG_SYNC = "SYNC";

	public Net(Engine engine) {
		_engine = engine;
		start();
	}
	
	public void setIP(String ip) { _ip = ip; }

	public void closeAll() {
		try {
			if (_in != null)
				_in.close();
			if (_out != null)
				_out.close();
			if (_con != null)
				_con.close();
		} catch (IOException e) {
			Error.addError(e, "Ein-/Ausgabefehler");
		}
	}

	public void run() {
		try {
			_s = new ServerSocket(8888);
			String n = _s.getInetAddress().toString();
			System.out.println("name = " + n + " " + _s.getLocalPort());
		} catch (Exception e) {
			Error.addError(e, "Es ist ein Fehler beim erstellen des Socket aufgetreten");
		}
		while (true) {
			try {
				_con = _s.accept();
				setIP(_con.getInetAddress().toString().substring(1,
						_con.getInetAddress().toString().length()));
				byte b[] = new byte[2048];
				int anzahl = _con.getInputStream().read(b);
				String msg = new String(b, 0, anzahl);
				System.out.println(" <- " + msg);
				_engine.Eventhandler(msg);
			} catch (Exception e) {
				Error.addError(e, "Fehler beim abhören");
			}
		}
	}

	public void send(String msg) {
		System.out.println(" -> " + msg + " to " + _ip);
		try {
			Socket _s = new Socket(_ip, 8888);
			_s.getOutputStream().write(msg.getBytes());
		} catch (IOException e) {
			Error.addError(e, "Konnte TCP Nachricht nicht senden");
		}
	}
}