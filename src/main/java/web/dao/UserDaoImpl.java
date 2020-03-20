package web.dao;
/*
 *
 *@Data 24.02.2020
 *@autor Fedorov Yuri
 *@project spring_hibernate
 *
 */


import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import web.dao.UserDao;
import web.model.User;


import javax.persistence.TypedQuery;
import java.util.List;

@Repository
public class UserDaoImpl implements UserDao {
    @Autowired
    private SessionFactory sessionFactory;


    @Override
    public void add(User model) {
        sessionFactory.getCurrentSession().save(model);
    }

    @Override
    public User findById(Long id) {
        Session session = sessionFactory.openSession();
        User user = session.get(User.class, id);
        return user;
    }

    @Override
    public void update(User model) {
    //    Session session = sessionFactory.openSession();
   //     session.saveOrUpdate(model);
        Session session = sessionFactory.openSession();
        String hql = "update User WHERE id = :id";
        Transaction transaction = session.beginTransaction();
        try {
            Query query = session.createQuery(hql);
            query.setParameter("id", model.getId());
            int rows = query.executeUpdate();
            transaction.commit();
        } catch (HibernateException he) {
            transaction.rollback();
        } finally {
            session.close();
        }
    }

    @Override
    public List<User> findAll() {
        TypedQuery<User> query1 = sessionFactory.getCurrentSession().createQuery("from User");
        return query1.getResultList();
    }

    @Override
    public void drop() {
      int y=sessionFactory.getCurrentSession().createQuery("DROP TABLE car cascade").executeUpdate();
    }

    @Override
    public void create() {

    }

    @Override
    public void delete(Long id) {
        Session session = sessionFactory.openSession();
        String hql = "DELETE User WHERE id = :id";
        Transaction transaction = session.beginTransaction();
        try {
            Query query = session.createQuery(hql);
            query.setParameter("id", id);
            int rows = query.executeUpdate();
            transaction.commit();
        } catch (HibernateException he) {
            transaction.rollback();
        } finally {
            session.close();
        }
    }
}
