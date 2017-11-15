
package serial;

public class Ilevels {
	
	// class containing array of primitives
	private final int MAX = 8;
	private int[] players = new int[MAX];
	
	public Ilevels() {
		for(int ilvl : players)
			ilvl = -1;
	}
	
	/**
	 * @param ilvls : array of max length 8
	 */
	public Ilevels(int[] ilvls) {
		if(ilvls.length>MAX) {
			for(int i=0;i<players.length;i++)
				players[i] = ilvls[i];
		}
		else if(ilvls.length==MAX)
			players = ilvls;
		else {
			int i=0;
			while(i<ilvls.length) {
				players[i] = ilvls[i];
				i++;
			}
				
			while(i<players.length) {
				players[i] = -1;
				i++;
			}
		}
	}
	
	public void setPlayerIlvl(int index, int ilvl) {
		if(ilvl>=0)
			players[index] = ilvl;
		else
			players[index] = -1;
	}
	
	public int[] getILevels() { return players; }
	
	public int getPlayerIlevel(int index) { return players[index]; }

}
