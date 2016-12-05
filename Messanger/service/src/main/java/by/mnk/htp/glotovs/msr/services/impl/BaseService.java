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
public abstract class BaseService<T extends IEntity, PK extends Serializable> implements IService<T, PK> {

    public abstract T get(PK id) throws ServiceException;

    public abstract T load(PK id) throws ServiceException;

    public boolean saveOrUpdate(T t) throws ServiceException {
        BaseDao<T, PK> baseDao = new BaseDao<T, PK>();
        try {
            baseDao.saveOrUpdate(t);
            return true;
        } catch (DaoException e) {
            throw new ServiceException(e);
        }
    }

    public boolean delete(T t) throws ServiceException {
        BaseDao<T, PK> baseDao = new BaseDao<T, PK>();
        try {
            baseDao.delete(t);
            return true;
        } catch (DaoException e) {
            throw new ServiceException(e);
        }
    }
}
