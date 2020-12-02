package com.fabriik.customerwebservice.domain;

import javax.persistence.Entity;
import javax.persistence.Id;
import java.io.Serializable;

@Entity
public class Customers implements Serializable {

    private Long id;
    private Long count;
    private Double average;

    @Id
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

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

    public Customers(Long id, Long count, Double average) {
        this.id = id;
        this.count = count;
        this.average = average;
    }

    public Customers() {
    }
}
