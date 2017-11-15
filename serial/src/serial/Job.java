package serial;

public class Job {
	
	// class containing primitives
	
	private String name;
	private int level;

	public Job() {
		name = "";
		level = -1;
	}
	
	/**
	 * @param n : name
	 * @param r : role
	 * @param l : level
	 */
	public Job(String n, int l) {
		setName(n);
		setLevel(l);
	}
	
	public void setName(String n) { name = n; }
	
	public String getName() { return name; }
	
	public void setLevel(int l) { 
		if(l>=1)
			level = l;
		else
			level = 1;
	}
	
	public int getLevel() { return level; }
	
}
