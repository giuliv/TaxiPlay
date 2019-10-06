package com.isil.dao;

import java.util.List;

public interface DAO<T, K>{

    void insertar(T a);
    void modificar(T a);
    void eliminar(T a);
    List<T> obtenerTodos();
    T obtenerUno(K id);

}
