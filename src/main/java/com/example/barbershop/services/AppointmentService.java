package com.example.barbershop.services;

import com.example.barbershop.entities.Appointment;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

@Service
public interface AppointmentService {

    Optional<Appointment> findById(Long id);
    List<Appointment> findAll();
    List<Appointment> findAllByCustomerEmail(String customerEmail) throws IllegalAccessException;
    Double calculateAppointmentsBenefitsByDate(LocalDate day);
    Appointment save(Appointment appointment);
    boolean deleteById(Long id);
    boolean deleteAll();
}
