package com.nosql.aws.dynamotest.service;

import org.springframework.data.repository.CrudRepository;
import org.springframework.http.HttpStatus;
import org.springframework.web.client.HttpClientErrorException;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

public abstract class AbstractCrudService<T, I> implements CrudService<T, I> {

    private final CrudRepository<T, I> repository;

    public AbstractCrudService(CrudRepository<T, I> repository) {
        this.repository = repository;
    }

    public List<T> getAll() {
        return StreamSupport.stream(repository.findAll().spliterator(), false)
                .collect(Collectors.toList());
    }

    public T getById(I id) {
        return repository.findById(id)
                .orElseThrow(() -> new HttpClientErrorException(HttpStatus.NOT_FOUND));
    }

    public T save(T configuration) {
        return repository.save(configuration);
    }

    public void delete(I id) {
        repository.deleteById(id);
    }
}
