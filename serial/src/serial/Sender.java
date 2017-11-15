package serial;

import java.awt.EventQueue;
import java.io.BufferedInputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.InetAddress;
import java.net.Socket;
import java.util.ArrayList;

import org.jdom2.Document;
import org.jdom2.output.XMLOutputter;

public class Sender {
	
	public static ArrayList<Object> objects = new ArrayList<Object>();
	public static boolean finished = false;
	
	/**
	 * Launch the application.
	 * @throws Exception 
	 */
	public static void main(String[] args) throws Exception {
		
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
		
		// wait for user to create objects
		while(!finished) {}
		System.out.println("Object created. Sending...");
		
		String host = "localhost";
		int port = 9000;
		System.out.println("Client 'sender' initialized");
		Serializer s = new Serializer();
		// request socket connection
		try {
			
			
			InetAddress address = InetAddress.getByName(host);
			Socket connection = new Socket(address, port);
			OutputStream os = connection.getOutputStream();
			
			
			// write to socket
			for(Object o : objects) {
				Document doc = s.serialize(o);
				try {
					XMLOutputter out = new XMLOutputter();
					out.output(doc, os);
					os.flush();
					
				} finally {}

			StringBuffer buf = new StringBuffer();
			// read from server socket
			BufferedInputStream is = new BufferedInputStream(connection.getInputStream());
			InputStreamReader ir = new InputStreamReader(is, "UTF-8");

			//connection.close();
			System.out.println(buf);
		} 
	} finally {}

	}
}
