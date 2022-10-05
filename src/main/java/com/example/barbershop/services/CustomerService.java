package com.example.barbershop.services;

import com.example.barbershop.entities.Customer;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

@Service
public interface CustomerService {
    List<Customer> findAll();
    Optional<Customer> findById(Long id);
    List<Customer> findAllByCustomerEmail(String customerEmail) throws IllegalAccessException;
    Double calculateAppointmentsBenefitsByDate(LocalDate day);
    Customer save(Customer customer);
    boolean deleteById(Long id);
    boolean deleteAll();
    boolean existsById(Long id);
}
