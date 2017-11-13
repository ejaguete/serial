package serial;

public class Party {

	// class containing object refs
	
	private Player tank;
	private Player healer;
	private Player dps1;
	private Player dps2;
	
	public Party() {
		tank = null;
		healer = null;
		dps1 = null;
		dps2 = null;
	}
	
	/**
	 * @param t : tank
	 * @param h : healer
	 * @param d1 : first dps
	 * @param d2 : second dps
	 */
	public Party(Player t, Player h, Player d1, Player d2) {
		setTank(t);
		setHealer(h);
		setDPS1(d1);
		setDPS2(d2);
	}
	
	public void setTank(Player t) { tank = t; }
	
	public Player getTank() { return tank; }
	
	public void setHealer(Player h) { healer = h; }
	
	public Player getHealer() { return healer; }
	
	public void setDPS1(Player d) { dps1 = d; }
	
	public Player getDPS1() { return dps1; }
	
	public void setDPS2(Player d) { dps2 = d; }
	
	public Player getDPS2() { return dps2; }
}
