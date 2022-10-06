package com.example.barbershop.services;

import com.example.barbershop.entities.Employee;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public interface EmployeeService {

    Optional<Employee> findById(Long id);
    List<Employee> findAll();
    Employee save(Employee employee);
    boolean deleteById(Long id);
}
