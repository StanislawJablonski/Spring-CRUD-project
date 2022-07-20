package ug.edu.pl.javaee.project;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import ug.edu.pl.javaee.project.domain.Client;
import ug.edu.pl.javaee.project.domain.Employee;
import ug.edu.pl.javaee.project.domain.Producer;
import ug.edu.pl.javaee.project.domain.Smartphone;
import ug.edu.pl.javaee.project.service.ClientService;
import ug.edu.pl.javaee.project.service.EmployeeService;
import ug.edu.pl.javaee.project.service.ProducerService;
import ug.edu.pl.javaee.project.service.SmartphoneService;

@SpringBootApplication
public class ProjectApplication {

	public static void main(String[] args) {
		SpringApplication.run(ProjectApplication.class, args);
	}

	@Bean
	public CommandLineRunner setUpApp(@Autowired ClientService clientService, @Autowired EmployeeService employeeService,
									  @Autowired ProducerService producerService, @Autowired SmartphoneService smartphoneService) {

		return (args) -> {
			clientService.addRecords();
			employeeService.addRecords();
			producerService.addRecords();
			smartphoneService.addRecords();
		};
	}
}
