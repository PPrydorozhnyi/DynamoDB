package com.nosql.aws.dynamotest.service;

import java.util.List;

public interface CrudService<T, I> {

    List<T> getAll();

    T getById(I id) throws Throwable;

    T save(T configuration);

    void delete(I id);

}
