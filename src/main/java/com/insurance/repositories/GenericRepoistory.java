package com.insurance.repositories;

import java.util.List;
import java.util.Optional;

public interface GenericRepoistory<T, ID> {
    void save(T entity);
    void update(T entity);
    void delete(T entity);
    Optional<T> find(ID id);
    List<T> getAll();
}
