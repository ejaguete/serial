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
import org.jdom2.output.Format;
import org.jdom2.output.XMLOutputter;

public class Receiver {
	
	public static boolean objCreated = false;
	
	public static void main(String[] args) throws IOException {
		int port = 9000;
		ServerSocket socket = new ServerSocket(port);
		System.out.println("RECEIVER : server initialized");
		
		while(true) {
			// wait for client
			Socket connection = socket.accept();
			System.out.println("RECEIVER : received connection from client");
			
			InputStream is = connection.getInputStream();
			SAXBuilder parser = new SAXBuilder();
			Inspector inspect = new Inspector();
			Deserializer ds = new Deserializer();
			Document doc=null;
			System.out.println("RECEIVER : attempting to deserialize...");
			try {

				doc = parser.build(is);
				System.out.println("RECEIVER : deserializing...");
				Object ob = ds.deserialize(doc);
				XMLOutputter out = new XMLOutputter();
				out.setFormat(Format.getPrettyFormat());
				out.output(doc, System.out);
				/*
				System.out.println("RECEIVER : inspecting...");
				inspect.inspect(ob,false);
				*/
				
			} catch (JDOMException e) {
				e.printStackTrace();
			} catch (Exception e) {
				e.printStackTrace();
			}
			is.close();
			
			connection.close();
		}
		
		

	}

}
