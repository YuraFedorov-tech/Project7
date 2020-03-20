package web.service;
/*
 *
 *@Data 25.02.2020
 *@autor Fedorov Yuri
 *@project spring_hibernate
 *
 */


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import web.dao.UserDao;
import web.model.User;

import java.util.List;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserDao userDao;



    @Transactional
    @Override
    public void add(User model) {

        userDao.add(model);
    }

    @Transactional(readOnly = true)
    @Override
    public List<User> findAll() {
        return userDao.findAll();
    }

    @Transactional(readOnly = true)
    @Override
    public User findById(Long id) {
        return userDao.findById(id);
    }

   @Transactional
    @Override
    public void update(User model) {
        userDao.update(model);
    }

    @Transactional
    @Override
    public void delete(Long id) {
        userDao.delete(id);
    }

    @Transactional
    @Override
    public void drop() {
        userDao.drop();
    }

    @Transactional
    @Override
    public void create() {
        userDao.create();
    }
}
