package com.example.barbershop.services.impl;

import com.example.barbershop.entities.Appointment;
import com.example.barbershop.entities.Customer;

import com.example.barbershop.repositories.CustomerRepository;
import com.example.barbershop.services.AppointmentService;
import com.example.barbershop.services.CustomerService;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

@Service
public class CustomerServiceImpl implements CustomerService {

    private final CustomerRepository customerRepository;
    private final AppointmentService appointmentService;

    public CustomerServiceImpl(CustomerRepository customerRepository, AppointmentService appointmentService) {
        this.customerRepository = customerRepository;
        this.appointmentService = appointmentService;
    }

    @Override
    public List<Customer> findAll() {
        return customerRepository.findAll();
    }

    @Override
    public Optional<Customer> findById(Long id) {
        if(id == null || id < 0)
            return Optional.empty();

        return customerRepository.findById(id);
    }

    @Override
    public List<Customer> findAllByCustomerEmail(String customerEmail) throws IllegalAccessException {
        return null;
    }

    @Override
    public Double calculateAppointmentsBenefitsByDate(LocalDate day) {
        return null;
    }

    @Override
    public Customer save(Customer customer) {
        if(customer == null)
            throw  new IllegalArgumentException("cliente no se puede registrar");

        //A un cliente se le asigna una cita
        //Se deben guardar desde el lado owner , las citas
        List<Appointment> appointmentList = customer.getAppointmentList();
        for(Appointment appointment: appointmentList){
            appointment.setCustomer(customer);
        }
        //appointmentRepository.saveAll(appointmentList);

        return customerRepository.save(customer);
    }

    @Override
    public boolean deleteById(Long id) {
        if(id == null || customerRepository.existsById(id))
            throw new IllegalArgumentException("No es posible eliminar el cliente");

        customerRepository.deleteById(id);
        return true;
    }

    @Override
    public boolean deleteAll() {
        customerRepository.deleteAll();
        return true;
    }

    @Override
    public boolean existsById(Long id) {
        return false;
    }
}
