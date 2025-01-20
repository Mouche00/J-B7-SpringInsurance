package com.insurance.repositories.implementations;

import com.insurance.models.Quote;
import com.insurance.repositories.GenericRepoistory;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public class QuoteRepositoryImpl extends GenericRepositoryImpl<Quote, UUID> implements GenericRepoistory<Quote, UUID> {
    protected QuoteRepositoryImpl() {
        super(Quote.class);
    }
}
