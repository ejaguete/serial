package serial;

import java.util.ArrayList;

public class Player {
	
	// object using a collection class to refer to other objects
	
	private String name;
	private ArrayList<Job> jobs = new ArrayList<Job>();
	
	public Player(String n) {
		setName(n);
	}
	
	public Player(String n, ArrayList<Job> js) {
		setName(n);
		setJobs(js);
	}
	
	public void setName(String n) { name = n; }
	
	public String getName() { return name; }
	
	public void setJobs(ArrayList<Job> js) {
		jobs = js;
	}
	
	public void addJob(Job j) {
		if(!jobs.contains(j))
		jobs.add(j);
	}
	
	public Job getJob(String jobName) {
		Job j = null;
		for (Job job : jobs) {
			if(job.getName()==jobName) {
				j = job;
				break;
			}
		}
		return j;
	}
	
	public void removeJob(String jobName) {
		for (Job j : jobs) {
			if(j.getName()==jobName) {
				jobs.remove(jobs.indexOf(j));
				break;
			}
		}
	}
	
	public int getJobListSize() { return jobs.size(); }

}
