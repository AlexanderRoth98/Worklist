package components;

import java.util.Iterator;
import java.util.List;

import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import main.MainApplication;

@CrossOrigin
@RestController
public class AppController {

	@Autowired
	EmailService emailService;

	@Autowired
	TaskService taskService;

	@RequestMapping(value = "worklist/items")
	public String worklistItems(@RequestHeader("CPEE-CALLBACK") String uiLink, HttpServletResponse response,
			@RequestParam String role, @RequestParam String label, @RequestParam String step) {

		Task task = new Task(uiLink, role, label);
		taskService.delegateTask(task, step);

		response.addHeader("CPEE-CALLBACK", "true");

		return "Important work in progress";
	}

	@RequestMapping(value = "/sendEmail")
	public void sendEmail(@RequestParam String sendTo, @RequestParam String confirmed) {

		if (confirmed.equals("true")) {
			System.out.println("Confirmed email send to: " + sendTo);
			emailService.sendEmail(sendTo, "Confirmation", "Job application confirmed!");
		} else {
			System.out.println("Deny email send to: " + sendTo);
			emailService.sendEmail(sendTo, "Not confirmed", "Job application NOT confirmed!");
		}

	}

	@RequestMapping(value = "/sendJobOffer")
	public void sendJobOffer(@RequestParam String sendTo) {
		System.out.println("Job offer send to: " + sendTo);
		emailService.sendEmail(sendTo, "Job offer", "Here is your job offer!");

	}

	@RequestMapping(value = "/startProbationPhase")
	public String startProbationPhase(@RequestParam String contractSigned) {
		if (contractSigned.equals("true")) {
			System.out.println("Probation phase started!");
			return "true";
		} else {
			return "false";
		}

	}

	@RequestMapping(value = "/checkRating")
	public String checkRating(@RequestParam String rating) {
		if (rating.equals("A") || rating.equals("B")) {
			System.out.println("Rating is ok!");
			return "true";
		} else {
			System.out.println("Rating is not ok!");
			return "false";
		}

	}

	@RequestMapping(value = "/jobBecomesPermanent")
	public String jobBecomesPermanent(@RequestParam String ratingOk) {

		if (ratingOk.equals("true")) {
			System.out.println("Job becomes permanent!");
			return "true";
		} else {
			return "false";
		}

	}

	@RequestMapping(value = "/users")
	public List<User> getUsers() {
		return MainApplication.users;
	}

	@RequestMapping(value = "/giveBack/{userName}/{taskLabel}")
	public void giveBack(@PathVariable(value = "userName") String userName,
			@PathVariable(value = "taskLabel") String taskLabel) {
		Task giveTask = new Task();

		for (User user : MainApplication.users) {
			if (user.getName().equals(userName)) {
				for (Iterator<Task> it = user.getTasks().iterator(); it.hasNext();) {
					Task task = it.next();
					if (task.getLabel().equals(taskLabel)) {
						giveTask = task;
						it.remove();
					}
				}
			}

		}

		this.taskService.delegateTask(giveTask, "0");

	}
	@RequestMapping(value = "/finished/{userName}/{taskLabel}")
	public void finished(@PathVariable(value = "userName") String userName,
			@PathVariable(value = "taskLabel") String taskLabel) {
		
		for (User user : MainApplication.users) {
			if (user.getName().equals(userName)) {
				for (Iterator<Task> it = user.getTasks().iterator(); it.hasNext();) {
					Task task = it.next();
					if (task.getLabel().equals(taskLabel)) {
						it.remove();
					}
				}
			}

		}


	}

}
