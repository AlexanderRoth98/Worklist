package main;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;
import org.springframework.context.annotation.ComponentScan;

import components.Applicant;
import components.User;

@ComponentScan(basePackages = "components")
@SpringBootApplication
public class MainApplication extends SpringBootServletInitializer {

	
	public static List<User> users = new ArrayList<User>();

	@Override
	protected SpringApplicationBuilder configure(SpringApplicationBuilder application) {
		return application.sources(MainApplication.class);
	}

	public static void main(String[] args) {

		SpringApplication.run(MainApplication.class, args);
		
	
		
		Applicant alex = new Applicant("Alexander Roth", new ArrayList<String>(Arrays.asList("Applicant")), null, 0);
		users.add(alex);
		
		Applicant fred = new Applicant("Fred Durst", new ArrayList<String>(Arrays.asList("Applicant")), null, 0);
		users.add(fred);
		
		Applicant oprah = new Applicant("Oprah Winfrey", new ArrayList<String>(Arrays.asList("Applicant")), null, 0);
		users.add(oprah);
		
		Applicant scooby = new Applicant("Scooby Doo", new ArrayList<String>(Arrays.asList("Applicant")), null, 0);
		users.add(scooby);
		
		Applicant kurt = new Applicant("Kurt Cobain", new ArrayList<String>(Arrays.asList("Applicant")), null, 0);
		users.add(kurt);
		
		
		User alan = new User("Alan Turing", new ArrayList<String>(Arrays.asList("Manager", "HR-Manager", "Report Confirmer")), null);
		users.add(alan);
		
		User jack = new User("Jack Jackson", new ArrayList<String>(Arrays.asList("Manager", "Rater", "Negociator")), null);
		users.add(jack);
		
		User peter = new User("Peter Parker", new ArrayList<String>(Arrays.asList("HR-Manager", "Rater", "Negociator")), null);
		users.add(peter);
		
		User velma = new User("Velma Dinkley", new ArrayList<String>(Arrays.asList("Report Confirmer", "Manager", "Negociator")), null);
		users.add(velma);
		
		User muriel = new User("Muriel Bagge", new ArrayList<String>(Arrays.asList("Report Confirmer", "Rater", "Negociator")), null);
		users.add(muriel);
		
	}
}
