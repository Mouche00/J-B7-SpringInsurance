package com.insurance.models;

import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;

@Entity
@Table(name = "health_insurances")
@DiscriminatorValue("health")
public class HealthInsurance extends Insurance {
}
