/**
 * @author Adrian Greiler, Marcel Ryser
 *
 * PROJECT: Battleship 1942
 *
 * Changelog:
 *
 * 26.08.2004   AG      Erstellung
 *
 */
package ch.bship;
import java.io.*;
import java.net.*;

public class Net extends Thread{
	Engine engine;
	
	InputStream 	_in = null;
	OutputStream 	_out = null;
	Socket 		_con = null;
	ServerSocket 	_s = null;
	String 		_ip;

	public Net(Engine engine){
		this.engine = engine;	
	}
	
	public void closeAll() {
		try {
			if (_in != null)
				_in.close(); 
			if (_out != null)
				_out.close(); 
			if (_con != null)
				_con.close(); 
		} catch (IOException e) {
			System.err.println (" " + e);
		}
	}

	public void run () {
		try {
			_s = new ServerSocket (8888);
    	  	String n = _s.getInetAddress ().toString ();
     	   	System.out.println ("name = " + n + " " + _s.getLocalPort ());
		} catch ( Exception e){
			System.err.println (e);
		}
		while (true) {
			try {
				_con = _s.accept ();			
				byte b[]=new byte [2048];
				int anzahl=_con.getInputStream().read(b);
				String msg = new String(b, 0, anzahl);
				engine.Eventhandler(msg);				
			} catch(Exception e){
				System.err.println (e);
			}
		}     
	}	 
		
	public void send (String msg) {
		try {			
			Socket _s= new Socket(_ip, 8888);
			_s.getOutputStream().write(msg.getBytes());	
		} catch (IOException e) {
			System.err.println (e);
		}	
	}

	public void setIP (String ip) {
		_ip = ip;
	}
}
