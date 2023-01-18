package com.company.service;

import java.util.List;

public interface IGenericService<T, ID> {

    List<T> buscarTodos();

    T buscarPorId(ID id);

    T guardar(T t);

    void eliminar(ID id);

}
