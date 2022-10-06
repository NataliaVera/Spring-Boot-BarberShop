package com.example.barbershop.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.*;
import java.io.Serializable;
import java.time.LocalDateTime;

@Entity
@Table(name= "appointments")
public class Appointment implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private LocalDateTime date;

    private Integer duration;
    @Column(length = 400)
    private String description;

    public Appointment() {
    }

    public Appointment(Long id, LocalDateTime date, Integer duration, String description) {
        this.id = id;
        this.date = date;
        this.duration = duration;
        this.description = description;
    }

    //Asociaciones: OneToOne, OneToMany, ManyToOne, ManyToMany
    @JsonIgnoreProperties(value = {"appointments"})
    @ManyToOne
    @JoinColumn(name = "customer_id", foreignKey = @ForeignKey(name = "fk_appointment_customer"))
    private Customer customer;

    @ManyToOne
    @JoinColumn(name = "hair_assistance_id", foreignKey = @ForeignKey(name = "fk_appointment_hairassistance"))
    private HairAssistance hairAssistance;

    @ManyToOne
    @JoinColumn(name = "employee_id", foreignKey = @ForeignKey(name = "fk_appointment_employee"))
    private Employee employee;


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public LocalDateTime getDate() {
        return date;
    }

    public void setDate(LocalDateTime date) {
        this.date = date;
    }

    public Integer getDuration() {
        return duration;
    }

    public void setDuration(Integer duration) {
        this.duration = duration;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    public HairAssistance getHairAssistance() {
        return hairAssistance;
    }

    public void setHairAssistance(HairAssistance hairAssistance) {
        this.hairAssistance = hairAssistance;
    }

    public Employee getEmployee() {
        return employee;
    }

    public void setEmployee(Employee employee) {
        this.employee = employee;
    }

    @Override
    public String toString() {
        return "Appointment{" +
                "id=" + id +
                ", date=" + date +
                ", duration=" + duration +
                ", description='" + description + '\'' +
                ", customer=" + customer +
                ", hairAssistance=" + hairAssistance +
                ", employee=" + employee +
                '}';
    }
}
