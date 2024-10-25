package com.insurance.repositories.implementations;

import com.insurance.repositories.GenericRepoistory;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.transaction.Transactional;

import java.util.List;
import java.util.Optional;

public class GenericRepositoryImpl<T, ID> implements GenericRepoistory<T, ID> {
    @PersistenceContext
    private EntityManager entityManager;

    protected Class<T> entityClass;

    protected GenericRepositoryImpl (Class<T> entityClass) {
        this.entityClass = entityClass;
    }

    @Override
    @Transactional
    public void save(T entity) {
        entityManager.merge(entity);
    }

    @Override
    public void update(T entity) {
        entityManager.merge(entity);
    }

    @Override
    public void delete(T entity) {
        entityManager.remove(entity);
    }

    @Override
    public Optional<T> find(ID id) {
        return Optional.ofNullable(entityManager.find(entityClass, id));
    }

    @Override
    public List<T> getAll() {
        return entityManager.createQuery("select from " + entityClass.getSimpleName() + " e", entityClass).getResultList();
    }
}
