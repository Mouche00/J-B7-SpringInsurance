package com.insurance.models;

import com.insurance.utils.enums.SecurtiyType;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;

@Entity
@Table(name = "home_insurances")
@DiscriminatorValue("home")
public class HomeInsurance extends Insurance {

    @NotNull
    @Positive
    private double assetValue;

    @Enumerated(EnumType.STRING)
    private SecurtiyType securtiyType;

    public double getAssetValue() {
        return assetValue;
    }

    public void setAssetValue(double assetValue) {
        this.assetValue = assetValue;
    }

    public SecurtiyType getSecurtiyType() {
        return securtiyType;
    }

    public void setSecurtiyType(SecurtiyType securtiyType) {
        this.securtiyType = securtiyType;
    }

    public HomeInsurance(String assetType, boolean riskFactor, User user, double assetValue, SecurtiyType securtiyType) {
        super(assetType, riskFactor, user);
        this.assetValue = assetValue;
        this.securtiyType = securtiyType;
    }

    public HomeInsurance() {
    }
}
