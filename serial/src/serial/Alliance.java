package serial;

public class Alliance {

	// class containing array of object refs
	
	private Party[] parties = new Party[3];
	
	public Alliance() {}
	
	public Alliance(Party a, Party b, Party c) {
		parties[0] = a;
		parties[1] = b;
		parties[2] = c;
	}
	
	public void setParty(int index, Party p) {
		parties[index] = p;
	}
	
	public Party getParty(int index) { return parties[index]; }

}
