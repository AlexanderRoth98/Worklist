package components;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.springframework.stereotype.Service;

import main.MainApplication;

@Service
public class TaskService {
	private List<String> managers = new ArrayList<String>(
			Arrays.asList("Alan Turing", "Jack Jackson", "Velma Dinkley"));
	private List<String> hrManagers = new ArrayList<String>(Arrays.asList("Alan Turing", "Peter Parker"));
	private List<String> raters = new ArrayList<String>(Arrays.asList("Jack Jackson", "Peter Parker", "Muriel Bagge"));
	private List<String> negociators = new ArrayList<String>(
			Arrays.asList("Jack Jackson", "Peter Parker", "Velma Dinkley","Muriel Bagge"));
	private List<String> reportConfirmers = new ArrayList<String>(
			Arrays.asList("Alan Turing", "Velma Dinkley", "Muriel Bagge"));

	private int managerCounter = 0;
	private int hrManagerCounter = 0;
	private int raterCounter = 0;
	private int negociatorCounter = 0;
	private int reportConfirmerCounter = 0;

	public void delegateTask(Task task, String step) {
		if (task.getRole().equals("Applicant")) {
			for (User user : MainApplication.users) {
				Applicant applicant = (Applicant) user;
				if (Integer.parseInt(step) == applicant.getStep()) {				
					applicant.addTask(task);
					applicant.setStep(applicant.getStep() + 1);				
					break;
				}
			}
		} else {

			switch (task.getRole()) {
			case "Manager":
				String userName = managers.get(managerCounter);

				for (User user : MainApplication.users) {
					if (user.getName().equals(userName)) {	
						user.addTask(task);
						break;
					}
				}

				if (managerCounter == managers.size() - 1)
					managerCounter = 0;
				else
					managerCounter++;

				break;

			case "HR-Manager":
				userName = hrManagers.get(hrManagerCounter);

				for (User user : MainApplication.users) {
					if (user.getName().equals(userName)) {
						user.addTask(task);
						break;
					}
				}

				if (hrManagerCounter == hrManagers.size() - 1)
					hrManagerCounter = 0;
				else
					hrManagerCounter++;
				break;

			case "Report Confirmer":
				userName = reportConfirmers.get(reportConfirmerCounter);

				for (User user : MainApplication.users) {
					if (user.getName().equals(userName)) {
						
						user.addTask(task);
						
						break;
					}
				}

				if (reportConfirmerCounter == reportConfirmers.size() - 1)
					reportConfirmerCounter = 0;
				else
					reportConfirmerCounter++;
				break;

			case "Rater":
				userName = raters.get(raterCounter);

				for (User user : MainApplication.users) {
					if (user.getName().equals(userName)) {
						
						user.addTask(task);
						
						break;
					}
				}

				if (raterCounter == raters.size() - 1)
					raterCounter = 0;
				else
					raterCounter++;
				break;

			case "Negociator":
				userName = negociators.get(negociatorCounter);

				for (User user : MainApplication.users) {
					if (user.getName().equals(userName)) {
						
						user.addTask(task);
						
						break;
					}
				}

				if (negociatorCounter == negociators.size() - 1)
					negociatorCounter = 0;
				else
					negociatorCounter++;
				break;

			}

		}
	}

}
