package com.andreitop.newco.controller;

import java.util.List;

public interface AbstractController<T> {
    List<T> findAll();

    T findById(final Long id);

    void create(final T entity);

    void delete(final Long id);

    void update(final T entity);
}
