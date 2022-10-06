package com.example.barbershop.services;

import com.example.barbershop.entities.Customer;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

@Service
public interface CustomerService {

    Optional<Customer> findById(Long id);
    List<Customer> findAll();
    Customer save(Customer customer);
    boolean deleteById(Long id);
}
