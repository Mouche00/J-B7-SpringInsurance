package com.insurance.services.implementations;

import com.insurance.models.Insurance;
import com.insurance.repositories.GenericRepoistory;
import com.insurance.services.InsuranceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
public class InsuranceServiceImpl extends GenericServiceImpl<Insurance, String> implements InsuranceService<Insurance, String> {

    @Autowired
    public InsuranceServiceImpl(GenericRepoistory<Insurance, UUID> genericRepoistory) {
        super(genericRepoistory);
    }
}
