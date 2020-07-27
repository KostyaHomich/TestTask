package test.task.com.service;

import test.task.com.entity.Entity;
import test.task.com.service.exception.ServiceException;

import java.util.List;

public interface EntityService<T extends Entity> {

    T create(T object) throws ServiceException;

    void update(T object) throws ServiceException;

    void delete(T object) throws ServiceException;

    Entity getByPk(int key) throws ServiceException;

    List<T> getAll() throws ServiceException;

}

