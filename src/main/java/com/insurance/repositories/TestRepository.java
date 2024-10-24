package com.insurance.repositories;

import com.insurance.models.Test;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Repository;

@Repository
public class TestRepository {
    @PersistenceContext
    private EntityManager entityManager;

    @Transactional
    public void save(Test test) {
        entityManager.persist(test);
    }
}
