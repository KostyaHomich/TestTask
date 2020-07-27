package test.task.com.dao;

import test.task.com.dao.exception.DaoException;
import test.task.com.entity.Entity;

import java.util.List;

public interface EntityDao<T extends Entity> {

    T create(T object) throws DaoException;

    void update(T object) throws DaoException;

    void delete(T object) throws DaoException;

    Entity getByPk(int key) throws DaoException;

    List<T> getAll() throws DaoException;

}
