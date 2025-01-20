package com.insurance.strategies.implementations;

import com.insurance.models.HomeInsurance;
import com.insurance.models.VehicleInsurance;
import com.insurance.strategies.InsuranceCalculator;
import com.insurance.utils.enums.UsageType;
import org.springframework.stereotype.Service;

@Service
public class VehicleInsuranceCalculator implements InsuranceCalculator<VehicleInsurance> {

    private static final double BASE = 500;
    private static final double AGE_THRESHOLD = 25;
    private static final double AGE_INCREASE = 0.10;
    private static final double PROFESSIONAL_VEHICLE_INCREASE = 0.15;
    private static final double RISK_FACTOR_INCREASE = 0.10;
    private static final double NO_RISK_FACTOR_DECREASE = 0.20;
    private static final double LUXURY_ASSET_INCREASE = 0.15;

    @Override
    public double calculate(VehicleInsurance insurance) {
        double finalAmount = BASE;

        if (insurance.getUser().getAge() < AGE_THRESHOLD) {
            finalAmount += BASE * AGE_INCREASE;
        }
        if (insurance.isRiskFactor()) {
            finalAmount += BASE * RISK_FACTOR_INCREASE;
        } else {
            finalAmount -= BASE * NO_RISK_FACTOR_DECREASE;
        }
        if ("luxury".equalsIgnoreCase(insurance.getAssetType())) {
            finalAmount += BASE * LUXURY_ASSET_INCREASE;
        }

        if(UsageType.PROFESSIONAL.equals(insurance.getUsageType())){
            finalAmount += BASE * PROFESSIONAL_VEHICLE_INCREASE;
        }

        return finalAmount;
    }
}
