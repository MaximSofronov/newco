package com.andreitop.newco.service;

import java.util.List;

public interface AbstractService<T> {
    List<T> findAll();

    T findById(final Long id);

    void save(final T entity);

    void delete(final Long id);

    void update(final T entity);
}
