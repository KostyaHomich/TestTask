package test.task.com.dao.impl;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import test.task.com.dao.EntityDao;
import test.task.com.dao.exception.DaoException;
import test.task.com.entity.Entity;

@Repository
@Scope("prototype")
@Transactional
public abstract class AbstractDaoImpl<T extends Entity> implements EntityDao<T> {

    @Autowired
    protected SessionFactory sessionFactory;


    public T create(T object) throws DaoException {
        try {

            Session session = sessionFactory.openSession();
            session.beginTransaction();
            session.save(object);
            session.getTransaction().commit();
            session.close();
            return object;

        } catch (HibernateException e) {
            throw new DaoException("Failed to add entity", e);
        }
    }

    public void update(T object) throws DaoException {
        try {
            Session session = sessionFactory.openSession();
            session.beginTransaction();
            session.update(object);
            session.getTransaction().commit();
        } catch (HibernateException e) {
            throw new DaoException("Failed to update entity", e);
        }

    }

    public void delete(T object) throws DaoException {
        try {
            Session session = sessionFactory.openSession();
            session.beginTransaction();
            session.delete(object);
            session.getTransaction().commit();
            session.close();
        } catch (HibernateException e) {
            throw new DaoException("Failed to delete entity", e);
        }

    }


}
