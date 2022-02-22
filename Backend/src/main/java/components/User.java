package components;

import java.util.ArrayList;
import java.util.List;

public class User {

	private String name;
	private List<String> role;
	private List<Task> tasks;

	public User(String name, List<String> role, List<Task> tasks) {
		super();
		this.name = name;
		this.role = role;
		this.tasks = tasks;
	}

	

	public User() {
		super();
	}


	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public List<String> getRole() {
		return role;
	}

	public void setRole(List<String> role) {
		this.role = role;
	}

	public List<Task> getTasks() {
		return tasks;
	}

	public void setTasks(List<Task> tasks) {
		this.tasks = tasks;
	}

	public void addTask(Task task) {
		if (this.tasks == null) {
			this.tasks = new ArrayList<Task>();
			this.tasks.add(task);
		} else {
			this.tasks.add(task);
		}
	}

}
