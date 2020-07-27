package test.task.com.dao.impl;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import test.task.com.dao.exception.DaoException;
import test.task.com.entity.Entity;
import test.task.com.entity.Room;

import javax.persistence.criteria.CriteriaQuery;
import java.util.List;

@Repository
@Scope("prototype")
@Transactional
public class RoomDaoImpl extends AbstractDaoImpl<Room> {


    public Entity getByPk(int key) throws DaoException {
        try {
            Session session = sessionFactory.openSession();
            session.beginTransaction();
            Entity entity= session.get(Room.class, key);
            session.getTransaction().commit();
            session.close();
            return entity;
        } catch (HibernateException e) {
            throw new DaoException("Failed to get entity", e);
        }

    }

    public List<Room> getAll() throws DaoException {
        try {
            Session session = sessionFactory.openSession();
            session.beginTransaction();
            CriteriaQuery criteriaQuery = session.getCriteriaBuilder().createQuery(Room.class);
            criteriaQuery.from(Room.class);
            List<Room> list = session.createQuery(criteriaQuery).getResultList();
            session.getTransaction().commit();
            session.close();
            return list;
        } catch (HibernateException e) {
            throw new DaoException("Failed to get entity's", e);
        }
    }
}
