package com.insurance.models;

import com.insurance.utils.enums.SecurityType;
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
    private SecurityType securityType;

    public double getAssetValue() {
        return assetValue;
    }

    public void setAssetValue(double assetValue) {
        this.assetValue = assetValue;
    }

    public SecurityType getSecurityType() {
        return securityType;
    }

    public void setSecurityType(SecurityType securityType) {
        this.securityType = securityType;
    }

    public HomeInsurance(String assetType, boolean riskFactor, User user, double assetValue, SecurityType securityType) {
        super(assetType, riskFactor, user);
        this.assetValue = assetValue;
        this.securityType = securityType;
    }

    public HomeInsurance() {
    }
}
