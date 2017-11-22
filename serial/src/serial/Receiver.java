package serial;

import java.io.InputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;

import org.jdom2.Document;
import org.jdom2.JDOMException;
import org.jdom2.input.SAXBuilder;

public class Receiver {
	static ArrayList<Object> objects = new ArrayList<Object>();
	
	public static void main(String[] args) throws Exception {
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
				Object o = ds.deserialize(doc);
				System.out.println("RECEIVER : inspecting...");
				inspect.inspect(o,false);
				if(ds.table.size()>1) {
					for(int i=1;i<ds.table.size();i++)
						inspect.inspect(ds.table.get(Integer.toString(i)), false);
				}
				
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
