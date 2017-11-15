package serial;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.InetAddress;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;

import org.jdom2.input.SAXBuilder;

public class Receiver {
	
	public static void main(String[] args) throws IOException {
		ServerSocket socket = new ServerSocket(Sender.port);
		System.out.println("Server 'receiver' initialized");
		int ch;
		
		while(true) {
			Socket connection = socket.accept();
			
			BufferedInputStream is = new BufferedInputStream(connection.getInputStream());
			InputStreamReader ir = new InputStreamReader(is);
			StringBuffer buf = new StringBuffer();
			
			// read input stream 
			while((ch=ir.read())!=13)
				buf.append((char) ch);
			
			System.out.println(buf);
			
			String resp = "Server 'receiver' responded" + (char) 13;
			BufferedOutputStream os = new BufferedOutputStream(connection.getOutputStream());
			OutputStreamWriter ow = new OutputStreamWriter(os, "US-ASCII");
			ow.write(resp);
			ow.flush();
		}
		
		

	}

}
