package com.company.service.impl;

import com.company.repository.IGenericRepo;
import com.company.service.IGenericService;

import java.util.List;

public abstract class GenericService<T, ID> implements IGenericService<T, ID> {

   protected abstract IGenericRepo<T, ID> getRepo();

    @Override
    public List<T> buscarTodos() {

        return getRepo().findAll();
    }

    @Override
    public T buscarPorId(ID id) {
        return getRepo().findById(id).orElse(null);
    }

    @Override
    public T guardar(T t) {
        return getRepo().save(t);
    }

    @Override
    public void eliminar(ID id) {
        getRepo().deleteById(id);
    }
}
