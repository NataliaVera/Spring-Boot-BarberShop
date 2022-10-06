package com.example.barbershop.controllers;

import com.example.barbershop.entities.Customer;
import com.example.barbershop.services.CustomerService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api")
public class CustomerController {

    private CustomerService customerService;

    public CustomerController(CustomerService customerService) {
        this.customerService = customerService;
    }

    @GetMapping("/customers")
    public List<Customer> findAll(){
        return customerService.findAll();
    }

    @GetMapping("/customers/{id}")
    public ResponseEntity<Customer> findById(@PathVariable Long id){
        Optional<Customer> customerOpt = customerService.findById(id);

        if(customerOpt.isPresent())
            return ResponseEntity.ok(customerOpt.get());

        return ResponseEntity.notFound().build();
    }

    @PostMapping("/customers/create")
    public ResponseEntity<Customer> create(@RequestBody Customer customer){
        if(customer.getId() != null)
            return ResponseEntity.badRequest().build();

        return ResponseEntity.ok(customerService.save(customer));
    }

    /**
     * Actualizar una cita existente
     * @param customer
     * @return
     */
    @PutMapping("/customers/update")
    public ResponseEntity<Customer> update(@RequestBody Customer customer){
        if(customer.getId() == null)
            return ResponseEntity.badRequest().build(); // 400

        return ResponseEntity.ok(customerService.save(customer));
    }

    @DeleteMapping("/customers/{id}")
    public ResponseEntity<Void> deleteById(@PathVariable Long id){
        boolean result = customerService.deleteById(id);
        if(result)
            return ResponseEntity.noContent().build();
        else
            return ResponseEntity.internalServerError().build();
    }

}
