package com.insurance.models;

import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;

@Entity
@Table(name = "vehicle_insurances")
@DiscriminatorValue("vehicle")
public class VehicleInsurance extends Insurance {
    private String vehicleMake;
    private String vehicleModel;

    public String getVehicleMake() {
        return vehicleMake;
    }

    public void setVehicleMake(String vehicleMake) {
        this.vehicleMake = vehicleMake;
    }

    public String getVehicleModel() {
        return vehicleModel;
    }

    public void setVehicleModel(String vehicleModel) {
        this.vehicleModel = vehicleModel;
    }

    public VehicleInsurance(String assetType, boolean riskFactor, User user, String vehicleMake, String vehicleModel) {
        super(assetType, riskFactor, user);
        this.vehicleMake = vehicleMake;
        this.vehicleModel = vehicleModel;
    }

    public VehicleInsurance() {
    }
}
