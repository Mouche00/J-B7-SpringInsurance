package com.insurance.services;

import com.insurance.models.Quote;

public interface QuoteService extends GenericService<Quote, String> {
    <T> double calculateQuote(T insurance);
}
