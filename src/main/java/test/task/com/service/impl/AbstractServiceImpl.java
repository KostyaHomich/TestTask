package test.task.com.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import test.task.com.dao.EntityDao;
import test.task.com.dao.exception.DaoException;
import test.task.com.entity.Entity;
import test.task.com.service.EntityService;
import test.task.com.service.exception.ServiceException;

import java.util.List;

public abstract class AbstractServiceImpl<T extends Entity> implements EntityService<T> {

    @Autowired
    protected EntityDao<T> dao;

    public T create(T object) throws ServiceException {
        try {
            return dao.create(object);
        } catch (DaoException e) {
            throw new ServiceException("Failed to create entity", e);
        }
    }

    public void update(T object) throws ServiceException {
        try {
            dao.update(object);
        } catch (DaoException e) {
            throw new ServiceException("Failed to update entity", e);
        }
    }

    public void delete(T object) throws ServiceException {
        try {
            dao.delete(object);
        } catch (DaoException e) {
            throw new ServiceException("Failed to delete entity", e);
        }
    }

    public Entity getByPk(int key) throws ServiceException {
        try {
            return dao.getByPk(key);
        } catch (DaoException e) {
            throw new ServiceException("Failed to get entity", e);
        }
    }

    public List<T> getAll() throws ServiceException {
        try {
            return dao.getAll();
        } catch (DaoException e) {
            throw new ServiceException("Failed to get entity's", e);
        }
    }
}
