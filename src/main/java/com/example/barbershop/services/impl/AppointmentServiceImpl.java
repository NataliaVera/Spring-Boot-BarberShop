package com.example.barbershop.services.impl;

import com.example.barbershop.entities.Appointment;
import com.example.barbershop.repositories.AppointmentRepository;
import com.example.barbershop.services.AppointmentService;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class AppointmentServiceImpl implements AppointmentService {

    //Acceso a DB
    //Debe inyectar al repositorio
    private AppointmentRepository appointmentRepository;

    public AppointmentServiceImpl(AppointmentRepository appointmentRepository) {
        this.appointmentRepository = appointmentRepository;
    }

    @Override
    public Optional<Appointment> findById(Long id) {
        if(id == null || id < 0){
            return Optional.empty();// No retorna null sino un Optional de tipo appointment
        }
        return appointmentRepository.findById(id);
    }

    @Override
    public List<Appointment> findAll() {

        return appointmentRepository.findAll();
    }

    @Override
    public List<Appointment> findAllByCustomerEmail(String customerEmail) throws IllegalAccessException {
        if(!StringUtils.hasLength(customerEmail) && !customerEmail.contains("@")){//asegurarnos que el campo no este vacío o null
            throw  new IllegalAccessException("Email incorrecto");
            //new ArrayList<>(); puede devolver un array vacío
        }
        return appointmentRepository.findAllByCustomerEmail(customerEmail);
    }

    @Override
    public Double calculateAppointmentsBenefitsByDate(LocalDate day) {
        if(day == null){
            return 0d;
        }
        LocalDateTime min = day.atTime(0, 0 );
        LocalDateTime max = day.atTime(23, 59, 59 );

        List<Appointment> appointmentList = appointmentRepository.findAllByDateBetween(min, max); //conseguir las citas de ese día

        double benefits = 0;
        for (Appointment appointment: appointmentList) {// citas que han tenido ese día
            if(appointment.getHairAssistance() == null)
                continue;

            benefits += appointment.getHairAssistance().getPrice();
        }
        return benefits;
    }

    @Override
    public Appointment save(Appointment appointment) {
        if(appointment == null || appointment.getDate() == null){
            throw new IllegalArgumentException("Cita incorrecta");
        }
        return appointmentRepository.save(appointment);
    }

    @Override
    public boolean deleteById(Long id) {
        if(id == null || appointmentRepository.existsById(id))
            throw new IllegalArgumentException("No es posible eliminar la cita");

        appointmentRepository.deleteById(id);
        return true;
    }

    @Override
    public boolean deleteAll() {
        appointmentRepository.deleteAll();
        return true;
    }
}
