package com.isil.dao;

import java.util.List;

public interface DAO<T, K>{

    void insertar(T a);
    void modificar(T a, K id);
    void eliminar(K id);
    List<T> obtenerTodos();
    T obtenerUno(K id);

}
