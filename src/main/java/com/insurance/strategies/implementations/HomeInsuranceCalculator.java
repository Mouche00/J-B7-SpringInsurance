package com.insurance.strategies.implementations;

import com.insurance.models.HomeInsurance;
import com.insurance.strategies.InsuranceCalculator;
import com.insurance.utils.enums.SecurityType;
import org.springframework.stereotype.Service;

@Service
public class HomeInsuranceCalculator implements InsuranceCalculator<HomeInsurance> {

    private static final double BASE = 300;
    private static final double ASSET_VALUE_THRESHOLD = 200_000;
    private static final double ASSET_VALUE_INCREASE = 0.10;
    private static final double SECURITY_SYSTEM_DECREASE = 0.15;
    private static final double NO_SECURITY_SYSTEM_INCREASE = 0.15;
    private static final double RISK_FACTOR_INCREASE = 0.05;
    private static final double HOUSE_ASSET_INCREASE = 0.02;

    @Override
    public double calculate(HomeInsurance insurance) {
        double finalAmount = BASE;

        if (insurance.getAssetValue() > ASSET_VALUE_THRESHOLD) {
            finalAmount += BASE * ASSET_VALUE_INCREASE;
        }
        if (insurance.isRiskFactor()) {
            finalAmount += BASE * RISK_FACTOR_INCREASE;
        }
        if (SecurityType.NONE.equals(insurance.getSecurityType())) {
            finalAmount += BASE * NO_SECURITY_SYSTEM_INCREASE;
        } else {
            finalAmount -= BASE * SECURITY_SYSTEM_DECREASE;
        }
        if("house".equalsIgnoreCase(insurance.getAssetType())){
            finalAmount += BASE * HOUSE_ASSET_INCREASE;
        }

        return finalAmount;
    }
}
