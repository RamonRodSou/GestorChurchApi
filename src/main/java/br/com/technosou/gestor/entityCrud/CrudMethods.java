package br.com.technosou.gestor.entityCrud;

import java.util.List;

public interface CrudMethods<T, ID> {
    List<T> findAll();

    T findById(ID id);

    T create(T t);

    T update(T t);

    void delete(ID id);
}
