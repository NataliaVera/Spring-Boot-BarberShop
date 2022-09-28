package com.example.barbershop.controllers;

import com.example.barbershop.entities.Appointment;
import com.example.barbershop.services.AppointmentService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api")
public class AppointmentController {

    private AppointmentService appointmentService; // conectarnos con la DB con la capa de servicio

    public AppointmentController(AppointmentService appointmentService) {
        this.appointmentService = appointmentService;
    }

    @GetMapping("/appointments")
    public List<Appointment> findAll(){
        return appointmentService.findAll();
    }

    @GetMapping("/appointments/{id}")
    public ResponseEntity<Appointment> findById(@PathVariable Long id){
        Optional<Appointment> appointment = appointmentService.findById(id);
        if(appointment.isPresent()) {
            return ResponseEntity.ok(appointment.get());//Response entity devuelve una respuesta http
        }
        return ResponseEntity.notFound().build();

        //Programacion funcional
        /*return appointmentService.findById(id)
                .map(ResponseEntity::ok)
                .orElseGet(() -> ResponseEntity.notFound().build());*/
    }

    @PostMapping("/appointments/create")
    public ResponseEntity<Appointment> create(@RequestBody Appointment appointment){
        if(appointment.getId() != null)
            return ResponseEntity.badRequest().build();

        appointmentService.save(appointment);

        return ResponseEntity.ok(appointmentService.save(appointment));
    }

    @PutMapping("/appointments/update")
    public ResponseEntity<Appointment> update(@RequestBody Appointment appointment){
        if(appointment.getId() == null)
            return ResponseEntity.badRequest().build();

        appointmentService.save(appointment);

        return ResponseEntity.ok(appointmentService.save(appointment));
    }

    @DeleteMapping("/appointments/delete")
    public ResponseEntity<Appointment> deleteById(@PathVariable Long id){
        boolean result = appointmentService.deleteById(id);
        if(result)
            return ResponseEntity.noContent().build();
        else
            return ResponseEntity.badRequest().build();
    }
}
