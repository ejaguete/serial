package serial;

import java.util.InputMismatchException;
import java.util.Scanner;

import org.jdom2.output.Format;
import org.jdom2.output.XMLOutputter;
public class Creator {
	
	public static void print(String s) { System.out.println(s); }
	
	// change this to run() in final program
	public static void main(String[] args) {
	/*
		 TODO:
		 > create object with primitive fields
				> job
				> contains job role/stats
		 > create object with object refs
				> party
				> references to party members (max 4)
		 > create object containing array of primitives
				> ilevels of players
		 > create object containing array of object refs
		 		> list of parties (alliance)
		 		> references to party objects
		 > create object that uses a collection class to refer to other objects
				> party member
				> references to job objects
	*/
		Scanner in = new Scanner(System.in);
		print("Specify class:");
		print("(a) Job : contains only primitives");
		print("(b) Party : contains object references");
		print("(c) ILevels : contains an array of primitives");
		print("(d) Alliance : contains an array of object references");
		print("(e) Player : contains a collection of object references");
		
		while(true) {
			try {
				char input = in.next("[a-eA-E]").charAt(0);
				print(input+"");
				break;
			} catch(InputMismatchException e) {
				print("Invalid input. Please choose one of the options above.");
				in.next();
			}
			
		}
		
	}
}
