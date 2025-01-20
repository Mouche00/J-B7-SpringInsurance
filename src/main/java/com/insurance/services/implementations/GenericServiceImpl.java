package com.insurance.services.implementations;

import com.insurance.repositories.GenericRepoistory;
import com.insurance.services.GenericService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

public class GenericServiceImpl<T, ID> implements GenericService<T, ID> {
    protected final GenericRepoistory<T, UUID> genericRepoistory;

    public GenericServiceImpl(GenericRepoistory<T, UUID> genericRepoistory) {
        this.genericRepoistory = genericRepoistory;
    }

    @Override
    public void save(T entity) {
        genericRepoistory.save(entity);
    }

    @Override
    public void update(T entity) {
        genericRepoistory.update(entity);
    }

    @Override
    public void delete(ID id) {
        Optional<T> entity = find(id);
        entity.ifPresent(genericRepoistory::delete);
    }

    @Override
    public Optional<T> find(ID id) {
        return genericRepoistory.find(UUID.fromString((String) id));
    }

    @Override
    public List<T> getAll() {
        return genericRepoistory.getAll();
    }
}
