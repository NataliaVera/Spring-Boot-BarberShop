package com.example.barbershop.services;

import com.example.barbershop.entities.Appointment;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.Month;
import java.util.List;
import java.util.Optional;

@Service
public interface AppointmentService {

    Optional<Appointment> findById(Long id);

    List<Appointment> findAll();

    List<Appointment> findAllById(List<Long> ids);

    List<Appointment> findAllByCustomerId(Long id);

    List<Appointment> findAllByIdNotInAndCustomerId(List<Long> ids, Long id);

    List<Appointment> findAllByCustomerEmail(String customerEmail) throws IllegalArgumentException, IllegalAccessException;

    List<Appointment> findAllByEmployeeId(Long id);

    List<Appointment> findAllByEmployeeDni(String dni);

    List<Appointment> findAllByPriceLessThanEqual(Double price);

    double calculateBenefitsByDate(LocalDate date);

    double calculateBenefitsByMonth(int year, Month month);

    double calculateBenefitsByYear(int year);

    Appointment save(Appointment appointment);

    List<Appointment> saveAll(List<Appointment> appointments);

    boolean deleteById(Long id);

    boolean deleteAll();
}
