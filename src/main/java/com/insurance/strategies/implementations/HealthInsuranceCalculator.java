package com.insurance.strategies.implementations;

import com.insurance.models.HealthInsurance;
import com.insurance.models.User;
import com.insurance.services.InsuranceService;
import com.insurance.strategies.InsuranceCalculator;
import org.springframework.stereotype.Service;

@Service
public class HealthInsuranceCalculator implements InsuranceCalculator<HealthInsurance> {

    private static final double BASE = 150;
    private static final double SENIOR_AGE_THRESHOLD = 60;
    private static final double SENIOR_AGE_INCREASE = 0.20;
    private static final double RISK_FACTOR_INCREASE = 0.30;
    private static final double BASIC_ASSET_DECREASE = 0.10;
    private static final double NON_BASIC_ASSET_INCREASE = 0.05;

    @Override
    public double calculate(HealthInsurance insurance) {
        double finalAmount = BASE;
        if (insurance.getUser().getAge() > SENIOR_AGE_THRESHOLD) {
            finalAmount += BASE * SENIOR_AGE_INCREASE;
        }
        if (insurance.isRiskFactor()) {
            finalAmount += BASE * RISK_FACTOR_INCREASE;
        }
        if ("basic".equalsIgnoreCase(insurance.getAssetType())) {
            finalAmount -= BASE * BASIC_ASSET_DECREASE;
        } else {
            finalAmount += BASE * NON_BASIC_ASSET_INCREASE;
        }
        return finalAmount;
    }
}
