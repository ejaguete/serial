package serial;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;

import java.util.ArrayList;

import org.junit.Test;

public class Tests {
	
	@Test
	public void test_Job_createJob() {
		Job drk = new Job("drk", "tank", 50);
		
		assertEquals("drk", drk.getName());
		assertEquals("tank", drk.getRole());
		assertEquals(50, drk.getLevel());
	}
	
	@Test
	public void test_Job_negativeLevel() {
		String name = "drk";
		String role = "tank";
		int level = -10;
		Job drk = new Job(name,role,level);
		
		assertEquals(1, drk.getLevel());
	}
	
	@Test
	public void test_Player_createPlayerWithoutJobArray() {
		Player noct = new Player("Noctis");
		
		assertEquals("Noctis", noct.getName());
		assertNull(noct.getJob("drk"));
	}
	
	@Test
	public void test_Player_createPlayerWithJobArray() {
		Job drk = new Job("drk", "tank", 50);
		ArrayList<Job> js = new ArrayList<Job>();
		js.add(drk);
		Player noct = new Player("Noctis", js);
		
		assertEquals("Noctis", noct.getName());
		assertEquals(drk, noct.getJob("drk"));
	}
	
	@Test
	public void test_Player_addOneJob() {
		Job drk = new Job("drk", "tank", 50);
		Player noct = new Player("Noctis");
		noct.addJob(drk);
		
		assertEquals(drk, noct.getJob("drk"));
	}
	
	@Test
	public void test_Player_addMultipleJobs() {
		Job drk = new Job("drk", "tank", 50);
		Job ast = new Job("ast", "healer", 50);
		Job rdm = new Job("rdm", "dps", 20);
		Player noct = new Player("Noctis");
		noct.addJob(drk);
		noct.addJob(ast);
		noct.addJob(rdm);
		
		assertEquals(ast, noct.getJob("ast"));
	}
	
	@Test
	public void test_Player_addTheSameJob() {
		Job drk = new Job("drk", "tank", 50);
		Job ast = new Job("ast", "healer", 50);
		Job rdm = new Job("rdm", "dps", 20);
		Player noct = new Player("Noctis");
		noct.addJob(drk);
		noct.addJob(ast);
		noct.addJob(rdm);
		noct.addJob(drk);
		
		assertEquals(3, noct.getJobListSize());
	}
	
	@Test
	public void test_Player_removeJobs() {
		Job drk = new Job("drk", "tank", 50);
		Job ast = new Job("ast", "healer", 50);
		Job rdm = new Job("rdm", "dps", 20);
		Player noct = new Player("Noctis");
		noct.addJob(drk);
		noct.addJob(ast);
		noct.addJob(rdm);
		noct.removeJob("drk");
		noct.removeJob("rdm");
		
		assertEquals(1, noct.getJobListSize());
		assertEquals(ast, noct.getJob("ast"));
	}
	
	@Test 
	public void test_Party_createNullParty() {
		Party p = new Party();
		assertNull(p.getTank());
		assertNull(p.getHealer());
		assertNull(p.getDPS1());
		assertNull(p.getDPS2());
	}
	
	@Test 
	public void test_Party_createFullParty() {
		Player noct = new Player("Noctis");
		Player prom = new Player("Prompto");
		Player gladio = new Player("Gladiolus");
		Player iggy = new Player("Ignis");	
		Party p = new Party(gladio, iggy, noct, prom);
		
		assertEquals(gladio, p.getTank());
		assertEquals(iggy, p.getHealer());
		assertEquals(noct, p.getDPS1());
		assertEquals(prom, p.getDPS2());
	}
	
	@Test 
	public void test_Party_createNotFullParty() {
		Player noct = new Player("Noctis");
		Player iggy = new Player("Ignis");	
		Party p = new Party(null, iggy, noct, null);
		
		assertEquals(null, p.getTank());
		assertEquals(iggy, p.getHealer());
		assertEquals(noct, p.getDPS1());
		assertEquals(null, p.getDPS2());
	}
	
	@Test
	public void test_ILevels_createILevels_array8() {
		int[] lv = {1,2,3,4,5,6,7,8};
		ILevels ilv = new ILevels(lv);
		
		for(int i=0;i<ilv.getILevels().length;i++)
			assertEquals(lv[i], ilv.getPlayerIlevel(i));
	}
	
	@Test
	public void test_ILevels_createILevels_array2() {
		int[] lv = {1,2};
		ILevels ilv = new ILevels(lv);
		
		assertEquals(lv[0], ilv.getPlayerIlevel(0));
		assertEquals(lv[1], ilv.getPlayerIlevel(1));
		for(int i=2;i<ilv.getILevels().length;i++)
			assertEquals(-1, ilv.getPlayerIlevel(i));
	}
	
	@Test
	public void test_ILevels_createILevels_array10() {
		int[] lv = {1,2,3,4,5,6,7,8,9,10};
		ILevels ilv = new ILevels(lv);

		for(int i=0;i<ilv.getILevels().length;i++)
			assertEquals(lv[i], ilv.getPlayerIlevel(i));
	}
	
	@Test
	public void test_Alliance_createAlliance() {
		Player noct = new Player("Noctis");
		Player prom = new Player("Prompto");
		Player gladio = new Player("Gladiolus");
		Player iggy = new Player("Ignis");	
		Party a = new Party(noct, prom, gladio, iggy);
		Party b = new Party(prom, gladio, noct, null);
		Party c = new Party(null, null, iggy, null);
		
		Alliance all = new Alliance(a,b,c);
		assertEquals(a, all.getParty(0));
		assertEquals(b, all.getParty(1));
		assertEquals(c, all.getParty(2));
	}
	
	@Test
	public void test_Alliance_setParty() {
		Player noct = new Player("Noctis");
		Player prom = new Player("Prompto");
		Player gladio = new Player("Gladiolus");
		Player iggy = new Player("Ignis");	
		Party a = new Party(noct, prom, gladio, iggy);
		Party b = new Party(prom, gladio, noct, null);
		Party c = new Party(null, null, iggy, null);
		
		Alliance all = new Alliance(a,b,c);
		all.setParty(1, a);
		all.setParty(0, b);
		assertEquals(b, all.getParty(0));
		assertEquals(a, all.getParty(1));
		assertEquals(c, all.getParty(2));
	}

}
