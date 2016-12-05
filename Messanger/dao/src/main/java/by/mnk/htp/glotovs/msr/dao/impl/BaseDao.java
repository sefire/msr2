package by.mnk.htp.glotovs.msr.dao.impl;

import by.mnk.htp.glotovs.msr.dao.exception.DaoException;
import by.mnk.htp.glotovs.msr.dao.interfaces.IDao;
import by.mnk.htp.glotovs.msr.entities.IEntity;
import by.mnk.htp.glotovs.msr.util.HibernateSessionFactory;

import org.apache.log4j.Logger;

import org.hibernate.HibernateException;
import org.hibernate.ObjectNotFoundException;
import org.hibernate.Session;

import java.io.Serializable;
import java.lang.reflect.ParameterizedType;

public class BaseDao<T extends IEntity, PK extends Serializable> implements IDao<T, PK> {
    private static Logger log = Logger.getLogger(BaseDao.class);

    private Class<T> type;

    public BaseDao(Class<T> type) {
        this.type = type;
    }

    public BaseDao() {
    }

    public boolean saveOrUpdate(T t) throws DaoException {
        log.info("Start saveOrUpdate:" + t);
        try {
            Session session = HibernateSessionFactory.getSession();
            session.saveOrUpdate(t);
            log.info("End saveOrUpdate:" + t);
            return true;
        } catch (HibernateException e) {
            log.error("Error save or update in Dao" + e);
            throw new DaoException(e);
        }
    }

    public T get(PK id) throws DaoException {
        log.info("Start get class by id:" + id);
        T t = null;
        try {
            Session session = HibernateSessionFactory.getSession();
            t = (T) session.get(type, id);
            log.info("End get class by id: " + t);
        } catch (HibernateException e) {
            log.error("Error get " + getPersistentClass() + " in Dao" + e);
            throw new DaoException(e);
        }
        return t;
    }

    public T load(PK id) throws DaoException {
        log.info("Start loading class by id:" + id);
        T t = null;
        try {
            Session session = HibernateSessionFactory.getSession();
            t = (T) session.load(getPersistentClass(), id);
            log.info("End loading class");
            try {
                log.info("load() was successful:" + t);
            } catch (ObjectNotFoundException e) {
                log.error("!!!Congratulations!\nYou managed to get ObjectNotFoundException on load()!!!");
            }
        } catch (HibernateException e) {
            log.error("Error load() " + getPersistentClass() + " in Dao" + e);
            throw new DaoException(e);
        }
        return t;
    }

    public boolean delete(T t) throws DaoException {
        try {
            Session session = HibernateSessionFactory.getSession();
            session.delete(t);
            log.info("Delete:" + t);
            return true;
        } catch (HibernateException e) {
            log.error("Error delete in Dao" + e);
            throw new DaoException(e);
        }
    }

    private Class getPersistentClass() {
        return (Class<T>) ((ParameterizedType) getClass().getGenericSuperclass()).getActualTypeArguments()[0];
    }

}
