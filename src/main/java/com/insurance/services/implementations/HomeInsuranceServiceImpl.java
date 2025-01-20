package com.insurance.services.implementations;

import com.insurance.models.HealthInsurance;
import com.insurance.models.HomeInsurance;
import com.insurance.models.Quote;
import com.insurance.repositories.GenericRepoistory;
import com.insurance.services.GenericService;
import com.insurance.services.QuoteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.UUID;

@Service
public class HomeInsuranceServiceImpl extends GenericServiceImpl<HomeInsurance, String> implements GenericService<HomeInsurance, String> {

    private QuoteService quoteService;

    @Autowired
    public HomeInsuranceServiceImpl(GenericRepoistory<HomeInsurance, UUID> genericRepoistory, QuoteService quoteService) {
        super(genericRepoistory);
        this.quoteService = quoteService;
    }

    @Override
    public void save(HomeInsurance homeInsurance) {
        Quote quote = new Quote(quoteService.calculateQuote(homeInsurance), LocalDate.now());
        homeInsurance.setQuote(quote);
        genericRepoistory.update(homeInsurance);

    }

    @Override
    public void update(HomeInsurance homeInsurance) {
        Quote quote = homeInsurance.getQuote();
        quote.setMonthlyAmount(quoteService.calculateQuote(homeInsurance));
        homeInsurance.setQuote(quote);
        genericRepoistory.update(homeInsurance);

    }
}
