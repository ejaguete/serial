package serial;

import java.awt.EventQueue;
import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.net.InetAddress;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import java.util.Arrays;

public class Sender {
	
	public static String host = "localhost";
	public static int port = 9000;
	
	public static ArrayList<Object> objects = new ArrayList<Object>();
	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) throws IOException {
		
		// create objects & store in array
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Creator window = new Creator();
					window.frmObjectCreator.setVisible(true);
			
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
		
		System.out.println("Client 'sender' initialized");
		// request socket connection
		try {
			InetAddress address = InetAddress.getByName(host);
			Socket connection = new Socket(address, port);
			BufferedOutputStream os = new BufferedOutputStream(connection.getOutputStream());
			OutputStreamWriter ow = new OutputStreamWriter(os, "US-ASCII");
			String msg = "Calling server" + (char) 13;
			ow.write(msg);
			ow.flush();

			StringBuffer buf = new StringBuffer();
			// read from socket
			BufferedInputStream is = new BufferedInputStream(connection.getInputStream());
			InputStreamReader ir = new InputStreamReader(is, "US-ASCII");
			
			int c;
			while((c=ir.read())!=13)
				buf.append((char) c);
			
			connection.close();
			System.out.println(buf);
		} finally {}
		
		
	}

}
