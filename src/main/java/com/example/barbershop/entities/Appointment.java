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

    private Integer duration; // tiempo real
    @Column(length = 400)
    private String description;

    //Relaciones: OneToOne, OneToMany, ManyToOne, ManyToMany
        //Cliente
    @JsonIgnore// ignora todos por completp
    @ManyToOne
    @JoinColumn(foreignKey = @ForeignKey(name = "fk_appointment_customer"))
    private Customer customer;
        //Servicio
    @JsonIgnoreProperties(value = {"customer_id"}) //ignora atributos especificos
    @ManyToOne
    @JoinColumn(name = "service_id", foreignKey = @ForeignKey(name= "fk_appointment_hair_assistence"))//Nombre de la nueva columna
    private HairAssistance hairAssistance;

    @ManyToOne
    @JoinColumn(name = "employee_id", foreignKey = @ForeignKey(name = "fk_appointment_employee"))
    private Employee employee;

    //Contructores

    public Appointment() {
    }

    public Appointment(Long id, LocalDateTime date, Integer duration, String description) {
        this.id = id;
        this.date = date;
        this.duration = duration;
        this.description = description;
    }

    //Métodos
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

    public Customer getCustomer() {
        return customer;
    }
    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public HairAssistance getHairAssistance() {
        return hairAssistance;
    }

    public void setHairAssistance(HairAssistance hairAssistance) {
        this.hairAssistance = hairAssistance;
    }
}
