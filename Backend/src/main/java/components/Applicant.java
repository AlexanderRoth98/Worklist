package components;

import java.util.List;

public class Applicant extends User {

	private int step;

	public Applicant(String name, List<String> role, List<Task> tasks, int step) {
		super(name, role, tasks);
		this.step = step;
	}

	public int getStep() {
		return step;
	}

	public void setStep(int step) {
		this.step = step;
	}
	
	
}
