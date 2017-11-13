package serial;

public class Job {
	
	// class containing primitives
	
	private String name;
	private String role;
	private int level;
	
	/**
	 * @param n : name
	 * @param r : role
	 * @param l : level
	 */
	public Job(String n, String r, int l) {
		setName(n);
		setRole(r);
		setLevel(l);
	}
	
	public void setName(String n) { name = n; }
	
	public String getName() { return name; }
	
	public void setRole(String r) { role = r; }
	
	public String getRole( ) { return role; }
	
	public void setLevel(int l) { 
		if(l>=0)
			level = l;
		else
			level = 1;
	}
	
	public int getLevel() { return level; }
	
}
