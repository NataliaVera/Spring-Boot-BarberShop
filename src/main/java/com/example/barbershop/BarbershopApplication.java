package com.example.barbershop;

import entities.Appoinment;
import entities.Customer;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import repositories.AppoinmentRepository;
import repositories.CustomerRepository;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Optional;

@SpringBootApplication
public class BarbershopApplication {

	public static void main(String[] args) {

		ApplicationContext context = SpringApplication.run(BarbershopApplication.class, args);

		AppoinmentRepository appointmentRepository = context.getBean(AppoinmentRepository.class);

		Appoinment date1 = new Appoinment(null, LocalDateTime.now(), 30, "");

		appointmentRepository.save(date1);

		CustomerRepository customerRepository = context.getBean(CustomerRepository.class);
		Customer customer = new Customer(null, "Customer 1", "last name1", "example@email.com", LocalDate.of(1990, 1, 3));

		customer.getAppointmentList().add(date1);//
		customerRepository.save(customer);

		//Asociacion Appoinmment - customer
		date1.setCustomer(customer);
		appointmentRepository.save(date1);


		Optional<Customer> customerOptional = customerRepository.findById(1L);
		Customer customer1 = null;
		if(customerOptional.isPresent()){
			customer1 = customerOptional.get();
			System.out.println(customer1.getAppointmentList());
		}
	}

}
