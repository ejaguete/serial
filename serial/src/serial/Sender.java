package serial;

import java.awt.EventQueue;
import java.io.OutputStream;
import java.net.InetAddress;
import java.net.Socket;
import java.util.ArrayList;

import org.jdom2.Document;
import org.jdom2.output.Format;
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
		while(true) {
			System.out.println("...");
			Thread.sleep(5000);
			if(finished)
				break;
		}
		
		System.out.println("SENDER : objects created. Sending...");
	
		String host = "localhost";
		int port = 9000;
		System.out.println("SENDER : client initialized");
		
		 
		Serializer s = new Serializer();
		// request socket connection
		try {
			
			InetAddress address = InetAddress.getByName(host);
			Socket connection = new Socket(address, port);
			OutputStream os = connection.getOutputStream();
			
			Document doc = null;
			

			// serialize objects
			for(Object o : objects)
				doc = s.serialize(o);

			try {
				XMLOutputter out = new XMLOutputter();
				out.setFormat(Format.getPrettyFormat());
				out.output(doc, os);
				
			} finally {
				os.flush();
				connection.close();
			}

		} finally {}
	}
}
