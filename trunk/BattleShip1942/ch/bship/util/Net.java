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

package ch.bship.util;

import java.io.*;
import java.net.*;
import ch.bship.*;

public class Net extends Thread{
	Engine engine;
	
	InputStream 		in = null;
	OutputStream		out = null;
	Socket				con = null;
	ServerSocket 		s = null;

	public Net(Engine engine){
		this.engine = engine;
	}
	
	public void closeAll() {
		try {
			if (in != null)
				in.close(); 
			if (out != null)
				out.close(); 
			if (con != null)
				con.close(); 
		} catch (IOException e) {
			System.err.println (" " + e);
		}
	}

	public void run () {
		try {
			s = new ServerSocket (8888);
    	  	String n = s.getInetAddress ().toString ();
     	   	System.out.println ("name = " + n + " " + s.getLocalPort ());
		} catch ( Exception e){
			System.err.println (e);
		}
		while (true) {
			try {
				con = s.accept ();			
				byte b[]=new byte [2048];
				int anzahl=con.getInputStream().read(b);
				String msg = new String(b, 0, anzahl);
				engine.Eventhandler(msg);				
			} catch(Exception e){
				System.err.println (e);
			}
		}     
	}	 
		
	public void send (String ip, String msg) {
		try {			
			Socket s= new Socket(ip, 8888);
			s.getOutputStream().write(msg.getBytes());	
		} catch (IOException e) {
			System.err.println (e);
		}	
	}
}