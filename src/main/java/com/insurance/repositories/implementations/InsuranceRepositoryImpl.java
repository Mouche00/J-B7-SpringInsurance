package com.insurance.repositories.implementations;

import com.insurance.models.Insurance;
import com.insurance.repositories.GenericRepoistory;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public class InsuranceRepositoryImpl extends GenericRepositoryImpl<Insurance, UUID> implements GenericRepoistory<Insurance, UUID> {
    protected InsuranceRepositoryImpl() {
        super(Insurance.class);
    }
}
