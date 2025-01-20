package com.insurance.repositories.implementations;

import com.insurance.models.HealthInsurance;
import com.insurance.repositories.GenericRepoistory;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public class HealthInsuranceRepositoryImpl extends GenericRepositoryImpl<HealthInsurance, UUID> implements GenericRepoistory<HealthInsurance, UUID> {
    protected HealthInsuranceRepositoryImpl() {
        super(HealthInsurance.class);
    }
}
