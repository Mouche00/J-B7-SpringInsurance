package com.insurance.models;

import com.insurance.utils.records.EntityId;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Past;
import jakarta.validation.constraints.PastOrPresent;
import jakarta.validation.constraints.Positive;

import java.time.LocalDate;

@Entity
@Table(name = "quotes")
public class Quote {

    @EmbeddedId
    private EntityId id;

    @NotNull
    @Positive
    private double monthlyAmount;

    @NotNull
    @PastOrPresent
    private LocalDate createdAt;

    @ManyToOne(cascade = CascadeType.ALL, fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "insurance_id")
    private Insurance insurance;

    public EntityId getId() {
        return id;
    }

    public void setId(EntityId id) {
        this.id = id;
    }

    public double getMonthlyAmount() {
        return monthlyAmount;
    }

    public void setMonthlyAmount(double monthlyAmount) {
        this.monthlyAmount = monthlyAmount;
    }

    public LocalDate getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(LocalDate createdAt) {
        this.createdAt = createdAt;
    }

    public Insurance getInsurance() {
        return insurance;
    }

    public void setInsurance(Insurance insurance) {
        this.insurance = insurance;
    }

    public Quote(double monthlyAmount, LocalDate createdAt) {
        this.monthlyAmount = monthlyAmount;
        this.createdAt = createdAt;
    }

    public Quote() {
    }
}
