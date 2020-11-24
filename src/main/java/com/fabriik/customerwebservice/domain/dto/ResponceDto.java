package com.fabriik.customerwebservice.domain.dto;

public class ResponceDto {

    private Long id;
    private Double average;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Double getAverage() {
        return average;
    }

    public void setAverage(Double average) {
        this.average = average;
    }

    public ResponceDto(Long id, Double average) {
        this.id = id;
        this.average = average;
    }
}
