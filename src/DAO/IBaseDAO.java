package DAO;

import java.util.List;

public interface IBaseDAO<T> {
    void insertar(T t);
    void actualizar(T t);
    void eliminar(String id);
    T obtenerPorID(String id);
    List<T> obtenerTodos();
}

