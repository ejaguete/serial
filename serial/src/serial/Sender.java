package serial;

import java.awt.EventQueue;
import java.util.ArrayList;
import java.util.Arrays;

public class Sender {
	
	public static ArrayList<Object> objects = new ArrayList<Object>();
	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
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
	}

}
