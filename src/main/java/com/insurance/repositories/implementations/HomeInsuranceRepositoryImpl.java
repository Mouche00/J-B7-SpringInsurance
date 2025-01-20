package com.insurance.repositories.implementations;

import com.insurance.models.HomeInsurance;
import com.insurance.repositories.GenericRepoistory;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public class HomeInsuranceRepositoryImpl extends GenericRepositoryImpl<HomeInsurance, UUID> implements GenericRepoistory<HomeInsurance, UUID> {
    protected HomeInsuranceRepositoryImpl() {
        super(HomeInsurance.class);
    }
}
