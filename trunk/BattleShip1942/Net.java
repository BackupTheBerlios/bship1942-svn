// Net-Modul
// Autor: Adrian Greiler
// Datum 2.1.2004

import java.io.*;
import java.net.*;

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