package test.task.com.dao.impl;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import test.task.com.dao.exception.DaoException;
import test.task.com.entity.Entity;
import test.task.com.entity.Worker;

import java.util.List;

@Repository
@Scope("prototype")
@Transactional
public class WorkerDaoImpl extends AbstractDaoImpl<Worker> {

    @Override
    public Entity getByPk(int key) throws DaoException {
        return null;
    }

    @Override
    public List<Worker> getAll() throws DaoException {
        return null;
    }
}
