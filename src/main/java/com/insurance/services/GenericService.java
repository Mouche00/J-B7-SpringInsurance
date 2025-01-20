package com.insurance.services;

import java.util.List;
import java.util.Optional;

public interface GenericService<T, ID> {
    void save(T entity);
    void update(T entity);
    void delete(ID id);
    Optional<T> find(ID id);
    List<T> getAll();
}
