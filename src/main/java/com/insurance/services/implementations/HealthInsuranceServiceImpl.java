package com.insurance.services.implementations;

import com.insurance.models.HealthInsurance;
import com.insurance.models.Quote;
import com.insurance.models.User;
import com.insurance.repositories.GenericRepoistory;
import com.insurance.services.GenericService;
import com.insurance.services.InsuranceService;
import com.insurance.services.QuoteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
public class HealthInsuranceServiceImpl extends GenericServiceImpl<HealthInsurance, String> implements GenericService<HealthInsurance, String> {

    private QuoteService quoteService;

    @Autowired
    public HealthInsuranceServiceImpl(GenericRepoistory<HealthInsurance, UUID> genericRepoistory, QuoteService quoteService) {
        super(genericRepoistory);
        this.quoteService = quoteService;
    }

    @Override
    public void save(HealthInsurance healthInsurance) {
        Quote quote = new Quote();
        quote.setMonthlyAmount(quoteService.calculateQuote(healthInsurance));
        healthInsurance.setQuote(quote);
        genericRepoistory.update(healthInsurance);

    }

    @Override
    public void update(HealthInsurance healthInsurance) {
        Quote quote = healthInsurance.getQuote();
        quote.setMonthlyAmount(quoteService.calculateQuote(healthInsurance));
        healthInsurance.setQuote(quote);
        genericRepoistory.update(healthInsurance);

    }
}
