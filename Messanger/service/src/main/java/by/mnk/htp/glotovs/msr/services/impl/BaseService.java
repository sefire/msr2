package by.mnk.htp.glotovs.msr.services.impl;

import by.mnk.htp.glotovs.msr.dao.exception.DaoException;
import by.mnk.htp.glotovs.msr.dao.impl.BaseDao;
import by.mnk.htp.glotovs.msr.entities.IEntity;
import by.mnk.htp.glotovs.msr.services.exception.ServiceException;
import by.mnk.htp.glotovs.msr.services.interfaces.IService;
import by.mnk.htp.glotovs.msr.util.HibernateSessionFactory;
import org.hibernate.Session;
import org.hibernate.Transaction;

import java.io.Serializable;

/**
 * Created by Sefire on 20.11.2016.
 */
//тут реализация
public class BaseService<T> implements IService<T> {

    public void saveOrUpdate(T t) throws ServiceException {
        BaseDao<T> baseDao =  new BaseDao<T>();
        Transaction transaction = null;
        try {
            Session session = HibernateSessionFactory.getSession();
            transaction = session.beginTransaction();
            baseDao.saveOrUpdate(t);
            transaction.commit();
            HibernateSessionFactory.closeSession();
        } catch (DaoException e) {
            transaction.rollback();
            HibernateSessionFactory.closeSession();
        }
    }

    public T get(Serializable id) throws ServiceException {
        return null;
    }

    public T load(Serializable id) throws ServiceException {
        return null;
    }

    public void delete(T t) throws ServiceException {

    }
}
