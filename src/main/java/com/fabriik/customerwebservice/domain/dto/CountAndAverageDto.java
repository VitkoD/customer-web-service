package com.fabriik.customerwebservice.domain.dto;

public class CountAndAverageDto {

    private Long count;
    private Double average;

    public Long getCount() {
        return count;
    }

    public void setCount(Long count) {
        this.count = count;
    }

    public Double getAverage() {
        return average;
    }

    public void setAverage(Double average) {
        this.average = average;
    }

    public CountAndAverageDto(Long count, Double average) {
        this.count = count;
        this.average = average;
    }
}
