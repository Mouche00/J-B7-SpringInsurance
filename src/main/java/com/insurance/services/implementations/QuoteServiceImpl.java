package com.insurance.services.implementations;

import com.insurance.factories.InsuranceCalculatorFactory;
import com.insurance.models.Insurance;
import com.insurance.models.Quote;
import com.insurance.repositories.GenericRepoistory;
import com.insurance.services.QuoteService;
import com.insurance.strategies.InsuranceCalculator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
public class QuoteServiceImpl extends GenericServiceImpl<Quote, String> implements QuoteService {
    private final InsuranceCalculatorFactory calculatorFactory;

    @Autowired
    public QuoteServiceImpl(GenericRepoistory<Quote, UUID> genericRepoistory, InsuranceCalculatorFactory calculatorFactory) {
        super(genericRepoistory);
        this.calculatorFactory = calculatorFactory;
    }

    public <T> double calculateQuote(T insurance) {
        InsuranceCalculator<T> strategy = calculatorFactory.getStrategy(insurance.getClass().getSimpleName());
        return strategy.calculate(insurance);
    }
}
