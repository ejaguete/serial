package serial;

import java.util.Scanner;

import org.jdom2.output.Format;
import org.jdom2.output.XMLOutputter;
public class Creator {
	
	public static void print(String s) { System.out.println(s); }
	
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
		//Scanner in = new Scanner(System.in);
		//print("Which object would you like to create?");
		
		String name = "drk";
		String role = "tank";
		int level = 50;
		Job drk = new Job(name,role,level);
		
		Serializer ser = new Serializer();
		
		try {
			print(new XMLOutputter(Format.getPrettyFormat()).outputString(ser.serialize(drk)));
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		
	}
}
