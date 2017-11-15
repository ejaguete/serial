package serial;

import java.io.BufferedOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStreamWriter;
import java.net.ServerSocket;
import java.net.Socket;

import org.jdom2.Document;
import org.jdom2.JDOMException;
import org.jdom2.input.SAXBuilder;
import org.jdom2.output.XMLOutputter;

public class Receiver {
	
	public static boolean objCreated = false;
	
	public static void main(String[] args) throws IOException {
		int port = 9000;
		ServerSocket socket = new ServerSocket(port);
		System.out.println("Server 'receiver' initialized");
		
		while(true) {
			// wait for client
			Socket connection = socket.accept();
			System.out.println("Received connection from client");
			
			InputStream is = connection.getInputStream();
			SAXBuilder parser = new SAXBuilder();
			Document doc=null;
			try {
				doc = parser.build(is);
				// deserialize the code
				// visualize it
			} catch (JDOMException e) {}
			is.close();

			String resp = "Server 'receiver' got object. Printing..." + (char) 13;

			if(doc!=null) {
				XMLOutputter xml = new XMLOutputter();
				xml.output(doc,System.out);
			}
			BufferedOutputStream os = new BufferedOutputStream(connection.getOutputStream());
			OutputStreamWriter ow = new OutputStreamWriter(os, "UTF-8");
			ow.write(resp);
			ow.flush();
			connection.close();
		}
		
		

	}

}
