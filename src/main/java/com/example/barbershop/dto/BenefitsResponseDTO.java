package com.example.barbershop.dto;

public class BenefitsResponseDTO {

    private Double benefits;
    private Integer year;

    public BenefitsResponseDTO(){}

    public BenefitsResponseDTO(Double benefits) {
        this.benefits = benefits;
    }

    public Double getBenefits() {
        return benefits;
    }

    public void setBenefits(Double benefits) {
        this.benefits = benefits;
    }

    public Integer getYear() {
        return year;
    }

    public void setYear(Integer year) {
        this.year = year;
    }
}
