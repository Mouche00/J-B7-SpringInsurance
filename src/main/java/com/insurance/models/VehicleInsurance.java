package com.insurance.models;

import com.insurance.utils.enums.UsageType;
import jakarta.persistence.*;

@Entity
@Table(name = "vehicle_insurances")
@DiscriminatorValue("vehicle")
public class VehicleInsurance extends Insurance {
    private String vehicleMake;
    private String vehicleModel;

    @Enumerated(EnumType.STRING)
    private UsageType usageType;

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

    public UsageType getUsageType() {
        return usageType;
    }

    public void setUsageType(UsageType usageType) {
        this.usageType = usageType;
    }

    public VehicleInsurance(String assetType, boolean riskFactor, User user, String vehicleMake, String vehicleModel, UsageType usageType) {
        super(assetType, riskFactor, user);
        this.vehicleMake = vehicleMake;
        this.vehicleModel = vehicleModel;
        this.usageType = usageType;
    }

    public VehicleInsurance() {
    }
}
