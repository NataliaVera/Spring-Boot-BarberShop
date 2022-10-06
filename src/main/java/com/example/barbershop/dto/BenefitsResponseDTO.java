package com.example.barbershop.dto;

public class BenefitsResponseDTO {

    private Double benefits;

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


}
