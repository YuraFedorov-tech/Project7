package web.dao;

import java.util.List;

/*
 *
 *@Data 24.02.2020
 *@autor Fedorov Yuri
 *@project spring_hibernate
 *
 */
public interface Dao<T> {
    void add(T model);
    List<T> findAll();
    T findById(Long id);
    void delete(Long id);
    void drop();
    void create();
    void update(T model);
}
