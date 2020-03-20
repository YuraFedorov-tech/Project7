package web.service;

import java.util.List;

public interface DaoService <T> {
    void add(T model);
    List<T> findAll();
    T findById(Long id);
    void delete(Long id);
    void drop();
    void create();
    void update(T model);
}
