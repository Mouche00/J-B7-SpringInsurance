package com.insurance.factories;

import com.insurance.strategies.InsuranceCalculator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Service
public class InsuranceCalculatorFactory {
    private final Map<String, InsuranceCalculator<?>> calculators;

    @Autowired
    public InsuranceCalculatorFactory(List<InsuranceCalculator<?>> calculatorList) {
        calculators = calculatorList.stream().collect(Collectors.toMap(
                calculator -> calculator.getClass().getSimpleName().replace("Calculator", ""),
                calculator -> calculator
        ));
    }

    public <T> InsuranceCalculator<T> getStrategy(String insuranceType) {
        return (InsuranceCalculator<T>) calculators.get(insuranceType);
    }
}